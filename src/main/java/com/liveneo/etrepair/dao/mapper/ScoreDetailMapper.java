package com.liveneo.etrepair.dao.mapper;

import com.liveneo.etrepair.pojo.ScoreDetail;
import com.liveneo.etrepair.pojo.ScoreDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScoreDetailMapper {
    int countByExample(ScoreDetailExample example);

    int deleteByExample(ScoreDetailExample example);

    int deleteByPrimaryKey(String scoreDetailId);

    int insert(ScoreDetail record);

    int insertSelective(ScoreDetail record);

    List<ScoreDetail> selectByExample(ScoreDetailExample example);

    ScoreDetail selectByPrimaryKey(String scoreDetailId);

    int updateByExampleSelective(@Param("record") ScoreDetail record, @Param("example") ScoreDetailExample example);

    int updateByExample(@Param("record") ScoreDetail record, @Param("example") ScoreDetailExample example);

    int updateByPrimaryKeySelective(ScoreDetail record);

    int updateByPrimaryKey(ScoreDetail record);

    List<ScoreDetail> getScoreDetailByEvId(String evId);
}