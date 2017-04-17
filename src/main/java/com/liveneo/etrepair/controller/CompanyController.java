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
import com.liveneo.etrepair.json.wrapper.DropDownModel;
import com.liveneo.etrepair.log.LVLogger;
import com.liveneo.etrepair.pojo.Company;
import com.liveneo.etrepair.pojo.User;
import com.liveneo.etrepair.service.CompanyService;

@Controller
@RequestMapping("/company")
public class CompanyController extends BaseController {
    LVLogger               logger = LVLogger.getLogger(this.getClass());
    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public String addCompany(Company company, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            String updateBy = user.getUserName();
            company.setUpdateBy(updateBy);
            company.setCreateBy(updateBy);
        }
        Date date = new Date();
        company.setCreateTime(date);
        company.setUpdateTime(date);
        try {
            logger.debug("新增公司" + company);
            companyService.addCompany(company);
        } catch (Exception e) {
            logger.error("新增公司失败" + e);
            return resultError("新增公司失败");
        }
        return resultOK();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public String deleteCompany(String id) {
        try {
            companyService.deleteCompany(id);
        } catch (Exception e) {
            logger.error("删除公司失败" + e);
            return resultError("删除公司失败");
        }
        return resultOK();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public String updateCompany(Company company, HttpSession session) {
        String[] companyCodes = company.getCompanyCode().split(",");
        String companyCode = companyCodes[0];
        String companyCodeUpdate = companyCodes[1];
        company.setCompanyCode(companyCode);
        company.setCompanyCodeUpdate(companyCodeUpdate);
        User user = (User) session.getAttribute("user");
        if (user != null) {
            String updateBy = user.getUserName();
            company.setUpdateBy(updateBy);
            company.setUpdateTime(new Date());
        }
        try {
            logger.debug("修改公司" + company);
            companyService.updateCompany(company);
        } catch (Exception e) {
            logger.error("修改公司失败" + e);
            return resultError("修改公司失败");
        }
        return resultOK();
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public String getAllCompanyByCondition(Company company, Integer page, Integer rows) {
        int skip = -1;
        if (page != -1) {
            skip = (page - 1) * rows;
        }
        List<Company> companys = companyService.getAllCompanyByCondition(company, skip, rows);
        Map<String, Object> maps = new HashMap<String, Object>();
        maps.put("total", companyService.countCompany(company));
        maps.put("rows", companys);
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

    @RequestMapping(value = "/code/exist", method = RequestMethod.GET)
    @ResponseBody
    public boolean isCompanyCodeExist(String companyCode) {
        return companyService.isCompanyCodeExist(companyCode);
    }

    @RequestMapping(value = "/name/exist", method = RequestMethod.GET)
    @ResponseBody
    public boolean isCompanyNameExist(String companyName) {
        return companyService.isCompanyNameExist(companyName);
    }

    /**
     * 返回全部公司列表
     * 
     * @return
     */
    @RequestMapping(value = "/list/json", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public String getCompanysJson() {
        List<Company> companys = this.companyService.getCompanys();
        List<DropDownModel> result = new ArrayList<DropDownModel>();
        for (Company company : companys) {
            DropDownModel d = new DropDownModel();
            d.setId(company.getCompanyCode());
            d.setText(company.getCompanyName());
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

    @RequestMapping(value = "/list/json/default", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public String getCompanysJsonDefault(String defaultVal) {
        List<Company> companys = this.companyService.getCompanys();
        // 添加默认值 0 请选择 ，-1 无
        List<DropDownModel> result = new ArrayList<DropDownModel>();
        DropDownModel defaultDropdown = null;
        if (defaultVal != null && "0".equals(defaultVal)) {
            defaultDropdown = new DropDownModel("0", "--全部--");
            defaultDropdown.setSelected(true);
            result.add(defaultDropdown);
        } else if (defaultVal != null && "-1".equals(defaultVal)) {
            defaultDropdown = new DropDownModel("-1", "--请选择--");
            defaultDropdown.setSelected(true);
            result.add(defaultDropdown);
        }
        for (Company company : companys) {
            DropDownModel d = new DropDownModel();
            d.setId(company.getCompanyCode());
            d.setText(company.getCompanyName());
            if (defaultVal.equals(company.getCompanyCode())) {
                d.setSelected(true);
            }
            result.add(d);
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            logger.debug("公司列表：" + result);
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

    @RequestMapping
    public String company() {
        return "company/list";
    }
}
