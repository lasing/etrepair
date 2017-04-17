package com.liveneo.etrepair.dao.mapper.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.liveneo.etrepair.dao.mapper.EvaluatePhotoMapper;
import com.liveneo.etrepair.dao.mapper.EvaluteItemMapper;
import com.liveneo.etrepair.dao.mapper.RepairTaskMapper;
import com.liveneo.etrepair.dao.mapper.ScoreDetailMapper;
import com.liveneo.etrepair.dao.mapper.TaskEvaluteMapper;
import com.liveneo.etrepair.pojo.EvaluatePhoto;
import com.liveneo.etrepair.pojo.EvaluteItem;
import com.liveneo.etrepair.pojo.RepairTask;
import com.liveneo.etrepair.pojo.ScoreDetail;
import com.liveneo.etrepair.pojo.TaskEvalute;

@Repository
public class RepairTaskDaoImpl {
    @Autowired
    RepairTaskMapper    repairTaskMapper;
    @Autowired
    TaskEvaluteMapper   taskEvaluteMapper;
    @Autowired
    EvaluteItemMapper   evaluteItemMapper;
    @Autowired
    ScoreDetailMapper   scoreDetailMapper;
    @Autowired
    EvaluatePhotoMapper evaluatePhotoMapper;

    /***
     * 修改送修任务状态
     */
    public int updateRepairTaskStatus(RepairTask repairTask) {
        return repairTaskMapper.updateByPrimaryKeySelective(repairTask);
    }

    /***
     * 送修任务总数
     */
    public int countRepairTask(RepairTask repairTask) {
        return repairTaskMapper.countRepairTask(repairTask);
    }

    /***
     * 获取ET修理厂列表
     */
    public List<RepairTask> getRepairTaskList(RepairTask repairTask, int skip, int rows) {
        repairTask.setSkip(skip);
        repairTask.setLimit(rows);
        return repairTaskMapper.selectRepairTaskList(repairTask);
    }

    /**
     * 当前任务号明细
     * @param taskId
     * @return
     */
    public RepairTask getTaskDetailByTaskId(String taskId) {
        return repairTaskMapper.selectByPrimaryKey(taskId);
    }

    /**
     * 用户表中查询修理厂id
     * @param userCode
     * @return
     */
    public String getGarageIdByUserCode(String userCode) {
        return repairTaskMapper.getGarageIdByUserCode(userCode);
    }

    /**
     * 根据任务号查询任务评论
     * @param taskId
     * @return
     */
    public TaskEvalute getTaskEvaluteByTaskId(String taskId) {
        return taskEvaluteMapper.getTaskEvaluteByTaskId(taskId);
    }

    /**
     * 配置用户打分项
     * @return
     */
    public List<EvaluteItem> getAllEvaluteItem() {
        return evaluteItemMapper.getAllEvaluteItem();
    }

    /**
     * 根据评论id获取打分项详情
     * @param evId
     * @return
     */
    public List<ScoreDetail> getScoreDetailByEvId(String evId) {
        return scoreDetailMapper.getScoreDetailByEvId(evId);
    }

    /**
     * 任务号查询评分的图片
     * @param taskId
     * @return
     */
    public List<EvaluatePhoto> getEvaluatePhotoByTaskId(String taskId) {
        return evaluatePhotoMapper.getEvaluatePhotoByTaskId(taskId);
    }
    
    /**
     * 报表列表  王学杰2016-11-01
     * @return 
     */
    public List<RepairTask> getReportFormList(RepairTask repairTask, int skip, int rows) {
    	repairTask.setSkip(skip);
        repairTask.setLimit(rows);
        return repairTaskMapper.getReportFormList(repairTask);
    }
    
    public List<RepairTask> getReportFormList2(RepairTask repairTask) {
        return repairTaskMapper.getReportFormList(repairTask);
    }
    
}
