package com.liveneo.etrepair.dao.mapper;

import com.liveneo.etrepair.pojo.RepairTask;
import com.liveneo.etrepair.pojo.RepairTaskExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RepairTaskMapper {
    int countByExample(RepairTaskExample example);

    int deleteByExample(RepairTaskExample example);

    int deleteByPrimaryKey(String taskId);

    int insert(RepairTask record);

    int insertSelective(RepairTask record);

    List<RepairTask> selectByExample(RepairTaskExample example);

    RepairTask selectByPrimaryKey(String taskId);

    int updateByExampleSelective(@Param("record") RepairTask record, @Param("example") RepairTaskExample example);

    int updateByExample(@Param("record") RepairTask record, @Param("example") RepairTaskExample example);

    int updateByPrimaryKeySelective(RepairTask record);

    int updateByPrimaryKey(RepairTask record);

    int countRepairTask(RepairTask repairTask);

    List<RepairTask> selectRepairTaskList(RepairTask repairTask);

    int updateRepairTaskStatus(@Param("taskId") String taskId, @Param("targetStatus") String targetStatus);

    String getGarageIdByUserCode(@Param("userCode") String userCode);
//    报表王学杰201611-01
    List<RepairTask> getReportFormList(RepairTask repairTask);
}