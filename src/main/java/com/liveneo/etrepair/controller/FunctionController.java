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
import javax.servlet.http.HttpSession;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.liveneo.etrepair.json.wrapper.DropDownModel;
import com.liveneo.etrepair.json.wrapper.FunctionWrapper;
import com.liveneo.etrepair.log.LVLogger;
import com.liveneo.etrepair.pojo.Function;
import com.liveneo.etrepair.pojo.User;
import com.liveneo.etrepair.service.FunctionService;

@Controller
@RequestMapping("/function")
public class FunctionController extends BaseController {
    LVLogger                logger = LVLogger.getLogger(FunctionController.class);
    @Autowired
    private FunctionService functionService;

    /***
     * 添加菜单
     * 
     * @param function
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String addFunction(Function function, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            String updateBy = user.getUserName();
            function.setCreateBy(updateBy);
            function.setUpdateBy(updateBy);
        }
        Date date = new Date();
        function.setCreateTime(date);
        function.setUpdateTime(date);
        try {
            functionService.addFunction(function);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("添加菜单失败" + e);
            return resultError("添加菜单失败！");
        }
        return resultOK();
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public String listFunction() {
        List<Function> functions = new ArrayList<Function>();
        try {
            functions = functionService.getAllFunctions();
        } catch (Exception e) {
            logger.error("获取菜单失败" + e);
            return resultError("获取菜单失败");
        }
        Map<String, Object> maps = new HashMap<String, Object>();
        maps.put("total", this.functionService.countFunctions());
        maps.put("rows", functions);
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

    /***
     * 下拉框数据
     * 
     * @return
     */
    @RequestMapping(value = "/list/json", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public String getDepartsJson() {
        List<Function> funcs = functionService.getAllFunctions();
        List<FunctionWrapper> result = new ArrayList<FunctionWrapper>();
        for (Function func : funcs) {
            FunctionWrapper d = new FunctionWrapper();
            d.setId(func.getFunctionId().toString());
            d.setText(func.getFunctionName());
            result.add(d);
        }
        return resultOK(result);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public String updateFunction(Function function, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            String updateBy = user.getUserName();
            function.setUpdateBy(updateBy);
        }
        function.setUpdateTime(new Date());
        try {
            functionService.updateFunction(function);
        } catch (Exception e) {
            logger.error("更新菜单失败" + e);
            return resultError("更新菜单失败！");
        }
        return resultOK();
    }

    /***
     * 删除菜单，以及该菜单下的子菜单
     * 
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public String deleteFunction(Integer id) {
        try {
            functionService.destroyFunction(id);
        } catch (Exception e) {
            logger.error("删除菜单失败" + e);
            return resultError("删除菜单失败！");
        }
        return resultOK();
    }

    /***
     * 菜单等级
     * 
     * @return
     */
    @RequestMapping(value = "/level/json", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public String listFunctionLevelForDropDown() {
        List<DropDownModel> dropList = new ArrayList<DropDownModel>();
        DropDownModel d = new DropDownModel("1", "同级菜单");
        d.setSelected(true);
        dropList.add(d);
        dropList.add(new DropDownModel("2", "下级菜单"));
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(dropList);
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
     * 菜单初始化
     * 
     * @param request
     * @return
     */
    @RequestMapping(value = "/init", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public String initFunctions(HttpServletRequest request) {
        User user = null;
        Object obj = request.getSession(true).getAttribute("user");
        if (obj != null) {
            user = (User) obj;
        } else {
            return resultError("请先登录！");
        }
        return functionService.initMenue(user);
    }

    @RequestMapping(value = "/name/exist", method = RequestMethod.GET)
    @ResponseBody
    public boolean isFunctionNameExist(String functionName) {
        try {
            functionName = URLDecoder.decode(functionName, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return functionService.isFunctionNameExist(functionName);
    }

    @RequestMapping
    public String function() {
        return "function/list";
    }
}
