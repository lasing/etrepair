package com.liveneo.etrepair.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.liveneo.etrepair.common.Constant;
import com.liveneo.etrepair.dao.mapper.impl.CompanyDaoImpl;
import com.liveneo.etrepair.log.Opertorlog;
import com.liveneo.etrepair.pojo.Company;
import com.liveneo.etrepair.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyDaoImpl companyDaoImpl;

    @Override
    @Opertorlog(name = "新增公司", functionPath = "系统配置-->公司管理-->新增公司", operateType = Constant.OPERATE_TYPE_ADD)
    public void addCompany(Company company) {
        this.companyDaoImpl.addCompany(company);
    }

    @Override
    public void deleteCompany(String companyId) {
        // 删除公司
        this.companyDaoImpl.deleteCompany(companyId);
    }

    @Override
    @Opertorlog(name = "修改公司", functionPath = "系统配置-->公司管理-->编辑公司", operateType = Constant.OPERATE_TYPE_UPDATE)
    public void updateCompany(Company company) {
        // 修改公司
        this.companyDaoImpl.updateCompany(company);
    }

    @Override
    public int countCompany(Company company) {
        return this.companyDaoImpl.countCompany(company);
    }

    /**
     * 根据条件检索公司
     * 
     * @param company
     * @param skip
     * @param limit
     * @return
     */
    @Override
    public List<Company> getAllCompanyByCondition(Company company, Integer skip, Integer limit) {
        return this.companyDaoImpl.getCompanyList(company, skip, limit);
    }

    @Override
    public int countCompanyByConditions(Company company) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isCompanyCodeExist(String companyCode) {
        Company company = this.companyDaoImpl.isCompanyCodeExist(companyCode);
        if (company != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isCompanyNameExist(String companyName) {
        Company company = this.companyDaoImpl.isCompanyNameExist(companyName);
        if (company != null) {
            return true;
        }
        return false;
    }

    @Override
    public List<Company> getCompanys() {
        List<Company> result = this.companyDaoImpl.getCompanys();
        // 如果有子公司，在下面做处理
        return result;
    }
}
