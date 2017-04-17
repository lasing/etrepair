package com.liveneo.etrepair.dao.mapper.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.liveneo.etrepair.dao.mapper.RoleFunctionMapper;
import com.liveneo.etrepair.pojo.RoleFunction;
import com.liveneo.etrepair.pojo.RoleFunctionExample;
import com.liveneo.etrepair.pojo.RoleFunctionExample.Criteria;

@Repository
public class RoleFunctionDaoImpl {
    @Autowired
    RoleFunctionMapper roleFunctionMapper;

    /***
     * 删除角色Id对应的菜单
     */
    public void deleteFunctionByRoleId(String roleId) {
        RoleFunctionExample example = new RoleFunctionExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        roleFunctionMapper.deleteByExample(example);
    }

    /***
     * 给角色添加菜单
     */
    public void addFunctionToRole(RoleFunction roleFunction) {
        roleFunctionMapper.insert(roleFunction);
    }

    /***
     * 根据角色id获取 角色菜单
     */
    public List<RoleFunction> getRoleFunctionsByRoleId(String roleId) {
        RoleFunctionExample example = new RoleFunctionExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        return roleFunctionMapper.selectByExample(example);
    }

    /***
     * 根据角色id 和菜单id 获取 对应的角色菜单
     * 
     * @param roleId
     * @param functionId
     * @return
     */
    public RoleFunction getRoleFunctionByRoleIdandFunctionId(String roleId, String functionId) {
        RoleFunctionExample example = new RoleFunctionExample();
        Criteria c = example.createCriteria();
        c.andRoleIdEqualTo(roleId);
        c.andFunctionIdEqualTo(Integer.valueOf(functionId));
        List<RoleFunction> result = roleFunctionMapper.selectByExample(example);
        if (result != null && result.size() != 0) {
            return result.get(0);
        }
        return null;
    }

    public void updateRoleFunction(RoleFunction roleFunction) {
        roleFunctionMapper.updateByPrimaryKey(roleFunction);
    }

    public void deleteRoleFunctionNotInFunctionIds(String funcs) {
        String[] funcIds = funcs.split(",");
        List list = null;
        if (funcIds != null && funcIds.length != 0) {
            list = Arrays.asList(funcIds);
        }
        RoleFunctionExample example = new RoleFunctionExample();
        Criteria c = example.createCriteria();
        c.andFunctionIdNotIn(list);
        roleFunctionMapper.deleteByExample(example);
    }

    /***
     * 根据菜单id 删除 角色菜单
     * @param functionId
     */
    public void deleteRoleFunctionByFunctionId(Integer functionId) {
        RoleFunctionExample example = new RoleFunctionExample();
        Criteria c = example.createCriteria();
        c.andFunctionIdEqualTo(functionId);
        roleFunctionMapper.deleteByExample(example);
    }
}
