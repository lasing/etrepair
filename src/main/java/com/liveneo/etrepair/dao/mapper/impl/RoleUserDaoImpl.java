package com.liveneo.etrepair.dao.mapper.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.liveneo.etrepair.dao.mapper.RoleUserMapper;
import com.liveneo.etrepair.pojo.RoleUser;
import com.liveneo.etrepair.pojo.RoleUserExample;

@Repository
public class RoleUserDaoImpl {
    @Autowired
    RoleUserMapper roleUserMapper;

    /***
     * 给用户添加角色
     */
    public void addRoleUser(RoleUser roleUser) {
        roleUserMapper.insert(roleUser);
    }

    /***
     * 删除用户角色
     */
    public void deleteUserRole(String userId) {
        RoleUserExample example = new RoleUserExample();
        example.createCriteria().andUserIdEqualTo(userId);
        roleUserMapper.deleteByExample(example);
    }

    /***
     * 获取用户角色列表
     */
    public List<RoleUser> getRolesByUserId(String userId) {
        RoleUserExample example = new RoleUserExample();
        example.createCriteria().andUserIdEqualTo(userId);
        return roleUserMapper.selectByExample(example);
    }
}
