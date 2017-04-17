package com.liveneo.etrepair.dao.mapper;

import com.liveneo.etrepair.pojo.Type;
import com.liveneo.etrepair.pojo.TypeExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

public interface TypeMapper {
    int countByExample(TypeExample example);

    int deleteByExample(TypeExample example);

    int deleteByPrimaryKey(String typeId);

    int insert(Type record);

    int insertSelective(Type record);

    List<Type> selectByExample(TypeExample example);

    Type selectByPrimaryKey(String typeId);

    int updateByExampleSelective(@Param("record") Type record, @Param("example") TypeExample example);

    int updateByExample(@Param("record") Type record, @Param("example") TypeExample example);

    int updateByPrimaryKeySelective(Type record);

    int updateByPrimaryKey(Type record);

    int deleteTypeByGroup(@Param("groupId") String groupId);

    List<Type> listRepairTaskStatus(@Param("taskstatus") String taskstatus);

    public List<Map<String, String>> getTypeNameByTypeGroupCode(@Param("typeGroupCode") String typeGroupCode);
}