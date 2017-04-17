package com.liveneo.etrepair.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.liveneo.etrepair.log.LVLogger;
import com.liveneo.etrepair.pojo.User;
import com.liveneo.etrepair.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
    LVLogger            logger = LVLogger.getLogger(this.getClass());
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String addUser(User user, HttpServletRequest request) {
        User updateBy = null;
        Object obj = request.getSession(true).getAttribute("user");
        if (obj != null) {
            updateBy = (User) obj;
            if (updateBy != null) {
                user.setCreateBy(updateBy.getUserName());
                user.setCreateBy(updateBy.getUserName());
            }
        }
        Date date = new Date();
        user.setCreateTime(date);
        user.setUpdateTime(date);
        try {
            logger.debug("新增用户" + user);
            return resultOK(userService.addUser(user));
        } catch (Exception e) {
            logger.error("");
            return "error";
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public String deleteUser(String id) {
        try {
            userService.deleteUser(id);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("删除用户失败" + e);
            return resultError("删除用户失败");
        }
        return resultOK();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public String updateUser(User user, String orgId, String passwordUpdate, HttpSession session) {
        User loginUser = (User) session.getAttribute("user");
        try {
            if (loginUser != null) {
                user.setUpdateBy(loginUser.getUserName());
            }
            userService.updateUser(user, passwordUpdate);
            // 将org_id设置为et_user对应userCode的org_id
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("更新用户失败" + e);
            return resultError("更新用户失败");
        }
        return resultOK();
    }

    @RequestMapping(value = "/updatePwd", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public String updatePwd(User user) {
        String errorMsg = userService.updatePwd(user);
        if (errorMsg != null && !"".equals(errorMsg)) {
            return resultError(errorMsg);
        }
        return resultOK();
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public String getAllUser(User user, Integer page, Integer rows) {
        int skip = -1;
        if (page != -1) {
            skip = (page - 1) * rows;
        }
        List<User> users = userService.getAllUserByCondition(user, skip, rows);
        Map<String, Object> maps = new HashMap<String, Object>();
        maps.put("total", userService.countUserByConditions(user));
        maps.put("rows", users);
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

    @RequestMapping(value = "org/getOrgDesc", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public String getOrgDesc(String orgCode) throws Exception {
        String orgDesc = userService.getOrgDesc(orgCode);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(orgDesc);
    }

    /***
     * 添加用户界面 分配角色时加载所有角色
     * 
     * @return
     */
    @RequestMapping(value = "/role/list/all", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public String listAllRoles() {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", 0);
        result.put("rows", userService.getAllRoles());
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

    /***
     * 根据用户Id 获取对应的 权限列表
     * 
     * @param userId
     * @return
     */
    @RequestMapping(value = "/role/all", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public String listAllUserRoles(String userId) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", 0);
        result.put("rows", userService.getAllRolesByUserId(userId));
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

    /***
     * 给用户添加角色
     * 
     * @param userId
     * @param roleIds
     * @return
     */
    @RequestMapping(value = "/role/update", method = RequestMethod.POST)
    @ResponseBody
    public String upDateUserRoles(String userId, String roleIds, HttpSession session) {
        User loginUser = (User) session.getAttribute("user");
        try {
            userService.addRoleToUser(userId, roleIds, loginUser.getUserName());
        } catch (Exception e) {
            logger.error("添加角色失败" + e);
            return resultError("数据异常");
        }
        return resultOK();
    }

    /***
     * 用户编码是否存在
     * @param userCode
     * @return
     */
    @RequestMapping(value = "/code/exist", method = RequestMethod.GET)
    @ResponseBody
    public boolean isUserCodeExist(String userCode) {
        return userService.isUserCodeExist(userCode);
    }

    @RequestMapping(value = "/username/exist", method = RequestMethod.GET)
    @ResponseBody
    public boolean isUserNameExist(String userName) {
        try {
            userName = URLDecoder.decode(userName, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return userService.isUserNameExist(userName);
    }

    /***
     * 
     * @param userCode
     * @return
     */
    @RequestMapping(value = "/isAdmin", method = RequestMethod.GET)
    @ResponseBody
    public boolean isUserAdmin(String userName) {
        return userService.isAdminRole(userName);
    }

    @RequestMapping
    public String user() {
        return "user/list";
    }
}
