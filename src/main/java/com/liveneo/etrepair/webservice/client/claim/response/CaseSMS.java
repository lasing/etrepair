package com.liveneo.etrepair.webservice.client.claim.response;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 短信返回信息
 * 
 * @author fcy
 *
 */
@XmlRootElement(name = "CaseSMS")
public class CaseSMS {
    /**
     * 报案号
     */
    private String registNo;
    /**
     * 机构代码
     */
    private String companyCode;
    /**
     * 模板ID
     */
    private String templateId;
    /**
     * 发送时间
     */
    private String planSendTime;
    /**
     * 发送内容
     */
    private String SMSContent;
    /**
     * 手机号
     */
    private String moblileNo;

    public String getRegistNo() {
        return registNo;
    }

    public void setRegistNo(String registNo) {
        this.registNo = registNo;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getPlanSendTime() {
        return planSendTime;
    }

    public void setPlanSendTime(String planSendTime) {
        this.planSendTime = planSendTime;
    }

    public String getSMSContent() {
        return SMSContent;
    }

    public void setSMSContent(String sMSContent) {
        SMSContent = sMSContent;
    }

    public String getMoblileNo() {
        return moblileNo;
    }

    public void setMoblileNo(String moblileNo) {
        this.moblileNo = moblileNo;
    }
}
