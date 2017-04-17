package com.liveneo.etrepair.pojo;

import java.util.Date;

public class GarageReport {
    private String garageId;
    private String garageCode;
    private Double paymentRate;
    private Double earnedPremium;
    private Double yearPremium;
    private Double completionAmount;
    private String createBy;
    private Date   createTime;
    private String updateBy;
    private Date   updateTime;

    public String getGarageId() {
        return garageId;
    }

    public void setGarageId(String garageId) {
        this.garageId = garageId == null ? null : garageId.trim();
    }

    public String getGarageCode() {
        return garageCode;
    }

    public void setGarageCode(String garageCode) {
        this.garageCode = garageCode == null ? null : garageCode.trim();
    }

    public Double getPaymentRate() {
        return paymentRate;
    }

    public void setPaymentRate(Double paymentRate) {
        this.paymentRate = paymentRate;
    }

    public Double getEarnedPremium() {
        return earnedPremium;
    }

    public void setEarnedPremium(Double earnedPremium) {
        this.earnedPremium = earnedPremium;
    }

    public Double getYearPremium() {
        return yearPremium;
    }

    public void setYearPremium(Double yearPremium) {
        this.yearPremium = yearPremium;
    }

    public Double getCompletionAmount() {
        return completionAmount;
    }

    public void setCompletionAmount(Double completionAmount) {
        this.completionAmount = completionAmount;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}