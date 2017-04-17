package com.liveneo.etrepair.webservice.client.claim.request;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 案件对象
 * 
 * @author fcy
 *
 */
@XmlRootElement(name = "CaseInfo")
public class CaseInfo {
    /**
     * 报案号
     */
    private String registNo;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 短信发送类型
     */
    private String msgType;
    /**
     * 用户编码，操作用户的编码（与核心系统保持一致）
     */
    private String userCode;

    public String getRegistNo() {
        return registNo;
    }

    public void setRegistNo(String registNo) {
        this.registNo = registNo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }
}
