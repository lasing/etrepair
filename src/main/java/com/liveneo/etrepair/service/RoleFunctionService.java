package com.liveneo.etrepair.service;

import java.util.List;
import com.liveneo.etrepair.pojo.RoleFunction;

public interface RoleFunctionService {
    /***
     * 分配角色菜单
     */
    void addRoleFunction(String roleId, java.util.List<String> functionIds);

    /**
     * 根据角色Id 条件检索角色菜单列表
     */
    List<RoleFunction> getRoleFunctionsByRoleId(String roleId);
}