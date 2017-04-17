package com.liveneo.etrepair.dao.mapper.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.liveneo.etrepair.dao.mapper.CompanyMapper;
import com.liveneo.etrepair.pojo.Company;

@Repository
public class CompanyDaoImpl {
    @Autowired
    CompanyMapper companyMapper;

    /***
     * 添加公司
     */
    public void addCompany(Company company) {
        companyMapper.insert(company);
    }

    /***
     * 修改公司
     */
    public void updateCompany(Company company) {
        companyMapper.updateByPrimaryKeySelective(company);
    }

    /***
     * 删除公司
     */
    public void deleteCompany(String companyId) {
        companyMapper.deleteByPrimaryKey(companyId);
    }

    /***
     * 公司总数
     */
    public int countCompany(Company company) {
        return companyMapper.countCompany(company);
    }

    /***
     * 获取公司列表
     */
    public List<Company> getCompanyList(Company company, int skip, int rows) {
        company.setSkip(skip);
        company.setLimit(rows);
        return companyMapper.selectCompanyList(company);
    }

    /**
     * 公司编码是否存在
     * @param companyCode
     * @return
     */
    public Company isCompanyCodeExist(String companyCode) {
        Company company = companyMapper.selectByPrimaryKey(companyCode);
        if (company != null) {
            return company;
        }
        return null;
    }

    /**
     * 公司名称是否存在
     * @param companyName
     * @return
     */
    public Company isCompanyNameExist(String companyName) {
        Company company = companyMapper.selectByCompanyName(companyName);
        if (company != null) {
            return company;
        }
        return null;
    }

    public List<Company> getCompanys() {
        return this.companyMapper.selectCompanyList(null);
    }
}
