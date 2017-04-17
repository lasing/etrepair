package com.liveneo.etrepair.dao.mapper;

import com.liveneo.etrepair.pojo.OrgInfo;
import com.liveneo.etrepair.pojo.OrgInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrgInfoMapper {
    int countByExample(OrgInfoExample example);

    int deleteByExample(OrgInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(OrgInfo record);

    int insertSelective(OrgInfo record);

    List<OrgInfo> selectByExample(OrgInfoExample example);

    OrgInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") OrgInfo record, @Param("example") OrgInfoExample example);

    int updateByExample(@Param("record") OrgInfo record, @Param("example") OrgInfoExample example);

    int updateByPrimaryKeySelective(OrgInfo record);

    int updateByPrimaryKey(OrgInfo record);

    /**
     * @Description:通过组织机构代码查询组织机构信息
     * @param orgcode
     * @ReturnType:OrgInfo
     * @Author:zuokunpeng
     * @Since:2016-3-31 下午4:21:40
     */
    OrgInfo selectOrgInfoByOrgcode(String orgcode);

    /**
     * @Description:获取所有的分公司
     * @ReturnType:List<OrgInfo>
     * @Author:zuokunpeng
     * @Since:2016-4-15 下午5:19:36
     */
    public List<OrgInfo> getAllChildCompany();

    /**
     * 查询公司下的组织结构
     * @param companyCode
     * @return
     */
    List<OrgInfo> selectByCompanyCode(@Param("companyCode") String companyCode);
}