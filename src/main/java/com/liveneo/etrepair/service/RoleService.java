package com.liveneo.etrepair.service;

import java.util.List;
import com.liveneo.etrepair.pojo.Role;

public interface RoleService {
    /**
     * 添加角色
     * 
     * @param role
     * @return
     */
    public void addRole(Role role);

    /**
     * 删除角色
     * 
     * @param id
     * @return
     */
    void deleteRoleRoleId(String id);

    /**
     * 获取角色列表
     * 
     * @return
     */
    List<Role> selectByExample();

    /**
     * 修改角色
     * 
     * @param role
     * @return
     */
    void updateRole(Role role);

    public String getAllFunctionsByRole(String roleId);

    public String getAllFunctions();

    public void setRoleFunctionOperation(String roleId, String functionId, Boolean isReadOnly);

    /***
     * 更新角色菜单
     * 
     * @param roleId
     * @param funcs
     * @param updateBy TODO
     */
    public void AddRoleFunction(String roleId, String funcs, String isReadableIds, String updateBy);

    /***
     * 角色编码是否存在
     * @param roleCode
     * @return
     */
    public boolean isRoleCodeExist(String roleCode);

    /***
     * 角色名称是否存在
     * @param roleCode
     * @return
     */
    public boolean isRoleNameExist(String roleName);

    public boolean updateRoleNameByCode(Role role);
}
