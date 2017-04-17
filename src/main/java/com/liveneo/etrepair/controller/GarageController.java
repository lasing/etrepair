package com.liveneo.etrepair.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.liveneo.etrepair.common.Constant;
import com.liveneo.etrepair.json.wrapper.DropDownModel;
import com.liveneo.etrepair.log.LVLogger;
import com.liveneo.etrepair.pojo.Garage;
import com.liveneo.etrepair.pojo.GarageCore;
import com.liveneo.etrepair.pojo.GaragePhoto;
import com.liveneo.etrepair.pojo.OrgInfo;
import com.liveneo.etrepair.pojo.Type;
import com.liveneo.etrepair.pojo.User;
import com.liveneo.etrepair.service.GarageService;
import com.liveneo.etrepair.service.OrgInfoService;
import com.liveneo.etrepair.service.RepairTaskService;

@Controller
@RequestMapping("/garage")
public class GarageController extends BaseController {
	LVLogger logger = LVLogger.getLogger(this.getClass());
	@Autowired
	private GarageService garageService;
	@Autowired
	private OrgInfoService orgInfoService;
	@Autowired
	private RepairTaskService repairTaskService;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	@ResponseBody
	public String addGarage(String garageId, HttpSession session) {
		User user = (User) session.getAttribute("user");
		Date date = new Date();
		// 根据查询精友修理厂数据转换到ET
		GarageCore garageCore = garageService.getGarageCoreById(garageId);
		Garage garage = new Garage();
		garage.setGarageId(garageCore.getGarageId());
		garage.setOrgId(garageCore.getOrgId());
		garage.setCompanyCode(garageCore.getCompanyCode());
		garage.setPointNumber(garageCore.getAtticepointcode());
		garage.setGarageCode(garageCore.getGarageCode());
		garage.setGarageName(garageCore.getGarageName());
		garage.setGarageAddr(garageCore.getGarageAddr());
		garage.setCategoryCode(garageCore.getCategoryCode());
		garage.setSpecializedBrand(garageCore.getSpecializedBrand());
		garage.setLongitude(garageCore.getLongitude());
		garage.setLatitude(garageCore.getLatitude());
		garage.setContact(garageCore.getContact());
		garage.setContactPhone(garageCore.getContactPhone());
		garage.setRepairTel(garageCore.getRepairTel());
		garage.setRepair4sFlag(garageCore.getRepair4sFlag());
		garage.setOutsideFlag(garageCore.getOutsideFlag());
		garage.setTasklimit(10);
		garage.setIsEnable(garageCore.getIsEnable());
		garage.setCreateTime(date);
		garage.setUpdateTime(date);
		if (user != null) {
			String updateBy = user.getUserName();
			garage.setCreateBy(updateBy);
			garage.setUpdateBy(updateBy);
		}
		try {
			logger.debug("新增修理厂" + garage);
			String retMsg = garageService.addGarage(garage);
			if (retMsg != null) {
				return resultError("该修理厂电话已经存在，请确认后修改");
			}
			/*
			 * String retmsg =
			 * garageService.processSynchroGara(garage,Constant.OPER_TYPE_ADD);
			 * if(retmsg!=null){ return resultError("同步查勘修理厂信息失败"); }
			 */
		} catch (Exception e) {
			logger.error("新增修理厂失败" + e);
			return resultError("新增修理厂失败");
		}
		return resultOK();
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public String deleteGarage(String id) {
		try {
			Garage garage = garageService.getGarageById(id);
			garageService.deleteGarage(id);
			// String retmsg = garageService.synchroMsGarage(garage,
			// Constant.OPER_TYPE_DELETE);
			// if (retmsg != null) {
			// return resultError("同步删除查勘修理厂信息失败");
			// }
		} catch (Exception e) {
			logger.error("删除修理厂失败" + e);
			return resultError("删除修理厂失败");
		}
		return resultOK();
	}

	@RequestMapping(value = "/deleteBatch", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public String deleteBatch(String[] idList) {
		if (idList != null && idList.length > 0) {
			List<String> ids = new ArrayList<String>();
			for (int i = 0; i < idList.length; i++) {
				ids.add(idList[i]);
			}
			// 同步删除查勘平台修理厂
			List<Garage> garageList = garageService.getGarageListByIdList(ids);
			if (garageList != null && garageList.size() > 0) {
				for (Garage garage : garageList) {
					// 这些字段要做非空判断，不然查勘那边会因为参数问题调用返回失败
					if (garage.getGarageName() != null
							&& !"".equals(garage.getGarageName())
							&& garage.getOrgId() != null
							&& !"".equals(garage.getOrgId())
							&& garage.getContactPhone() != null
							&& !"".equals(garage.getContactPhone())) {
						// String retmsg = garageService.synchroMsGarage(garage,
						// Constant.OPER_TYPE_DELETE);
						// if (retmsg != null) {
						// return resultError("同步删除查勘修理厂信息失败");
						// }
					}
				}
			}
			garageService.deleteBatch(ids);
		}
		return resultOK();
	}

	/**
	 * 修理厂类别206-11-17王学杰
	 * 
	 * @return
	 */
	@RequestMapping(value = "/repairList/json", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public String statusList() {
		List<DropDownModel> dropList = new ArrayList<DropDownModel>();
		String taskstatus = "CATEGTYPE";
		List<Type> result = repairTaskService.listRepairTaskStatus(taskstatus);
		for (Type type : result) {
			dropList.add(new DropDownModel(type.getTypeCode(), type
					.getTypeName()));
		}
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(dropList);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
			return JSON_PARSE_ERROR;
		} catch (JsonMappingException e) {
			e.printStackTrace();
			return JSON_PARSE_ERROR;
		} catch (IOException e) {
			e.printStackTrace();
			return JSON_PARSE_ERROR;
		}
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST/*, produces ={"application/json;charset=UTF-8"}*/)
	@ResponseBody
	public String updateGarage(Garage garage, HttpSession session) {
		User user = (User) session.getAttribute("user");
		Garage newgarage = garageService.getGarageById(garage.getGarageId());
		newgarage.setPointNumber(garage.getPointNumber());
		newgarage.setContact(garage.getContact());
		newgarage.setContactPhone(garage.getContactPhone());
		newgarage.setGarageNameAbb(garage.getGarageNameAbb());
		newgarage.setGarageAddrAbb(garage.getGarageAddrAbb());
		newgarage.setGarageAddr(garage.getGarageAddr());
		newgarage.setExpDate(garage.getExpDate());
		newgarage.setTasklimit(garage.getTasklimit());
		newgarage.setServiceFeature(garage.getServiceFeature());
//		newgarage.setCategoryCode(garage.getCategoryCode());
		newgarage.setUpdateTime(new Date());

		// 更新核心 et_garage_core
//		GarageCore newgarageCore = garageService.getGarageCoreById(garage
//				.getGarageId());
//		newgarageCore.setContact(garage.getContact());//联系人
//		newgarageCore.setContactPhone(garage.getContactPhone());//联系人电话
//		newgarageCore.setGarageAbbr(garage.getGarageNameAbb());// 修理厂简称
//		newgarageCore.setGarageAddr(garage.getGarageAddr());// 修理厂地址
//		newgarageCore.setCategoryCode(garage.getCategoryCode());// 修理厂类别
//		newgarageCore.setUpdateTime(new Date());

		if (user != null) {
			String updateBy = user.getUserName();
			newgarage.setUpdateBy(updateBy);
//			newgarageCore.setUpdateBy(updateBy);
		}
		try {
			logger.debug("修改修理厂" + newgarage);
			String retmsg = null;
			retmsg = garageService.updateGarage(newgarage);
//			garageService.updateGarageCore(newgarageCore);
			if (retmsg != null) {
				return resultError(retmsg);
			}
			/****************** 同步更新查勘修理厂 ********************/

			// retmsg = garageService.synchroMsGarage(newgarage,
			// Constant.OPER_TYPE_ADD);
			// if (retmsg != null) {
			// return resultError("同步查勘修理厂信息失败");
			// }
			/****************** 调用核心更新调度修理厂 ********************/
			retmsg = garageService.synchroDispatchGarage(newgarage,
					Constant.OPER_TYPE_ADD);
			if (retmsg == "1") {
				return resultError("同步核心修理厂信息失败");
			}
		} catch (Exception e) {
			logger.error("修改修理厂失败" + e);
			return resultError("修改修理厂失败");
		}
		return resultOK();
	}

	@RequestMapping(value = "/list", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public String getAllGarageByCondition(Garage garage, Integer page,
			Integer rows, HttpSession session) {
		int skip = -1;
		if (page != -1) {
			skip = (page - 1) * rows;
		}
		// 当前组织结构用户只能查看该组织机构的修理厂
		User user = (User) session.getAttribute("user");
		// if (user != null) {
		// if ("admin".equals(user.getUserName())) {
		// if (user.getOrgId() != null) {
		// if (garage.getOrgId() != null) {
		// garage.setOrgId(garage.getOrgId());
		// } else {
		// // 管理员请求全部数据
		// garage.setOrgId(null);
		// }
		// } else {
		// garage.setOrgId(garage.getOrgId());
		// }
		// } else {
		// garage.setOrgId(user.getOrgId());
		// }
		// }
		if (user != null) {
			// admin用户查看所有
			if ("admin".equals(user.getUserName())) {
				if (user.getOrgId() != null) {
                    if (garage.getOrgId() != null) {
                    	garage.setOrgId(garage.getOrgId());
                    } else {
                        // 管理员请求全部数据
                    	garage.setOrgId(null);
                    }
                } else {
                	garage.setOrgId(garage.getOrgId());
                }
			} else {
				// 判断用户是否总公司
				OrgInfo orgInfo = orgInfoService.getOrgInfoByOrgId(user
						.getOrgId()); // 根据机构ID获取组织机构
				if (orgInfo != null && orgInfo.getParentOrgId().isEmpty()) { // 为空
																				// ==总公司
					garage.setOrgId(null);
					garage.setCompanyCode(orgInfo.getCompanyCode());
				} else { // 分公司
					garage.setOrgId(user.getOrgId());
				}
			}
		}
		List<Garage> garages = garageService.getAllGarageByCondition(garage,
				skip, rows);
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("total", garageService.countGarage(garage));
		maps.put("rows", garages);
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(maps);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
			return JSON_PARSE_ERROR;
		} catch (JsonMappingException e) {
			e.printStackTrace();
			return JSON_PARSE_ERROR;
		} catch (IOException e) {
			e.printStackTrace();
			return JSON_PARSE_ERROR;
		}
	}

	@RequestMapping(value = "/getMaxPointNumber", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public String getMaxPointNumber(String orgId) {
		Map<String, Object> maps = new HashMap<String, Object>();
		String mpn = garageService.getMaxPointNumber(orgId);
		maps.put("maxPointNumber", mpn);
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(maps);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
			return JSON_PARSE_ERROR;
		} catch (JsonMappingException e) {
			e.printStackTrace();
			return JSON_PARSE_ERROR;
		} catch (IOException e) {
			e.printStackTrace();
			return JSON_PARSE_ERROR;
		}
	}

	@RequestMapping(value = "/code/exist", method = RequestMethod.GET)
	@ResponseBody
	public boolean isGarageCodeExist(String garageCode) {
		return garageService.isGarageCodeExist(garageCode);
	}

	/**
	 * 返回全部修理厂列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "/list/json", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public String getgaragesJson() {
		List<Garage> garages = this.garageService.getGarages();
		List<DropDownModel> result = new ArrayList<DropDownModel>();
		for (Garage Garage : garages) {
			DropDownModel d = new DropDownModel();
			d.setId(Garage.getGarageCode());
			d.setText(Garage.getGarageName());
			result.add(d);
		}
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(result);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
			return JSON_PARSE_ERROR;
		} catch (JsonMappingException e) {
			e.printStackTrace();
			return JSON_PARSE_ERROR;
		} catch (IOException e) {
			e.printStackTrace();
			return JSON_PARSE_ERROR;
		}
	}

	@RequestMapping(value = "/list/json/default", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public String getgaragesJsonDefault(String defaultVal) {
		List<Garage> garages = this.garageService.getGarages();
		// 添加默认值 0 请选择 ，-1 无
		List<DropDownModel> result = new ArrayList<DropDownModel>();
		DropDownModel defaultDropdown = null;
		if (defaultVal != null && "0".equals(defaultVal)) {
			defaultDropdown = new DropDownModel("0", "--全部--");
			defaultDropdown.setSelected(true);
			result.add(defaultDropdown);
		} else if (defaultVal != null && "-1".equals(defaultVal)) {
			defaultDropdown = new DropDownModel("-1", "--请选择--");
			defaultDropdown.setSelected(true);
			result.add(defaultDropdown);
		}
		for (Garage Garage : garages) {
			DropDownModel d = new DropDownModel();
			d.setId(Garage.getGarageCode());
			d.setText(Garage.getGarageName());
			if (defaultVal.equals(Garage.getGarageCode())) {
				d.setSelected(true);
			}
			result.add(d);
		}
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(result);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
			return JSON_PARSE_ERROR;
		} catch (JsonMappingException e) {
			e.printStackTrace();
			return JSON_PARSE_ERROR;
		} catch (IOException e) {
			e.printStackTrace();
			return JSON_PARSE_ERROR;
		}
	}

	/**
	 * 查询核心修理厂
	 * 
	 * @param garageCore
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping(value = "/core/list", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public String getAllGarageCoreByCondition(GarageCore garageCore,
			Integer page, Integer rows, HttpSession session) {
		int skip = -1;
		if (page != -1) {
			skip = (page - 1) * rows;
		}
		// 当前组织结构用户只能查看该组织机构的修理厂
		User user = (User) session.getAttribute("user");
		// if (user != null) {
		// if ("admin".equals(user.getUserName())) {
		// if (user.getOrgId() != null) {
		// if (garageCore.getOrgId() != null) {
		// garageCore.setOrgId(garageCore.getOrgId());
		// } else {
		// // 管理员请求全部数据
		// garageCore.setOrgId(null);
		// }
		// } else {
		// garageCore.setOrgId(garageCore.getOrgId());
		// }
		// } else {
		// garageCore.setOrgId(user.getOrgId());
		// }
		// }
		if (user != null) {
			// admin用户查看所有
			if ("admin".equals(user.getUserName())) {
				garageCore.setOrgId(null);
			} else {
				// 判断用户是否总公司
				OrgInfo orgInfo = orgInfoService.getOrgInfoByOrgId(user
						.getOrgId()); // 根据机构ID获取组织机构
				if (orgInfo != null && orgInfo.getParentOrgId().isEmpty()) { // 为空
																				// ==总公司
					garageCore.setOrgId(null);
					garageCore.setCompanyCode(orgInfo.getCompanyCode());
				} else { // 分公司
					garageCore.setOrgId(user.getOrgId());
				}
			}
		}
		List<GarageCore> garageCores = garageService
				.getAllGarageCoreByCondition(garageCore, skip, rows);
		List<GarageCore> garageCoreList = new ArrayList<GarageCore>();
		if (garageCores != null && garageCores.size() > 0) {
			for (GarageCore bean : garageCores) {
				int isExists = garageService.isGarageIdExistInGarageCore(bean
						.getGarageId());
				bean.setIsExists(isExists);
				garageCoreList.add(bean);
			}
		}
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("total", garageService.countGarageCore(garageCore));
		maps.put("rows", garageCoreList);
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(maps);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
			return JSON_PARSE_ERROR;
		} catch (JsonMappingException e) {
			e.printStackTrace();
			return JSON_PARSE_ERROR;
		} catch (IOException e) {
			e.printStackTrace();
			return JSON_PARSE_ERROR;
		}
	}

	/**
	 * 文件上传
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/uploadFile", produces = { "application/text;charset=UTF-8" })
	public void uploadFile(HttpServletRequest request,
			HttpServletResponse response, MultipartFile file, String garageId) {
		int res = 0;
		Map<String, String> map = garageService.uploadFile(request, file);
		if (map != null && map.size() > 0) {
			User updateBy = null;
			Object obj = request.getSession(true).getAttribute("user");
			if (obj != null) {
				updateBy = (User) obj;
			}
			String photoUrl = map.get("url");
			GaragePhoto garagePhoto = new GaragePhoto();
			garagePhoto.setGarageId(garageId);
			garagePhoto.setPhotoUrl(photoUrl);
			if (updateBy != null) {
				garagePhoto.setCreateBy(updateBy.getUserName());
				garagePhoto.setUpdateBy(updateBy.getUserName());
			}
			Date date = new Date();
			garagePhoto.setCreateTime(date);
			garagePhoto.setUpdateTime(date);
			res = garageService.insertGaragePhoto(garagePhoto);
		}
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().write("{\"result\":\"" + res + "\"}");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/photolist", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public String getAllGarageByCondition(String garageId) {
		List<GaragePhoto> garagePhotos = garageService
				.getGaragePhotoByGarageId(garageId);
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("total", garagePhotos.size());
		maps.put("rows", garagePhotos);
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(maps);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
			return JSON_PARSE_ERROR;
		} catch (JsonMappingException e) {
			e.printStackTrace();
			return JSON_PARSE_ERROR;
		} catch (IOException e) {
			e.printStackTrace();
			return JSON_PARSE_ERROR;
		}
	}

	@RequestMapping(value = "/photolist/delete", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public String deleteGaragePhoto(String garagePhotoId) {
		try {
			garageService.deleteGaragePhoto(garagePhotoId);
		} catch (Exception e) {
			logger.error("删除修理厂失败" + e);
			return resultError("删除修理厂失败");
		}
		return resultOK();
	}

	@RequestMapping
	public String Garage() {
		return "garage/list";
	}
}
