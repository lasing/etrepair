package com.liveneo.etrepair.webservice.server.survey.request;

/**
 * 查勘员信息
 */
public class SynSurveyPowerInfo {
    private String name;
    private String phone;
    private String userName;
    private String userCode;
    private String orgCode;
    private String userType;
    private String isVideo;
    private String status;
    private String survey;
    private String peopl_survey;
    private String peopl_estimete;
    private String vehicle_estimete;
    private String prop_estimete;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getIsVideo() {
        return isVideo;
    }

    public void setIsVideo(String isVideo) {
        this.isVideo = isVideo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSurvey() {
        return survey;
    }

    public void setSurvey(String survey) {
        this.survey = survey;
    }

    public String getPeopl_survey() {
        return peopl_survey;
    }

    public void setPeopl_survey(String peopl_survey) {
        this.peopl_survey = peopl_survey;
    }

    public String getPeopl_estimete() {
        return peopl_estimete;
    }

    public void setPeopl_estimete(String peopl_estimete) {
        this.peopl_estimete = peopl_estimete;
    }

    public String getVehicle_estimete() {
        return vehicle_estimete;
    }

    public void setVehicle_estimete(String vehicle_estimete) {
        this.vehicle_estimete = vehicle_estimete;
    }

    public String getProp_estimete() {
        return prop_estimete;
    }

    public void setProp_estimete(String prop_estimete) {
        this.prop_estimete = prop_estimete;
    }
}
