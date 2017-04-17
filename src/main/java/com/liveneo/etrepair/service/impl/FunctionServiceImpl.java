package com.liveneo.etrepair.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.liveneo.etrepair.common.Constant;
import com.liveneo.etrepair.common.MenuJsonTree;
import com.liveneo.etrepair.common.ServiceAssert;
import com.liveneo.etrepair.common.UserReadableException;
import com.liveneo.etrepair.dao.mapper.impl.FunctionDaoImpl;
import com.liveneo.etrepair.dao.mapper.impl.RoleFunctionDaoImpl;
import com.liveneo.etrepair.dao.mapper.impl.RoleUserDaoImpl;
import com.liveneo.etrepair.log.Opertorlog;
import com.liveneo.etrepair.model.IsFunctionReadOnlyDto;
import com.liveneo.etrepair.model.NoSubFuncResultDto;
import com.liveneo.etrepair.pojo.Function;
import com.liveneo.etrepair.pojo.User;
import com.liveneo.etrepair.service.FunctionService;

@Service
public class FunctionServiceImpl implements FunctionService {
    private static Logger       logger = Logger.getLogger(FunctionServiceImpl.class);
    @Autowired
    private FunctionDaoImpl     functionDaoImpl;
    @Autowired
    private RoleUserDaoImpl     roleUserDaoImpl;
    @Autowired
    private RoleFunctionDaoImpl roleFunctionDaoImpl;

    /***
     * 添加菜单
     */
    @Override
    @Opertorlog(name = "新增菜单", functionPath = "系统操作-->菜单管理-->添加菜单", operateType = Constant.OPERATE_TYPE_ADD)
    public int addFunction(Function function) {
        ServiceAssert.notNull(function, "菜单信息");
        ServiceAssert.notNull(function.getFunctionName(), "菜单名称");
        logger.debug("添加菜单" + function);
        // functionlevel 1同级菜单
        if (function.getFunctionId() != null) {
            if (function.getFunctionLevel() != null && function.getFunctionLevel() == 1) {
                Function f = this.functionDaoImpl.getFunctionById(function.getFunctionId());
                if (f != null) {
                    function.setParentFunctionId(f.getParentFunctionId());
                } else {
                    function.setParentFunctionId(null);
                }
                // 添加新的菜单时 ， 有可能之前有的角色菜单 父节点为全选状态，而新的菜单还没有被添加到角色菜单中，所以
                // 删除新的节点的父节点为选中状态的角色菜单节点
                if (function.getFunctionId() != null) {
                    deleteParentNode(function.getFunctionId().toString());
                }
                function.setFunctionId(null);
                return this.functionDaoImpl.addFunction(function);
                // functionlevel 2 下级菜单
            } else if (function.getFunctionLevel() != null && function.getFunctionLevel() == 2) {
                // 添加新的菜单时 ， 有可能之前有的角色菜单 父节点为全选状态，而新的菜单还没有被添加到角色菜单中，所以
                // 删除新的节点的父节点为选中状态的角色菜单节点
                if (function.getFunctionId() != null) {
                    deleteParentNode(function.getFunctionId().toString());
                    function.setParentFunctionId(function.getFunctionId());
                }
                function.setFunctionId(null);
                return this.functionDaoImpl.addFunction(function);
            }
        }
        // functionlevel null 或者 0
        return this.functionDaoImpl.addFunction(function);
    }

    // 添加新的菜单时 ， 有可能之前有的角色菜单 父节点为全选状态，而新的菜单还没有被添加到角色菜单中，所以
    // 删除新的节点的父节点为选中状态的角色菜单节点
    @Opertorlog(name = "添加菜单时删除父节点选中的角色菜单", functionPath = "系统操作-->菜单管理-->添加菜单", operateType = Constant.OPERATE_TYPE_DELETE)
    public void deleteParentNode(String id) {
        List<Function> parents = this.functionDaoImpl.getParents(id);
        if (parents != null && parents.size() != 0) {
            for (Function function : parents) {
                if (!function.getFunctionId().toString().equals(id)) {
                    this.roleFunctionDaoImpl.deleteRoleFunctionByFunctionId(function.getFunctionId());
                }
            }
        }
    }

    // 删除菜单 以及菜单下面的子菜单
    @Override
    @Opertorlog(name = "删除菜单", functionPath = "系统操作-->菜单管理-->删除菜单", operateType = Constant.OPERATE_TYPE_DELETE)
    public int destroyFunction(Integer id) {
        int result = this.functionDaoImpl.deleteFunctionById(id);
        // 删除菜单，删除对应的菜单权限
        this.roleFunctionDaoImpl.deleteRoleFunctionByFunctionId(id);
        // 根据父id 获取子菜单列表
        List<Function> list = this.functionDaoImpl.getFunctionsByParentId(id);
        if (list != null && list.size() != 0) {
            // 递归删除
            this.deleteFunctionByParentId(id);
        }
        return result;
    }

    // 递归删除子菜单
    public void deleteFunctionByParentId(Integer pId) {
        this.functionDaoImpl.deleteFunctionById(pId);
        // 删除菜单，删除对应的菜单权限
        this.roleFunctionDaoImpl.deleteRoleFunctionByFunctionId(pId);
        // 根据父id 获取子菜单列表
        List<Function> result = this.functionDaoImpl.getFunctionsByParentId(pId);
        if (result != null && result.size() != 0) {
            for (Function function : result) {
                this.deleteFunctionByParentId(function.getFunctionId());
            }
        }
    }

    /***
     * 更新菜单
     */
    @Override
    @Opertorlog(name = "更新菜单", functionPath = "系统操作-->菜单管理-->更新菜单", operateType = Constant.OPERATE_TYPE_UPDATE)
    public int updateFunction(Function function) {
        ServiceAssert.notNull(function, "菜单信息");
        ServiceAssert.notNull(function.getFunctionName(), "菜单名称");
        Function oldFunction = this.functionDaoImpl.getFunctionById(function.getFunctionId());
        if (oldFunction == null) {
            throw new UserReadableException("该菜单已被删除!");
        }
        oldFunction.setFunctionName(function.getFunctionName());
        oldFunction.setFunctionUrl(function.getFunctionUrl());
        oldFunction.setIconId(function.getIconId());
        oldFunction.setFunctionOrder(function.getFunctionOrder());
        return this.functionDaoImpl.updateFunction(oldFunction);
    }

    /***
     * 获取所有菜单
     */
    @Override
    public List<Function> getAllFunctions() {
        List<Function> functions = this.functionDaoImpl.getAllFunctionAndIconName();
        for (Function func : functions) {
            Function f = new Function();
            if (func.getParentFunctionId() != null) {
                f = this.functionDaoImpl.getFunctionById(Integer.valueOf(func.getParentFunctionId()));
                if (f != null) {
                    func.setParentfunctionname(f.getFunctionName());
                }
                func.set_parentId(func.getParentFunctionId());
                if (!this.functionDaoImpl.isLeaf(func.getFunctionId())) {
                    func.setState("closed");
                }
            }
        }
        return functions;
    }

    /***
     * 根据用户id 获取所有菜单
     */
    @Override
    public List<Function> getFunctionsByUserId(String userId) {
        // 没有子节点的的顶级菜单不显示
        List<NoSubFuncResultDto> noSubFuncs = this.functionDaoImpl.noSubFuncTopFunc();
        StringBuilder noSubFuncStr = new StringBuilder();
        if (noSubFuncs != null && noSubFuncs.size() != 0) {
            for (NoSubFuncResultDto no : noSubFuncs) {
                noSubFuncStr.append(no.getFunction_id()).append(",");
            }
            noSubFuncStr.deleteCharAt(noSubFuncStr.length() - 1);
        }
        List<Function> funcs = this.functionDaoImpl.getFunctionsByUserid(userId, noSubFuncStr.toString());
        // 添加父节点菜单
        List<Function> addFunction = new ArrayList<Function>();
        Set<Integer> funcIds = new HashSet<Integer>();
        // 根据菜单号 如果有父节点 则获取父节点id
        if (funcs != null && funcs.size() != 0) {
            for (Function f : funcs) {
                funcIds.add(f.getFunctionId());
            }
            // 根据菜单号 如果有父节点 则获取父节点id
            for (Function f : funcs) {
                if (f != null && f.getFunctionId() != null) {
                    List<Function> parentFunctions = this.functionDaoImpl.getParents(f.getFunctionId().toString());
                    if (parentFunctions != null && parentFunctions.size() != 0) {
                        for (Function p : parentFunctions) {
                            // 添加父节点
                            if (!funcIds.contains(p.getFunctionId())) {
                                addFunction.add(p);
                            }
                        }
                    }
                }
            }
        }
        // 原来的菜单
        List<Function> result = new ArrayList<Function>();
        for (Function tf : funcs) {
            result.add(tf);
        }
        // 父节点菜单
        for (Function tf : addFunction) {
            result.add(tf);
        }
        return result;
    }

    /**
     *是否只读 key:url value: 1/0 1: 只读  0：可编辑
     * @param userId
     * @return
     */
    @Override
    public Map<String, String> functionUrlReadOnely(String userId) {
        // Map<String, String> urlReadonely = new HashMap<String,String>();
        // List<Function> functions = this.getFunctionsByUserId(userId);
        // if(functions!=null){
        // for(Function function:functions){
        // urlReadonely.put(function.getFunctionUrl(), function.getIsreadonly());
        // }
        // }
        return null;
    }

    /***
     * 初始化菜单
     * 
     * @return
     */
    @Override
    public String initMenue(User user) {
        List<Function> result = this.getFunctionsByUserId(user.getUserId());
        List<HashMap> dataList = new ArrayList<HashMap>();
        for (Function function : result) {
            HashMap hash = new HashMap();
            hash.put("menuid", function.getFunctionId());
            hash.put("menuname", function.getFunctionName());
            hash.put("url", function.getFunctionUrl());
            hash.put("parentId", function.getParentFunctionId());
            hash.put("icon", function.getIconClass() == null ? "" : function.getIconClass());
            hash.put("order", function.getFunctionOrder());
            dataList.add(hash);
        }
        return MenuJsonTree.dataToTree(dataList);
    }

    /***
       * 根据url 和用户id 获取用户对该菜单是否只读
       * @param dto
       * @return
       */
    @Override
    public boolean isFunctionReadonly(String userId, String functionUrl) {
        IsFunctionReadOnlyDto dto = new IsFunctionReadOnlyDto();
        dto.setUserId(userId);
        dto.setFunctionUrl(functionUrl);
        List<Byte> result = this.functionDaoImpl.isFunctionReadonly(dto);
        if (result != null && result.size() != 0) {
            if (1 == result.get(0)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isFunctionUrlExist(String functionUrl) {
        Function function = this.functionDaoImpl.getFunctionByUrl(functionUrl);
        if (function != null) {
            return true;
        }
        return false;
    }

    @Override
    public int countFunctions() {
        return this.functionDaoImpl.countFunctions();
    }

    @Override
    public boolean isFunctionNameExist(String functionName) {
        Function function = this.functionDaoImpl.getFunctionByName(functionName);
        if (function != null) {
            return true;
        }
        return false;
    }
}
