package com.liveneo.etrepair.service;

import java.util.List;
import com.liveneo.etrepair.pojo.RoleUser;

public interface RoleUserService {
    void AddRoleUser(String userId, List<String> roleIds);

    List<RoleUser> getUserRoleByUserId(String userId);
}
