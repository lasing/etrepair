package com.liveneo.etrepair.service;

import java.util.List;
import com.liveneo.etrepair.json.wrapper.RoleCheckBox;
import com.liveneo.etrepair.pojo.User;

public interface UserService {
    public void logOut(User user);

    public String addUser(User user);

    public void deleteUser(String userId);

    public void updateUser(User user, String passwordUpdate);

    public String updatePwd(User user);

    public List<RoleCheckBox> getAllRoles();

    public List<RoleCheckBox> getAllRolesByUserId(String userId);

    public String addRoleToUser(String userId, String roleIds, String updateBy);

    public int countUserByConditions(User user);

    /**
     * 根据userCode获取主键Id
     * @return
     */
    public String getUserIdByUserCode(String userCode);

    /**
    * 该usercode 是否存在  
    */
    public boolean isUserCodeExist(String userCode);

    /**
     * 该usercode 是否存在  
     */
    public boolean isUserNameExist(String userName);

    public String getUserPwdByUserCode(String userCode);

    public String getUserNameByUserCode(String userCode);

    /***
    * 根据用户名判断是否为管理员
    * @param username
    * @return
    */
    boolean isAdminRole(String username);

    /**
     * 根据条件检索用户
     * @param conditionUser
     * @param skip
     * @param limit
     * @return
     */
    public List<User> getAllUserByCondition(User conditionUser, Integer skip, Integer limit);

    /***
     * 是否为总部员工 
     * 
     * @param userId
     * @return
     */
    public boolean isHeadquarters(String userId);

    public String getOrgDesc(String orgCode);

    public String getOrgIdByCode(String orgCode);

    public void updateOrgId(User u);
}
