package com.liveneo.etrepair.service;

import java.util.List;
import java.util.Map;
import com.liveneo.etrepair.pojo.EvaluatePhoto;
import com.liveneo.etrepair.pojo.EvaluteItem;
import com.liveneo.etrepair.pojo.RepairTask;
import com.liveneo.etrepair.pojo.ScoreDetail;
import com.liveneo.etrepair.pojo.TaskEvalute;
import com.liveneo.etrepair.pojo.Type;

public interface RepairTaskService {
    public void updateRepairTaskStatus(String taskId, String registNo, String targetStatus);

    public int countRepairTask(RepairTask repairTask);

    public List<RepairTask> getAllRepairTaskByCondition(RepairTask repairTask, Integer skip, Integer limit);

    public List<Type> listRepairTaskStatus(String taskstatus);

    RepairTask getTaskDetailByTaskId(String taskId);

    public int countGarageRepairTask(RepairTask repairTask);

    public List<Map<String, String>> getTypeNameByTypeGroupCode(String typeGroupCode);

    public String getGarageIdByUserCode(String userCode);

    TaskEvalute getTaskEvaluteByTaskId(String taskId);

    List<ScoreDetail> getScoreDetailByEvId(String evId);

    List<EvaluteItem> getAllEvaluteItem();

    List<EvaluatePhoto> getEvaluatePhotoByTaskId(String taskId);
//    报表王学杰2016-11-01
    public List<RepairTask> getReportFormList(RepairTask conditionRepairTask, Integer skip, Integer limit);
    
    public List<RepairTask> getReportFormList2(RepairTask conditionRepairTask);
}
