package com.liveneo.etrepair.dao.mapper;

import com.liveneo.etrepair.pojo.Company;
import com.liveneo.etrepair.pojo.CompanyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CompanyMapper {
    int countByExample(CompanyExample example);

    int delete(String companyId);

    int deleteByPrimaryKey(String companyCode);

    int insert(Company record);

    int insertSelective(Company record);

    List<Company> selectByExample(CompanyExample example);

    Company selectByPrimaryKey(String companyCode);

    Company selectByCompanyName(String companyName);

    int updateByExampleSelective(@Param("record") Company record, @Param("example") CompanyExample example);

    int updateByExample(@Param("record") Company record, @Param("example") CompanyExample example);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKey(Company record);

    int countCompany(Company company);

    List<Company> selectCompanyList(Company company);
}