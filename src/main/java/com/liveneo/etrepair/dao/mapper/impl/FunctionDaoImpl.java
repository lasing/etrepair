package com.liveneo.etrepair.dao.mapper.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.liveneo.etrepair.dao.mapper.FunctionMapper;
import com.liveneo.etrepair.model.IsFunctionReadOnlyDto;
import com.liveneo.etrepair.model.NoSubFuncConditionDto;
import com.liveneo.etrepair.model.NoSubFuncResultDto;
import com.liveneo.etrepair.pojo.Function;
import com.liveneo.etrepair.pojo.FunctionExample;
import com.liveneo.etrepair.pojo.Role;
import com.liveneo.etrepair.pojo.RoleExample;
import com.liveneo.etrepair.pojo.FunctionExample.Criteria;

@Repository(value = "functionDaoImpl")
public class FunctionDaoImpl {
    @Autowired
    private FunctionMapper functionMapper;

    /**
     * 根据角色ID查找菜单
     * 
     * @param roleId
     * @return
     */
    public List<Function> getFunctionByRoleId(String roleId) {
        return functionMapper.selectFunctionByRoleId(roleId);
    }

    public int addFunction(Function function) {
        function.setUpdateTime(new Date());
        return functionMapper.insert(function);
    }

    // 根据菜单id 删除菜单
    public int deleteFunctionById(Integer id) {
        return functionMapper.deleteByPrimaryKey(id);
    }

    public int updateFunction(Function function) {
        function.setUpdateTime(new Date());
        return functionMapper.updateByPrimaryKey(function);
    }

    public List<Function> getAllFunctions() {
        FunctionExample example = new FunctionExample();
        example.createCriteria().andFunctionUrlNotEqualTo("**/index");
        return functionMapper.selectByExample(example);
    }

    public Function getFunction(String functionname, byte functionlevel) {
        FunctionExample example = new FunctionExample();
        example.createCriteria().andFunctionNameEqualTo(functionname).andFunctionLevelEqualTo(functionlevel);
        List<Function> result = functionMapper.selectByExample(example);
        if (result != null && result.size() > 0) {
            return result.get(0);
        }
        return null;
    }

    public Function getFunctionById(Integer id) {
        return functionMapper.selectByPrimaryKey(id);
    }

    public void deleteByParentId(Integer parentId) {
        FunctionExample example = new FunctionExample();
        Criteria c = example.createCriteria();
        c.andParentFunctionIdEqualTo(parentId);
    }

    // 根据父级id 查询子集列表
    public List<Function> getFunctionsByParentId(Integer parentId) {
        FunctionExample example = new FunctionExample();
        Criteria c = example.createCriteria();
        c.andParentFunctionIdEqualTo(parentId);
        return functionMapper.selectByExample(example);
    }

    /**
     * 根据子节点获取所有的父节点
     * 
     * @param id
     * @return
     */
    public List<Function> getParents(String id) {
        List<Function> funcs = new ArrayList<Function>();
        Function f = functionMapper.selectByPrimaryKey(Integer.valueOf(id));
        funcs.add(f);
        boolean hasparent = false;
        Integer parentId = null;
        if (f.getParentFunctionId() != null) {
            hasparent = true;
            parentId = Integer.valueOf(f.getParentFunctionId());
        }
        while (hasparent == true) {
            Function function = functionMapper.selectFuncAndIconClassByPrimaryKey(parentId);
            funcs.add(function);
            if (function.getParentFunctionId() != null) {
                parentId = Integer.valueOf(function.getParentFunctionId());
            } else {
                hasparent = false;
            }
        }
        return funcs;
    }

    public boolean isLeaf(Integer id) {
        FunctionExample example = new FunctionExample();
        example.createCriteria().andParentFunctionIdEqualTo(id);
        List<Function> result = functionMapper.selectByExample(example);
        if (result != null && result.size() != 0) {
            return false;
        }
        return true;
    }

    public List<Function> getFunctionsByUserid(String userId, String noSubFunctionIds) {
        NoSubFuncConditionDto dto = new NoSubFuncConditionDto();
        dto.setUserId(userId);
        dto.setNoSubFuncIds(noSubFunctionIds);
        return functionMapper.selectFunctionByUserId(dto);
    }

    /*
     * 获取所有的菜单含ICON名称
     * 
     * @return
     */
    public List<Function> getAllFunctionAndIconName() {
        return functionMapper.selectAllFunction();
    }

    public Function getFunctionByUrl(String functionUrl) {
        FunctionExample fExample = new FunctionExample();
        fExample.createCriteria().andFunctionUrlEqualTo(functionUrl);
        List<Function> result = functionMapper.selectByExample(fExample);
        if (result != null && result.size() != 0) {
            return result.get(0);
        }
        return null;
    }

    /***
     * 没有字节点的顶级菜单
     * @return
     */
    public List<NoSubFuncResultDto> noSubFuncTopFunc() {
        return functionMapper.noSubFuncTopFunc();
    }

    public int countFunctions() {
        FunctionExample example = new FunctionExample();
        return this.functionMapper.countByExample(example);
    }

    /***
        * 根据url 和用户id 获取用户对该菜单是否只读
        * @param dto
        * @return
        */
    public List<Byte> isFunctionReadonly(IsFunctionReadOnlyDto dto) {
        return this.functionMapper.isFunctionReadonly(dto);
    }

    public Function getFunctionByName(String functionName) {
        FunctionExample example = new FunctionExample();
        example.createCriteria().andFunctionNameEqualTo(functionName);
        List<Function> functions = functionMapper.selectByExample(example);
        if (functions != null && functions.size() != 0) {
            return functions.get(0);
        }
        return null;
    }
}
