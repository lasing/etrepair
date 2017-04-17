package com.liveneo.etrepair.service.impl;

import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.liveneo.etrepair.common.Constant;
import com.liveneo.etrepair.common.JsonUtils;
import com.liveneo.etrepair.common.MD5Util;
import com.liveneo.etrepair.common.MapUtil;
import com.liveneo.etrepair.common.OssManage;
import com.liveneo.etrepair.common.PropertyConfigurer;
import com.liveneo.etrepair.dao.mapper.impl.GarageDaoImpl;
import com.liveneo.etrepair.dao.mapper.impl.GaragePhotoDaoImpl;
import com.liveneo.etrepair.dao.mapper.impl.OrgInfoDaoImpl;
import com.liveneo.etrepair.dao.mapper.impl.UserDaoImpl;
import com.liveneo.etrepair.log.LVLogger;
import com.liveneo.etrepair.pojo.Garage;
import com.liveneo.etrepair.pojo.GarageCore;
import com.liveneo.etrepair.pojo.GaragePhoto;
import com.liveneo.etrepair.pojo.OrgInfo;
import com.liveneo.etrepair.pojo.User;
import com.liveneo.etrepair.pojo.support.CoreRequestHeadDto;
import com.liveneo.etrepair.pojo.support.GarageSupport;
import com.liveneo.etrepair.pojo.support.RepairRequest;
import com.liveneo.etrepair.pojo.support.RequestDetail;
import com.liveneo.etrepair.pojo.support.response.RepairResponse;
import com.liveneo.etrepair.pojo.support.response.ReponseGarageInfo;
import com.liveneo.etrepair.pojo.support.response.ResponseHeadDto;
import com.liveneo.etrepair.service.GarageService;
import com.liveneo.etrepair.service.support.InvokedInterfaceTool;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;

@Service
public class GarageServiceImpl implements GarageService {
    @Autowired
    private GarageDaoImpl      garageDaoImpl;
    @Autowired
    private GaragePhotoDaoImpl garagePhotoDaoImpl;
    @Autowired
    private UserDaoImpl        userDaoImpl;
    @Autowired
    private OrgInfoDaoImpl     orgInfoDaoImpl;
    @Autowired
    private OssManage          ossManage;
    private String             garagePhotoPath  = PropertyConfigurer.getValue("garagePhotoPath");
    private String             ossbucketsubname = PropertyConfigurer.getValue("OSS_BUCKET_SUB_NAME");
    // private String ossBaseUrl = PropertyConfigurer.getValue("ossBaseUrl"); zhaoyy 不用该地址 20161025
    private String             msplatformUrl    = PropertyConfigurer.getValue("msplatformUrl");
    private String             coreserviceUrl   = PropertyConfigurer.getValue("coreserviceUrl");
    static final LVLogger      logger           = LVLogger.getLogger(GarageServiceImpl.class);

    @Override
    @Transactional
    public String addGarage(Garage garage) {
        // 同步修理厂信息到用户表中
        String ret = addGarageToUser(garage, "0");
        if (ret != null && "exist".equals(ret)) {
            return ret;
        }
        // 通过修理厂地址去高德地图查询经纬度
        if (garage.getGarageAddr() != null && !"".equals(garage.getGarageAddr())) {
            String location = MapUtil.addressToGPS(garage.getGarageAddr());
            if (location != null) {
                garage.setLongitude(Double.valueOf(location.split(",")[0]));
                garage.setLatitude(Double.valueOf(location.split(",")[1]));
            }
        }
        this.garageDaoImpl.addGarage(garage);
        return null;
    }

    @Override
    public String updateGarage(Garage garage) throws Exception {
        // 同步修理厂信息到用户表中
        String ret = addGarageToUser(garage, "1");
        if (ret != null && "exist".equals(ret)) {
            return ret;
        }
        // 通过修理厂地址去高德地图查询经纬度
        if (garage.getGarageAddr() != null && !"".equals(garage.getGarageAddr())) {
            String location = MapUtil.addressToGPS(garage.getGarageAddr());
            if (location != null) {
                garage.setLongitude(Double.valueOf(location.split(",")[0]));
                garage.setLatitude(Double.valueOf(location.split(",")[1]));
            }
        }
        this.garageDaoImpl.updateGarage(garage);
        return null;
    }

    // 添加修理厂到用户表中
    private String addGarageToUser(Garage garage, String oper) {
        /************************新增修理厂操作**************************/
        if ("0".equals(oper)) {
            // 判断该手机号在用户表是否存在，不存在的话新增，存在的话返回提示用户
            if (garage.getContactPhone() != null && !"".equals(garage.getContactPhone())) {
                int userName = userDaoImpl.selectByUserName(garage.getContactPhone());
                if (userName == 0) {
                    User user = new User();
                    user.setUserName(garage.getContactPhone());
                    user.setRealName(garage.getGarageName());
                    user.setMobilePhone(garage.getContactPhone());
                    user.setCompanyCode(garage.getCompanyCode());
                    // 从组织结构表中查询orgid
                    OrgInfo orgInfo = orgInfoDaoImpl.selectOrgInfoByOrgode(garage.getOrgId());
                    if (orgInfo != null) {
                        user.setOrgId(orgInfo.getOrgId());
                    }
                    user.setUserCode(garage.getGarageCode());
                    user.setPassword(MD5Util.GetMD5Code("111111"));
                    user.setIsEnable("1");
                    this.userDaoImpl.addUser(user);
                } else {
                    // retMsg("该号码对应的修理厂已经存在");
                    return "exist";
                }
            }
        }
        /************************更新修理厂操作**************************/
        if ("1".equals(oper)) {
            // 查询原修理厂信息
            Garage oldgarage = this.garageDaoImpl.getGarageById(garage.getGarageId());
            // 更新后的号码和原号码不同，更新用户表的信息
            if (!oldgarage.getContactPhone().equals(garage.getContactPhone())) {
                // 判断用户表中是该修理厂的code是否存在
                User usercode = this.userDaoImpl.getUserByUsercode(garage.getGarageCode());
                if (usercode != null) {
                    // 判断手机号是否存在，不存在的更新，存的话提示
                    int userName = userDaoImpl.selectByUserName(garage.getContactPhone());
                    if (userName == 0) {
                        // 根据code更新手机号
                        this.userDaoImpl.updateUserNameByUserCode(garage.getContactPhone(), garage.getGarageCode());
                    } else {
                        return "exist";
                    }
                } else {
                    // 判断手机号是否存在，不存在的新增，存的话提示
                    int userName = userDaoImpl.selectByUserName(garage.getContactPhone());
                    if (userName == 0) {
                        User user = new User();
                        user.setUserName(garage.getContactPhone());
                        user.setRealName(garage.getGarageName());
                        user.setMobilePhone(garage.getContactPhone());
                        user.setCompanyCode(garage.getCompanyCode());
                        // 从组织结构表中查询orgid
                        OrgInfo orgInfo = orgInfoDaoImpl.selectOrgInfoByOrgode(garage.getOrgId());
                        if (orgInfo != null) {
                            user.setOrgId(orgInfo.getOrgId());
                        }
                        user.setUserCode(garage.getGarageCode());
                        user.setPassword(MD5Util.GetMD5Code("111111"));
                        user.setIsEnable("1");
                        this.userDaoImpl.addUser(user);
                    } else {
                        return "exist";
                    }
                }
            }
        }
        return null;
    }

    @Override
    public void deleteGarage(String garageId) {
        // 需要将用户表中该修理厂的用户也删掉
        Garage garage = this.garageDaoImpl.getGarageById(garageId);
        // （通过garage_code删除，手机号有可能会变更）
        String usercode = garage.getGarageCode();
        if (usercode != null) {
            this.userDaoImpl.deleteByCode(usercode);
        }
        this.garageDaoImpl.deleteGarage(garageId);
    }

    public void deleteBatch(List<String> idList) {
        // 批量删除修理厂中用户
        userDaoImpl.deleteBatch(idList);
        garageDaoImpl.deleteBatch(idList);
    }

    @Override
    public int countGarageByConditions(Garage garage) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isGarageCodeExist(String garageCode) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int countGarage(Garage garage) {
        return this.garageDaoImpl.countGarage(garage);
    }

    @Override
    public List<Garage> getAllGarageByCondition(Garage conditionGarage, Integer skip, Integer limit) {
        return this.garageDaoImpl.getGarageList(conditionGarage, skip, limit);
    }

    @Override
    public List<Garage> getGarages() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int countGarageCore(GarageCore garageCore) {
        return this.garageDaoImpl.countGarageCore(garageCore);
    }

    @Override
    public List<GarageCore> getAllGarageCoreByCondition(GarageCore conditionGarageCore, Integer skip, Integer limit) {
        return this.garageDaoImpl.getGarageCoreList(conditionGarageCore, skip, limit);
    }

    @Override
    public GarageCore getGarageCoreById(String garageId) {
        return this.garageDaoImpl.getGarageCoreById(garageId);
    }

    @Override
    public Map<String, String> uploadFile(HttpServletRequest request, MultipartFile file) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Map<String, String> map = new HashMap<String, String>();
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartRequest.getFile("file");
        if (!multipartFile.isEmpty()) {
            String fileType = multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf("."));
            // 文件名称
            String fileName = UUID.randomUUID().toString().replace("-", "") + fileType;
            // 构建文件保存的目录
            String savedate = sdf.format(new Date()) + "/";
            // TODO zhaoyy 20161025 增加图片路径前缀
            String savepath = ossbucketsubname + "/" + garagePhotoPath + savedate;
            if (null != file && !file.isEmpty()) {
                InputStream in;
                try {
                    in = multipartFile.getInputStream();
                    ossManage.uploadFile(in, savepath + fileName, "image/jpeg");
                    // TODO 修改图片路径
                    map.put("url", garagePhotoPath + savedate + fileName);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return map;
    }

    @Override
    public int insertGaragePhoto(GaragePhoto garagePhoto) {
        return this.garagePhotoDaoImpl.addGaragePhoto(garagePhoto);
    }

    @Override
    public List<GaragePhoto> getGaragePhotoByGarageId(String garageId) {
        List<GaragePhoto> photoList = garagePhotoDaoImpl.getGaragePhotoByGarageId(garageId);
        if (photoList != null && photoList.size() > 0) {
            List<GaragePhoto> photoUrlList = new ArrayList<GaragePhoto>();//
            for (GaragePhoto photo : photoList) {// 遍历点评图片
                GaragePhoto ph = new GaragePhoto();
                String photoUrl = ossbucketsubname + "/" + photo.getPhotoUrl();
                // TODO zhaoyy 20161025 根据key获取图片URL地址
                String url = ossManage.getURL(photoUrl);
                ph.setPhotoUrl(url);
                ph.setGaragePhotoId(photo.getGaragePhotoId());
                photoUrlList.add(ph);
            }
            return photoUrlList;
        }
        return new ArrayList<GaragePhoto>();
    }

    @Override
    public void deleteGaragePhoto(String garagePhotoId) {
        // 查询图片在服务器上的地址
        GaragePhoto garagePhoto = this.garagePhotoDaoImpl.getGaragePhotoByGaragePhotoId(garagePhotoId);
        // 删除服务器上的文件
        String fileUrl = ossbucketsubname + "/" + garagePhoto.getPhotoUrl();
        // TODO 获取图片路径 zhaoyy 20161025
        String filePath = ossManage.getURL(fileUrl);
        // 删除服务器上文件
        ossManage.deleteFile(fileUrl);
        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
        }
        this.garagePhotoDaoImpl.deleteGaragePhoto(garagePhotoId);
    }

    /**
     * 同步修理厂信息到查勘平台   (王学杰 2016-11-04 已过时)
     */
    @Override
    @Deprecated
    public String synchroMsGarage(Garage garage, int operType) {
        GarageSupport garageSupport = new GarageSupport();
        try {
            garageSupport.setSurveyNo(URLEncoder.encode(garage.getGarageCode(), "UTF-8"));
            garageSupport.setSurveyName(URLEncoder.encode(garage.getGarageName(), "UTF-8"));
            garageSupport.setAddress(URLEncoder.encode(garage.getGarageAddr(), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        garageSupport.setSurveyPhone(garage.getContactPhone());
        garageSupport.setSituation("2");
        if (Constant.OPER_TYPE_DELETE == operType) {
            garageSupport.setValidStatus("0");
        } else {
            garageSupport.setValidStatus("1");
        }
        garageSupport.setUnitCode(garage.getOrgId());
        garageSupport.setType("1");
        StringBuffer result = new StringBuffer();
        String jsondata = JsonUtils.beanToJson(garageSupport);
        String params = "jsonstr=" + jsondata;
        logger.info("开始调用【同步到查勘平台接口】，传入参数【" + params + "】");
        int retCode = InvokedInterfaceTool.connectionHttpURLByGet(msplatformUrl + "/msplatform/mobile/synCheckUser.action", params, result);
        logger.info("结束调用【同步到查勘平台接口】，返回状态码【" + retCode + "】，返回信息【" + result.toString() + "】");
        // Map<String, Object> resultMap = null;
        // 返回成功状态
        if (retCode == 200) {
            JSONObject jsonObject = JSONObject.fromObject(result.toString());
            JSONObject jsonstr = jsonObject.getJSONObject("jsonstr");
            JSONObject returnMsgDto = jsonstr.getJSONObject("ReturnMsgDto");
            // 返回码
            String resultCode = returnMsgDto.getString("resultCode");
            // 返回信息
            String resultMessage = returnMsgDto.getString("resultMessage");
            // 其它信息
            String extMessage = returnMsgDto.getString("extMessage");
            if ("1".equals(resultCode)) {
                // 返回成功
            } else {
                // 失败
                if ("0".equals(resultCode)) {
                    logger.error("接口【同步到查勘平台接口】访问失败，返回错误码【" + resultCode + "】，错误信息【" + resultMessage + extMessage + "】");
                    return resultCode.toString();
                }
            }
        } else {
            logger.error("接口【同步到查勘平台接口】访问失败，失败的状态码【" + retCode + "】");
            return String.valueOf(retCode);
        }
        return null;
    }

    /**
     * 同步修理厂信息通过核心到调度平台
     * 同步修理厂通过朗泰服务层到调度查勘
     */ 
    @Override
    public String synchroDispatchGarage(Garage garage, int operType) {
        garage.setCreateBy("ET");
        garage.setCreateTime(new Date());
        garage.setUpdateBy("ET");
        garage.setDataSources("1");// 调度设置1
        garage.setUpdateTime(new Date());
        String resultCode = "0";
        // 组装请求信息
        RepairRequest request = new RepairRequest();
        CoreRequestHeadDto head = new CoreRequestHeadDto();
        RequestDetail requestDetail = new RequestDetail();
        requestDetail.setGarageInfo(garage);
        head.setServiceCode("ET");
        head.setServiceName("ET网络送修系统");
        head.setSendCode("1004");
        head.setSendName("ET修理厂数据推送给调度");
        request.setRequestHead(head);
        request.setRequestDetails(requestDetail);
        String result = null;
        XStream xStream = new XStream(new JsonHierarchicalStreamDriver());
        xStream.autodetectAnnotations(true);
        xStream.alias("repairRequest", RepairRequest.class);
        xStream.aliasField("orgCode", Garage.class, "orgId");
        xStream.aliasField("status", Garage.class, "isEnable");
        xStream.aliasField("garageAbbr", Garage.class, "garageNameAbb");
        // 忽略的元素
        xStream.omitField(Garage.class, "garageId");
        xStream.omitField(Garage.class, "garageAddrAbb");
        xStream.omitField(Garage.class, "garageScore");
        String jsondata = xStream.toXML(request);
        String params = jsondata;
        logger.info("开始调用【朗泰核心平台接口】，传入参数【" + params + "】");
        result = InvokedInterfaceTool.httpPost(coreserviceUrl + "/repair/etGarageToDispatch.json", params, "utf-8");
        logger.info("结束调用【朗泰核心平台接口】，返回信息【" + result + "】");
        // 处理返回信息
        XStream xstream = new XStream(new JettisonMappedXmlDriver());
        xstream.autodetectAnnotations(true);
        xstream.alias("repairResponse", RepairResponse.class);
        RepairResponse repairResponse = (RepairResponse) xstream.fromXML(result);
        if (repairResponse != null) {
            ResponseHeadDto responsHead = repairResponse.getResponseHead();
            ReponseGarageInfo reponseGarageInfo = repairResponse.getResponseDetails().getGarageInfo().get(0);
            resultCode = reponseGarageInfo.getResultCode();
            if (resultCode.equals("1")) {
                logger.error("接口【同步到朗泰核心平台接口】访问失败，返回错误码【" + resultCode + "】，错误信息【" + reponseGarageInfo.getErrorMessage() + "】");
            }
        }
        return resultCode;
    }

    @Override
    public Garage getGarageById(String garageId) {
        return garageDaoImpl.getGarageById(garageId);
    }

    @Override
    public List<GaragePhoto> getGaragePhotoById(String garageId) {
        return garagePhotoDaoImpl.getGaragePhotoByGarageId(garageId);
    }

    @Override
    public int isGarageIdExistInGarageCore(String garageId) {
        return garageDaoImpl.isGarageIdExistInGarageCore(garageId);
    }

    @Override
    public String getGarageIdByUserCode(String userCode) {
        return garageDaoImpl.getGarageIdByUserCode(userCode);
    }

    @Override
    public List<Garage> getGarageListByIdList(List<String> idList) {
        return garageDaoImpl.getGarageListByIdList(idList);
    }

    @Override
    public String getTypeNameByCode(String category) {
        return garageDaoImpl.getTypeNameByCode(category);
    }

    @Override
    public String getMaxPointNumber(String orgId) {
        return garageDaoImpl.getMaxPointNumber(orgId);
    }
    /**
	  * 同步到核心 王学杰 206-11-18
	  */
	    @Override
		public int updateGarageCore(GarageCore record){
		 return garageDaoImpl.updateGarageCore(record);
		}
}
