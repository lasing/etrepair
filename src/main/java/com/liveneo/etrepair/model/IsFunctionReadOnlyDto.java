package com.liveneo.etrepair.model;

public class IsFunctionReadOnlyDto {
    private String userId;
    private String functionUrl;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFunctionUrl() {
        return functionUrl;
    }

    public void setFunctionUrl(String functionUrl) {
        this.functionUrl = functionUrl;
    }
}
