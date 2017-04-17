package com.liveneo.etrepair.dao.mapper;

import com.liveneo.etrepair.pojo.EvaluteItem;
import com.liveneo.etrepair.pojo.EvaluteItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EvaluteItemMapper {
    int countByExample(EvaluteItemExample example);

    int deleteByExample(EvaluteItemExample example);

    int deleteByPrimaryKey(String evItemId);

    int insert(EvaluteItem record);

    int insertSelective(EvaluteItem record);

    List<EvaluteItem> selectByExample(EvaluteItemExample example);

    EvaluteItem selectByPrimaryKey(String evItemId);

    int updateByExampleSelective(@Param("record") EvaluteItem record, @Param("example") EvaluteItemExample example);

    int updateByExample(@Param("record") EvaluteItem record, @Param("example") EvaluteItemExample example);

    int updateByPrimaryKeySelective(EvaluteItem record);

    int updateByPrimaryKey(EvaluteItem record);

    List<EvaluteItem> getAllEvaluteItem();
}