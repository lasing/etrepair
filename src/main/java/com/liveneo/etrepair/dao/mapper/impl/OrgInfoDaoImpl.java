package com.liveneo.etrepair.dao.mapper.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.liveneo.etrepair.common.UserReadableException;
import com.liveneo.etrepair.dao.mapper.OrgInfoMapper;
import com.liveneo.etrepair.pojo.OrgInfo;
import com.liveneo.etrepair.pojo.OrgInfoExample;

@Repository
public class OrgInfoDaoImpl {
    @Autowired
    private OrgInfoMapper orgInfoMapper;

    /***
     * 新增组织机构
     * 
     * @param orgInfo
     * @return
     */
    public int addOrgInfo(OrgInfo orgInfo) {
        orgInfo.setCreateTime(new Date());
        return orgInfoMapper.insert(orgInfo);
    }

    /***
     * 根据主键删除组织机构
     * 
     * @param id
     */
    public int deleteOrgInfoById(String id) {
        return orgInfoMapper.deleteByPrimaryKey(id);
    }

    /***
     * 更新组织机构
     * 
     * @param orgInfo
     */
    public void updateOrgInfo(OrgInfo orgInfo) {
        orgInfo.setUpdateTime(new Date());
        try {
            orgInfoMapper.updateByPrimaryKey(orgInfo);
        } catch (Exception e) {
            throw new UserReadableException("更新失败");
        }
    }

    /***
     * 检索所有的组织机构
     * 
     * @return
     */
    public List<OrgInfo> listAllOrgInfo() {
        OrgInfoExample example = new OrgInfoExample();
        example.setOrderByClause("CREATE_TIME");
        return orgInfoMapper.selectByExample(example);
    }

    /**
     * @Description:通过组织结构代码查询组织结构信息
     * @param orgcode
     * @ReturnType:OrgInfo
     * @Author:zuokunpeng
     * @Since:2016-3-31 下午4:06:54
     */
    public OrgInfo selectOrgInfoByOrgode(String orgcode) {
        return orgInfoMapper.selectOrgInfoByOrgcode(orgcode);
    }

    public OrgInfo getOrgInfo(String orgId) {
        return orgInfoMapper.selectByPrimaryKey(orgId);
    }

    public String getOrgCodeByOrgId(String orgId) {
        OrgInfo orgInfo = orgInfoMapper.selectByPrimaryKey(orgId);
        return orgInfo.getOrgCode();
    }

    public List<OrgInfo> getOrgInfoByParentorgId(String pid) {
        OrgInfoExample example = new OrgInfoExample();
        example.createCriteria().andParentOrgIdEqualTo(pid);
        return orgInfoMapper.selectByExample(example);
    }

    public List<OrgInfo> getOrgInfoByUserorgId(String uid) {
        OrgInfoExample example = new OrgInfoExample();
        example.createCriteria().andOrgIdEqualTo(uid);
        return orgInfoMapper.selectByExample(example);
    }

    public List<OrgInfo> selectByExample(OrgInfoExample orgExample) {
        return orgInfoMapper.selectByExample(orgExample);
    }

    public boolean isOrgCodeExist(String orgCode) {
        OrgInfoExample example = new OrgInfoExample();
        example.createCriteria().andOrgCodeEqualTo(orgCode);
        List<OrgInfo> result = orgInfoMapper.selectByExample(example);
        if (result != null && result.size() != 0) {
            return true;
        }
        return false;
    }

    /**
     * @Description:获取所有的分公司
     * @ReturnType:List<OrgInfo>
     * @Author:zuokunpeng
     * @Since:2016-4-15 下午5:19:36
     */
    public List<OrgInfo> getAllChildCompany() {
        return orgInfoMapper.getAllChildCompany();
    }

    /**
     * @Description:通过组织机构Id获取旗下所有的中支机构
     * @param orgInfoId
     * @ReturnType:List<OrgInfo>
     * @Author:zuokunpeng
     * @Since:2016-4-15 下午6:06:49
     */
    public List<OrgInfo> getZZOrgInfosById(String orgInfoId) {
        OrgInfoExample example = new OrgInfoExample();
        OrgInfoExample.Criteria criteria = example.createCriteria();
        if (orgInfoId != null && orgInfoId.trim().length() > 0) {
            criteria.andParentOrgIdEqualTo(orgInfoId);
        }
        return orgInfoMapper.selectByExample(example);
    }

    /**
     * 根据机构id获取机构列表
     * 
     * @param ids
     * @return
     */
    public List<OrgInfo> getOrgInfosByIds(List<String> ids) {
        if (ids == null || ids.isEmpty()) return new ArrayList<OrgInfo>();
        OrgInfoExample example = new OrgInfoExample();
        example.createCriteria().andOrgIdIn(ids);
        return orgInfoMapper.selectByExample(example);
    }

    public List<OrgInfo> selectByCompanyCode(String companyCode) {
        return orgInfoMapper.selectByCompanyCode(companyCode);
    }

    public List<OrgInfo> getOrgInfoByParentorgIdAndCompanyCode(String pid, String companyCode) {
        OrgInfoExample example = new OrgInfoExample();
        example.createCriteria().andParentOrgIdEqualTo(pid).andCompanyCodeEqualTo(companyCode);
        return orgInfoMapper.selectByExample(example);
    }

    /**
     * @Desc: 根据id获取组织机构 
     * @Author: zhaoyy 2016年10月27日 下午6:09:57
     * @param orgId
     * @return
     */
    public OrgInfo selectOrgInfoByOrgId(String orgId) {
        return orgInfoMapper.selectByPrimaryKey(orgId);
    }
}
