package com.liveneo.etrepair.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.liveneo.etrepair.common.Constant;
import com.liveneo.etrepair.common.ErrorConstant;
import com.liveneo.etrepair.common.MD5Util;
import com.liveneo.etrepair.common.StringUtil;
import com.liveneo.etrepair.common.UserReadableException;
import com.liveneo.etrepair.dao.mapper.impl.RoleDaoImpl;
import com.liveneo.etrepair.dao.mapper.impl.RoleUserDaoImpl;
import com.liveneo.etrepair.dao.mapper.impl.UserDaoImpl;
import com.liveneo.etrepair.json.wrapper.RoleCheckBox;
import com.liveneo.etrepair.log.Opertorlog;
import com.liveneo.etrepair.pojo.Role;
import com.liveneo.etrepair.pojo.RoleUser;
import com.liveneo.etrepair.pojo.User;
import com.liveneo.etrepair.pojo.UserExample;
import com.liveneo.etrepair.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDaoImpl     userDaoImpl;
    @Autowired
    private RoleUserDaoImpl roleUserDaoImpl;
    @Autowired
    private RoleDaoImpl     roleDaoImpl;

    @Override
    @Opertorlog(name = "新增用户", functionPath = "系统操作-->用户管理-->新增用户", operateType = Constant.OPERATE_TYPE_ADD)
    public String addUser(User user) {
        user.setPassword(MD5Util.GetMD5Code(user.getPassword()));
        String userId = this.userDaoImpl.addUser(user);
        return userId;
    }

    @Override
    public void deleteUser(String userId) {
        // 删除用户对应的 角色用户记录
        roleUserDaoImpl.deleteUserRole(userId);
        // 删除用户
        this.userDaoImpl.deleteUserById(userId);
    }

    // public List<User> getAllUser(User userCondition, Integer skip, Integer
    // limit) {
    // List<User> users = this.userDaoImpl.getAllUsers(userCondition, skip,
    // limit);
    // for (User user : users) {
    // Depart depart = departDaoImpl.getDepartById(user.getDepartid());
    // List<RoleUser> roleUsers = this.roleUserDaoImpl
    // .getRolesByUserId(user.getId());
    //
    // if (roleUsers != null && roleUsers.size() != 0) {
    // String roleName = "";
    // for (RoleUser roleUser : roleUsers) {
    // Role role = this.roleDaoImpl.getRoleById(roleUser
    // .getRoleid());
    // if (role != null && role.getRolename() != null
    // && !"".equals(role.getRolename())) {
    // roleName += role.getRolename() + ",";
    // }
    // }
    // if (!roleName.equals("")) {
    // int index = roleName.lastIndexOf(",");
    // user.setRolename(roleName.substring(0, index));
    // }
    // }
    // OrgInfo orgInfo = this.orgInfoDaoImpl.getOrgInfo(user.getTaorgid());
    // if (orgInfo != null) {
    // user.setOrgname(orgInfo.getDescription());
    // }
    //
    // if(depart!=null){
    // user.setDepartname(depart.getDepartname());
    // }
    //
    // }
    // return users;
    // }
    @Override
    @Opertorlog(name = "修改用户", functionPath = "系统操作-->用户管理-->编辑用户", operateType = Constant.OPERATE_TYPE_UPDATE)
    public void updateUser(User user, String passwordUpdate) {
        System.out.println(user);
        System.out.println(passwordUpdate);
        String newPwd = null;
        User oldUser = this.userDaoImpl.getUserById(user.getUserId());
        if (oldUser != null) {
            if (!StringUtil.isEmptyOrNull(passwordUpdate)) {
                newPwd = MD5Util.GetMD5Code(passwordUpdate);
                if (!newPwd.equals(oldUser.getPassword())) {
                    user.setPassword(MD5Util.GetMD5Code(passwordUpdate.trim()));
                } else {
                    user.setPassword(oldUser.getPassword());
                }
            } else {
                user.setPassword(oldUser.getPassword());
            }
            this.userDaoImpl.updateUser(user);
        } else {
            throw new UserReadableException("该用户已被删除！");
        }
    }

    // @Override
    // public String getAllRoles() {
    // return JsonTreeTool.roleToJsonTree(this.roleDaoImpl.getRoles(), null);
    // }
    //
    // @Override
    // public String getAllRolesByUserId(String userId) {
    // Set<Integer> roleIds = new HashSet<Integer>();
    // List<RoleUser> existRoleIds = this.roleUserDaoImpl
    // .getRolesByUserId(userId);
    // for (RoleUser roleUser : existRoleIds) {
    // roleIds.add(Integer.valueOf(roleUser.getRoleid()));
    // }
    // return JsonTreeTool
    // .roleToJsonTree(this.roleDaoImpl.getRoles(), roleIds);
    // }
    @Override
    public List<RoleCheckBox> getAllRoles() {
        List<Role> result = this.roleDaoImpl.getAllRoles();
        List<RoleCheckBox> cks = new ArrayList<RoleCheckBox>();
        for (Role role : result) {
            RoleCheckBox ck = new RoleCheckBox();
            ck.setId(role.getRoleId());
            ck.setText(role.getRoleName());
            cks.add(ck);
        }
        return cks;
    }

    /***
     * 根据uerId获取，对应的角色列表
     * 
     */
    @Override
    public List<RoleCheckBox> getAllRolesByUserId(String userId) {
        List<Role> result = this.roleDaoImpl.getAllRoles();
        List<RoleUser> roleUsers = roleUserDaoImpl.getRolesByUserId(userId);
        // 已存在的用户Ids
        Set<String> existIds = new HashSet<String>();
        for (RoleUser roleUser : roleUsers) {
            existIds.add(roleUser.getRoleId());
        }
        List<RoleCheckBox> cks = new ArrayList<RoleCheckBox>();
        for (Role role : result) {
            RoleCheckBox ck = new RoleCheckBox();
            ck.setId(role.getRoleId());
            ck.setText(role.getRoleName());
            if (existIds.contains(role.getRoleId())) {
                ck.setChecked(true);
            }
            cks.add(ck);
        }
        return cks;
    }

    @Override
    public String addRoleToUser(String userId, String roleIds, String updateBy) {
        // 删除之前用户对应的角色
        this.roleUserDaoImpl.deleteUserRole(userId);
        // 给用户添加角色
        if (!StringUtil.isEmptyOrNull(roleIds)) {
            String[] roles = roleIds.split(",");
            int length = roles.length;
            for (int i = 0; i < length; i++) {
                RoleUser roleUser = new RoleUser();
                roleUser.setUserId(userId);
                roleUser.setRoleId(roles[i]);
                roleUser.setUpdateBy(updateBy);
                this.roleUserDaoImpl.addRoleUser(roleUser);
            }
        }
        return null;
    }

    @Override
    public int countUserByConditions(User user) {
        return this.userDaoImpl.countByCondition(user);
    }

    @Override
    public String getUserIdByUserCode(String userCode) {
        String userId = null;
        UserExample userExample = new UserExample();
        if (userCode != null && !userCode.equals("")) {
            userExample.createCriteria().andUserCodeEqualTo(userCode);
        }
        List<User> list = userDaoImpl.selectByExample(userExample);
        if (list != null && !list.isEmpty()) {
            userId = list.get(0).getUserId();
        }
        return userId;
    }

    @Override
    public String getUserPwdByUserCode(String userCode) {
        String userId = null;
        UserExample userExample = new UserExample();
        if (userCode != null && !userCode.equals("")) {
            userExample.createCriteria().andUserCodeEqualTo(userCode);
        }
        List<User> list = userDaoImpl.selectByExample(userExample);
        if (list != null && !list.isEmpty()) {
            userId = list.get(0).getPassword();
        }
        return userId;
    }

    @Override
    public String updatePwd(User user) {
        User confirmUser = userDaoImpl.getUserByUsercode(user.getUserCode());
        if (confirmUser != null) {
            user.setPassword(MD5Util.GetMD5Code(user.getOrgPassword()));
            if (!user.getPassword().equals(confirmUser.getPassword())) {
                return ErrorConstant.DISPATCH_ORG_PWD_ERROR;
            } else {
                if (user.getNewPassword().equals(user.getOrgPassword())) {
                    return ErrorConstant.DISPATCH_NEW_ORG_PWD_ERROR;
                } else if (!user.getNewPassword().equals(user.getConfirmPassword())) {
                    return ErrorConstant.DISPATCH_PWD_NOT_SAME;
                } else if (user.getNewPassword().length() < 6 || user.getNewPassword().length() > 18) {
                    return ErrorConstant.DISPATCH_PWD_LENGTH_ERROR;
                } else {
                    String newPwd = MD5Util.GetMD5Code(user.getNewPassword());
                    user.setPassword(newPwd);
                    userDaoImpl.updateByUsercode(user);
                    return null;
                }
            }
        } else {
            return ErrorConstant.DISPATCH_USER_NOT_EXIST;
        }
    }

    /**
     * 判断用户编码是否存在
     */
    @Override
    public boolean isUserCodeExist(String userCode) {
        User user = this.userDaoImpl.getUserByUsercode(userCode);
        if (user != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isUserNameExist(String userName) {
        User user = this.userDaoImpl.getUserByUserName(userName);
        if (user != null) {
            return true;
        }
        return false;
    }

    @Override
    public String getUserNameByUserCode(String userCode) {
        String userName = null;
        UserExample userExample = new UserExample();
        if (userCode != null && !userCode.equals("")) {
            userExample.createCriteria().andUserCodeEqualTo(userCode);
        }
        List<User> list = userDaoImpl.selectByExample(userExample);
        if (list != null && !list.isEmpty()) {
            userName = list.get(0).getUserName();
        }
        return userName;
    }

    @Override
    @Opertorlog(name = "退出", functionPath = "安全退出", operateType = Constant.OPERATE_TYPE_LOGOUT)
    public void logOut(User user) {
    }

    /**
     * 根据用户名判断是否为管理员
     */
    @Override
    public boolean isAdminRole(String username) {
        List<Role> result = this.roleDaoImpl.isAdminRole(username);
        if (result != null && result.size() != 0) {
            return true;
        }
        return false;
    }

    /**
     * 根据条件检索用户
     * 
     * @param conditionUser
     * @param skip
     * @param limit
     * @return
     */
    public List<User> getAllUserByCondition(User conditionUser, Integer skip, Integer limit) {
        return this.userDaoImpl.getAllUserByCondition(conditionUser, skip, limit);
    }

    @Override
    public boolean isHeadquarters(String userId) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public String getOrgDesc(String orgCode) {
        return userDaoImpl.getOrgDesc(orgCode);
    }

    @Override
    public String getOrgIdByCode(String orgCode) {
        return userDaoImpl.getOrgIdByCode(orgCode);
    }

    @Override
    public void updateOrgId(User u) {
        userDaoImpl.updateOrgId(u);
    };
}
