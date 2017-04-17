package com.liveneo.etrepair.pojo;

import java.util.Date;

public class GaragePhoto {
    private String garagePhotoId;
    private String garageId;
    private String photoUrl;
    private Byte   photoOrder;
    private String createBy;
    private Date   createTime;
    private String updateBy;
    private Date   updateTime;

    public String getGaragePhotoId() {
        return garagePhotoId;
    }

    public void setGaragePhotoId(String garagePhotoId) {
        this.garagePhotoId = garagePhotoId == null ? null : garagePhotoId.trim();
    }

    public String getGarageId() {
        return garageId;
    }

    public void setGarageId(String garageId) {
        this.garageId = garageId == null ? null : garageId.trim();
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl == null ? null : photoUrl.trim();
    }

    public Byte getPhotoOrder() {
        return photoOrder;
    }

    public void setPhotoOrder(Byte photoOrder) {
        this.photoOrder = photoOrder;
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