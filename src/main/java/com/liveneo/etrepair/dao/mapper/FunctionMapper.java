package com.liveneo.etrepair.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.liveneo.etrepair.model.IsFunctionReadOnlyDto;
import com.liveneo.etrepair.model.NoSubFuncConditionDto;
import com.liveneo.etrepair.model.NoSubFuncResultDto;
import com.liveneo.etrepair.pojo.Function;
import com.liveneo.etrepair.pojo.FunctionExample;

public interface FunctionMapper {
    int countByExample(FunctionExample example);

    int deleteByExample(FunctionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Function record);

    int insertSelective(Function record);

    List<Function> selectByExample(FunctionExample example);

    Function selectByPrimaryKey(Integer id);

    Function selectFuncAndIconClassByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Function record, @Param("example") FunctionExample example);

    int updateByExample(@Param("record") Function record, @Param("example") FunctionExample example);

    int updateByPrimaryKeySelective(Function record);

    int updateByPrimaryKey(Function record);

    /**
     * 根据UserID查询权限
     * 
     * @param id
     * @return
     */
    List<Function> selectFunctionByUserId(NoSubFuncConditionDto dto);

    List<Function> selectFunctionByRoleId(String id);

    /***
     * 查询所有权限
     * @return
     */
    List<Function> selectAllFunction();

    List<NoSubFuncResultDto> noSubFuncTopFunc();

    List<Byte> isFunctionReadonly(IsFunctionReadOnlyDto dto);
}