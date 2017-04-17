package com.liveneo.etrepair.model;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;

public class UnsolvedCaseConditionDto {
    private Date    dispatchStart;
    private Date    dispatchEnd;
    private String  registNo;
    private String  licenceCode;
    private String  taorgid;
    private String  surveyNumber;
    private String  surveyName;
    private String  operateStatus;
    private Integer skip;
    private Integer limit;

    public Date getDispatchStart() {
        return dispatchStart;
    }

    public void setDispatchStart(Date dispatchStart) {
        this.dispatchStart = dispatchStart;
    }

    public Date getDispatchEnd() {
        return dispatchEnd;
    }

    public void setDispatchEnd(Date dispatchEnd) {
        this.dispatchEnd = dispatchEnd;
    }

    public String getRegistNo() {
        return registNo;
    }

    public void setRegistNo(String registNo) {
        this.registNo = registNo;
    }

    public String getLicenceCode() {
        return licenceCode;
    }

    public void setLicenceCode(String licenceCode) {
        this.licenceCode = licenceCode;
    }

    public String getTaorgid() {
        return taorgid;
    }

    public void setTaorgid(String taorgid) {
        this.taorgid = taorgid;
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

    public void setSurveyName(String surveyName) throws UnsupportedEncodingException {
        this.surveyName = URLDecoder.decode(surveyName, "UTF-8");
    }

    public String getOperateStatus() {
        return operateStatus;
    }

    public void setOperateStatus(String operateStatus) {
        this.operateStatus = operateStatus;
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

    @Override
    public String toString() {
        return "UnsolvedCaseConditionDto [dispatchStart=" + dispatchStart + ", dispatchEnd=" + dispatchEnd + ", registNo=" + registNo + ", licenceCode="
                + licenceCode + ", taorgid=" + taorgid + ", surveyNumber=" + surveyNumber + ", surveyName=" + surveyName + ", operateStatus=" + operateStatus
                + ", skip=" + skip + ", limit=" + limit + "]";
    }
}
