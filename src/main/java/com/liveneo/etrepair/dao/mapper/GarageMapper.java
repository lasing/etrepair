package com.liveneo.etrepair.dao.mapper;

import com.liveneo.etrepair.pojo.Garage;
import com.liveneo.etrepair.pojo.GarageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GarageMapper {
    int countByExample(GarageExample example);

    int deleteByExample(GarageExample example);

    int deleteByPrimaryKey(String garageId);

    int deleteBatch(List<String> idList);

    int insert(Garage record);

    int insertSelective(Garage record);

    List<Garage> selectByExample(GarageExample example);

    Garage selectByPrimaryKey(String garageId);

    int updateByExampleSelective(@Param("record") Garage record, @Param("example") GarageExample example);

    int updateByExample(@Param("record") Garage record, @Param("example") GarageExample example);

    int updateByPrimaryKeySelective(Garage record);

    int updateByPrimaryKey(Garage record);

    int countGarage(Garage garage);

    List<Garage> selectGarageList(Garage garage);

    String getGarageIdByUserCode(String userCode);

    List<Garage> getGarageListByIdList(List<String> idList);

    String getTypeNameByCode(String category);

    /**
     * 根据机构id 获取最大的编号
     * @param orgId
     * @return
     */
    String getMaxPointNumber(String orgId);
}