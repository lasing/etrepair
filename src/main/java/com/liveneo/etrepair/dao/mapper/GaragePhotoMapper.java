package com.liveneo.etrepair.dao.mapper;

import com.liveneo.etrepair.pojo.GaragePhoto;
import com.liveneo.etrepair.pojo.GaragePhotoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GaragePhotoMapper {
    int countByExample(GaragePhotoExample example);

    int deleteByExample(GaragePhotoExample example);

    int deleteByPrimaryKey(String garagePhotoId);

    int insert(GaragePhoto record);

    int insertSelective(GaragePhoto record);

    List<GaragePhoto> selectByExample(GaragePhotoExample example);

    GaragePhoto selectByPrimaryKey(String garagePhotoId);

    int updateByExampleSelective(@Param("record") GaragePhoto record, @Param("example") GaragePhotoExample example);

    int updateByExample(@Param("record") GaragePhoto record, @Param("example") GaragePhotoExample example);

    int updateByPrimaryKeySelective(GaragePhoto record);

    int updateByPrimaryKey(GaragePhoto record);

    List<GaragePhoto> getGaragePhotoByGarageId(String garageId);

    GaragePhoto getGaragePhotoByGaragePhotoId(String garagePhotoId);
}