package com.liveneo.etrepair.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.liveneo.etrepair.auth.MySecurityMetadataSource;
import com.liveneo.etrepair.common.Constant;
import com.liveneo.etrepair.common.JsonTreeTool;
import com.liveneo.etrepair.common.ServiceAssert;
import com.liveneo.etrepair.common.StringUtil;
import com.liveneo.etrepair.common.UserReadableException;
import com.liveneo.etrepair.dao.mapper.impl.FunctionDaoImpl;
import com.liveneo.etrepair.dao.mapper.impl.RoleDaoImpl;
import com.liveneo.etrepair.dao.mapper.impl.RoleFunctionDaoImpl;
import com.liveneo.etrepair.dao.mapper.impl.RoleUserDaoImpl;
import com.liveneo.etrepair.log.LVLogger;
import com.liveneo.etrepair.log.Opertorlog;
import com.liveneo.etrepair.pojo.Function;
import com.liveneo.etrepair.pojo.Role;
import com.liveneo.etrepair.pojo.RoleFunction;
import com.liveneo.etrepair.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
    LVLogger                         logger = LVLogger.getLogger(RoleServiceImpl.class);
    @Autowired
    RoleDaoImpl                      roleDaoImpl;
    @Autowired
    FunctionDaoImpl                  functionDaoImpl;
    @Autowired
    RoleFunctionDaoImpl              roleFunctionDaoImpl;
    @Autowired
    RoleUserDaoImpl                  roleUserDaoImpl;
    @Autowired
    private MySecurityMetadataSource mySecurityMetadataSource;

    /**
     * 添加角色
     * 
     * @param role
     * @return
     */
    @Override
    @Opertorlog(name = "新增角色", functionPath = "系统操作-->角色管理-->新增角色", operateType = Constant.OPERATE_TYPE_ADD)
    public void addRole(Role role) {
        ServiceAssert.notNull(role, "角色");
        if (StringUtil.isEmptyOrNull(role.getRoleCode()) || StringUtil.isEmptyOrNull(role.getRoleCode())) {
            throw new UserReadableException("角色名称或角色编号不能为空", "notNull");
        }
        Role roleExist = this.roleDaoImpl.getRoleByCode(role.getRoleCode());
        if (roleExist != null) {
            throw new UserReadableException("角色编码不能重复", "duplicateField");
        }
        this.roleDaoImpl.addRole(role);
    }

    /**
     * 删除角色
     * 
     * @param id
     * @return
     */
    @Override
    @Opertorlog(name = "删除角色", functionPath = "系统操作-->角色管理-->删除角色", operateType = Constant.OPERATE_TYPE_DELETE)
    public void deleteRoleRoleId(String id) {
        // 删除角色对应额 角色菜单
        this.roleFunctionDaoImpl.deleteFunctionByRoleId(id);
        // 删除角色
        this.roleDaoImpl.deleteRoleBykey(id);
    }

    /**
     * 获取角色列表
     * 
     * @return
     */
    @Override
    public List<Role> selectByExample() {
        return this.roleDaoImpl.getRoles();
    }

    /***
     * 更新角色
     */
    @Override
    @Opertorlog(name = "更新角色", functionPath = "系统操作-->角色管理-->更新角色", operateType = Constant.OPERATE_TYPE_UPDATE)
    public void updateRole(Role role) {
        ServiceAssert.notNull(role, "角色");
        ServiceAssert.notNull(role.getRoleId(), "角色Id");
        this.roleDaoImpl.updateRole(role);
    }

    @Override
    @Opertorlog(name = "添加角色菜单", functionPath = "系统操作-->角色管理-->权限设置", operateType = Constant.OPERATE_TYPE_ADD)
    public void AddRoleFunction(String roleId, String funcs, String isReadableIds, String updateBy) {
        ServiceAssert.notNull(roleId, "角色");
        Set<String> existIds = new HashSet<String>();
        if (isReadableIds != null && !"".equals(isReadableIds.trim())) {
            String[] ids = isReadableIds.trim().split(",");
            int length = ids.length;
            for (int i = 0; i < length; i++) {
                existIds.add(ids[i]);
            }
        }
        // 删除老的菜单页
        this.roleFunctionDaoImpl.deleteFunctionByRoleId(roleId);
        // 添加新的菜单
        if (funcs != null && !"".equals(funcs)) {
            String[] funcIds = funcs.split(",");
            int length = funcIds.length;
            for (int i = 0; i < length; i++) {
                if (!"0".equals(funcIds[i])) {
                    RoleFunction roleFunction = new RoleFunction();
                    roleFunction.setRoleId(roleId);
                    roleFunction.setFunctionId(Integer.valueOf(funcIds[i]));
                    if (existIds.contains(funcIds[i])) {
                        roleFunction.setIsreadonly((byte) 1);
                    } else {
                        roleFunction.setIsreadonly((byte) 0);
                    }
                    roleFunction.setCreateBy(updateBy);
                    this.roleFunctionDaoImpl.addFunctionToRole(roleFunction);
                }
            }
        }
        // 重新加载角色资源信息
        mySecurityMetadataSource.loadResourceDefine();
    }

    @Override
    public String getAllFunctionsByRole(String roleId) {
        List<Function> result = functionDaoImpl.getAllFunctions();
        List<RoleFunction> exist = roleFunctionDaoImpl.getRoleFunctionsByRoleId(roleId);
        // 角色已有的的菜单Id
        Map<Integer, Integer> functionIds = new HashMap<Integer, Integer>();
        for (RoleFunction roleFunction : exist) {
            functionIds.put(roleFunction.getFunctionId(), (int) roleFunction.getIsreadonly());
        }
        List<HashMap> dataList = new ArrayList<HashMap>();
        for (Function function : result) {
            HashMap hash = new HashMap();
            hash.put("id", function.getFunctionId());
            hash.put("text", function.getFunctionName());
            hash.put("parentId", function.getParentFunctionId());
            hash.put("checked", functionIds.containsKey(function.getFunctionId()));
            Integer isreadonly = functionIds.get(function.getFunctionId());
            hash.put("isreadonly", isreadonly == null ? 0 : isreadonly);
            dataList.add(hash);
        }
        return JsonTreeTool.dataToTree(dataList);
    }

    @Override
    public String getAllFunctions() {
        List<Function> result = functionDaoImpl.getAllFunctions();
        // 已存在的菜单Id
        Set<Integer> functionIds = new HashSet<Integer>();
        List<HashMap> dataList = new ArrayList<HashMap>();
        for (Function function : result) {
            HashMap hash = new HashMap();
            hash.put("id", function.getFunctionId());
            hash.put("text", function.getFunctionName());
            hash.put("parentId", function.getParentFunctionId());
            hash.put("checked", false);
            dataList.add(hash);
        }
        return JsonTreeTool.dataToTree(dataList);
    }

    /***
     * isReadOnly 1 为只读， 0 为可读写 funcs 被选择了的 菜单id
     */
    @Override
    public void setRoleFunctionOperation(String roleId, String functionId, Boolean isReadOnly) {
        RoleFunction roleFunction = null;
        roleFunction = this.roleFunctionDaoImpl.getRoleFunctionByRoleIdandFunctionId(roleId, functionId);
        if (roleFunction != null) {
            if (isReadOnly) {
                roleFunction.setIsreadonly((byte) 1);
            } else {
                roleFunction.setIsreadonly((byte) 0);
            }
            this.roleFunctionDaoImpl.updateRoleFunction(roleFunction);
        } else {
            roleFunction = new RoleFunction();
            roleFunction.setRoleId(roleId);
            roleFunction.setFunctionId(Integer.valueOf(functionId));
            if (isReadOnly) {
                roleFunction.setIsreadonly((byte) 1);
            } else {
                roleFunction.setIsreadonly((byte) 0);
            }
            this.roleFunctionDaoImpl.addFunctionToRole(roleFunction);
        }
    }

    @Override
    public boolean isRoleCodeExist(String roleCode) {
        Role role = this.roleDaoImpl.getRoleByCode(roleCode);
        if (role != null) {
            return true;
        }
        return false;
    }

    public boolean updateRoleNameByCode(Role role) {
        return roleDaoImpl.updateRoleNameByCode(role);
    }

    @Override
    public boolean isRoleNameExist(String roleName) {
        Role role = this.roleDaoImpl.getRoleByName(roleName);
        if (role != null) {
            return true;
        }
        return false;
    }
}