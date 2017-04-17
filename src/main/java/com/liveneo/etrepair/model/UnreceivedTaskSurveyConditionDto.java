package com.liveneo.etrepair.model;

public class UnreceivedTaskSurveyConditionDto {
    private String  caseInfoId;
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

    public String getCaseInfoId() {
        return caseInfoId;
    }

    public void setCaseInfoId(String caseInfoId) {
        this.caseInfoId = caseInfoId;
    }
}
