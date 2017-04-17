package com.liveneo.etrepair.pojo;

import java.util.Date;

public class EvaluteItem {
    private String evItemId;
    private String itemCode;
    private String itemName;
    private Byte   itemOrder;
    private Byte   weight;
    private String isEnable;
    private String createBy;
    private Date   createTime;
    private String updateBy;
    private Date   updateTime;

    public String getEvItemId() {
        return evItemId;
    }

    public void setEvItemId(String evItemId) {
        this.evItemId = evItemId == null ? null : evItemId.trim();
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode == null ? null : itemCode.trim();
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public Byte getItemOrder() {
        return itemOrder;
    }

    public void setItemOrder(Byte itemOrder) {
        this.itemOrder = itemOrder;
    }

    public Byte getWeight() {
        return weight;
    }

    public void setWeight(Byte weight) {
        this.weight = weight;
    }

    public String getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable == null ? null : isEnable.trim();
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