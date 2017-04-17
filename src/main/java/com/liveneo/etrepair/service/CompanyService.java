package com.liveneo.etrepair.service;

import java.util.List;
import com.liveneo.etrepair.pojo.Company;

public interface CompanyService {
    public void addCompany(Company company);

    public void deleteCompany(String CompanyId);

    public void updateCompany(Company company);

    public int countCompanyByConditions(Company company);

    public boolean isCompanyCodeExist(String companyCode);

    public boolean isCompanyNameExist(String companyName);

    public int countCompany(Company company);

    public List<Company> getAllCompanyByCondition(Company conditionCompany, Integer skip, Integer limit);

    // 获取所有公司列表
    public List<Company> getCompanys();
}
