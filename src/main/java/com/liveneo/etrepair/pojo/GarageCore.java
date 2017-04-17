package com.liveneo.etrepair.pojo;

import java.util.Date;

public class GarageCore {
    private String  garageId;
    private String  garageCode;
    private String  garageName;
    private String  garageAbbr;
    private String  garageAddr;
    private Double  longitude;
    private Double  latitude;
    private String  companyCode;
    private String  orgId;                 // 对应et_org_info表的org_code
    private String  orgDesc;
    private String  industryOrgCode;
    private String  contact;
    private String  contactPhone;
    private String  fax;
    private String  repairLevel;
    private String  categoryCode;
    private String  categoryName;
    private String  directPayFlag;
    private Float   partDiscountRate;
    private Float   paintFacmanHour;
    private Float   repairFacmanHour;
    private Float   assemblyFacmanHour;
    private Float   discountStandard;
    private Float   repairFacmanDiscount;
    private Float   paintFacmanDiscount;
    private Float   assemblyFacmanDiscount;
    private Float   machineRepairDiscount;
    private Float   electricanDiscount;
    private Float   evalFloatRatio;
    private Float   auditRatio;
    private Float   compensateIndex;
    private Date    contractDate;
    private String  repair4sFlag;
    private String  outsideFlag;
    private String  cptFlag;
    private String  price4sCode;
    private String  priceAgreementCode;
    private String  priceMarkCode;
    private String  priceTryoutCode;
    private String  platformOrgCode;
    private String  videoFlag;
    private String  repairTel;
    private String  repairScope;
    private String  specializedBrand;
    private String  auditOpinion;
    private String  remark;
    private String  accountcode;
    private String  accountname;
    private String  bankname;
    private String  citycode;
    private String  towncode;
    private String  regioncode;
    private String  cityname;
    private String  townname;
    private String  regionname;
    private String  brandcode;
    private String  brandname;
    private Float   brandpercent;
    private String  atticepointcode;
    private String  atticepointname;
    private Float   partspercent;
    private String  verifyflag;
    private String  verifyby;
    private Date    verifydate;
    private String  isEnable;
    private String  createBy;
    private Date    createTime;
    private String  updateBy;
    private Date    updateTime;
    private Integer skip;
    private Integer limit;
    private Integer isExists;

    public Integer getIsExists() {
        return isExists;
    }

    public void setIsExists(Integer isExists) {
        this.isExists = isExists;
    }

    public String getOrgDesc() {
        return orgDesc;
    }

    public void setOrgDesc(String orgDesc) {
        this.orgDesc = orgDesc;
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

    public String getGarageAbbr() {
        return garageAbbr;
    }

    public void setGarageAbbr(String garageAbbr) {
        this.garageAbbr = garageAbbr == null ? null : garageAbbr.trim();
    }

    public String getGarageAddr() {
        return garageAddr;
    }

    public void setGarageAddr(String garageAddr) {
        this.garageAddr = garageAddr == null ? null : garageAddr.trim();
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

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode == null ? null : companyCode.trim();
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public String getIndustryOrgCode() {
        return industryOrgCode;
    }

    public void setIndustryOrgCode(String industryOrgCode) {
        this.industryOrgCode = industryOrgCode == null ? null : industryOrgCode.trim();
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

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public String getRepairLevel() {
        return repairLevel;
    }

    public void setRepairLevel(String repairLevel) {
        this.repairLevel = repairLevel == null ? null : repairLevel.trim();
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode == null ? null : categoryCode.trim();
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public String getDirectPayFlag() {
        return directPayFlag;
    }

    public void setDirectPayFlag(String directPayFlag) {
        this.directPayFlag = directPayFlag == null ? null : directPayFlag.trim();
    }

    public Float getPartDiscountRate() {
        return partDiscountRate;
    }

    public void setPartDiscountRate(Float partDiscountRate) {
        this.partDiscountRate = partDiscountRate;
    }

    public Float getPaintFacmanHour() {
        return paintFacmanHour;
    }

    public void setPaintFacmanHour(Float paintFacmanHour) {
        this.paintFacmanHour = paintFacmanHour;
    }

    public Float getRepairFacmanHour() {
        return repairFacmanHour;
    }

    public void setRepairFacmanHour(Float repairFacmanHour) {
        this.repairFacmanHour = repairFacmanHour;
    }

    public Float getAssemblyFacmanHour() {
        return assemblyFacmanHour;
    }

    public void setAssemblyFacmanHour(Float assemblyFacmanHour) {
        this.assemblyFacmanHour = assemblyFacmanHour;
    }

    public Float getDiscountStandard() {
        return discountStandard;
    }

    public void setDiscountStandard(Float discountStandard) {
        this.discountStandard = discountStandard;
    }

    public Float getRepairFacmanDiscount() {
        return repairFacmanDiscount;
    }

    public void setRepairFacmanDiscount(Float repairFacmanDiscount) {
        this.repairFacmanDiscount = repairFacmanDiscount;
    }

    public Float getPaintFacmanDiscount() {
        return paintFacmanDiscount;
    }

    public void setPaintFacmanDiscount(Float paintFacmanDiscount) {
        this.paintFacmanDiscount = paintFacmanDiscount;
    }

    public Float getAssemblyFacmanDiscount() {
        return assemblyFacmanDiscount;
    }

    public void setAssemblyFacmanDiscount(Float assemblyFacmanDiscount) {
        this.assemblyFacmanDiscount = assemblyFacmanDiscount;
    }

    public Float getMachineRepairDiscount() {
        return machineRepairDiscount;
    }

    public void setMachineRepairDiscount(Float machineRepairDiscount) {
        this.machineRepairDiscount = machineRepairDiscount;
    }

    public Float getElectricanDiscount() {
        return electricanDiscount;
    }

    public void setElectricanDiscount(Float electricanDiscount) {
        this.electricanDiscount = electricanDiscount;
    }

    public Float getEvalFloatRatio() {
        return evalFloatRatio;
    }

    public void setEvalFloatRatio(Float evalFloatRatio) {
        this.evalFloatRatio = evalFloatRatio;
    }

    public Float getAuditRatio() {
        return auditRatio;
    }

    public void setAuditRatio(Float auditRatio) {
        this.auditRatio = auditRatio;
    }

    public Float getCompensateIndex() {
        return compensateIndex;
    }

    public void setCompensateIndex(Float compensateIndex) {
        this.compensateIndex = compensateIndex;
    }

    public Date getContractDate() {
        return contractDate;
    }

    public void setContractDate(Date contractDate) {
        this.contractDate = contractDate;
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

    public String getCptFlag() {
        return cptFlag;
    }

    public void setCptFlag(String cptFlag) {
        this.cptFlag = cptFlag == null ? null : cptFlag.trim();
    }

    public String getPrice4sCode() {
        return price4sCode;
    }

    public void setPrice4sCode(String price4sCode) {
        this.price4sCode = price4sCode == null ? null : price4sCode.trim();
    }

    public String getPriceAgreementCode() {
        return priceAgreementCode;
    }

    public void setPriceAgreementCode(String priceAgreementCode) {
        this.priceAgreementCode = priceAgreementCode == null ? null : priceAgreementCode.trim();
    }

    public String getPriceMarkCode() {
        return priceMarkCode;
    }

    public void setPriceMarkCode(String priceMarkCode) {
        this.priceMarkCode = priceMarkCode == null ? null : priceMarkCode.trim();
    }

    public String getPriceTryoutCode() {
        return priceTryoutCode;
    }

    public void setPriceTryoutCode(String priceTryoutCode) {
        this.priceTryoutCode = priceTryoutCode == null ? null : priceTryoutCode.trim();
    }

    public String getPlatformOrgCode() {
        return platformOrgCode;
    }

    public void setPlatformOrgCode(String platformOrgCode) {
        this.platformOrgCode = platformOrgCode == null ? null : platformOrgCode.trim();
    }

    public String getVideoFlag() {
        return videoFlag;
    }

    public void setVideoFlag(String videoFlag) {
        this.videoFlag = videoFlag == null ? null : videoFlag.trim();
    }

    public String getRepairTel() {
        return repairTel;
    }

    public void setRepairTel(String repairTel) {
        this.repairTel = repairTel == null ? null : repairTel.trim();
    }

    public String getRepairScope() {
        return repairScope;
    }

    public void setRepairScope(String repairScope) {
        this.repairScope = repairScope == null ? null : repairScope.trim();
    }

    public String getSpecializedBrand() {
        return specializedBrand;
    }

    public void setSpecializedBrand(String specializedBrand) {
        this.specializedBrand = specializedBrand == null ? null : specializedBrand.trim();
    }

    public String getAuditOpinion() {
        return auditOpinion;
    }

    public void setAuditOpinion(String auditOpinion) {
        this.auditOpinion = auditOpinion == null ? null : auditOpinion.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getAccountcode() {
        return accountcode;
    }

    public void setAccountcode(String accountcode) {
        this.accountcode = accountcode == null ? null : accountcode.trim();
    }

    public String getAccountname() {
        return accountname;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname == null ? null : accountname.trim();
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname == null ? null : bankname.trim();
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode == null ? null : citycode.trim();
    }

    public String getTowncode() {
        return towncode;
    }

    public void setTowncode(String towncode) {
        this.towncode = towncode == null ? null : towncode.trim();
    }

    public String getRegioncode() {
        return regioncode;
    }

    public void setRegioncode(String regioncode) {
        this.regioncode = regioncode == null ? null : regioncode.trim();
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname == null ? null : cityname.trim();
    }

    public String getTownname() {
        return townname;
    }

    public void setTownname(String townname) {
        this.townname = townname == null ? null : townname.trim();
    }

    public String getRegionname() {
        return regionname;
    }

    public void setRegionname(String regionname) {
        this.regionname = regionname == null ? null : regionname.trim();
    }

    public String getBrandcode() {
        return brandcode;
    }

    public void setBrandcode(String brandcode) {
        this.brandcode = brandcode == null ? null : brandcode.trim();
    }

    public String getBrandname() {
        return brandname;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname == null ? null : brandname.trim();
    }

    public Float getBrandpercent() {
        return brandpercent;
    }

    public void setBrandpercent(Float brandpercent) {
        this.brandpercent = brandpercent;
    }

    public String getAtticepointcode() {
        return atticepointcode;
    }

    public void setAtticepointcode(String atticepointcode) {
        this.atticepointcode = atticepointcode == null ? null : atticepointcode.trim();
    }

    public String getAtticepointname() {
        return atticepointname;
    }

    public void setAtticepointname(String atticepointname) {
        this.atticepointname = atticepointname == null ? null : atticepointname.trim();
    }

    public Float getPartspercent() {
        return partspercent;
    }

    public void setPartspercent(Float partspercent) {
        this.partspercent = partspercent;
    }

    public String getVerifyflag() {
        return verifyflag;
    }

    public void setVerifyflag(String verifyflag) {
        this.verifyflag = verifyflag == null ? null : verifyflag.trim();
    }

    public String getVerifyby() {
        return verifyby;
    }

    public void setVerifyby(String verifyby) {
        this.verifyby = verifyby == null ? null : verifyby.trim();
    }

    public Date getVerifydate() {
        return verifydate;
    }

    public void setVerifydate(Date verifydate) {
        this.verifydate = verifydate;
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
}