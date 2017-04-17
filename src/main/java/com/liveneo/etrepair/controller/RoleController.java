package com.liveneo.etrepair.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.liveneo.etrepair.json.wrapper.RoleWrapper;
import com.liveneo.etrepair.log.LVLogger;
import com.liveneo.etrepair.pojo.Role;
import com.liveneo.etrepair.pojo.User;
import com.liveneo.etrepair.service.RoleFunctionService;
import com.liveneo.etrepair.service.RoleService;
import com.liveneo.etrepair.service.RoleUserService;

@Controller
@RequestMapping("/role")
public class RoleController extends BaseController {
    LVLogger                    logger = LVLogger.getLogger(this.getClass());
    @Autowired
    private RoleService         roleService;
    @Autowired
    private RoleFunctionService roleFunctionService;
    @Autowired
    private RoleUserService     roleUserService;

    @RequestMapping(value = "/user/get", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public String getUserRole(HttpServletRequest request, HttpServletResponse response) {
        String userId = request.getParameter("userId");
        return resultOK(this.roleUserService.getUserRoleByUserId(userId));
    }

    // @RequestMapping(value = "/user/add", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8"
    // })
    // @ResponseBody
    // public String addRoleUser(HttpServletRequest request,
    // HttpServletResponse response,HttpSession session) {
    // String userId = request.getParameter("userId");
    // String roleIds = request.getParameter("roleIds");
    // List<String> listString = JSON.parseArray(roleIds, String.class);
    // this.roleUserService.AddRoleUser(userId, listString);
    // return resultOK();
    // }
    @RequestMapping(value = "/function/get", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public String getRoleFunctions(HttpServletRequest request, HttpServletResponse response) {
        String roleId = request.getParameter("roldId");
        return resultOK(this.roleFunctionService.getRoleFunctionsByRoleId(roleId));
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String addRole(Role role, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            String updateBy = user.getUserName();
            role.setCreateBy(updateBy);
            role.setUpdateBy(updateBy);
        }
        Date date = new Date();
        role.setCreateTime(date);
        role.setUpdateTime(date);
        try {
            roleService.addRole(role);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("新增角色失败" + e);
            return resultError("新增角色失败");
        }
        return resultOK();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public String deleteRole(String id) {
        try {
            roleService.deleteRoleRoleId(id);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("删除角色失败" + e);
            return resultError("删除角色失败");
        }
        return resultOK();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public String updateRole(Role role, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            String updateBy = user.getUserName();
            role.setUpdateBy(updateBy);
        }
        role.setUpdateTime(new Date());
        try {
            roleService.updateRole(role);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("更新角色失败" + e);
            return resultError("更新角色失败");
        }
        return resultOK();
    }

    /***
     * 给角色添加菜单
     * 
     * @param id
     * @param funcs
     * @return
     */
    @RequestMapping(value = "/function/add", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public String addRoleFunction(String id, String funcs, String isReadableIds, HttpSession session) {
        User user = (User) session.getAttribute("user");
        String operUser = null;
        if (user != null) {
            operUser = user.getUserName();
        } else {
            operUser = "SYSTEM";
        }
        try {
            roleService.AddRoleFunction(id, funcs, isReadableIds, operUser);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("添加角色菜单失败" + e);
            return resultError("添加角色菜单失败");
        }
        return resultOK();
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public String listRole(Role role) throws IOException {
        Map<String, Object> maps = new HashMap<String, Object>();
        maps.put("total", 11L);
        maps.put("rows", roleService.selectByExample());
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(maps);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
            return JSON_PARSE_ERROR;
        } catch (JsonMappingException e) {
            e.printStackTrace();
            return JSON_PARSE_ERROR;
        } catch (IOException e) {
            e.printStackTrace();
            return JSON_PARSE_ERROR;
        }
    }

    @RequestMapping(value = "/list/json", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public String getRoleJson() {
        List<Role> roles = roleService.selectByExample();
        List<RoleWrapper> result = new ArrayList<RoleWrapper>();
        for (Role role : roles) {
            RoleWrapper d = new RoleWrapper();
            d.setId(role.getRoleId());
            d.setText(role.getRoleName());
            result.add(d);
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(result);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
            return JSON_PARSE_ERROR;
        } catch (JsonMappingException e) {
            e.printStackTrace();
            return JSON_PARSE_ERROR;
        } catch (IOException e) {
            e.printStackTrace();
            return JSON_PARSE_ERROR;
        }
    }

    /**
     * 根据角色id 设置角色对应的菜单checkbox 并返回所有菜单
     * @param roleId
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/function/list", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public String listRoleFunctions(String roleId, HttpServletRequest request, HttpServletResponse response) {
        return "[" + roleService.getAllFunctionsByRole(roleId) + "]";
    }

    @RequestMapping(value = "/function/list/all", method = RequestMethod.GET)
    @ResponseBody
    public String listAllFunctions() {
        return "[" + roleService.getAllFunctions() + "]";
    }

    @RequestMapping(value = "/function/operation", method = RequestMethod.POST)
    @ResponseBody
    public String setRoleFunctionOperation(String roleId, String functionId, Boolean isReadOnly) {
        roleService.setRoleFunctionOperation(roleId, functionId, isReadOnly);
        return resultOK();
    }

    @RequestMapping(value = "/code/exist", method = RequestMethod.GET)
    @ResponseBody
    public boolean isRoleCodeExist(String roleCode) {
        try {
            roleCode = URLDecoder.decode(roleCode, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return roleService.isRoleCodeExist(roleCode);
    }

    @RequestMapping(value = "/name/exist", method = RequestMethod.GET)
    @ResponseBody
    public boolean isRoleNameExist(String roleName) {
        try {
            roleName = URLDecoder.decode(roleName, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return roleService.isRoleNameExist(roleName);
    }

    @RequestMapping(value = "/code/roleCodeNoExit", method = RequestMethod.GET)
    @ResponseBody
    public boolean RoleCodeNoExit(String roleCode, String roleName) {
        Role role = new Role();
        try {
            role.setRoleCode(URLDecoder.decode(roleCode, "UTF-8"));
            role.setRoleName(URLDecoder.decode(roleName, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        role.setUpdateTime(new Date());
        return roleService.updateRoleNameByCode(role);
    }

    @RequestMapping
    public String role() {
        return "role/list";
    }
}
