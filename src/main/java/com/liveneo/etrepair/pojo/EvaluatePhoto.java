package com.liveneo.etrepair.pojo;

import java.util.Date;

public class EvaluatePhoto {
    private String evaluatePhotoId;
    private String taskId;
    private String garageId;
    private String photoUrl;
    private String createBy;
    private Date   createTime;

    public String getEvaluatePhotoId() {
        return evaluatePhotoId;
    }

    public void setEvaluatePhotoId(String evaluatePhotoId) {
        this.evaluatePhotoId = evaluatePhotoId == null ? null : evaluatePhotoId.trim();
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId == null ? null : taskId.trim();
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
}