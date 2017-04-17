package com.liveneo.etrepair.webservice.server.survey.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 保单项目
 */
@XStreamAlias("PolicyItem")
public class PolicyItem {
    private String policyNumber;
    private String categoryCode;
    private String categoryName;
    private String speciesCode;
    private String speciesName;
    private String insuranceOrgCode;
    private String itemSort;

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getSpeciesCode() {
        return speciesCode;
    }

    public void setSpeciesCode(String speciesCode) {
        this.speciesCode = speciesCode;
    }

    public String getSpeciesName() {
        return speciesName;
    }

    public void setSpeciesName(String speciesName) {
        this.speciesName = speciesName;
    }

    public String getInsuranceOrgCode() {
        return insuranceOrgCode;
    }

    public void setInsuranceOrgCode(String insuranceOrgCode) {
        this.insuranceOrgCode = insuranceOrgCode;
    }

    public String getItemSort() {
        return itemSort;
    }

    public void setItemSort(String itemSort) {
        this.itemSort = itemSort;
    }
}
