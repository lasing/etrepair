package com.liveneo.etrepair.service;

import java.util.List;
import java.util.Map;
import com.liveneo.etrepair.pojo.Function;
import com.liveneo.etrepair.pojo.User;

public interface FunctionService {
    int addFunction(Function record);

    /***
     * 根据菜单id 删除菜单 以及 该菜单下的子菜单
     * @param id
     * @return
     */
    public int destroyFunction(Integer id);

    // int deleteFunctionByPrimaryKey(String id);
    int updateFunction(Function record);

    List<Function> getAllFunctions();

    public int countFunctions();

    /**
     * 根据用户信息获取用户所拥有的菜单
     * 
     * @param string
     * @return
     */
    public List<Function> getFunctionsByUserId(String userId);

    /***
     * 初始化菜单
     * 
     * @return
     */
    public String initMenue(User usre);

    /**
     *是否只读 key:url value: 1/0 1: 只读  0：可编辑
     * @param userId
     * @return
     */
    public Map<String, String> functionUrlReadOnely(String userId);

    /***
       * 根据url 和用户id 获取用户对该菜单是否只读
       * @param dto
       * @return
       */
    boolean isFunctionReadonly(String userId, String functionUrl);

    public boolean isFunctionUrlExist(String functionUrl);

    public boolean isFunctionNameExist(String functionName);
}
