package com.liveneo.etrepair.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.liveneo.etrepair.common.UserReadableException;
import com.liveneo.etrepair.dao.mapper.impl.OrgInfoDaoImpl;
import com.liveneo.etrepair.json.wrapper.OrgInfoWrapper;
import com.liveneo.etrepair.pojo.OrgInfo;
import com.liveneo.etrepair.pojo.OrgInfoExample;
import com.liveneo.etrepair.service.OrgInfoService;

@Service
public class OrgInfoServiceImpl implements OrgInfoService {
    @Autowired
    private OrgInfoDaoImpl orgInfoDaoImpl;

    @Override
    public int addOrgInfo(OrgInfo orgInfo) {
        return orgInfoDaoImpl.addOrgInfo(orgInfo);
    }

    // 删除组织机构，以及该组织机构对应的分支机构
    @Override
    public void deleteOrgInfoById(String id) {
        OrgInfo orgInfo = orgInfoDaoImpl.getOrgInfo(id);
        /*
         * if(orgInfo.getOrgCode().length()!=6){ throw new UserReadableException("该组织不能被删除", "deleteForbidden"); }
         */
        orgInfoDaoImpl.deleteOrgInfoById(id);
        List<OrgInfo> result = orgInfoDaoImpl.getOrgInfoByParentorgId(id);
        if (result != null && result.size() != 0) {
            this.deleteByParentId(id);
        }
    }

    // 递归删除 组织机构下的分支机构
    public void deleteByParentId(String pId) {
        List<OrgInfo> pOrgs = orgInfoDaoImpl.getOrgInfoByParentorgId(pId);
        orgInfoDaoImpl.deleteOrgInfoById(pId);
        List<OrgInfo> result = orgInfoDaoImpl.getOrgInfoByParentorgId(pId);
        if (result != null && result.size() != 0) {
            for (OrgInfo orgInfo : result) {
                this.deleteByParentId(orgInfo.getOrgId());
            }
        }
    }

    @Override
    public void updateOrgInfo(OrgInfo orgInfo) {
        orgInfoDaoImpl.updateOrgInfo(orgInfo);
    }

    @Override
    public List<OrgInfo> listAllOrgInfo() {
        return orgInfoDaoImpl.listAllOrgInfo();
    }

    @Override
    public String getOrgCodeByOrgId(String orgId) {
        return orgInfoDaoImpl.getOrgCodeByOrgId(orgId);
    }

    @Override
    public List<Map<String, Object>> getJsonTtree(String id) {
        List<Map<String, Object>> wapList1 = new ArrayList<Map<String, Object>>();
        // 第一级目录
        List<OrgInfo> list1 = orgInfoDaoImpl.getOrgInfoByParentorgId(id);
        for (OrgInfo orgInfo : list1) {
            OrgInfoWrapper wap = new OrgInfoWrapper();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", orgInfo.getOrgId());
            map.put("text", orgInfo.getOrgDesc());
            // 第二级目录
            List<OrgInfo> list2 = orgInfoDaoImpl.getOrgInfoByParentorgId(orgInfo.getOrgId());
            if (list2 != null && !list2.isEmpty()) {
                map.put("state", "closed");
                List<Map<String, Object>> wapList2 = new ArrayList<Map<String, Object>>();
                for (OrgInfo orgInfo2 : list2) {
                    Map<String, Object> map2 = new HashMap<String, Object>();
                    map2.put("id", orgInfo2.getOrgId());
                    map2.put("text", orgInfo2.getOrgDesc());
                    // 第三级目录
                    List<OrgInfo> list3 = orgInfoDaoImpl.getOrgInfoByParentorgId(orgInfo2.getOrgId());
                    if (list3 != null && !list3.isEmpty()) {
                        map2.put("state", "closed");
                        List<Map<String, Object>> wapList3 = new ArrayList<Map<String, Object>>();
                        for (OrgInfo orgInfo3 : list3) {
                            Map<String, Object> map3 = new HashMap<String, Object>();
                            map3.put("id", orgInfo3.getOrgId());
                            map3.put("text", orgInfo3.getOrgDesc());
                            // 第四层级目录
                            List<OrgInfo> list4 = orgInfoDaoImpl.getOrgInfoByParentorgId(orgInfo3.getOrgId());
                            if (list4 != null && !list4.isEmpty()) {
                                map3.put("state", "closed");
                            } else {
                                map3.put("state", "open");
                            }
                            wapList3.add(map3);
                        }
                        map2.put("children", wapList3);
                    } else {
                        map2.put("state", "open");
                    }
                    wapList2.add(map2);
                }
                map.put("children", wapList2);
            } else {
                wap.setState("open");
            }
            wapList1.add(map);
        }
        return wapList1;
    }

    @Override
    public List<OrgInfo> selectByExample(OrgInfoExample orgExample) {
        return orgInfoDaoImpl.selectByExample(orgExample);
    }

    @Override
    public String getOrgIdByDescription(String orgName) {
        // 根据分公司名称查询分公司信息
        String orgId = null;
        OrgInfoExample orgExample = new OrgInfoExample();
        if (orgName != null && !orgName.equals("")) {
            orgExample.createCriteria().andOrgDescEqualTo(orgName.trim());
        }
        List<OrgInfo> orgList = orgInfoDaoImpl.selectByExample(orgExample);
        if (orgList != null && !orgList.isEmpty()) {
            OrgInfo org = orgList.get(0);
            orgId = org.getOrgId();// 分公司ID
        }
        return orgId;
    }

    @Override
    public Map<String, String> getBranchByOrgId(String orgId) {
        Map<String, String> map = new HashMap<String, String>();
        OrgInfoExample orgExample = new OrgInfoExample();
        orgExample.createCriteria().andOrgDescEqualTo(orgId);
        List<OrgInfo> list = orgInfoDaoImpl.selectByExample(orgExample);
        for (OrgInfo orgInfo : list) {// 由于页面显示简称 故此处保存简称-code键值对
            map.put(orgInfo.getOrgDesc(), orgInfo.getOrgCode());
        }
        return map;
    }

    @Override
    public List<Map<String, Object>> getCodelist(String id, String companyCode) {
        List<Map<String, Object>> wapList1 = new ArrayList<Map<String, Object>>();
        // 第一级目录(查询公司下的父机构)
        List<OrgInfo> list1 = orgInfoDaoImpl.getOrgInfoByParentorgIdAndCompanyCode(id, companyCode);
        for (OrgInfo orgInfo : list1) {
            OrgInfoWrapper wap = new OrgInfoWrapper();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", orgInfo.getOrgId());
            map.put("text", orgInfo.getOrgDesc());
            // 第二级目录
            List<OrgInfo> list2 = orgInfoDaoImpl.getOrgInfoByParentorgIdAndCompanyCode(orgInfo.getOrgId(), companyCode);
            if (list2 != null && !list2.isEmpty()) {
                map.put("state", "closed");
                List<Map<String, Object>> wapList2 = new ArrayList<Map<String, Object>>();
                for (OrgInfo orgInfo2 : list2) {
                    Map<String, Object> map2 = new HashMap<String, Object>();
                    map2.put("id", orgInfo2.getOrgId());
                    map2.put("text", orgInfo2.getOrgDesc());
                    map2.put("state", "open");
                    wapList2.add(map2);
                }
                map.put("children", wapList2);
            } else {
                wap.setState("open");
            }
            wapList1.add(map);
        }
        return wapList1;
    }

    @Override
    public String getOrgCodeByDescription(String orgName) {
        // 根据分公司名称查询分公司信息
        String orgCode = null;
        OrgInfoExample orgExample = new OrgInfoExample();
        if (orgName != null && !orgName.equals("")) {
            orgExample.createCriteria().andOrgDescEqualTo(orgName.trim());
        }
        List<OrgInfo> orgList = orgInfoDaoImpl.selectByExample(orgExample);
        if (orgList != null && !orgList.isEmpty()) {
            OrgInfo org = orgList.get(0);
            orgCode = org.getOrgCode();// 分公司编号
        }
        return orgCode;
    }

    @Override
    public List<OrgInfo> getAllChildCompany() {
        return orgInfoDaoImpl.getAllChildCompany();
    }

    @Override
    public List<Map<String, Object>> getCodeIdJsonTtree(String id) {
        List<Map<String, Object>> wapList1 = new ArrayList<Map<String, Object>>();
        // 第一级目录
        List<OrgInfo> list1 = orgInfoDaoImpl.getOrgInfoByParentorgId(id);
        for (OrgInfo orgInfo : list1) {
            OrgInfoWrapper wap = new OrgInfoWrapper();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", orgInfo.getOrgId());
            map.put("text", orgInfo.getOrgDesc());
            // 第二级目录
            List<OrgInfo> list2 = orgInfoDaoImpl.getOrgInfoByParentorgId(orgInfo.getOrgId());
            if (list2 != null && !list2.isEmpty()) {
                map.put("state", "closed");
                List<Map<String, Object>> wapList2 = new ArrayList<Map<String, Object>>();
                for (OrgInfo orgInfo2 : list2) {
                    Map<String, Object> map2 = new HashMap<String, Object>();
                    map2.put("id", orgInfo2.getOrgId());
                    map2.put("text", orgInfo2.getOrgDesc());
                    map2.put("state", "open");
                    wapList2.add(map2);
                }
                map.put("children", wapList2);
            } else {
                wap.setState("open");
            }
            wapList1.add(map);
        }
        return wapList1;
    }

    @Override
    public OrgInfo selectOrgInfoByOrgode(String orgCode) {
        return orgInfoDaoImpl.selectOrgInfoByOrgode(orgCode);
    }

    @Override
    public List<OrgInfo> getOrgInfoByParentorgId(String id) {
        return orgInfoDaoImpl.getOrgInfoByParentorgId(id);
    }

    /**
     * 根据id获取组织机构编码位数
     */
    @Override
    public String getOrgCodeById(String id) {
        OrgInfo orgInfo = orgInfoDaoImpl.getOrgInfo(id);
        if (orgInfo != null) {
            return orgInfo.getOrgCode();
        } else {
            throw new UserReadableException("该组织机构不存在");
        }
    }

    /**
     * 该组织机构是否已存在
     */
    @Override
    public boolean isOrgCodeExist(String orgCode) {
        return orgInfoDaoImpl.isOrgCodeExist(orgCode);
    }

    @Override
    public OrgInfo getHeadOffice() {
        OrgInfoExample example = new OrgInfoExample();
        example.createCriteria().andOrgDescEqualTo("");
        List<OrgInfo> list = orgInfoDaoImpl.selectByExample(example);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<OrgInfo> selectByCompanyCode(String companyCode) {
        return orgInfoDaoImpl.selectByCompanyCode(companyCode);
    }

    // 获取当前和子机构id
    @Override
    public List<Map<String, Object>> jsonCodeIdTreeByUserOrgId(String orgId) {
        List<Map<String, Object>> wapList1 = new ArrayList<Map<String, Object>>();
        // 第一级目录
        List<OrgInfo> list1 = orgInfoDaoImpl.getOrgInfoByUserorgId(orgId);
        for (OrgInfo orgInfo : list1) {
            OrgInfoWrapper wap = new OrgInfoWrapper();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", orgInfo.getOrgId());
            map.put("text", orgInfo.getOrgDesc());
            // 第二级目录
            List<OrgInfo> list2 = orgInfoDaoImpl.getOrgInfoByParentorgId(orgInfo.getOrgId());
            if (list2 != null && !list2.isEmpty()) {
                map.put("state", "closed");
                List<Map<String, Object>> wapList2 = new ArrayList<Map<String, Object>>();
                for (OrgInfo orgInfo2 : list2) {
                    Map<String, Object> map2 = new HashMap<String, Object>();
                    map2.put("id", orgInfo2.getOrgId());
                    map2.put("text", orgInfo2.getOrgDesc());
                    map2.put("state", "open");
                    wapList2.add(map2);
                }
                map.put("children", wapList2);
            } else {
                wap.setState("open");
            }
            wapList1.add(map);
        }
        return wapList1;
    }

    // 根据id获取组织机构
    @Override
    public OrgInfo getOrgInfoByOrgId(String orgId) {
        return orgInfoDaoImpl.selectOrgInfoByOrgId(orgId);
    }
}
