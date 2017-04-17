package com.liveneo.etrepair.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
import com.liveneo.etrepair.common.UserReadableException;
import com.liveneo.etrepair.json.wrapper.DropDownModel;
import com.liveneo.etrepair.json.wrapper.OrgInfoWrapper;
import com.liveneo.etrepair.pojo.OrgInfo;
import com.liveneo.etrepair.pojo.User;
import com.liveneo.etrepair.service.OrgInfoService;

@Controller
@RequestMapping("/orginfo")
public class OrgInfoController extends BaseController {
    @Autowired
    private OrgInfoService orgInfoService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String addOrgInfo(OrgInfo orgInfo, HttpSession session) {
        Date date = new Date();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            orgInfo.setCreateBy(user.getUserName());
            orgInfo.setUpdateBy(user.getUserName());
        }
        orgInfo.setCreateTime(date);
        orgInfo.setUpdateTime(date);
        try {
            orgInfoService.addOrgInfo(orgInfo);
        } catch (Exception e) {
            return resultError("添加组织机构失败");
        }
        return resultOK();
    }

    /***
     * 删除组织以及该组织下的分支机构
     * 
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public String deleteOrgInfo(String id) {
        orgInfoService.deleteOrgInfoById(id);
        return resultOK();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public String updateOrgInfo(OrgInfoWrapper orgInfoWrapper, String _parentId, HttpSession session) {
        OrgInfo orgInfo = new OrgInfo();
        orgInfo.setOrgId(orgInfoWrapper.getId());
        orgInfo.setCompanyCode(orgInfoWrapper.getCompanycode());
        orgInfo.setOrgCode(orgInfoWrapper.getOrgcode());
        orgInfo.setOrgName(orgInfoWrapper.getOrgname());
        orgInfo.setOrgDesc(orgInfoWrapper.getDescription());
        orgInfo.setParentOrgId(_parentId);
        orgInfo.setIsEnable(orgInfoWrapper.getIsEnable());
        orgInfo.setCreateTime(orgInfoWrapper.getCreateTime());
        orgInfo.setUpdateTime(new Date());
        User user = (User) session.getAttribute("user");
        if (user != null) {
            orgInfo.setUpdateBy(user.getUserName());
        }
        try {
            orgInfoService.updateOrgInfo(orgInfo);
        } catch (Exception e) {
            return resultError("更新失败！");
        }
        return resultOK();
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public String listAllOrgInfo(String companyCode) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", 0);
        if (companyCode != null && companyCode.equals("0")) {
            companyCode = null;
        }
        List<OrgInfo> orgs = orgInfoService.selectByCompanyCode(companyCode);
        List<OrgInfoWrapper> orgNewrs = new ArrayList<OrgInfoWrapper>();
        for (OrgInfo orginfo : orgs) {
            OrgInfoWrapper o = new OrgInfoWrapper();
            o.setId(orginfo.getOrgId());
            o.setDescription(orginfo.getOrgDesc());
            o.setOrgcode(orginfo.getOrgCode());
            o.setOrgname(orginfo.getOrgName());
            o.setCompanycode(orginfo.getCompanyCode());
            o.setIsEnable(orginfo.getIsEnable());
            o.setCreateBy(orginfo.getCreateBy());
            o.setCreateTime(orginfo.getCreateTime());
            if (orginfo.getParentOrgId() != null && !"".equals(orginfo.getParentOrgId()) && !"0".equals(orginfo.getParentOrgId())) {
                o.set_parentId(orginfo.getParentOrgId());
            } else {
                o.set_parentId(null);
                o.setState("closed");
            }
            orgNewrs.add(o);
        }
        result.put("rows", orgNewrs);
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

    @RequestMapping(value = "/list/json", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public String listAllOrgInfoForDropDown() {
        List<OrgInfo> orgs = orgInfoService.listAllOrgInfo();
        List<DropDownModel> dropList = new ArrayList<DropDownModel>();
        if (orgs == null || orgs.size() == 0) {
            DropDownModel dedaultList = new DropDownModel();
            dedaultList.setId("0");
            dedaultList.setText("无");
            dedaultList.setSelected(true);
            dropList.add(dedaultList);
        } else {
            for (OrgInfo orginfo : orgs) {
                DropDownModel d = new DropDownModel();
                d.setId(orginfo.getOrgId());
                d.setText(orginfo.getOrgDesc());
                dropList.add(d);
            }
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

    @RequestMapping(value = "/list/json/default", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public String listAllOrgInfoForDropDownDefault() {
        List<OrgInfo> orgs = orgInfoService.listAllOrgInfo();
        DropDownModel defaultDropdown = new DropDownModel("0", "--请选择--");
        defaultDropdown.setSelected(true);
        List<DropDownModel> dropList = new ArrayList<DropDownModel>();
        dropList.add(defaultDropdown);
        for (OrgInfo orginfo : orgs) {
            DropDownModel d = new DropDownModel();
            d.setId(orginfo.getOrgId());
            d.setText(orginfo.getOrgDesc());
            dropList.add(d);
        }
        if (dropList != null && dropList.size() != 0) {
            dropList.get(0).setSelected(true);
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

    /**
     * 获取组织机构的树形Json数据
     * 
     * @return
     */
    @RequestMapping(value = "/list/jsonTree", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public List<Map<String, Object>> jsonTree() {
        List<Map<String, Object>> jsonTree = orgInfoService.getCodeIdJsonTtree("");
        return jsonTree;
    }

    /**
     * 获取组织机构的树形Json数据
     * 
     * @return
     */
    @RequestMapping(value = "/list/jsonCodeIdTree", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public List<Map<String, Object>> jsonCodeTree() {
        List<Map<String, Object>> jsonTree = orgInfoService.getCodeIdJsonTtree("");
        return jsonTree;
    }

    /**
     * 根据公司code获取组织机构的树形Json数据
     * 
     * @return
     */
    @RequestMapping(value = "/list/jsonTreeByCompanyCode", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public List<Map<String, Object>> jsonCodeTree(String companyCode) {
        if ("-1".equals(companyCode)) {
            return null;
        }
        List<Map<String, Object>> jsonTree = orgInfoService.getCodelist("", companyCode);
        return jsonTree;
    }

    /**
     * 获取组织机构的树形Json数据
     * @return
     */
    @RequestMapping(value = "/codelist/jsonTree", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public List<Map<String, Object>> codelist() {
        List<Map<String, Object>> jsonTree = orgInfoService.getCodeIdJsonTtree("");
        return jsonTree;
    }

    /**
     * @Description:所有分公司下拉框Json数据
     * @ReturnType:String
     * @Author:zuokunpeng
     * @Since:2016-4-15 下午5:27:14
     */
    @RequestMapping(value = "/allChildOrgInfo/json", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public String getAllChildOrgInfo() {
        List<OrgInfo> orginfos = orgInfoService.getAllChildCompany();
        // 构造下拉框数据源
        List<DropDownModel> dropDownList = new ArrayList<DropDownModel>();
        DropDownModel first = new DropDownModel("", "--请选择--");
        dropDownList.add(first);
        for (OrgInfo item : orginfos) {
            DropDownModel model = new DropDownModel(item.getOrgCode(), item.getOrgDesc());
            dropDownList.add(model);
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(dropDownList);
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
     * 获取组织机构编码位数
     * 
     * @param id
     * @return
     */
    @RequestMapping(value = "/code", method = RequestMethod.GET)
    @ResponseBody
    public String getCodeLength(String id) {
        try {
            return orgInfoService.getOrgCodeById(id);
        } catch (Exception e) {
            return resultError("获取组织机构编码长度失败！");
        }
    }

    @RequestMapping(value = "/code/exist", method = RequestMethod.GET)
    @ResponseBody
    public boolean isOrgCodeExist(String orgCode) {
        return orgInfoService.isOrgCodeExist(orgCode);
    }

    /**
     * 获取当前用户组织机构的树形Json数据
     * 
     * @return
     */
    @RequestMapping(value = "/list/jsonCodeIdTreeByUserOrgId", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public List<Map<String, Object>> jsonCodeIdTreeByUserOrgId(HttpSession session) {
        String orgId = null;
        User user = (User) session.getAttribute("user");
        if (user != null) {
            // 根据当前用户名的orgid(如果是admin的话展示全部的)
            if ("admin".equals(user.getUserName())) {
                List<Map<String, Object>> jsonTree = orgInfoService.getCodeIdJsonTtree("");
                return jsonTree;
            }
            orgId = user.getOrgId();
            List<Map<String, Object>> jsonTree = orgInfoService.jsonCodeIdTreeByUserOrgId(orgId);
            return jsonTree;
        }
        throw new UserReadableException("登录超时，请重新登录！");
    }

    @RequestMapping
    public String orgInfo() {
        return "orginfo/list";
    }
}
