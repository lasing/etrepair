package com.liveneo.etrepair.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
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
import com.liveneo.etrepair.pojo.Type;
import com.liveneo.etrepair.pojo.Typegroup;
import com.liveneo.etrepair.pojo.User;
import com.liveneo.etrepair.service.TypeService;

@Controller
@RequestMapping("/type")
public class TypeController extends BaseController {
    LVLogger            logger = LVLogger.getLogger(this.getClass());
    @Autowired
    private TypeService typeService;

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public String listAllType() {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", 0);
        result.put("rows", this.typeService.listTypes());
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

    @RequestMapping(value = "/typegroup/add", method = RequestMethod.POST)
    @ResponseBody
    public String addTypeGroup(String name, String code, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Typegroup typeGroup = new Typegroup();
        typeGroup.setTypeGroupCode(code);
        typeGroup.setTypeGroupName(name);
        if (user != null) {
            String updateBy = user.getUserName();
            typeGroup.setCreateBy(updateBy);
            typeGroup.setUpdateBy(updateBy);
        }
        Date date = new Date();
        typeGroup.setCreateTime(date);
        typeGroup.setUpdateTime(date);
        try {
            this.typeService.saveTypeGroup(typeGroup);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("字典项新增失败" + e);
            return resultError("字典项新增失败");
        }
        return resultOK();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public String addTypeGroup(String name, String code, String id, HttpSession session) {
        User user = (User) session.getAttribute("user");
        String operUser = null;
        if (user != null) {
            operUser = user.getUserName();
        } else {
            operUser = "SYSTEM";
        }
        try {
            this.typeService.update(name, code, id, operUser);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("字典项更新失败" + e);
            return resultError("字典项更新失败");
        }
        return resultOK();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String addType(String typename, String typecode, String id, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Type type = new Type();
        type.setTypeCode(typecode);
        type.setTypeName(typename);
        if (user != null) {
            String updateBy = user.getUserName();
            type.setCreateBy(updateBy);
            type.setUpdateBy(updateBy);
        }
        Date date = new Date();
        type.setCreateTime(date);
        type.setUpdateTime(date);
        try {
            this.typeService.saveType(type, id);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("字典录入失败" + e);
            return resultError("字典录入失败");
        }
        return resultOK();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public String delete(String id) {
        try {
            this.typeService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("字典删除失败" + e);
            return resultError("字典删除失败");
        }
        return resultOK();
    }

    @RequestMapping(value = "/typeOrTypeGroup", method = RequestMethod.GET)
    @ResponseBody
    public String getLocker(String id) {
        return this.typeService.typeOrTypeGroup(id);
    }

    @RequestMapping
    public String type() {
        return "type/list";
    }
}
