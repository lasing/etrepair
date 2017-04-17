package com.liveneo.etrepair.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.liveneo.etrepair.dao.mapper.impl.RoleUserDaoImpl;
import com.liveneo.etrepair.pojo.RoleUser;
import com.liveneo.etrepair.pojo.RoleUserExample;
import com.liveneo.etrepair.service.RoleUserService;

@Service
public class RoleUserServiceImpl implements RoleUserService {
    @Autowired
    RoleUserDaoImpl roleUserDaoImpl;

    /**
     * 给用户分配角色
     */
    @Override
    public void AddRoleUser(String userId, List<String> roleIds) {
        // 删除原来用户的角色
        this.roleUserDaoImpl.deleteUserRole(userId);
        // 给用户添加新的角色
        for (String roleId : roleIds) {
            RoleUser roleUser = new RoleUser();
            roleUser.setRoleId(roleId);
            roleUser.setUserId(userId);
            this.roleUserDaoImpl.addRoleUser(roleUser);
        }
    }

    @Override
    public List<RoleUser> getUserRoleByUserId(String userId) {
        RoleUserExample example = new RoleUserExample();
        example.createCriteria().andUserIdEqualTo(userId);
        return this.roleUserDaoImpl.getRolesByUserId(userId);
    }
}
