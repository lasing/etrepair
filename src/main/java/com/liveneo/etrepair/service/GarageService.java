package com.liveneo.etrepair.service;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;
import com.liveneo.etrepair.pojo.Garage;
import com.liveneo.etrepair.pojo.GarageCore;
import com.liveneo.etrepair.pojo.GaragePhoto;

public interface GarageService {
    public String addGarage(Garage garage);

    public void deleteGarage(String garageId);

    public void deleteBatch(List<String> idList);

    public String updateGarage(Garage garage) throws Exception;

    public int countGarageByConditions(Garage garage);

    public boolean isGarageCodeExist(String garageCode);

    public int countGarage(Garage garage);

    public List<Garage> getAllGarageByCondition(Garage conditionGarage, Integer skip, Integer limit);

    // 获取所有ET修理厂列表
    public List<Garage> getGarages();

    public int countGarageCore(GarageCore garageCore);

    /**
     * 查询精友修理厂列表
     * @param conditionGarageCore
     * @param skip
     * @param limit
     * @return
     */
    public List<GarageCore> getAllGarageCoreByCondition(GarageCore conditionGarageCore, Integer skip, Integer limit);

    public GarageCore getGarageCoreById(String garageId);

    Map<String, String> uploadFile(HttpServletRequest request, MultipartFile file);

    int insertGaragePhoto(GaragePhoto garagePhoto);

    public String synchroMsGarage(Garage garage, int operType);

    public String synchroDispatchGarage(Garage garage, int operType);

    public List<GaragePhoto> getGaragePhotoByGarageId(String garageId);

    public void deleteGaragePhoto(String garagePhotoId);

    public Garage getGarageById(String garageId);

    public List<GaragePhoto> getGaragePhotoById(String garageId);

    public int isGarageIdExistInGarageCore(String garageId);

    public String getGarageIdByUserCode(String userCode);

    public List<Garage> getGarageListByIdList(List<String> idList);

    public String getTypeNameByCode(String category);

    /**
     * 根据机构id 获取最大的编号
     * @param orgId
     * @return
     */
    String getMaxPointNumber(String orgId);
    
    /**
	  * 同步到核心 王学杰 206-11-18
	  */
   public int updateGarageCore(GarageCore record)throws Exception;
}
