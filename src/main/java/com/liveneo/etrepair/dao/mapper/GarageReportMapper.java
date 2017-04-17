package com.liveneo.etrepair.dao.mapper;

import com.liveneo.etrepair.pojo.GarageReport;
import com.liveneo.etrepair.pojo.GarageReportExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GarageReportMapper {
    int countByExample(GarageReportExample example);

    int deleteByExample(GarageReportExample example);

    int deleteByPrimaryKey(String garageId);

    int insert(GarageReport record);

    int insertSelective(GarageReport record);

    List<GarageReport> selectByExample(GarageReportExample example);

    GarageReport selectByPrimaryKey(String garageId);

    int updateByExampleSelective(@Param("record") GarageReport record, @Param("example") GarageReportExample example);

    int updateByExample(@Param("record") GarageReport record, @Param("example") GarageReportExample example);

    int updateByPrimaryKeySelective(GarageReport record);

    int updateByPrimaryKey(GarageReport record);
}