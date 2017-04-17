package com.liveneo.etrepair.dao.mapper;

import com.liveneo.etrepair.pojo.TaskEvalute;
import com.liveneo.etrepair.pojo.TaskEvaluteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaskEvaluteMapper {
    int countByExample(TaskEvaluteExample example);

    int deleteByExample(TaskEvaluteExample example);

    int deleteByPrimaryKey(String evId);

    int insert(TaskEvalute record);

    int insertSelective(TaskEvalute record);

    List<TaskEvalute> selectByExample(TaskEvaluteExample example);

    TaskEvalute selectByPrimaryKey(String evId);

    int updateByExampleSelective(@Param("record") TaskEvalute record, @Param("example") TaskEvaluteExample example);

    int updateByExample(@Param("record") TaskEvalute record, @Param("example") TaskEvaluteExample example);

    int updateByPrimaryKeySelective(TaskEvalute record);

    int updateByPrimaryKey(TaskEvalute record);

    TaskEvalute getTaskEvaluteByTaskId(String taskId);
}