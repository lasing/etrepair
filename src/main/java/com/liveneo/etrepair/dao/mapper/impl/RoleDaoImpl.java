package com.liveneo.etrepair.dao.mapper.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.liveneo.etrepair.dao.mapper.RoleMapper;
import com.liveneo.etrepair.pojo.Role;
import com.liveneo.etrepair.pojo.RoleExample;

@Repository(value = "roleDaoImpl")
public class RoleDaoImpl {
    @Autowired
    private RoleMapper roleMapper;

    /**
     * 获取所有角色
     * 
     * @return
     */
    public List<Role> getAllRoles() {
        return roleMapper.selectByExample(null);
    }

    /***
     * 添加角色
     */
    public String addRole(Role role) {
        role.setCreateTime(new Date());
        int result = roleMapper.insert(role);
        if (result == 1) return role.getRoleId();
        return null;
    }

    /***
     * 删除角色
     */
    public void deleteRoleBykey(String id) {
        roleMapper.deleteByPrimaryKey(id);
    }

    /***
     * 获取角色列表
     */
    public List<Role> getRoles() {
        RoleExample example = new RoleExample();
        return roleMapper.selectByExample(example);
    }

    /***
     * 更新角色
     */
    public void updateRole(Role role) {
        role.setUpdateTime(new Date());
        roleMapper.updateByPrimaryKey(role);
    }

    public Role getRoleById(String roleId) {
        return roleMapper.selectByPrimaryKey(roleId);
    }

    /**
     * 根据用户名称查找角色信息
     * @param username
     * @return
     */
    public List<Role> getRolesByUserName(String username) {
        return roleMapper.selectByUserName(username);
    }

    public Role getRoleByCode(String roleCode) {
        RoleExample example = new RoleExample();
        example.createCriteria().andRoleCodeEqualTo(roleCode);
        List<Role> roles = roleMapper.selectByExample(example);
        if (roles != null && roles.size() != 0) {
            return roles.get(0);
        }
        return null;
    }

    public Role getRoleByName(String roleName) {
        RoleExample example = new RoleExample();
        example.createCriteria().andRoleNameEqualTo(roleName);
        List<Role> roles = roleMapper.selectByExample(example);
        if (roles != null && roles.size() != 0) {
            return roles.get(0);
        }
        return null;
    }

    /***
     * 根据用户名判断是否有管理员权限
     * @param username
     * @return
     */
    public List<Role> isAdminRole(String username) {
        return roleMapper.isAdminRole(username);
    }

    public boolean updateRoleNameByCode(Role role) {
        return roleMapper.updateRoleNameByCode(role);
    }
}
