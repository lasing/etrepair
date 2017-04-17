package com.liveneo.etrepair.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.liveneo.etrepair.common.ServiceAssert;
import com.liveneo.etrepair.dao.mapper.impl.RoleFunctionDaoImpl;
import com.liveneo.etrepair.pojo.RoleFunction;
import com.liveneo.etrepair.service.RoleFunctionService;

@Service
public class RoleFunctionServiceImpl implements RoleFunctionService {
    @Autowired
    private RoleFunctionDaoImpl roleFunctionDaoImpl;

    /***
     * 分配角色菜单
     */
    @Override
    public void addRoleFunction(String roleId, java.util.List<String> functionIds) {
        // 原角色对应菜单
        List<RoleFunction> oldRoleFunctions = this.getRoleFunctionsByRoleId(roleId);
        // 清除原角色菜单
        this.roleFunctionDaoImpl.deleteFunctionByRoleId(roleId);
        // 给角色添加菜单
        for (String functionId : functionIds) {
            RoleFunction roleFunction = new RoleFunction();
            roleFunction.setRoleId(roleId);
            roleFunction.setFunctionId(Integer.valueOf(functionId));
            this.roleFunctionDaoImpl.addFunctionToRole(roleFunction);
        }
    };

    /**
     * 根据角色Id 条件检索角色菜单列表
     */
    @Override
    public List<RoleFunction> getRoleFunctionsByRoleId(String roleId) {
        ServiceAssert.notNull(roleId, "角色标识");
        return this.roleFunctionDaoImpl.getRoleFunctionsByRoleId(roleId);
    }
}
