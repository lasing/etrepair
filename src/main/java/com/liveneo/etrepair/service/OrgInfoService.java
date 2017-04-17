package com.liveneo.etrepair.service;

import java.util.List;
import java.util.Map;
import com.liveneo.etrepair.pojo.OrgInfo;
import com.liveneo.etrepair.pojo.OrgInfoExample;

public interface OrgInfoService {
    public int addOrgInfo(OrgInfo orgInfo);

    public void deleteOrgInfoById(String id);

    public void updateOrgInfo(OrgInfo orgInfo);

    public List<OrgInfo> listAllOrgInfo();

    public String getOrgCodeByOrgId(String orgId);

    /**
     * 根据组织机构的父级id 获取组织机构的树形Json数据 <br>
     * 由于此处只有三层目录 数据量也不太多，故暂不考虑使用ajax异步获取 <br>
     * 
     * @return
     */
    public List<Map<String, Object>> getJsonTtree(String id);

    public List<OrgInfo> selectByExample(OrgInfoExample orgExample);

    /**
     * 根据组织机构简称获取组织机构编码
     * 
     * @param orgName
     * @return
     */
    public String getOrgCodeByDescription(String orgName);

    /**
     * 根据分公司编码获取中支 名称-code
     * 
     * @return
     */
    public Map<String, String> getBranchByOrgId(String orgId);

    /**
     * 根据组织机构简称获取组织机构Id
     * 
     * @param orgName
     * @return
     */
    public String getOrgIdByDescription(String orgName);

    /**
     * 获取组织机构的树形数据 格式 code-name <br>
     * 只获取总公司和分公司（中支不需要） <br>
     * 
     * @return
     */
    public List<Map<String, Object>> getCodelist(String id, String companyCode);

    public List<Map<String, Object>> getCodeIdJsonTtree(String id);

    /**
     * @Description:获取所有的分公司
     * @ReturnType:List<OrgInfo>
     * @Author:zuokunpeng
     * @Since:2016-4-15 下午5:19:36
     */
    public List<OrgInfo> getAllChildCompany();

    /**
     * 根据组织机构编号获取组织机构id
     * 
     * @param orgCode
     * @return
     */
    public OrgInfo selectOrgInfoByOrgode(String orgCode);

    /**
     * 根据组织机构id获取子级机构
     * 
     * @param id
     * @return
     */
    public List<OrgInfo> getOrgInfoByParentorgId(String id);

    /**
     * 根据id获取组织机构编码位数
     * @param id
     * @return
     */
    public String getOrgCodeById(String id);

    /**
     * 该组织机构编码是否已存在
     * @param orgCode
     * @return
     */
    public boolean isOrgCodeExist(String orgCode);

    /**
     * 获取总公司
     * @return
     */
    public OrgInfo getHeadOffice();

    List<OrgInfo> selectByCompanyCode(String companyCode);

    List<Map<String, Object>> jsonCodeIdTreeByUserOrgId(String id);

    /**
     * @Desc: 根据组织机构id获取组织机构
     * @Author: zhaoyy 2016年10月27日 下午6:08:00
     * @param orgId
     * @return
     */
    public OrgInfo getOrgInfoByOrgId(String orgId);
}
