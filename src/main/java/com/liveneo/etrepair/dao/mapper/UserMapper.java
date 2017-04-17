package com.liveneo.etrepair.dao.mapper;

import com.liveneo.etrepair.pojo.User;
import com.liveneo.etrepair.pojo.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(String id);

    int updatePassByUsercode(User user);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 符合条件的用户总数
     * @param user
     * @return
     */
    int countByCondition(User user);

    /**
     * 根据条件检索用户
     * @param userCondition
     * @return
     */
    List<User> selectAllUserByCondition(User userCondition);

    int deleteByName(@Param("username") String username);

    int deleteByCode(@Param("usercode") String usercode);

    int deleteBatch(@Param("idList") List<String> idList);

    int selectByUserName(@Param("username") String username);

    User getUserByUserCode(@Param("usercode") String usercode);

    String getOrgDesc(String orgCode);

    String getOrgIdByCode(String orgCode);

    void updateOrgId(User u);

    int updateUserNameByUserCode(@Param("newPhone") String newPhone, @Param("usercode") String usercode);
}