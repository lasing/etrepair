package com.liveneo.etrepair.dao.mapper.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.liveneo.etrepair.common.Page;
import com.liveneo.etrepair.common.StringUtil;
import com.liveneo.etrepair.dao.mapper.UserMapper;
import com.liveneo.etrepair.pojo.User;
import com.liveneo.etrepair.pojo.UserExample;
import com.liveneo.etrepair.pojo.UserExample.Criteria;

@Repository
public class UserDaoImpl {
    @Autowired
    private UserMapper userMapper;

    /**
     * 根据员工号查询用户
     * 
     * @param userCode
     * @return
     */
    public User getUserByUsercode(String userCode) {
        UserExample example = new UserExample();
        example.createCriteria().andUserCodeEqualTo(userCode);
        List<User> users = userMapper.selectByExample(example);
        if (users != null && users.size() > 0) {
            return users.get(0);
        }
        return null;
    }

    /**
     * 根据用户名查询用户
     * @param userName
     * @return
     */
    public User getUserByUserName(String userName) {
        UserExample example = new UserExample();
        example.createCriteria().andUserNameEqualTo(userName);
        List<User> users = userMapper.selectByExample(example);
        if (users != null && users.size() > 0) {
            return users.get(0);
        }
        return null;
    }

    public Integer updateByUsercode(User user) {
        int returnCount = userMapper.updatePassByUsercode(user);
        return returnCount;
    }

    /***
     * 新增用户
     * 
     * @param user
     * @param updateBy TODO
     * @return
     */
    public String addUser(User user) {
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        int i = userMapper.insert(user);
        if (i == 1) {
            return user.getUserId();
        }
        return null;
    }

    /**
     * 新增用户
     * 
     * @param user
     * @return
     */
    public int insert(User user) {
        return userMapper.insert(user);
    }

    /***
     * 删除用户
     * 
     * @param id
     */
    public void deleteUserById(String id) {
        userMapper.deleteByPrimaryKey(id);
    }

    /***
     * 修改用户
     * 
     * @param user
     * @return
     */
    public int updateUser(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

    /**
     * 修改用户
     * 
     * @param user
     * @return
     */
    public int updateByKeySelective(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    /***
     * 获取所有用户
     * 
     * @return
     */
    public List<User> getAllUsers(User user, Integer skip, Integer limit) {
        UserExample example = new UserExample();
        if (skip != -1 && limit != -1) {
            Page page = new Page();
            page.setBegin(skip);
            page.setLength(limit);
            example.setPage(page);
        }
        Criteria criteria = example.createCriteria();
        if (!StringUtil.isEmptyOrNull(user.getUserCode())) {
            criteria.andUserCodeEqualTo(user.getUserCode());
        }
        if (!StringUtil.isEmptyOrNull(user.getUserName())) {
            criteria.andUserNameEqualTo(user.getUserName());
        }
        if (!StringUtil.isEmptyOrNull(user.getRealName())) {
            criteria.andRealNameEqualTo(user.getRealName());
        }
        if (!StringUtil.isEmptyOrNull(user.getOrgId()) && !"0".equals(user.getOrgId())) {
            criteria.andOrgIdEqualTo(user.getOrgId());
        }
        return userMapper.selectByExample(example);
    }

    public int countUserByConditions(User user) {
        UserExample example = new UserExample();
        Criteria criteria = example.createCriteria();
        if (!StringUtil.isEmptyOrNull(user.getUserCode())) {
            criteria.andUserCodeEqualTo(user.getUserCode());
        }
        if (!StringUtil.isEmptyOrNull(user.getUserName())) {
            criteria.andUserNameEqualTo(user.getUserName());
        }
        if (!StringUtil.isEmptyOrNull(user.getRealName())) {
            criteria.andRealNameEqualTo(user.getRealName());
        }
        if (!StringUtil.isEmptyOrNull(user.getPassword())) {
            criteria.andPasswordEqualTo(user.getPassword());
        }
        if (!StringUtil.isEmptyOrNull(user.getOrgId()) && !"0".equals(user.getOrgId())) {
            criteria.andOrgIdEqualTo(user.getOrgId());
        }
        return userMapper.countByExample(example);
    }

    public List<User> selectByExample(UserExample userExample) {
        return userMapper.selectByExample(userExample);
    }

    public User getUserById(String id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public int countByCondition(User user) {
        return userMapper.countByCondition(user);
    }

    /**
     * 根据条件检索用户
     * @param conditionUser
     * @param skip
     * @param limit
     * @return
     */
    public List<User> getAllUserByCondition(User conditionUser, Integer skip, Integer limit) {
        conditionUser.setSkip(skip);
        conditionUser.setLimit(limit);
        if (!StringUtil.isEmptyOrNull(conditionUser.getOrgId())) {
            if (conditionUser.getOrgId().equals("0")) {
                conditionUser.setOrgId("");
            }
        }
        if (!StringUtil.isEmptyOrNull(conditionUser.getCompanyCode())) {
            if (conditionUser.getCompanyCode().equals("0")) {
                conditionUser.setCompanyCode("");
            }
        }
        return userMapper.selectAllUserByCondition(conditionUser);
    };

    /***
     * 根据用户名删除用户
     * 
     * @param id
     */
    public void deleteByCode(String usercode) {
        userMapper.deleteByCode(usercode);
    }

    /**
     * 批量删除修理厂用户
     * @param idList
     */
    public void deleteBatch(List<String> idList) {
        userMapper.deleteBatch(idList);
    }

    public int selectByUserName(String username) {
        return userMapper.selectByUserName(username);
    }

    public String getOrgDesc(String orgCode) {
        return userMapper.getOrgDesc(orgCode);
    }

    public String getOrgIdByCode(String orgCode) {
        return userMapper.getOrgIdByCode(orgCode);
    }

    public void updateOrgId(User u) {
        userMapper.updateOrgId(u);
    }

    public Integer updateUserNameByUserCode(String newPhone, String usercode) {
        int returnCount = userMapper.updateUserNameByUserCode(newPhone, usercode);
        return returnCount;
    }

    public User getUserByUserCode(String usercode) {
        return userMapper.getUserByUserCode(usercode);
    }
}
