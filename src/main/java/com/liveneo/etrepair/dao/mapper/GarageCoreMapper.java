package com.liveneo.etrepair.dao.mapper;

import com.liveneo.etrepair.pojo.GarageCore;
import com.liveneo.etrepair.pojo.GarageCoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GarageCoreMapper {
    int countByExample(GarageCoreExample example);

    int deleteByExample(GarageCoreExample example);

    int deleteByPrimaryKey(String garageId);

    int insert(GarageCore record);

    int insertSelective(GarageCore record);

    List<GarageCore> selectByExample(GarageCoreExample example);

    GarageCore selectByPrimaryKey(String garageId);

    int updateByExampleSelective(@Param("record") GarageCore record, @Param("example") GarageCoreExample example);

    int updateByExample(@Param("record") GarageCore record, @Param("example") GarageCoreExample example);

    int updateByPrimaryKeySelective(GarageCore record);

    int updateByPrimaryKey(GarageCore record);

    int countGarageCore(GarageCore garageCore);

    List<GarageCore> selectGarageCoreList(GarageCore garageCore);

    public int isGarageIdExistInGarageCore(String garageId);
}