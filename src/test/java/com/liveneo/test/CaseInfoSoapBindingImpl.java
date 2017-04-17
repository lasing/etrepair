//package com.liveneo.test;
//
//import java.io.StringWriter;
//import java.io.UnsupportedEncodingException;
//import java.io.Writer;
//import java.net.URLEncoder;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import javax.jws.WebService;
//
//import net.sf.json.JSONObject;
//
//import org.apache.commons.httpclient.HttpClient;
//import org.apache.commons.httpclient.cookie.CookiePolicy;
//import org.apache.commons.httpclient.methods.GetMethod;
//import org.apache.commons.httpclient.params.DefaultHttpParams;
//import org.jeecgframework.core.constant.Globals;
//import org.jeecgframework.core.util.ResourceUtil;
//import org.jeecgframework.core.util.StringUtil;
//import org.jeecgframework.web.system.pojo.base.TSBaseUser;
//import org.jeecgframework.web.system.pojo.base.TSTerritory;
//import org.jeecgframework.web.system.service.SystemService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.dispatch.common.DispatchConstants;
//import com.dispatch.entity.survey.TaCaseDispatchEntity;
//import com.dispatch.entity.survey.TaCaseInfoEntity;
//import com.dispatch.entity.survey.TaDispatchItemEntity;
//import com.dispatch.entity.survey.TaLossItemEntity;
//import com.dispatch.entity.survey.TaOrgEntity;
//import com.dispatch.entity.survey.TaPolicyItemEntity;
//import com.dispatch.entity.survey.TaSurveyProvideEntity;
//import com.dispatch.entity.survey.req.PushReq;
//import com.dispatch.entity.survey.resp.GetLatLonResp;
//import com.dispatch.entity.survey.ws.dispatch.AddLossItemRequest;
//import com.dispatch.entity.survey.ws.dispatch.ApplyTaskReassignmentRequest;
//import com.dispatch.entity.survey.ws.dispatch.ApplyVideoReassignmentRequest;
//import com.dispatch.entity.survey.ws.dispatch.ChangeTaskStatusRequest;
//import com.dispatch.entity.survey.ws.dispatch.DelegateLoss;
//import com.dispatch.entity.survey.ws.dispatch.DisableLossItemRequest;
//import com.dispatch.entity.survey.ws.dispatch.DispatchRequest;
//import com.dispatch.entity.survey.ws.dispatch.DispatchResponse;
//import com.dispatch.entity.survey.ws.dispatch.PolicyItem;
//import com.dispatch.entity.survey.ws.dispatch.ResponseHead;
//import com.dispatch.entity.survey.ws.dispatch.SendClaimInfoRequest;
//import com.dispatch.entity.survey.ws.dispatch.SynGarageInfo;
//import com.dispatch.entity.survey.ws.dispatch.SynReassignTaskRequest;
//import com.dispatch.entity.survey.ws.dispatch.SynSurveyorInfo;
//import com.dispatch.service.survey.SurveyWsServiceI;
//import com.dispatch.service.survey.SurveyWxServiceI;
//import com.dispatch.util.GeoUtil;
//import com.dispatch.util.PushUtil;
//import com.dispatch.util.XStreamUtil;
//import com.liveneo.xstream.XStream;
//import com.liveneo.xstream.io.xml.CompactWriter;
//
//@Service("CaseInfoSoapBindingImpl")
//@WebService(targetNamespace = "http://survey.ws.dispatch.com")
//@Transactional
//public class CaseInfoSoapBindingImpl implements CaseInfoSoapBinding {
//
//	/*@Autowired
//	private TaCaseInfoServiceI taCaseInfoService;*/
//	@Autowired
//	private SystemService systemService;
//	@Autowired
//	private SurveyWxServiceI surveyWxService;
//	@Autowired
//	private SurveyWsServiceI surveyWsService;
//	private static final String AK = ResourceUtil.getConfigByName("bdmap.key");
//	//private static final String AK = "F271714e97374b406ad03b0f438e9921";
//	public String sendClaimInfo(String dispatchRequest) {
//
//		systemService.addLog(StringUtil.replaceBlank(dispatchRequest),
//				Globals.Log_Type_WS, Globals.Log_Leavel_INFO);
//		// 返回值
//		DispatchResponse dr = new DispatchResponse();
//		ResponseHead res = new ResponseHead();
//
//		DispatchRequest dres = XStreamUtil.fromXML(dispatchRequest,
//				DispatchRequest.class);
//
//		SendClaimInfoRequest request = dres.getSendClaimInfoRequest();
//
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//		String valiStr = request.validate();
//		if (!"success".equals(valiStr)) {
//			res.setErrorMessage(valiStr);
//			res.setResultCode(ResponseHead.CODE_FAIL);
//			dr.setResponseHead(res);
//			return getResponse(dr);
//		}
//
//		String registNo = request.getRegistNo();
//
//		TaCaseInfoEntity old = systemService.findUniqueByProperty(
//				TaCaseInfoEntity.class, "registNo", registNo);
//		if (old != null) {
//			res.setErrorMessage("重复的报案号");
//			res.setResultCode(ResponseHead.CODE_FAIL);
//			dr.setResponseHead(res);
//			return getResponse(dr);
//		}
//
//		TaCaseInfoEntity taCaseInfo = new TaCaseInfoEntity();
//		taCaseInfo.setContact(request.getContact());
//		taCaseInfo.setContactPhone(request.getContactPhone());
//		try {
//			taCaseInfo.setDamageDate(sdf.parse(request.getDamageDate()));
//			taCaseInfo.setRegistDate(sdf.parse(request.getRegistDate()));
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		taCaseInfo.setDamagePlace(request.getDamagePlace());
//
//		taCaseInfo.setDamagePlaceId(request.getDamageDistrict());
//		taCaseInfo.setDamageRemark(request.getDamageReamrk());
//		taCaseInfo.setInformant(request.getInformant());
//		taCaseInfo.setInformantPhone(request.getInformantPhone());
//		taCaseInfo.setLicenseNo(request.getLicenseNo());
//		taCaseInfo.setRegistNo(request.getRegistNo());
//		taCaseInfo.setStatus(DispatchConstants.TA_CASE_STATUS_DISPATCH_READY);
//		taCaseInfo.setUserName(request.getUserName());
//		taCaseInfo.setSurveyPlace(request.getDamagePlace());
//		taCaseInfo.setSurveyPlaceId(request.getDamageDistrict());
//		taCaseInfo.setRepairCode(request.getRepairCode());
//		taCaseInfo.setBehalfThe(request.getBehalfThe());
//		taCaseInfo.setCompensationCode(request.getCompensationCode());
//		// taCaseInfo.setCompensationOrg(request.getCompensationOrg());//TODO
//		// XUGANG
//
//		// if(request.getCompensationOrg() != null){
//		// TaOrgEntity orgEntity =
//		// systemService.findUniqueByProperty(TaOrgEntity.class, "orgcode",
//		// request.getCompensationCode());
//		// taCaseInfo.setCompOrg(orgEntity);
//		// }
//
//		taCaseInfo.setVIPLevel(request.getVIPLevel());
//
//		TSTerritory tsTer = systemService
//				.findUniqueByProperty(TSTerritory.class, "territoryCode",
//						request.getDamageDistrict());
//		if (tsTer == null) {
//			res.setErrorMessage("无效的区县code");
//			res.setResultCode(ResponseHead.CODE_FAIL);
//			dr.setResponseHead(res);
//			return getResponse(dr);
//		}
//
//		taCaseInfo.setOrg(tsTer.getTaOrg());
//
//		taCaseInfo.setCreateBy(request.getUserCode());
//		taCaseInfo.setCreateTime(new Date());
//		taCaseInfo.setIsEnable(1);
//		taCaseInfo.setIsLock(0);
//		List<DelegateLoss> lossItems = request.getDelegateLoss();
//		List<TaLossItemEntity> taLossItemList = new ArrayList<TaLossItemEntity>();
//		for (DelegateLoss lossItem : lossItems) {
//			String validLoss = lossItem.validate();
//			if (!"success".equals(validLoss)) {
//				res.setErrorMessage(validLoss);
//				res.setResultCode(ResponseHead.CODE_FAIL);
//				dr.setResponseHead(res);
//				return getResponse(dr);
//			}
//			TaLossItemEntity taLoss = new TaLossItemEntity();
//			taLoss.setCreateBy(request.getUserCode());
//			taLoss.setLossName(lossItem.getVehicleModle());
//			taLoss.setLossNo(lossItem.getLossId());
//			taLoss.setLossPageType(Integer.valueOf(lossItem.getLossPageType()));
//			taLoss.setLossType(Integer.valueOf(lossItem.getLossType()));
//			taLoss.setStatus(DispatchConstants.LOSS_ITEM_STATUS_NO);
//			taLoss.setVehicleModel(lossItem.getVehicleModle());
//			taLoss.setMobile(lossItem.getMobile());
//			taLoss.setLossDesc(lossItem.getLossDesc());
//			taLoss.setCreateTime(new Date());
//			taLoss.setIsEnable(1);
//			taLossItemList.add(taLoss);
//		}
//		List<PolicyItem> policyItems = request.getPolicyItems();
//		List<TaPolicyItemEntity> taPolicyItemList = new ArrayList<TaPolicyItemEntity>();
//		for (PolicyItem policyItem : policyItems) {
//			String validPolicy = policyItem.validate();
//			if (!"success".equals(validPolicy)) {
//				res.setErrorMessage(validPolicy);
//				res.setResultCode(ResponseHead.CODE_FAIL);
//				dr.setResponseHead(res);
//				return getResponse(dr);
//			}
//			TaPolicyItemEntity taPolicyItem = new TaPolicyItemEntity();
//			taPolicyItem.setCreateBy(request.getUserCode());
//			taPolicyItem.setInsuranceCode(policyItem.getCategoryCode());
//			taPolicyItem.setInsuranceName(policyItem.getCategoryName());
//			taPolicyItem.setInsuranceTypeCode(policyItem.getSpeciesCode());
//			taPolicyItem.setInsuranceTypeName(policyItem.getCategoryName());
//			taPolicyItem.setItemSort(policyItem.getItemSort());
//			taPolicyItem.setPolicyNumber(policyItem.getPolicyNumber());
//			taPolicyItem.setCreateTime(new Date());
//			taPolicyItem.setIsEnable(1);
//			taPolicyItemList.add(taPolicyItem);
//		}
//		try {
//			/*taCaseInfoService.addMain(taCaseInfo, taLossItemList,
//					taPolicyItemList);*/
//		} catch (Exception e) {
//			e.printStackTrace();
//			res.setErrorMessage("接收错误");
//			res.setResultCode(ResponseHead.CODE_FAIL);
//			systemService.addLog(e.getLocalizedMessage(), Globals.Log_Type_WS,
//					Globals.Log_Leavel_ERROR);
//		}
//
//		try {
//			surveyWxService.getLngLatOfByAddress(taCaseInfo.getDamagePlace(),
//					taCaseInfo.getRegistNo());
//		} catch (Exception e) {
//			e.printStackTrace();
//			systemService.addLog("获取案件经纬度失败", Globals.Log_Type_WX,
//					Globals.Log_Leavel_ERROR);
//		}
//
//		dr.setResponseHead(res);
//		return getResponse(dr);
//	}
//
//	/**
//	 * c02增加损失任务
//	 * 核心传过来的任务永远是普通任务
//	 */
//	public String addLossItem(String dispatchRequest) {
//		systemService.addLog(StringUtil.replaceBlank(dispatchRequest),Globals.Log_Type_WS, Globals.Log_Leavel_INFO);
//		
//		// 返回值
//		DispatchResponse dr = new DispatchResponse();
//		ResponseHead res = new ResponseHead();
//
//		DispatchRequest dres = XStreamUtil.fromXML(dispatchRequest, DispatchRequest.class);
//
//		// 业务逻辑
//		AddLossItemRequest addRes = dres.getAddLossItemRequest();
//		String registNo = addRes.getRegistNo();
//		TaCaseInfoEntity caseInfo = systemService.findUniqueByProperty(TaCaseInfoEntity.class, "registNo", registNo);
//		if (caseInfo == null) {
//			//res.setResultCode(ResponseHead.CODE_FAIL);
//			res.setErrorMessage("无此报案号");
//			dr.setResponseHead(res);
//			return getResponse(dr);
//		}
//
//		List<DelegateLoss> list = addRes.getDelegateLoss();
//		for (DelegateLoss loss : list) {
//			String lossNo = loss.getLossId();
//			
//			String hql0 = "from TaLossItemEntity t where 1 = 1 AND t.lossNo = ? and t.registNo =? ";
//			List<TaLossItemEntity> lossitemList = systemService.findHql(hql0,lossNo,registNo);
//		  
//			TaDispatchItemEntity tdi =null;//调度详情
//			if (lossitemList.size()==0||lossitemList==null) {
//				TaLossItemEntity lossitem = null;
//				// 新增
//				lossitem = new TaLossItemEntity();
//				lossitem.setCaseInfoId(caseInfo.getId());
//				lossitem.setCreateBy("Interface_c02");
//				lossitem.setCreateTime(new Date());
//				lossitem.setIsEnable(1);
//				lossitem.setLossName(loss.getLossName());
//				lossitem.setLossNo(lossNo);
//				lossitem.setLossType(Integer.valueOf(loss.getLossType()));
//				lossitem.setLossPageType(1);
//				lossitem.setIsCompany(0);
//				lossitem.setRegistNo(registNo);
//				
//				if (loss.getSurveyorCode() != null && !"".equals(loss.getSurveyorCode())) {
////					TaSurveyProvideEntity survey = systemService.findUniqueByProperty(TaSurveyProvideEntity.class,"userCode", loss.getSurveyorCode());
//					
//					List<TaSurveyProvideEntity> surveyProvideList = systemService.findHql("from TaSurveyProvideEntity t where t.userCode=? and t.isEnable=1 and rownum = 1", loss.getSurveyorCode());
//					TaSurveyProvideEntity survey = null;
//					if(null != surveyProvideList && surveyProvideList.size()>0){
//						survey = surveyProvideList.get(0);
//					}
//					
//					lossitem.setStatus(DispatchConstants.LOSS_ITEM_STATUS_YES);
//					//调度详情
//					tdi = new TaDispatchItemEntity();
//					tdi.setLossNo(lossNo);
//					//前端页面展示 1代表普通 2代表视频
//					if(addRes.getType().equals("2")){
//						tdi.setDispatchType(1);
//					}else {
//						tdi.setDispatchType(2);
//					}
//				
//					tdi.setDispatchTime(new Date());
//					if (survey != null) {
//						lossitem.setSurveyId(survey.getId());
//						if("1".equals(addRes.getType())){
//							tdi.setVideoSurveyId(survey.getId());
//							tdi.setVideoSurveyName(survey.getName());
//							tdi.setVideoSurveyNumber(survey.getUserCode());
//						}else{
//							tdi.setSurveyId(survey.getId());
//						}
//						tdi.setSurveyNumber(survey.getUserCode());
//						tdi.setSurveyName(survey.getName());
//						TaOrgEntity org = survey.getOrg();
//						if(org!=null){
//							tdi.setCompanyId(org.getId());
//							tdi.setCompanyName(org.getOrgname());
//						}
//						TSBaseUser user = systemService.findUniqueByProperty(TSBaseUser.class,"usercode", addRes.getUserCode());
//						if(user!=null){
//							tdi.setYardmanId(user.getId());
//							tdi.setYardmanName(user.getUserName());
//							tdi.setYardmanNumber(user.getUsercode());
//						}
//						tdi.setMobile(survey.getTel());
//						tdi.setStatus("2");
//					}
//				} else {
//					lossitem.setStatus(DispatchConstants.LOSS_ITEM_STATUS_NO);
//				}
//				// 车型信息
//				// 损失类型分类
//				// 损失情况
//				// 联系电话
//				systemService.save(lossitem);
//				if(tdi!=null){
//					tdi.setCaseInfoId(caseInfo.getId());
//					tdi.setTaLossItem(lossitem);
//					tdi.setLossId(lossitem.getId());
//					systemService.save(tdi);
//				}
//			} else {
//				// 没有修改。。。。。。。。。
//				// 修改
//			/*	lossitem.setLossName(loss.getLossName());
//				lossitem.setLossNo(lossNo);
//				lossitem.setLossType(Integer.valueOf(loss.getLossType()));
//				if (loss.getSurveyorCode() != null && !"".equals(loss.getSurveyorCode())) {
//					TaSurveyProvideEntity survey = systemService.findUniqueByProperty(TaSurveyProvideEntity.class,"userCode", loss.getSurveyorCode());
//					lossitem.setStatus(DispatchConstants.LOSS_ITEM_STATUS_YES);
//					if (survey != null) {
//						lossitem.setSurveyId(survey.getId());
//					}
//				} else {
//					lossitem.setStatus(DispatchConstants.LOSS_ITEM_STATUS_NO);
//				}
//				// 车型信息
//				// 损失类型分类
//				// 损失情况
//				// 联系电话
//				lossitem.setUpdateTime(new Date());
//				systemService.updateEntitie(lossitem);*/
//				res.setResultCode(ResponseHead.CODE_FAIL);
//				res.setErrorMessage("此任务已存在");
//			}
//		}
//
//		dr.setResponseHead(res);
//		return getResponse(dr);
//	}
//
//	/**
//	 * c03注销损失任务
//	 */
//	public String disableLossItem(String dispatchRequest) {
//		systemService.addLog(StringUtil.replaceBlank(dispatchRequest), Globals.Log_Type_WS, Globals.Log_Leavel_INFO);
//		
//		// 返回值
//		DispatchResponse dr = new DispatchResponse();
//		ResponseHead res = new ResponseHead();
//
//		DispatchRequest dres = XStreamUtil.fromXML(dispatchRequest,DispatchRequest.class);
//
//		// 业务逻辑
//		DisableLossItemRequest disRes = dres.getDisableLossItemRequest();
//		String registNo = disRes.getRegistNo();
//		TaCaseInfoEntity caseInfo = systemService.findUniqueByProperty(TaCaseInfoEntity.class, "registNo", registNo);
//		if (caseInfo == null) {
//			//res.setResultCode(ResponseHead.CODE_FAIL);
//			res.setErrorMessage("无此报案号");
//			dr.setResponseHead(res);
//			return getResponse(dr);
//		}
//
//		List<DelegateLoss> list = disRes.getDelegateLoss();
//		for (DelegateLoss loss : list) {
//			String lossNo = loss.getLossId();
//			//TaLossItemEntity lossitem = systemService.findUniqueByProperty(TaLossItemEntity.class, "lossNo", lossNo);
//			String hql0 = "from TaLossItemEntity t where 1 = 1 AND t.lossNo = ? and t.registNo =? ";
//			List<TaLossItemEntity> lossitemList = systemService.findHql(hql0,lossNo,registNo);
//			
//			//if (lossitem != null) {
//			   
//				if (lossitemList.size()>0) {
//				TaLossItemEntity lossitem = lossitemList.get(0);
//				lossitem.setStatus(DispatchConstants.LOSS_ITEM_STATUS_CANCEL);
//				
//				/*if (loss.getSurveyorCode() != null && !"".equals(loss.getSurveyorCode())) {
//					TaSurveyProvideEntity survey = systemService.findUniqueByProperty(TaSurveyProvideEntity.class, "userCode", loss.getSurveyorCode());
//					lossitem.setStatus(DispatchConstants.LOSS_ITEM_STATUS_YES);
//					if (survey != null) {
//						lossitem.setSurveyId(survey.getId());
//					}
//				} else {
//					lossitem.setStatus(DispatchConstants.LOSS_ITEM_STATUS_NO);
//				}*/
//				// 车型信息
//				// 损失类型分类
//				// 损失情况
//				// 联系电话
//				lossitem.setUpdateTime(new Date());
//				systemService.updateEntitie(lossitem);
//				//更新调度详情
//				TaDispatchItemEntity tdi = systemService.findUniqueByProperty(TaDispatchItemEntity.class,"lossId", lossitem.getId());
//				tdi.setStatus("99");
//				systemService.saveOrUpdate(tdi);
//				//更新成功,发送消息
//				String losstypeName = "";
//				if(lossitem.getLossType() == 1){
//					losstypeName = "标的车";
//				}
//				else if(lossitem.getLossType() == 2){
//					losstypeName = "三者车";
//				}
//				else if(lossitem.getLossType() == 3){
//					losstypeName = "本车司机";
//				}
//				else if(lossitem.getLossType() == 4){
//					losstypeName = "本车车上人员";
//				}
//				else if(lossitem.getLossType() == 5){
//					losstypeName = "三者人员";
//				}
//				else if(lossitem.getLossType() == 6){
//					losstypeName = "车上物";
//				}
//				else if(lossitem.getLossType() == 7){
//					losstypeName = "三者物";
//				}
//				String sendMsg = "";
//				if("0".equals(lossitem.getLossNo())){
//					sendMsg = "案件号："+caseInfo.getRegistNo()+";"+losstypeName + "：" + DispatchConstants.DISPATCH_TASK_TYPE_0 + "：" + lossitem.getLossName() + ";任务注销了！";
//				}else{
//					sendMsg = "案件号："+caseInfo.getRegistNo()+";"+losstypeName + "：" + DispatchConstants.DISPATCH_TASK_TYPE_1 + "：" + lossitem.getLossName() + ";任务注销了！";
//				}
//		    	//推送消息给APP
//				PushReq pushReq = new PushReq();
//				pushReq.setAlias(tdi.getSurveyNumber());
//				pushReq.setAlert(sendMsg);
//				PushUtil.sendPush(pushReq);
//			}
//		}
//
//		dr.setResponseHead(res);
//		return getResponse(dr);
//	}
//	
//	/**
//	 * c03-1注销损失案件
//	 */
//	public String disableCase(String dispatchRequest) {
//		systemService.addLog(StringUtil.replaceBlank(dispatchRequest), Globals.Log_Type_WS, Globals.Log_Leavel_INFO);
//		
//		// 返回值
//		DispatchResponse dr = new DispatchResponse();
//		ResponseHead res = new ResponseHead();
//
//		DispatchRequest dres = XStreamUtil.fromXML(dispatchRequest,
//				DispatchRequest.class);
//
//		// 业务逻辑
//		DisableLossItemRequest disRes = dres.getDisableLossItemRequest();
//		String registNo = disRes.getRegistNo();
//		TaCaseInfoEntity caseInfo = systemService.findUniqueByProperty(TaCaseInfoEntity.class, "registNo", registNo);
//		if (caseInfo == null) {
//			//res.setResultCode(ResponseHead.CODE_FAIL);
//			res.setErrorMessage("无此报案号");
//			dr.setResponseHead(res);
//			return getResponse(dr);
//		}
//		//获取案件 所有任务 数据集
//		String hql0 = "from TaLossItemEntity t where  t.registNo =? ";
//		List<TaLossItemEntity> lossitemList = systemService.findHql(hql0,registNo);
//		if (lossitemList.size()>0) {
//			TaLossItemEntity lossitem = lossitemList.get(0);
//			lossitem.setStatus(DispatchConstants.LOSS_ITEM_STATUS_CANCEL);
//			lossitem.setUpdateTime(new Date());
//			systemService.updateEntitie(lossitem);
//			//更新调度详情
//			TaDispatchItemEntity tdi = systemService.findUniqueByProperty(TaDispatchItemEntity.class,"lossId", lossitem.getId());
//			tdi.setStatus("99");
//			systemService.saveOrUpdate(tdi);
//			//更新成功,发送消息
//			String losstypeName = "";
//			if(lossitem.getLossType() == 1){
//				losstypeName = "标的车";
//			}
//			else if(lossitem.getLossType() == 2){
//				losstypeName = "三者车";
//			}
//			else if(lossitem.getLossType() == 3){
//				losstypeName = "本车司机";
//			}
//			else if(lossitem.getLossType() == 4){
//				losstypeName = "本车车上人员";
//			}
//			else if(lossitem.getLossType() == 5){
//				losstypeName = "三者人员";
//			}
//			else if(lossitem.getLossType() == 6){
//				losstypeName = "车上物";
//			}
//			else if(lossitem.getLossType() == 7){
//				losstypeName = "三者物";
//			}
//			String sendMsg = "";
//			if("0".equals(lossitem.getLossNo())){
//				sendMsg = "案件号："+caseInfo.getRegistNo()+";"+losstypeName + "：" + DispatchConstants.DISPATCH_TASK_TYPE_0 + "：" + lossitem.getLossName() + ";案件注销了！";
//			}else{
//				sendMsg = "案件号："+caseInfo.getRegistNo()+";"+losstypeName + "：" + DispatchConstants.DISPATCH_TASK_TYPE_1 + "：" + lossitem.getLossName() + ";案件注销了！";
//			}
//	    	//推送消息给APP
//			PushReq pushReq = new PushReq();
//			pushReq.setAlias(tdi.getSurveyNumber());
//			pushReq.setAlert(sendMsg);
//			PushUtil.sendPush(pushReq);
//		}
//		dr.setResponseHead(res);
//		return getResponse(dr);
//		
//		
//	}
//
//	/**
//	 * c04通知调度系统变更状态
//	 */
//	public String changeTaskStatus(String dispatchRequest) {
//		systemService.addLog(StringUtil.replaceBlank(dispatchRequest), Globals.Log_Type_WS, Globals.Log_Leavel_INFO);
//		
//		// 返回值
//		DispatchResponse dr = new DispatchResponse();
//		ResponseHead res = new ResponseHead();
//		DispatchRequest dres = null;
//
//		try {
//			dres = XStreamUtil.fromXML(dispatchRequest, DispatchRequest.class);
//			String valiStr = dres.getChangeTaskStatusRequest().validate();
//			if (!"success".equals(valiStr)) {
//				res.setErrorMessage(valiStr);
//				res.setResultCode(ResponseHead.CODE_FAIL);
//				dr.setResponseHead(res);
//				return getResponse(dr);
//			}
//			ChangeTaskStatusRequest request = dres.getChangeTaskStatusRequest();
//			String registNo = request.getRegistNo();
//			String userCode = request.getUserCode();
//			
//			TaSurveyProvideEntity surveyProvideEntity = new TaSurveyProvideEntity();
//			if(!userCode.equals("handkoo")){
//				List<TaSurveyProvideEntity> surveyProvideList = systemService.findHql("from TaSurveyProvideEntity t where t.userCode=? and t.isEnable=1 and rownum = 1", userCode);
//				if(null != surveyProvideList && surveyProvideList.size()>0){
//					surveyProvideEntity = surveyProvideList.get(0);
//				} else{
//					res.setErrorMessage("查勘员信息不存在");
//					dr.setResponseHead(res);
//					return getResponse(dr);
//				}
//			}
//			
//			TaCaseInfoEntity caseInfo = systemService.findUniqueByProperty(TaCaseInfoEntity.class, "registNo", registNo);
//			//同步核心案件
//			if (caseInfo == null) {
//				try{
//					caseInfo = surveyWxService.synCaseInfo(registNo);
//				} catch(Exception e){
//					e.printStackTrace();
//					res.setErrorMessage("案件新增错误");
//					res.setResultCode(ResponseHead.CODE_FAIL);
//					systemService.addLog(e.getMessage(), Globals.Log_Type_WS,Globals.Log_Leavel_ERROR);
//				}
//			}
//
//			caseInfo.setDispatchType(Integer.parseInt(request.getType()));
//			List<TaLossItemEntity> losss = new ArrayList<TaLossItemEntity>();
//			if(StringUtil.isNotEmpty(registNo)){
//				try{
//					losss = surveyWxService.synLossItem(caseInfo);
//				} catch(Exception e){
//					e.printStackTrace();
//					res.setErrorMessage("任务同步错误");
//					res.setResultCode(ResponseHead.CODE_FAIL);
//					systemService.addLog(e.getMessage(), Globals.Log_Type_WS,Globals.Log_Leavel_ERROR);
//				}
//			}
//			List<TaLossItemEntity> lists = new ArrayList<TaLossItemEntity>();
//			
//			if(losss.size()<0){
//				losss = systemService.findByProperty(TaLossItemEntity.class, "caseInfoId", caseInfo.getId());
//			}
//			
//			//修改案件状态
//			if(null != losss && losss.size()>0){
//				for (DelegateLoss loss : request.getDelegateLoss()) {
//					for (TaLossItemEntity oldLoss : losss) {
//						if (oldLoss.getLossNo().equals(loss.getLossId())) {
//							TaLossItemEntity lossItem = oldLoss;
//							lossItem.setStatus(Integer.parseInt(loss.getStatus()));
//							lossItem.setRemark(loss.getChangeReason());
//							lists.add(lossItem);
//							
//							//调度详情
//							TaDispatchItemEntity tdi = systemService.findUniqueByProperty(TaDispatchItemEntity.class,"lossId", lossItem.getId());
//							if(null != tdi){
//								tdi.setStatus(loss.getStatus());
//								tdi.setDispatchRemark(loss.getChangeReason());
//								systemService.saveOrUpdate(tdi);
//							} else{
//								dr.setResponseHead(res);
//								return getResponse(dr);
//							}
//							
//							//调度历史 申请改派 调度历史记录
//							if("3".equals(loss.getStatus())){
//								TaCaseDispatchEntity dispatch = new TaCaseDispatchEntity();
//								//普通查勘
//								if("1".equals(tdi.getDispatchType())){
//									TaSurveyProvideEntity survey = systemService.getEntity(TaSurveyProvideEntity.class, tdi.getSurveyId());
//									dispatch.setSurveyName(survey.getName());
//									dispatch.setMobile(survey.getTel());
//								}
//								//0：修理厂，2：视频
//								if("0".equals(tdi.getDispatchType()) || "2".equals(tdi.getDispatchType())){
//									TaSurveyProvideEntity survey = systemService.getEntity(TaSurveyProvideEntity.class, tdi.getVideoSurveyId());
//									dispatch.setSurveyName(survey.getName());
//						        	dispatch.setMobile(survey.getTel());
//								}
//								
//					            dispatch.setSurveyType(tdi.getDispatchType());
//					            dispatch.setCaseInfoId(tdi.getCaseInfoId());
//					            dispatch.setVideoType(DispatchConstants.DISPATCH_TYPE_GP);
//					            dispatch.setSurveyId(tdi.getSurveyId());
//					           
//					            if(userCode.equals("handkoo")){
//					            	dispatch.setDispatchName("");
//					            } else{
//					            	dispatch.setDispatchName(surveyProvideEntity.getName());
//					            }
//					            dispatch.setClientName(tdi.getContact());
//					            dispatch.setClientMobile(tdi.getMobile());
//					            dispatch.setDispatchRemark(tdi.getDispatchRemark());
//					            dispatch.setCreateTime(new Date());
//					            dispatch.setIsEnable(1);
//								dispatch.setResult("改派成功");
//								dispatch.setSurveyType(10);
//								systemService.save(dispatch);//调度历史插入
//							}
//						}
//					}
//				}
//				surveyWsService.changeTaskStatus(lists, caseInfo);
//			} 
//		} catch (Exception e) {
//			e.printStackTrace();
//			res.setErrorMessage("参数错误");
//			res.setResultCode(ResponseHead.CODE_FAIL);
//			systemService.addLog(e.getLocalizedMessage(), Globals.Log_Type_WS,Globals.Log_Leavel_ERROR);
//		}
//		dr.setResponseHead(res);
//		return getResponse(dr);
//	}
//
//	/**
//	 * c05将核心系统中二级调度改派结果同步给调度系统
//	 */
//	public String synReassignTask(String dispatchRequest) {
//		systemService.addLog(StringUtil.replaceBlank(dispatchRequest), Globals.Log_Type_WS, Globals.Log_Leavel_INFO);
//		TaCaseDispatchEntity caseDispatchEntity = new TaCaseDispatchEntity();
//		// 返回值
//		DispatchResponse dr = new DispatchResponse();
//		ResponseHead res = new ResponseHead();
//
//		DispatchRequest dres = null;
//
//		try {
//			dres = XStreamUtil.fromXML(dispatchRequest, DispatchRequest.class);
//			String valiStr = dres.getSynReassignTaskRequest().validate();
//			if (!"success".equals(valiStr)) {
//				res.setErrorMessage(valiStr);
//				res.setResultCode(ResponseHead.CODE_FAIL);
//				dr.setResponseHead(res);
//				return getResponse(dr);
//			}
//			SynReassignTaskRequest request = dres.getSynReassignTaskRequest();
//			String registNo = request.getRegistNo();
//			TaCaseInfoEntity caseInfo = systemService.findUniqueByProperty(
//					TaCaseInfoEntity.class, "registNo", registNo);
//			if (caseInfo == null) {
//				res.setErrorMessage("案件不存在");
//				//res.setResultCode(ResponseHead.CODE_FAIL);
//				dr.setResponseHead(res);
//				return getResponse(dr);
//			}
//
//			caseInfo.setDispatchType(Integer.parseInt(request.getMobileUser()));
//
//			List<TaLossItemEntity> losss = systemService.findByProperty(
//					TaLossItemEntity.class, "caseInfoId", caseInfo.getId());
//
//			List<TaLossItemEntity> lists = new ArrayList<TaLossItemEntity>();
//			for (DelegateLoss loss : request.getDelegateLoss()) {
//				for (TaLossItemEntity oldLoss : losss) {
//					if (oldLoss.getLossNo().equals(loss.getLossId())) {
//						TaLossItemEntity lossItem = oldLoss;
//						if (request.getMobileUser().equals("1")) {
//							lossItem.setSurveyId("");
//							lossItem.setMobile(loss.getMobile());
//							caseDispatchEntity.setSurveyName(caseInfo.getInformant());
//							caseDispatchEntity.setMobile(loss.getMobile());
//						} else {
////							TaSurveyProvideEntity surveyProvideEntity = systemService.findUniqueByProperty(TaSurveyProvideEntity.class,"userCode", loss.getSurveyorCode());
//							List<TaSurveyProvideEntity> surveyProvideList = systemService.findHql("from TaSurveyProvideEntity t where t.userCode=? and t.isEnable=1 and rownum=1 ", loss.getSurveyorCode());
//							TaSurveyProvideEntity surveyProvideEntity = new TaSurveyProvideEntity();
//							if(null != surveyProvideList && surveyProvideList.size()>0){
//								surveyProvideEntity = surveyProvideList.get(0);
//							} else{
//								res.setErrorMessage("查勘员不存在");
//								res.setResultCode(ResponseHead.CODE_FAIL);
//								dr.setResponseHead(res);
//								return getResponse(dr);
//							}
//							lossItem.setSurveyId(surveyProvideEntity.getName());
//							lossItem.setMobile(surveyProvideEntity.getTel());
//							caseDispatchEntity.setSurveyName(surveyProvideEntity.getName());
//							caseDispatchEntity.setMobile(surveyProvideEntity.getTel());
//							caseDispatchEntity.setSurveyId(surveyProvideEntity.getId());
//						}
//						lossItem.setStatus(Integer.parseInt(loss.getStatus()));
//						lossItem.setLossName(loss.getLossName());
//						lossItem.setLossType(Integer.parseInt(loss
//								.getLossType()));
//						caseDispatchEntity.setCaseInfoId(caseInfo.getId());
//						caseDispatchEntity.setSurveyType(Integer
//								.parseInt(request.getMobileUser()));
//						lists.add(lossItem);
//					}
//				}
//			}
//
//			surveyWsService
//					.synReassignTask(caseDispatchEntity, lists, caseInfo);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			res.setErrorMessage("处理错误");
//			res.setResultCode(ResponseHead.CODE_FAIL);
//			systemService.addLog(e.getLocalizedMessage(), Globals.Log_Type_WS,
//					Globals.Log_Leavel_ERROR);
//		}
//		dr.setResponseHead(res);
//		return getResponse(dr);
//	}
//
//	/**
//	 * c06 c07视频定损查勘员改派申请接口
//	 */
//	public String applyVideoReassignment(String dispatchRequest) {
//		systemService.addLog(StringUtil.replaceBlank(dispatchRequest),
//				Globals.Log_Type_WS, Globals.Log_Leavel_INFO);
//		TaCaseDispatchEntity caseDispatchEntity = new TaCaseDispatchEntity();
//		// 返回值
//		DispatchResponse dr = new DispatchResponse();
//		ResponseHead res = new ResponseHead();
//
//		DispatchRequest dres = null;
//
//		try {
//			dres = XStreamUtil.fromXML(dispatchRequest, DispatchRequest.class);
//			String valiStr = dres.getApplyVideoReassignmentRequest().validate();
//			if (!"success".equals(valiStr)) {
//				res.setErrorMessage(valiStr);
//				res.setResultCode(ResponseHead.CODE_FAIL);
//				dr.setResponseHead(res);
//				return getResponse(dr);
//			}
//
//			ApplyVideoReassignmentRequest request = dres
//					.getApplyVideoReassignmentRequest();
//
//			String registNo = request.getRegistNo();
//			TaCaseInfoEntity caseInfo = systemService.findUniqueByProperty(
//					TaCaseInfoEntity.class, "registNo", registNo);
//			if (caseInfo == null) {
//				res.setErrorMessage("案件不存在");
//				//res.setResultCode(ResponseHead.CODE_FAIL);
//				dr.setResponseHead(res);
//				return getResponse(dr);
//			}
//
//			caseInfo.setDispatchType(Integer.parseInt(request.getMobileUser()));
//
//			List<TaLossItemEntity> losss = systemService.findByProperty(
//					TaLossItemEntity.class, "caseInfoId", caseInfo.getId());
//
//			List<TaLossItemEntity> lists = new ArrayList<TaLossItemEntity>();
//			for (DelegateLoss loss : request.getDelegateLoss()) {
//				for (TaLossItemEntity oldLoss : losss) {
//					if (oldLoss.getLossNo().equals(loss.getLossId())) {
//						TaLossItemEntity lossItem = oldLoss;
//
//						lossItem.setSurveyId("");
//						lossItem.setStatus(Integer.parseInt(loss.getStatus()));
//						lossItem.setLossName(loss.getLossName());
//						lossItem.setLossPageType(Integer.parseInt(loss
//								.getLossType()));
//
//						caseDispatchEntity.setCaseInfoId(caseInfo.getId());
//						caseDispatchEntity.setSurveyType(Integer
//								.parseInt(request.getMobileUser()));
//						caseDispatchEntity.setCreateBy(request.getUserCode());
//						caseDispatchEntity.setDispatchRemark(request
//								.getApplyRemark());
//						lists.add(lossItem);
//					}
//				}
//			}
//
//			surveyWsService.applyVideoReassignment(caseDispatchEntity, lists,
//					caseInfo);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			res.setErrorMessage("参数错误");
//			res.setResultCode(ResponseHead.CODE_FAIL);
//			systemService.addLog(e.getLocalizedMessage(), Globals.Log_Type_WS,
//					Globals.Log_Leavel_ERROR);
//		}
//		dr.setResponseHead(res);
//		return getResponse(dr);
//	}
//
//	/**
//	 * c08申请改派任务接口
//	 */
//	public String applyTaskReassignment(String dispatchRequest) {
//		systemService.addLog(StringUtil.replaceBlank(dispatchRequest),
//				Globals.Log_Type_WS, Globals.Log_Leavel_INFO);
//		TaCaseDispatchEntity caseDispatchEntity = new TaCaseDispatchEntity();
//		// 返回值
//		DispatchResponse dr = new DispatchResponse();
//		ResponseHead res = new ResponseHead();
//
//		DispatchRequest dres = null;
//
//		try {
//			dres = XStreamUtil.fromXML(dispatchRequest, DispatchRequest.class);
//			String valiStr = dres.getApplyTaskReassignmentRequest().validate();
//			if (!"success".equals(valiStr)) {
//				res.setErrorMessage(valiStr);
//				res.setResultCode(ResponseHead.CODE_FAIL);
//				dr.setResponseHead(res);
//				return getResponse(dr);
//			}
//			ApplyTaskReassignmentRequest request = dres
//					.getApplyTaskReassignmentRequest();
//
//			String registNo = request.getRegistNo();
//			TaCaseInfoEntity caseInfo = systemService.findUniqueByProperty(
//					TaCaseInfoEntity.class, "registNo", registNo);
//			if (caseInfo == null) {
//				res.setErrorMessage("案件不存在");
//				//res.setResultCode(ResponseHead.CODE_FAIL);
//				dr.setResponseHead(res);
//				return getResponse(dr);
//			}
//
//			caseInfo.setDispatchType(Integer.parseInt(request.getMobileUser()));
//
//			List<TaLossItemEntity> losss = systemService.findByProperty(
//					TaLossItemEntity.class, "caseInfoId", caseInfo.getId());
//
//			List<TaLossItemEntity> lists = new ArrayList<TaLossItemEntity>();
//			for (DelegateLoss loss : request.getDelegateLoss()) {
//				for (TaLossItemEntity oldLoss : losss) {
//					if (oldLoss.getLossNo().equals(loss.getLossId())) {
//						TaLossItemEntity lossItem = oldLoss;
//
//						lossItem.setSurveyId("");
//						lossItem.setStatus(Integer.parseInt(loss.getStatus()));
//						lossItem.setLossName(loss.getLossName());
//						lossItem.setLossPageType(Integer.parseInt(loss
//								.getLossType()));
//
//						caseDispatchEntity.setCaseInfoId(caseInfo.getId());
//						caseDispatchEntity.setSurveyType(Integer
//								.parseInt(request.getMobileUser()));
//						caseDispatchEntity.setCreateBy(request.getUserCode());
//						caseDispatchEntity.setDispatchRemark(request
//								.getApplyRemark());
//						lists.add(lossItem);
//					}
//				}
//			}
//
//			surveyWsService.applyVideoReassignment(caseDispatchEntity, lists,
//					caseInfo);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			res.setErrorMessage("参数错误");
//			res.setResultCode(ResponseHead.CODE_FAIL);
//			systemService.addLog(e.getLocalizedMessage(), Globals.Log_Type_WS,
//					Globals.Log_Leavel_ERROR);
//		}
//		dr.setResponseHead(res);
//		return getResponse(dr);
//	}
//
//	/**
//	 * c09案件任务转交接口
//	 */
//	public String taskTransfer(String dispatchRequest) {
//		systemService.addLog(StringUtil.replaceBlank(dispatchRequest),
//				Globals.Log_Type_WS, Globals.Log_Leavel_INFO);
//		// 返回值
//		DispatchResponse dr = new DispatchResponse();
//		ResponseHead res = new ResponseHead();
//
//		DispatchRequest dres = XStreamUtil.fromXML(dispatchRequest,
//				DispatchRequest.class);
//
//		dr.setResponseHead(res);
//		return getResponse(dr);
//	}
//
//	/**
//	 * c10查勘员信息同步接口  （备注：由于无法区分车险和非车险查勘员，所以此接口已经废弃）
//	 */
//	public String synSurveyorInfo(String dispatchRequest) {
//		systemService.addLog(StringUtil.replaceBlank(dispatchRequest), Globals.Log_Type_WS, Globals.Log_Leavel_INFO);
//		// 返回值
//		DispatchResponse dr = new DispatchResponse();
//		ResponseHead res = new ResponseHead();
////		DispatchRequest dres = XStreamUtil.fromXML(dispatchRequest, DispatchRequest.class);
////		//业务逻辑
////		SynSurveyorInfo surveyInfo = dres.getSynSurveyorInfo();
////		String vali = surveyInfo.validate();
////		if (!"success".equals(vali)) {
////			res.setErrorMessage(vali);
////			res.setResultCode(ResponseHead.CODE_FAIL);
////			dr.setResponseHead(res);
////			return getResponse(dr);
////		}
////		//调度系统（组织机构表）
////		TaOrgEntity org = systemService.findUniqueByProperty(TaOrgEntity.class,"orgcode", surveyInfo.getOrgCode());
////		if (org == null) {
////			res.setErrorMessage("组织机构编号错误");
////			res.setResultCode(ResponseHead.CODE_FAIL);
////			dr.setResponseHead(res);
////			return getResponse(dr);
////		}
////		//核心系统（查勘提供方）
////		List<TaSurveyProvideEntity> surveyList = systemService.findHql("from TaSurveyProvideEntity t where t.userCode=? and t.isEnable=1 and rownum=1", surveyInfo.getUserCode());
////		TaSurveyProvideEntity survey = null;
////		if(null != surveyList && surveyList.size()>0){
////			survey = surveyList.get(0);
////			survey.setUpdateDate(new Date());
////			survey.setUpdateBy("Interface_C10");
////		} else{
////			survey = new TaSurveyProvideEntity();
////			survey.setCreateDate(new Date());
////			survey.setCreateBy("Interface_C10");
////			survey.setPassWord("111111");
////			survey.setIsEnable(1);
////			survey.setSignStatus(0);
////			survey.setTaskUpperLimit(10);
////		}
////		survey.setName(surveyInfo.getName());
////		survey.setTel(surveyInfo.getPhone());
////		survey.setUserCode(surveyInfo.getUserCode());
////		survey.setOrg(org);
////		survey.setOrgCode(org.getOrgcode());
////		survey.setIsVideo(Integer.valueOf(surveyInfo.getIsVideo()));
////		survey.setSurveytype(TaSurveyProvideEntity.SURVEY_TYPE_CK);
////		if ("9".equals(surveyInfo.getStatus())) {
////			survey.setIsEnable(0);
////			try {
////				systemService.saveOrUpdate(survey);
////			} catch (Exception e) {
////				e.printStackTrace();
////				res.setErrorMessage("注销查勘员错误");
////				res.setResultCode(ResponseHead.CODE_FAIL);
////				dr.setResponseHead(res);
////				return getResponse(dr);
////			}
////			dr.setResponseHead(res);
////			return getResponse(dr);
////		} else{
////			try {
////				systemService.saveOrUpdate(survey);
////			} catch (Exception e) {
////				e.printStackTrace();
////				res.setErrorMessage("修改查勘员错误");
////				res.setResultCode(ResponseHead.CODE_FAIL);
////				dr.setResponseHead(res);
////				return getResponse(dr);
////			}
////		}
//		dr.setResponseHead(res);
//		return getResponse(dr);
//	}
//
//	/**
//	 * c11修理厂信息同步接口
//	 */
//	public String synGarageInfo(String dispatchRequest) {
//		
//		systemService.addLog(StringUtil.replaceBlank(dispatchRequest),Globals.Log_Type_WS, Globals.Log_Leavel_INFO);
//		// 返回值
//		DispatchResponse dr = new DispatchResponse();
//		ResponseHead res = new ResponseHead();
//		try {
//		DispatchRequest dres = XStreamUtil.fromXML(dispatchRequest,DispatchRequest.class);
//		//业务逻辑
//		SynGarageInfo garageInfo = dres.getSynGarageInfo();
//		String vali = garageInfo.validate();
//		
//		if (StringUtil.isEmpty(garageInfo.getAddress())) {
//			res.setErrorMessage("修理厂地址不能为空");
//			res.setResultCode(ResponseHead.CODE_FAIL);
//			dr.setResponseHead(res);
//			return getResponse(dr);
//		}
//		//修理厂地址解析 
//		
//        String addressEncoded;
//		try {
//			addressEncoded = URLEncoder.encode(garageInfo.getAddress(), "utf-8");
//		} catch (UnsupportedEncodingException e1) {
//			res.setErrorMessage("修理厂地址utf-8编码转换失败"+e1.getMessage());
//			res.setResultCode(ResponseHead.CODE_FAIL);
//			dr.setResponseHead(res);
//			return getResponse(dr);
//		}
//        DefaultHttpParams.getDefaultParams().setParameter("http.protocol.cookie-policy", CookiePolicy.BROWSER_COMPATIBILITY);
//        String url = GeoUtil.GET_LAT_LON_URL.replace("ADDRESS", addressEncoded).replace("AK", AK);
//        //{"results":[],"status":1,"msg":"Internal Service Error:\u65e0\u76f8\u5173\u7ed3\u679c"}
//
//        HttpClient httpClient= new HttpClient();
//		GetMethod getMethod = new GetMethod(url);
//		GetLatLonResp getLatLonResp = new GetLatLonResp();
//		try {
//			httpClient.executeMethod(getMethod);
//			String respStr = getMethod.getResponseBodyAsString();
//			System.out.println(respStr);
//			JSONObject jobj = JSONObject.fromObject(respStr);
//			
//			if("0".equals(jobj.get("status").toString())) {
//				JSONObject location = (JSONObject)((JSONObject) jobj.get("result")).get("location");
//				getLatLonResp.setLatitude(location.get("lat").toString());
//				getLatLonResp.setLongitude(location.get("lng").toString());
//			} else {
//				res.setErrorMessage("修理厂地址："+garageInfo.getAddress()+jobj.toString());
//				res.setResultCode(ResponseHead.CODE_FAIL);
//				dr.setResponseHead(res);
//				return getResponse(dr);
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			res.setErrorMessage("修理厂地址："+garageInfo.getAddress()+"经纬度解析失败"+e.getMessage());
//			res.setResultCode(ResponseHead.CODE_FAIL);
//			dr.setResponseHead(res);
//			return getResponse(dr);
//		}
//		//getLatLonResp地址解析结束
//		if (!"success".equals(vali)) {
//			res.setErrorMessage(vali);
//			res.setResultCode(ResponseHead.CODE_FAIL);
//			dr.setResponseHead(res);
//			return getResponse(dr);
//		}
//		
//		//调度系统（组织机构表）
//		TaOrgEntity org = systemService.findUniqueByProperty(TaOrgEntity.class,"orgcode", garageInfo.getOrgCode());
//		if (org == null) {
//			res.setErrorMessage("组织机构编号错误");
//			res.setResultCode(ResponseHead.CODE_FAIL);
//			dr.setResponseHead(res);
//			return getResponse(dr);
//		}
//		
//		//核心系统（查勘提供方）
//		List<TaSurveyProvideEntity> surveyList = systemService.findHql("from TaSurveyProvideEntity t where t.userCode=?  and t.surveytype=1 and rownum=1", garageInfo.getUserCode());
//		TaSurveyProvideEntity survey = null;
//		//更新
//		if(null != surveyList && surveyList.size()>0){
//			for(int i=0;i<surveyList.size();i++){
//				survey = surveyList.get(i);
//				survey.setUpdateDate(new Date());
//				survey.setUpdateBy("Interface_C11");
//				survey.setIsVideo(Integer.valueOf(garageInfo.getIsVideo()));
//				survey.setName(garageInfo.getName());
//				survey.setAbbreviation(garageInfo.getName());
//				survey.setSurveytype(TaSurveyProvideEntity.SURVEY_TYPE_XL);
//				survey.setUserCode(garageInfo.getUserCode());
//				survey.setTel(garageInfo.getPhone());
//				survey.setOrg(org);
//				survey.setOrgCode(org.getOrgcode());
//				survey.setAddress(garageInfo.getAddress());
//				survey.setLatitude(Double.parseDouble(getLatLonResp.getLatitude()));
//				survey.setLongitude(Double.parseDouble(getLatLonResp.getLatitude()));
//				//注销修理厂
//				if ("9".equals(garageInfo.getStatus())) {
//					survey.setIsEnable(0);
//					try {
//						systemService.saveOrUpdate(survey);
//					} catch (Exception e) {
//						e.printStackTrace();
//						res.setErrorMessage("注销修理厂错误");
//						res.setResultCode(ResponseHead.CODE_FAIL);
//						dr.setResponseHead(res);
//						return getResponse(dr);
//					}
//					dr.setResponseHead(res);
//					return getResponse(dr);
//				} else{//更新或者新增修理厂
//					try {
//						systemService.saveOrUpdate(survey);
//					} catch (Exception e) {
//						e.printStackTrace();
//						res.setErrorMessage("修改查勘员错误");
//						res.setResultCode(ResponseHead.CODE_FAIL);
//						dr.setResponseHead(res);
//						return getResponse(dr);
//					}
//				}
//			}
//		} else{//新增
//			survey = new TaSurveyProvideEntity();
//			survey.setCreateDate(new Date());
//			survey.setCreateBy("Interface_C11");
//			survey.setPassWord("111111");
//			survey.setIsEnable(1);//默认为可用
//			survey.setTaskUpperLimit(10);//默认为10
//			survey.setSignStatus(1);//默认为签到
//			survey.setIsVideo(Integer.valueOf(garageInfo.getIsVideo()));
//			survey.setName(garageInfo.getName());
//			survey.setAbbreviation(garageInfo.getName());
//			survey.setSurveytype(TaSurveyProvideEntity.SURVEY_TYPE_XL);
//			survey.setUserCode(garageInfo.getUserCode());
//			survey.setTel(garageInfo.getPhone());
//			survey.setOrg(org);
//			survey.setOrgCode(org.getOrgcode());
//			survey.setAddress(garageInfo.getAddress());
//			survey.setLatitude(Double.parseDouble(getLatLonResp.getLatitude()));
//			survey.setLongitude(Double.parseDouble(getLatLonResp.getLatitude()));
//			systemService.save(survey);
//		}
//		dr.setResponseHead(res);
//		return getResponse(dr);
//		} catch (Exception e) {
//			e.printStackTrace();
//			res.setErrorMessage(e.getMessage());
//			res.setResultCode(ResponseHead.CODE_FAIL);
//			dr.setResponseHead(res);
//			return getResponse(dr);
//		}
//	}
//
//	/**
//	 * c124S店信息同步接口
//	 */
//	public String syn4SInfo(String dispatchRequest) {
//		systemService.addLog(StringUtil.replaceBlank(dispatchRequest),
//				Globals.Log_Type_WS, Globals.Log_Leavel_INFO);
//		// 返回值
//		DispatchResponse dr = new DispatchResponse();
//		ResponseHead res = new ResponseHead();
//		DispatchRequest dres = XStreamUtil.fromXML(dispatchRequest,
//				DispatchRequest.class);
//
//		dr.setResponseHead(res);
//		return getResponse(dr);
//	}
//
//	/**
//	 * c013调度用户信息同步接口
//	 */
//	public String synUserInfo(String dispatchRequest) {
//		systemService.addLog(StringUtil.replaceBlank(dispatchRequest),
//				Globals.Log_Type_WS, Globals.Log_Leavel_INFO);
//		//暂时 接口不用 只实现了 车险  
//		/*// 返回值
//		DispatchResponse dr = new DispatchResponse();
//		ResponseHead res = new ResponseHead();
//
//		DispatchRequest dres = XStreamUtil.fromXML(dispatchRequest,
//				DispatchRequest.class);
//
//		SynUserInfo userInfo = dres.getSynUserInfo();
//		String vali = userInfo.validate();
//		if (!"success".equals(vali)) {
//			res.setErrorMessage(vali);
//			res.setResultCode(ResponseHead.CODE_FAIL);
//			dr.setResponseHead(res);
//			return getResponse(dr);
//		}
//		TSUser user = systemService.findUniqueByProperty(TSUser.class,
//				"usercode", userInfo.getUserCode());
//		if ("9".equals(userInfo.getStatus())) {
//			if (user == null) {
//				res.setErrorMessage("没有找到该调度员");
//				res.setResultCode(ResponseHead.CODE_FAIL);
//				dr.setResponseHead(res);
//				return getResponse(dr);
//			} else {
//				user.setStatus(WebConstants.TS_USER_STATUS_DEL);
//				try {
//					systemService.updateEntitie(user);
//				} catch (Exception e) {
//					e.printStackTrace();
//					res.setErrorMessage("注销调度员错误");
//					res.setResultCode(ResponseHead.CODE_FAIL);
//					dr.setResponseHead(res);
//					return getResponse(dr);
//				}
//				dr.setResponseHead(res);
//				return getResponse(dr);
//			}
//		}
//
//		TSUser user1 = systemService.findUniqueByProperty(TSUser.class,
//				"userName", userInfo.getUserName());
//		if (user1 != null && user1.getUsercode() != userInfo.getUserCode()) {
//			res.setErrorMessage("调度员账户重复");
//			res.setResultCode(ResponseHead.CODE_FAIL);
//			dr.setResponseHead(res);
//			return getResponse(dr);
//		}
//
//		if (user == null) {
//			user = new TSUser();
//		}
//
//		TSDepart td = systemService.findUniqueByProperty(TSDepart.class,
//				"departname", "信息部");
//
//		user.setMobilePhone(userInfo.getPhone());
//		user.setRealName(userInfo.getRealName());
//		user.setUsercode(userInfo.getUserCode());
//		user.setUserName(userInfo.getUserName());
//		user.setStatus(Globals.User_Normal);
//		user.setTSDepart(td);
//		try {
//			systemService.save(user);
//		} catch (Exception e) {
//			e.printStackTrace();
//			res.setErrorMessage("修改查勘员错误");
//			res.setResultCode(ResponseHead.CODE_FAIL);
//			dr.setResponseHead(res);
//			return getResponse(dr);
//		}
//
//		dr.setResponseHead(res);
//		return getResponse(dr);*/
//		// 返回值
//		DispatchResponse dr = new DispatchResponse();
//		ResponseHead res = new ResponseHead();
//		dr.setResponseHead(res);
//		return getResponse(dr);
//	}
//
//	public String getResponse(DispatchResponse res) {
//		String reStr = "";
//		XStream xstream = new XStream();
//		xstream.autodetectAnnotations(true);
//		Writer writer = new StringWriter();
//		xstream.marshal(res, new CompactWriter(writer));
//		reStr = writer.toString();
//		systemService.addLog(StringUtil.replaceBlank(reStr),
//				Globals.Log_Type_WS, Globals.Log_Leavel_INFO);
//		return reStr;
//	}
//}
