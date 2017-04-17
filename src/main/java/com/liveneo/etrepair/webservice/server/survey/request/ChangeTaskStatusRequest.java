package com.liveneo.etrepair.webservice.server.survey.request;

import java.util.List;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 任务状态变更参数
 */
public class ChangeTaskStatusRequest {
    private String             registNo;
    private String             userCode;
    @XStreamAlias("delegateLoss")
    private List<DelegateLoss> delegateLosses;
    private String             type;
    private String             status;

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

    public List<DelegateLoss> getDelegateLosses() {
        return delegateLosses;
    }

    public void setDelegateLosses(List<DelegateLoss> delegateLosses) {
        this.delegateLosses = delegateLosses;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
