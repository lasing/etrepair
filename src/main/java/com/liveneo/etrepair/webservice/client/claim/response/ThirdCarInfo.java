package com.liveneo.etrepair.webservice.client.claim.response;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * (三者相关信息) 只传新增的
 * 
 * @author fcy
 *
 */
@XmlRootElement(name = "ThirdCarInfo")
public class ThirdCarInfo {
    /**
     * 损失项名称
     */
    private String lossName;
    /**
     * 损失类型
     */
    private String lossType;
    /**
     * 调度系统临时损失ID
     */
    private String dlgLossId;
    /**
     * 损失情况
     */
    private String lossDes;
    /**
     * 损失标的联系电话
     */
    private String phoneNumber;
    /**
     * 核心系统lossId
     */
    private String lossId;

    public String getLossName() {
        return lossName;
    }

    public void setLossName(String lossName) {
        this.lossName = lossName;
    }

    public String getLossType() {
        return lossType;
    }

    public void setLossType(String lossType) {
        this.lossType = lossType;
    }

    public String getDlgLossId() {
        return dlgLossId;
    }

    public void setDlgLossId(String dlgLossId) {
        this.dlgLossId = dlgLossId;
    }

    public String getLossDes() {
        return lossDes;
    }

    public void setLossDes(String lossDes) {
        this.lossDes = lossDes;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLossId() {
        return lossId;
    }

    public void setLossId(String lossId) {
        this.lossId = lossId;
    }
}
