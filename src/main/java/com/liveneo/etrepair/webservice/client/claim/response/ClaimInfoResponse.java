package com.liveneo.etrepair.webservice.client.claim.response;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import com.liveneo.etrepair.webservice.server.survey.request.DelegateLoss;
import com.liveneo.etrepair.webservice.server.survey.request.PolicyItem;
import com.liveneo.etrepair.webservice.server.survey.request.ServiceItem;

public class ClaimInfoResponse {
    private String                        registNo;
    private String                        userCode;
    private List<DelegateLoss>            delegateLoss;
    private String                        registDate;
    private String                        damageProvince;
    private String                        damageCity;
    private String                        damageDistrict;
    private String                        damagePlace;
    private String                        damageDate;
    private String                        damageReamrk;
    private String                        behalfThe;
    private String                        VIPLevel;
    private List<ServiceItem>             VIPServiceItem;
    private String                        compensationCode;
    private String                        compensationOrg;
    private String                        repairCode;
    private List<PolicyItem>              policyItems;
    private String                        userName;
    private String                        licenseNo;
    private String                        informant;
    private String                        contact;
    private String                        informantPhone;
    private String                        contactPhone;
    private String                        drivername;
    private String                        driverphone;
    private String                        isVehicleInsurance;
    private Byte                          status;
    private List<CaseDispatchForResponse> caseDispatch;

    @XmlElementWrapper(name = "caseDispatch")
    @XmlElement(name = "CaseDispatch")
    public List<CaseDispatchForResponse> getCaseDispatch() {
        return caseDispatch;
    }

    public void setCaseDispatch(List<CaseDispatchForResponse> caseDispatch) {
        this.caseDispatch = caseDispatch;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getRegistNo() {
        return registNo;
    }

    public void setRegistNo(String registNo) {
        this.registNo = registNo;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    @XmlElementWrapper(name = "delegateLoss")
    @XmlElement(name = "DelegateLoss")
    public List<DelegateLoss> getDelegateLoss() {
        return delegateLoss;
    }

    public void setDelegateLoss(List<DelegateLoss> delegateLoss) {
        this.delegateLoss = delegateLoss;
    }

    public String getRegistDate() {
        return registDate;
    }

    public void setRegistDate(String registDate) {
        this.registDate = registDate;
    }

    public String getDamageProvince() {
        return damageProvince;
    }

    public void setDamageProvince(String damageProvince) {
        this.damageProvince = damageProvince;
    }

    public String getDamageCity() {
        return damageCity;
    }

    public void setDamageCity(String damageCity) {
        this.damageCity = damageCity;
    }

    public String getDamageDistrict() {
        return damageDistrict;
    }

    public void setDamageDistrict(String damageDistrict) {
        this.damageDistrict = damageDistrict;
    }

    public String getDamagePlace() {
        return damagePlace;
    }

    public void setDamagePlace(String damagePlace) {
        this.damagePlace = damagePlace;
    }

    public String getDamageDate() {
        return damageDate;
    }

    public void setDamageDate(String damageDate) {
        this.damageDate = damageDate;
    }

    public String getDamageReamrk() {
        return damageReamrk;
    }

    public void setDamageReamrk(String damageReamrk) {
        this.damageReamrk = damageReamrk;
    }

    public String getBehalfThe() {
        return behalfThe;
    }

    public void setBehalfThe(String behalfThe) {
        this.behalfThe = behalfThe;
    }

    public String getVIPLevel() {
        return VIPLevel;
    }

    public void setVIPLevel(String vIPLevel) {
        VIPLevel = vIPLevel;
    }

    @XmlElementWrapper(name = "VIPServiceItem")
    @XmlElement(name = "ServiceItem")
    public List<ServiceItem> getVIPServiceItem() {
        return VIPServiceItem;
    }

    public void setVIPServiceItem(List<ServiceItem> vIPServiceItem) {
        VIPServiceItem = vIPServiceItem;
    }

    public String getCompensationCode() {
        return compensationCode;
    }

    public void setCompensationCode(String compensationCode) {
        this.compensationCode = compensationCode;
    }

    public String getCompensationOrg() {
        return compensationOrg;
    }

    public void setCompensationOrg(String compensationOrg) {
        this.compensationOrg = compensationOrg;
    }

    public String getRepairCode() {
        return repairCode;
    }

    public void setRepairCode(String repairCode) {
        this.repairCode = repairCode;
    }

    @XmlElementWrapper(name = "policyItems")
    @XmlElement(name = "PolicyItem")
    public List<PolicyItem> getPolicyItems() {
        return policyItems;
    }

    public void setPolicyItems(List<PolicyItem> policyItems) {
        this.policyItems = policyItems;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getInformant() {
        return informant;
    }

    public void setInformant(String informant) {
        this.informant = informant;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getInformantPhone() {
        return informantPhone;
    }

    public void setInformantPhone(String informantPhone) {
        this.informantPhone = informantPhone;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getDrivername() {
        return drivername;
    }

    public void setDrivername(String drivername) {
        this.drivername = drivername;
    }

    public String getDriverphone() {
        return driverphone;
    }

    public void setDriverphone(String driverphone) {
        this.driverphone = driverphone;
    }

    public String getIsVehicleInsurance() {
        return isVehicleInsurance;
    }

    public void setIsVehicleInsurance(String isVehicleInsurance) {
        this.isVehicleInsurance = isVehicleInsurance;
    }
}
