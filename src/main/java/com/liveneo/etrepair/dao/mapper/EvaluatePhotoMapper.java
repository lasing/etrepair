package com.liveneo.etrepair.dao.mapper;

import com.liveneo.etrepair.pojo.EvaluatePhoto;
import com.liveneo.etrepair.pojo.EvaluatePhotoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EvaluatePhotoMapper {
    int countByExample(EvaluatePhotoExample example);

    int deleteByExample(EvaluatePhotoExample example);

    int deleteByPrimaryKey(String evaluatePhotoId);

    int insert(EvaluatePhoto record);

    int insertSelective(EvaluatePhoto record);

    List<EvaluatePhoto> selectByExample(EvaluatePhotoExample example);

    EvaluatePhoto selectByPrimaryKey(String evaluatePhotoId);

    int updateByExampleSelective(@Param("record") EvaluatePhoto record, @Param("example") EvaluatePhotoExample example);

    int updateByExample(@Param("record") EvaluatePhoto record, @Param("example") EvaluatePhotoExample example);

    int updateByPrimaryKeySelective(EvaluatePhoto record);

    int updateByPrimaryKey(EvaluatePhoto record);

    List<EvaluatePhoto> getEvaluatePhotoByTaskId(String taskId);
}