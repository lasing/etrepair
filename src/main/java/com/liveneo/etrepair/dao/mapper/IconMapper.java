package com.liveneo.etrepair.dao.mapper;

import com.liveneo.etrepair.pojo.Icon;
import com.liveneo.etrepair.pojo.IconExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IconMapper {
    int countByExample(IconExample example);

    int deleteByExample(IconExample example);

    int deleteByPrimaryKey(String iconId);

    int insert(Icon record);

    int insertSelective(Icon record);

    List<Icon> selectByExample(IconExample example);

    Icon selectByPrimaryKey(String iconId);

    int updateByExampleSelective(@Param("record") Icon record, @Param("example") IconExample example);

    int updateByExample(@Param("record") Icon record, @Param("example") IconExample example);

    int updateByPrimaryKeySelective(Icon record);

    int updateByPrimaryKey(Icon record);
}