package com.liveneo.etrepair.webservice.client.claim.request;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 4S店信息
 * 
 * @author fcy
 *
 */
@XmlRootElement(name = "Case4SInfo")
public class Case4SInfo {
    /**
     * 4s店code
     */
    private String        code;
    /**
     * 4s店名称
     */
    private String        name;
    /**
     * 送修码
     */
    private String        sendRepairCode;
    /**
     * 查勘员姓名
     */
    private String        surveyName;
    /**
     * 查勘员电话
     */
    private String        surveyPhone;
    /**
     * 查勘员电话
     */
    private String        repairPhone;
    /**
     * 机构代码
     */
    private String        companyCode;
    /**
     * 机构名称
     */
    private String        companyName;
    /**
     * 业务代码
     */
    private String        repairCode;
    /**
     * 联系人信息
     */
    private List<Contact> LstContact;
    /**
     * 业务员姓名
     */
    private String        salesManName;
    /**
     * 业务员联系方式
     */
    private String        salesManphone;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSendRepairCode() {
        return sendRepairCode;
    }

    public void setSendRepairCode(String sendRepairCode) {
        this.sendRepairCode = sendRepairCode;
    }

    public String getSurveyName() {
        return surveyName;
    }

    public void setSurveyName(String surveyName) {
        this.surveyName = surveyName;
    }

    public String getSurveyPhone() {
        return surveyPhone;
    }

    public void setSurveyPhone(String surveyPhone) {
        this.surveyPhone = surveyPhone;
    }

    public String getRepairPhone() {
        return repairPhone;
    }

    public void setRepairPhone(String repairPhone) {
        this.repairPhone = repairPhone;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRepairCode() {
        return repairCode;
    }

    public void setRepairCode(String repairCode) {
        this.repairCode = repairCode;
    }

    public void setLstContact(List<Contact> lstContact) {
        LstContact = lstContact;
    }

    @XmlElementWrapper(name = "LstContact")
    @XmlElement(name = "Contact")
    public List<Contact> getLstContact() {
        return LstContact;
    }

    public String getSalesManName() {
        return salesManName;
    }

    public void setSalesManName(String salesManName) {
        this.salesManName = salesManName;
    }

    public String getSalesManphone() {
        return salesManphone;
    }

    public void setSalesManphone(String salesManphone) {
        this.salesManphone = salesManphone;
    }
}
