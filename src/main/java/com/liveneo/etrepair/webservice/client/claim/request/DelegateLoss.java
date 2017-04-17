package com.liveneo.etrepair.webservice.client.claim.request;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DelegateLoss")
public class DelegateLoss {
    /**
     * 损失项名称
     */
    private String lossName;
    /**
     * 损失类型
     */
    private String lossType;
    /**
     * 损失类型分类
     */
    private String lossPageType;
    /**
     * 损失ID
     */
    private String lossId;
    /**
     * 调度状态
     */
    private String status;
    /**
     * 查勘员所属分公司
     */
    private String surveyUnitCode;
    /**
     * 查勘员所属分公司名称
     */
    private String surveyUnitNme;
    /**
     * 查勘员代码
     */
    private String surveyorCode;
    /**
     * 查勘员名称
     */
    private String surveyorName;
    /**
     * 手机号码
     */
    private String mobile;
    /**
     * 联系人
     */
    private String contact;
    /**
     * 联系电话
     */
    private String contactPhone;
    /**
     * 调度用户
     */
    private String userCode;
    /**
     * 调度类型
     */
    private String delegateType;

    public String getLossName() {
        return lossName;
    }

    public void setLossName(String lossName) {
        this.lossName = lossName;
    }

    public String getLossType() {
        return lossType;
    }

    public void setLossType(String lossType) {
        this.lossType = lossType;
    }

    public String getLossPageType() {
        return lossPageType;
    }

    public void setLossPageType(String lossPageType) {
        this.lossPageType = lossPageType;
    }

    public String getLossId() {
        return lossId;
    }

    public void setLossId(String lossId) {
        this.lossId = lossId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSurveyUnitCode() {
        return surveyUnitCode;
    }

    public void setSurveyUnitCode(String surveyUnitCode) {
        this.surveyUnitCode = surveyUnitCode;
    }

    public String getSurveyUnitNme() {
        return surveyUnitNme;
    }

    public void setSurveyUnitNme(String surveyUnitNme) {
        this.surveyUnitNme = surveyUnitNme;
    }

    public String getSurveyorCode() {
        return surveyorCode;
    }

    public void setSurveyorCode(String surveyorCode) {
        this.surveyorCode = surveyorCode;
    }

    public String getSurveyorName() {
        return surveyorName;
    }

    public void setSurveyorName(String surveyorName) {
        this.surveyorName = surveyorName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getDelegateType() {
        return delegateType;
    }

    public void setDelegateType(String delegateType) {
        this.delegateType = delegateType;
    }
}
