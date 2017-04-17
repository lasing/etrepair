package com.liveneo.etrepair.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.liveneo.etrepair.common.SendMessage;
import com.liveneo.etrepair.dao.mapper.impl.GarageDaoImpl;
import com.liveneo.etrepair.dao.mapper.impl.RepairTaskDaoImpl;
import com.liveneo.etrepair.dao.mapper.impl.TypeDaoImpl;
import com.liveneo.etrepair.pojo.EvaluatePhoto;
import com.liveneo.etrepair.pojo.EvaluteItem;
import com.liveneo.etrepair.pojo.Garage;
import com.liveneo.etrepair.pojo.Message;
import com.liveneo.etrepair.pojo.RepairTask;
import com.liveneo.etrepair.pojo.ScoreDetail;
import com.liveneo.etrepair.pojo.SendInfo;
import com.liveneo.etrepair.pojo.TaskEvalute;
import com.liveneo.etrepair.pojo.Type;
import com.liveneo.etrepair.service.RepairTaskService;

@Service
public class RepairTaskServiceImpl implements RepairTaskService {
    @Autowired
    private RepairTaskDaoImpl repairTaskDaoImpl;
    @Autowired
    private TypeDaoImpl       typeDaoImpl;
    @Autowired
    private GarageDaoImpl     garageDaoImpl;
    @Resource
    SendMessage               sendMessage;

    @Override
    public RepairTask getTaskDetailByTaskId(String taskId) {
        return repairTaskDaoImpl.getTaskDetailByTaskId(taskId);
    }

    @Override
    public void updateRepairTaskStatus(String taskId, String registNo, String targetStatus) {
        if (!StringUtils.equals("99", targetStatus)) {
            RepairTask repairTasks = new RepairTask();
            repairTasks.setTaskId(taskId);
            repairTasks.setStatus(targetStatus);
            Date now = new Date();
            switch (Integer.valueOf(targetStatus)) {
            // 状态 0：送修发起 1：维修中 2:车辆抵场放弃 3：车辆未抵厂放弃
            // 4:用户取消放弃 5:车辆已修好 6:用户提车确认 7：用户评分完成
            case 5:
                repairTasks.setInformTime(now);
                repairTasks.setPreStatus("1");
                break;
            case 6:
                repairTasks.setFinishTime(now);
                repairTasks.setPreStatus("5");
                break;
            case 7:
                repairTasks.setEvTime(now);
                repairTasks.setPreStatus("6");
                break;
            case 3:
                repairTasks.setConfirmTime(now);
                repairTasks.setPreStatus("0");
                break;
            case 2:
                repairTasks.setConfirmTime(now);
                repairTasks.setPreStatus("0");
                break;
            case 4:
                repairTasks.setConfirmTime(now);
                repairTasks.setPreStatus("0");
                break;
            default:
                repairTasks.setConfirmTime(now);
                break;
            }
            repairTasks.setUpdateTime(now);
            int i = this.repairTaskDaoImpl.updateRepairTaskStatus(repairTasks);
            /**********************参考APP接口调用推送逻辑**************************/
            if (i > 0) {
                /** 状态 0：送修发起 1：维修中 2:车辆抵场放弃 3：车辆未抵厂放弃 4:用户取消放弃 
                 5:车辆已修好 6:用户提车确认 7：用户评分完成
                 **/
                RepairTask repairTask = repairTaskDaoImpl.getTaskDetailByTaskId(taskId);
                // 查询根据任务号修理厂信息
                Garage garage = garageDaoImpl.getGarageById(repairTask.getGarageId());
                // 修理厂名称
                String garageName = garage.getGarageName();
                // 修理厂电话
                String phoneNo = garage.getContactPhone();
                // 案件号
                String caseNo = repairTask.getTaskId();
                // 获取发生任务手机号
                String phoneBC = repairTask.getUserAccount();
                // 任务类型
                String taskType = repairTask.getTaskType();
                /******* A端变更推送给B端或者C端(任务类型如果为1车主，则推送给C端，
                        如果是2查勘员，则推送给B端)，B,C端变更后推送给A端
                 **************/
                SendInfo sendInfo = new SendInfo();
                // TODO zhaoyy 20161025 修改消息推送为公共接口
                List<Message> ulist = new ArrayList<Message>();
                Message msg = new Message();
                // 根据任务状态判断( A端变更)
                if ("1".equals(targetStatus) || "2".equals(targetStatus) || "3".equals(targetStatus) || "5".equals(targetStatus)) {
                    if (phoneBC != null) {
                        msg.setCaseNo(caseNo == null ? "et" : caseNo);
                        if ("1".equals(targetStatus)) {
                            msg.setContent(garageName + "确认了您的任务编号为" + repairTask.getTaskId() + "的送修任务");
                        } else if ("2".equals(targetStatus)) {
                            msg.setContent(garageName + "放弃了您的任务编号为" + repairTask.getTaskId() + "的送修任务");
                        } else if ("3".equals(targetStatus)) {
                            msg.setContent(garageName + "的车辆未抵厂！");
                        } else if ("5".equals(targetStatus)) {
                            msg.setContent(garageName + "的车辆已修好！");
                        }
                        msg.setMsgUUID("ET" + UUID.randomUUID().toString().replace("-", ""));
                        msg.setNewstype("0");
                        msg.setUserMobile(phoneBC);// 13910000008
                        if ("1".equals(taskType)) {
                            // 推送给C端车主
                            msg.setClientType("C");
                        } else if ("2".equals(taskType)) {// B
                            // //先推送B 然后推送c
                            msg.setClientType("B");
                        }
                        msg.setUserCode(phoneBC);
                        ulist.add(msg);
                        sendInfo.setMsgList(ulist);
                        // sendMessage.push(sendInfo);
                        sendMessage.pushMessage(sendInfo);
                    }
                } else if ("4".equals(targetStatus) || "6".equals(targetStatus)) {// B、C端变更
                    if (phoneNo != null) {
                        msg.setCaseNo(caseNo == null ? "et" : caseNo);
                        if ("4".equals(targetStatus)) {
                            msg.setContent("用户取消了任务编号为" + repairTask.getTaskId() + "的送修任务");
                        } else if ("6".equals(targetStatus)) {
                            msg.setContent("用户已经提取了任务编号为" + repairTask.getTaskId() + "的车辆");
                        }
                        msg.setMsgUUID("ET" + UUID.randomUUID().toString().replace("-", ""));
                        msg.setClientType("A");
                        msg.setNewstype("0");
                        msg.setUserMobile(phoneNo);
                        msg.setUserCode(phoneBC);
                        ulist.add(msg);
                        sendInfo.setMsgList(ulist);
                        // sendMessage.push(sendInfo);
                        sendMessage.pushMessage(sendInfo);
                    }
                }
                // RepairTask repairTask = repairTaskDaoImpl.getTaskDetailByTaskId(taskId);
                // //任务类型 1车主报案 2查勘员报案
                // String type = repairTask.getTaskType();
                // //登录账号
                // String user_account = repairTask.getUserAccount();
                // if("1".equals(type)){
                // /*************给用户发送推送提醒**************/
                // SendInfo sendInfoUser = new SendInfo();
                // sendInfoUser.setCaseNo(registNo);
                // sendInfoUser.setPhoneNo(user_account);
                // sendInfoUser.setMsg("您的车辆已修好，请及时取车");
                // sendInfoUser.setReqType("1");
                // sendInfoUser.setNewsType("0");
                // sendMessage.push(sendInfoUser);
                // }
                //
                // if("2".equals(type)){
                // /*************给查勘员发送推送提醒**************/
                // SendInfo sendInfoSurvey = new SendInfo();
                // sendInfoSurvey.setCaseNo(registNo);
                // sendInfoSurvey.setPhoneNo(user_account);
                // sendInfoSurvey.setMsg(repairTask.getCarOwner()+"的车辆已修好");
                // sendInfoSurvey.setReqType("2");
                // sendInfoSurvey.setNewsType("0");
                // sendMessage.push(sendInfoSurvey);
                // }
            }
        } else {
            RepairTask repairTask = repairTaskDaoImpl.getTaskDetailByTaskId(taskId);
            // 查询根据任务号修理厂信息
            Garage garage = garageDaoImpl.getGarageById(repairTask.getGarageId());
            // 修理厂名称
            String garageName = garage.getGarageName();
            // 案件号
            String caseNo = repairTask.getTaskId();
            // 获取发生任务手机号
            String phoneBC = repairTask.getUserAccount();
            // 任务类型
            String taskType = repairTask.getTaskType();
            SendInfo sendInfo = new SendInfo();
            List<Message> ulist = new ArrayList<Message>();
            Message msg = new Message();
            // 如果状态为99，则同时推送到BC端，再次通知用户取车
            if (phoneBC != null) {
                msg.setNewstype("0");
                msg.setUserMobile(phoneBC);
                msg.setCaseNo(caseNo == null ? "ET" : caseNo);
                msg.setContent(garageName + "的车辆已修好，请您及时取车");
                if ("1".equals(taskType)) {// 车主
                    // 推送给C端
                    msg.setClientType("C");
                } else if ("2".equals(taskType)) {// B
                    msg.setClientType("B");
                }
                msg.setMsgUUID("ET" + UUID.randomUUID().toString().replace("-", ""));
                msg.setUserCode(phoneBC);
                ulist.add(msg);
                sendInfo.setMsgList(ulist);
                // sendMessage.push(sendInfo);
                sendMessage.pushMessage(sendInfo);
            }
        }
    }

    @Override
    public int countRepairTask(RepairTask repairTask) {
        return this.repairTaskDaoImpl.countRepairTask(repairTask);
    }

    @Override
    public List<RepairTask> getAllRepairTaskByCondition(RepairTask conditionRepairTask, Integer skip, Integer limit) {
        return this.repairTaskDaoImpl.getRepairTaskList(conditionRepairTask, skip, limit);
    }

    @Override
    public List<Type> listRepairTaskStatus(String taskstatus) {
        return typeDaoImpl.listRepairTaskStatus(taskstatus);
    }

    @Override
    public int countGarageRepairTask(RepairTask repairTask) {
        return this.repairTaskDaoImpl.countRepairTask(repairTask);
    }

    @Override
    public List<Map<String, String>> getTypeNameByTypeGroupCode(String typeGroupCode) {
        return typeDaoImpl.getTypeNameByTypeGroupCode(typeGroupCode);
    }

    @Override
    public String getGarageIdByUserCode(String userCode) {
        return repairTaskDaoImpl.getGarageIdByUserCode(userCode);
    }

    @Override
    public TaskEvalute getTaskEvaluteByTaskId(String taskId) {
        return repairTaskDaoImpl.getTaskEvaluteByTaskId(taskId);
    }

    @Override
    public List<EvaluteItem> getAllEvaluteItem() {
        return repairTaskDaoImpl.getAllEvaluteItem();
    }

    @Override
    public List<ScoreDetail> getScoreDetailByEvId(String evId) {
        return repairTaskDaoImpl.getScoreDetailByEvId(evId);
    }

    @Override
    public List<EvaluatePhoto> getEvaluatePhotoByTaskId(String taskId) {
        return repairTaskDaoImpl.getEvaluatePhotoByTaskId(taskId);
    }
//    报表王学杰2016-11-01
    @Override
    public List<RepairTask> getReportFormList(RepairTask conditionRepairTask, Integer skip, Integer limit) {
        return this.repairTaskDaoImpl.getReportFormList(conditionRepairTask,skip,limit);
    }
    
    @Override
    public List<RepairTask> getReportFormList2(RepairTask conditionRepairTask) {
        return this.repairTaskDaoImpl.getReportFormList2(conditionRepairTask);
    }
}
