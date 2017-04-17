package com.liveneo.etrepair.model;

import java.util.Date;

public class UnsolvedCaseDto {
    private String id;
    private String doStatus;
    private Date   dispatchTime;
    private String registNo;
    private String status;
    private String lossType;
    private String lossNo;
    private String dispatchType;
    private String orgName;
    private String licenceCode;
    private String surveyNumber;
    private String surveyName;
    private String tel;
    // 调度员编号
    private String yardManNumber;
    // 调度员姓名
    private String yardManName;
    // 查勘地址
    private String surveyPlace;
    // 联系人
    private String contact;
    // 备注
    private String dispatchRemark;

    public String getDoStatus() {
        return doStatus;
    }

    public void setDoStatus(String doStatus) {
        this.doStatus = doStatus;
    }

    public Date getDispatchTime() {
        return dispatchTime;
    }

    public void setDispatchTime(Date dispatchTime) {
        this.dispatchTime = dispatchTime;
    }

    public String getRegistNo() {
        return registNo;
    }

    public void setRegistNo(String registNo) {
        this.registNo = registNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLossType() {
        return lossType;
    }

    public void setLossType(String lossType) {
        this.lossType = lossType;
    }

    public String getLossNo() {
        return lossNo;
    }

    public void setLossNo(String lossNo) {
        this.lossNo = lossNo;
    }

    public String getDispatchType() {
        return dispatchType;
    }

    public void setDispatchType(String dispatchType) {
        this.dispatchType = dispatchType;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getLicenceCode() {
        return licenceCode;
    }

    public void setLicenceCode(String licenceCode) {
        this.licenceCode = licenceCode;
    }

    public String getSurveyNumber() {
        return surveyNumber;
    }

    public void setSurveyNumber(String surveyNumber) {
        this.surveyNumber = surveyNumber;
    }

    public String getSurveyName() {
        return surveyName;
    }

    public void setSurveyName(String surveyName) {
        this.surveyName = surveyName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getYardManNumber() {
        return yardManNumber;
    }

    public void setYardManNumber(String yardManNumber) {
        this.yardManNumber = yardManNumber;
    }

    public String getYardManName() {
        return yardManName;
    }

    public void setYardManName(String yardManName) {
        this.yardManName = yardManName;
    }

    public String getSurveyPlace() {
        return surveyPlace;
    }

    public void setSurveyPlace(String surveyPlace) {
        this.surveyPlace = surveyPlace;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDispatchRemark() {
        return dispatchRemark;
    }

    public void setDispatchRemark(String dispatchRemark) {
        this.dispatchRemark = dispatchRemark;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
