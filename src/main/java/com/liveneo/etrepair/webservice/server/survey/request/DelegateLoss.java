package com.liveneo.etrepair.webservice.server.survey.request;

import java.math.BigDecimal;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 损失项目
 */
@XStreamAlias("DelegateLoss")
public class DelegateLoss {
    private String     objectName;
    private String     lossType;
    private String     lossPageType;
    private String     lossDesc;
    private String     mobile;
    private String     vehicleModle;
    private String     lossId;
    private String     damagePlace;
    private BigDecimal LONGITUDE;
    private BigDecimal LATITUDE;
    private String     status;
    private String     surveyorCode;
    private String     lossName;
    private String     changeReason;

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getLossType() {
        return lossType;
    }

    public void setLossType(String lossType) {
        this.lossType = lossType;
    }

    public String getLossPageType() {
        return lossPageType;
    }

    public void setLossPageType(String lossPageType) {
        this.lossPageType = lossPageType;
    }

    public String getLossDesc() {
        return lossDesc;
    }

    public void setLossDesc(String lossDesc) {
        this.lossDesc = lossDesc;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getVehicleModle() {
        return vehicleModle;
    }

    public void setVehicleModle(String vehicleModle) {
        this.vehicleModle = vehicleModle;
    }

    public String getLossId() {
        return lossId;
    }

    public void setLossId(String lossId) {
        this.lossId = lossId;
    }

    public String getDamagePlace() {
        return damagePlace;
    }

    public void setDamagePlace(String damagePlace) {
        this.damagePlace = damagePlace;
    }

    public BigDecimal getLONGITUDE() {
        return LONGITUDE;
    }

    public void setLONGITUDE(BigDecimal lONGITUDE) {
        LONGITUDE = lONGITUDE;
    }

    public BigDecimal getLATITUDE() {
        return LATITUDE;
    }

    public void setLATITUDE(BigDecimal lATITUDE) {
        LATITUDE = lATITUDE;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSurveyorCode() {
        return surveyorCode;
    }

    public void setSurveyorCode(String surveyorCode) {
        this.surveyorCode = surveyorCode;
    }

    public String getLossName() {
        return lossName;
    }

    public void setLossName(String lossName) {
        this.lossName = lossName;
    }

    public String getChangeReason() {
        return changeReason;
    }

    public void setChangeReason(String changeReason) {
        this.changeReason = changeReason;
    }
}
