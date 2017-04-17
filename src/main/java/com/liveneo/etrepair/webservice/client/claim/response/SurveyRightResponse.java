package com.liveneo.etrepair.webservice.client.claim.response;

public class SurveyRightResponse {
    private String surveyorCode;
    private String valid;
    private String survey;
    private String peopl_survey;
    private String peopl_estimete;
    private String vehicle_estimete;
    private String prop_estimete;

    public String getSurveyorCode() {
        return surveyorCode;
    }

    public void setSurveyorCode(String surveyorCode) {
        this.surveyorCode = surveyorCode;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
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
