package com.liveneo.etrepair.dao.mapper;

import com.liveneo.etrepair.pojo.Typegroup;
import com.liveneo.etrepair.pojo.TypegroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TypegroupMapper {
    int countByExample(TypegroupExample example);

    int deleteByExample(TypegroupExample example);

    int deleteByPrimaryKey(String typeGroupId);

    int insert(Typegroup record);

    int insertSelective(Typegroup record);

    List<Typegroup> selectByExample(TypegroupExample example);

    Typegroup selectByPrimaryKey(String typeGroupId);

    int updateByExampleSelective(@Param("record") Typegroup record, @Param("example") TypegroupExample example);

    int updateByExample(@Param("record") Typegroup record, @Param("example") TypegroupExample example);

    int updateByPrimaryKeySelective(Typegroup record);

    int updateByPrimaryKey(Typegroup record);
}