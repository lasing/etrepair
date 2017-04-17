package com.liveneo.etrepair.webservice.client.claim.request;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 调度处理参数对象
 * 
 * @author fcy
 *
 */
@XmlRootElement(name = "DelegateRequest")
public class DelegateRequest {
    /**
     * 报案号
     */
    private String             registNo;
    /**
     * 用户编码
     */
    private String             userCode;
    /**
     * 调度损失项
     */
    private List<DelegateLoss> delegateLoss;
    /**
     * 调度类型
     */
    private String             type;
    /**
     * 被保险人
     */
    private String             userName;
    /**
     * 调度说明
     */
    private String             delegateReamrk;
    /**
     * 查勘地点
     */
    private String             surveyPlace;
    /**
     * 出险地点
     */
    private String             damageplace;
    /**
     * 出险时间
     */
    private String             damagedate;
    /**
     * 车牌号
     */
    private String             licenseNo;
    /**
     * 联系人
     */
    private String             contact;
    /**
     * 联系电话
     */
    private String             contactPhone;
    private List<ThirdCarInfo> thirdCarInfoList;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDelegateReamrk() {
        return delegateReamrk;
    }

    public void setDelegateReamrk(String delegateReamrk) {
        this.delegateReamrk = delegateReamrk;
    }

    public String getSurveyPlace() {
        return surveyPlace;
    }

    public void setSurveyPlace(String surveyPlace) {
        this.surveyPlace = surveyPlace;
    }

    public String getDamageplace() {
        return damageplace;
    }

    public void setDamageplace(String damageplace) {
        this.damageplace = damageplace;
    }

    public String getDamagedate() {
        return damagedate;
    }

    public void setDamagedate(String damagedate) {
        this.damagedate = damagedate;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    @XmlElementWrapper(name = "thirdCarInfoList")
    @XmlElement(name = "ThirdCarInfo")
    public List<ThirdCarInfo> getThirdCarInfoList() {
        return thirdCarInfoList;
    }

    public void setThirdCarInfoList(List<ThirdCarInfo> thirdCarInfoList) {
        this.thirdCarInfoList = thirdCarInfoList;
    }
}
