package com.liveneo.etrepair.model;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;

public class ComprehensiveQueryConditionDto {
    private String  id;
    private String  registNo;
    private String  policyNumber;
    private String  licenceCode;
    private String  userName;
    private String  compensationCode;
    private Date    registStart;
    private Date    registEnd;
    private Date    apointmentStart;
    private Date    apointmentEnd;
    private String  taorgid;
    private String  compensationOrg;
    private String  surveyType;
    private String  isAppointment;
    private String  isBehalfthe;
    private String  isLocked;
    private String  isCompensation;
    private String  caseStatus;
    private String  insuranceType;
    private Integer skip;
    private Integer limit;

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

    public String getRegistNo() {
        return registNo;
    }

    public void setRegistNo(String registNo) {
        this.registNo = registNo;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getLicenceCode() {
        return licenceCode;
    }

    public void setLicenceCode(String licenceCode) throws UnsupportedEncodingException {
        this.licenceCode = URLDecoder.decode(licenceCode, "UTF-8");
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) throws UnsupportedEncodingException {
        this.userName = URLDecoder.decode(userName, "UTF-8");
    }

    public String getCompensationCode() {
        return compensationCode;
    }

    public void setCompensationCode(String compensationCode) {
        this.compensationCode = compensationCode;
    }

    public Date getRegistStart() {
        return registStart;
    }

    public void setRegistStart(Date registStart) {
        this.registStart = registStart;
    }

    public Date getRegistEnd() {
        return registEnd;
    }

    public void setRegistEnd(Date registEnd) {
        this.registEnd = registEnd;
    }

    public Date getApointmentStart() {
        return apointmentStart;
    }

    public void setApointmentStart(Date apointmentStart) {
        this.apointmentStart = apointmentStart;
    }

    public Date getApointmentEnd() {
        return apointmentEnd;
    }

    public void setApointmentEnd(Date apointmentEnd) {
        this.apointmentEnd = apointmentEnd;
    }

    public String getTaorgid() {
        return taorgid;
    }

    public void setTaorgid(String taorgid) {
        this.taorgid = taorgid;
    }

    public String getCompensationOrg() {
        return compensationOrg;
    }

    public void setCompensationOrg(String compensationOrg) {
        this.compensationOrg = compensationOrg;
    }

    public String getSurveyType() {
        return surveyType;
    }

    public void setSurveyType(String surveyType) {
        this.surveyType = surveyType;
    }

    public String getIsAppointment() {
        return isAppointment;
    }

    public void setIsAppointment(String isAppointment) {
        this.isAppointment = isAppointment;
    }

    public String getIsBehalfthe() {
        return isBehalfthe;
    }

    public void setIsBehalfthe(String isBehalfthe) {
        this.isBehalfthe = isBehalfthe;
    }

    public String getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(String isLocked) {
        this.isLocked = isLocked;
    }

    public String getIsCompensation() {
        return isCompensation;
    }

    public void setIsCompensation(String isCompensation) {
        this.isCompensation = isCompensation;
    }

    public String getCaseStatus() {
        return caseStatus;
    }

    public void setCaseStatus(String caseStatus) {
        this.caseStatus = caseStatus;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    @Override
    public String toString() {
        return "ComprehensiveQueryConditionDto [registNo=" + registNo + ", policyNumber=" + policyNumber + ", licenceCode=" + licenceCode + ", userName="
                + userName + ", compensationCode=" + compensationCode + ", registStart=" + registStart + ", registEnd=" + registEnd + ", apointmentStart="
                + apointmentStart + ", apointmentEnd=" + apointmentEnd + ", taorgid=" + taorgid + ", compensationOrg=" + compensationOrg + ", surveyType="
                + surveyType + ", isAppointment=" + isAppointment + ", isBehalfthe=" + isBehalfthe + ", isLocked=" + isLocked + ", isCompensation="
                + isCompensation + ", caseStatus=" + caseStatus + ", insuranceType=" + insuranceType + ", skip=" + skip + ", limit=" + limit + "]";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
