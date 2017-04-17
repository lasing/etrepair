package com.liveneo.etrepair.dao.mapper;

import com.liveneo.etrepair.pojo.Role;
import com.liveneo.etrepair.pojo.RoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleMapper {
    int countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(String id);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    /**
     * 根据用户名查找角色信息
     * @param username
     * @return
     */
    List<Role> selectByUserName(String username);

    /***
     * 根据用户名判断是否有管理员权限
     * @param username
     * @return
     */
    List<Role> isAdminRole(String username);

    boolean updateRoleNameByCode(Role role);
}