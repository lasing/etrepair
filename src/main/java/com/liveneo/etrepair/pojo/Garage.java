package com.liveneo.etrepair.pojo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Garage {
    private String  garageId;
    private String  orgId;
    private String  orgDesc;
    private List    photoList;        // 修理厂对应图片
    private String  typeName;         // 类型
    private String  companyCode;
    private String  pointNumber;
    private String  garageCode;
    private String  garageName;
    private String  garageNameAbb;
    private String  garageAddr;
    private String  garageAddrAbb;
    private String  categoryCode;
    private String  specializedBrand;
    private Double  longitude;
    private Double  latitude;
    private String  contact;
    private String  contactPhone;
    private String  repairTel;
    private Date    expDate;
    private String  serviceFeature;
    private String  summary;
    private String  repair4sFlag;
    private String  outsideFlag;
    private Integer tasklimit;
    private Integer hits;
    private Byte    garageScore;
    private String  isEnable;
    private String  createBy;
    // 调度使用 1标识 来自ET
    private String  dataSources = "1";
    private Date    createTime;
    private String  updateBy;
    private Date    updateTime;
    private Integer skip;
    private Integer limit;

    public String getOrgDesc() {
        return orgDesc;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public void setOrgDesc(String orgDesc) {
        this.orgDesc = orgDesc;
    }

    public List getPhotoList() {
        return photoList;
    }

    public void setPhotoList(List photoList) {
        this.photoList = photoList;
    }

    public Integer getSkip() {
        return skip;
    }

    public void setSkip(Integer skip) {
        this.skip = skip;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getGarageId() {
        return garageId;
    }

    public void setGarageId(String garageId) {
        this.garageId = garageId == null ? null : garageId.trim();
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode == null ? null : companyCode.trim();
    }

    public String getPointNumber() {
        return pointNumber;
    }

    public void setPointNumber(String pointNumber) {
        this.pointNumber = pointNumber == null ? null : pointNumber.trim();
    }

    public String getGarageCode() {
        return garageCode;
    }

    public void setGarageCode(String garageCode) {
        this.garageCode = garageCode == null ? null : garageCode.trim();
    }

    public String getGarageName() {
        return garageName;
    }

    public void setGarageName(String garageName) {
        this.garageName = garageName == null ? null : garageName.trim();
    }

    public String getGarageNameAbb() {
        return garageNameAbb;
    }

    public void setGarageNameAbb(String garageNameAbb) {
        this.garageNameAbb = garageNameAbb == null ? null : garageNameAbb.trim();
    }

    public String getGarageAddr() {
        return garageAddr;
    }

    public void setGarageAddr(String garageAddr) {
        this.garageAddr = garageAddr == null ? null : garageAddr.trim();
    }

    public String getGarageAddrAbb() {
        return garageAddrAbb;
    }

    public void setGarageAddrAbb(String garageAddrAbb) {
        this.garageAddrAbb = garageAddrAbb == null ? null : garageAddrAbb.trim();
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode == null ? null : categoryCode.trim();
    }

    public String getSpecializedBrand() {
        return specializedBrand;
    }

    public void setSpecializedBrand(String specializedBrand) {
        this.specializedBrand = specializedBrand;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
    }

    public String getRepairTel() {
        return repairTel;
    }

    public void setRepairTel(String repairTel) {
        this.repairTel = repairTel == null ? null : repairTel.trim();
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public String getServiceFeature() {
        return serviceFeature;
    }

    public void setServiceFeature(String serviceFeature) {
        this.serviceFeature = serviceFeature == null ? null : serviceFeature.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public String getRepair4sFlag() {
        return repair4sFlag;
    }

    public void setRepair4sFlag(String repair4sFlag) {
        this.repair4sFlag = repair4sFlag == null ? null : repair4sFlag.trim();
    }

    public String getOutsideFlag() {
        return outsideFlag;
    }

    public void setOutsideFlag(String outsideFlag) {
        this.outsideFlag = outsideFlag == null ? null : outsideFlag.trim();
    }

    public Integer getTasklimit() {
        return tasklimit;
    }

    public void setTasklimit(Integer tasklimit) {
        this.tasklimit = tasklimit;
    }

    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }

    public Byte getGarageScore() {
        return garageScore;
    }

    public void setGarageScore(Byte garageScore) {
        this.garageScore = garageScore;
    }

    public String getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable == null ? null : isEnable.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDataSources() {
        return dataSources;
    }

    public void setDataSources(String dataSources) {
        this.dataSources = dataSources;
    }
}