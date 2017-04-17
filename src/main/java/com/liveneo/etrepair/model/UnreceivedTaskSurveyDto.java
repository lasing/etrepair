package com.liveneo.etrepair.model;

import java.util.Date;

public class UnreceivedTaskSurveyDto {
    private String userCode;
    private String name;
    private String tel;
    private Date   updateTime;
    private Date   pushTime;
    private String isSuccess;
    private String logsMsg;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(String isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getLogsMsg() {
        return logsMsg;
    }

    public void setLogsMsg(String logsMsg) {
        this.logsMsg = logsMsg;
    }

    public Date getPushTime() {
        return pushTime;
    }

    public void setPushTime(Date pushTime) {
        this.pushTime = pushTime;
    }
}
