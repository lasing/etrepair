package com.liveneo.etrepair.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.liveneo.etrepair.json.wrapper.DropDownModel;
import com.liveneo.etrepair.pojo.Icon;
import com.liveneo.etrepair.service.IconService;

@Controller
@RequestMapping("/icon")
public class IconController extends BaseController {
    @Autowired
    private IconService iconService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String listRole(Icon icon) {
        return resultOK(iconService.addIcon(icon));
    }

    @RequestMapping(value = "/list/json", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public String listFunctionLevelForDropDown() {
        List<DropDownModel> dropList = new ArrayList<DropDownModel>();
        List<Icon> result = iconService.listIcons();
        for (Icon icon : result) {
            dropList.add(new DropDownModel(icon.getIconId(), icon.getIconName()));
        }
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
}
