package com.liveneo.etrepair.pojo;

import java.util.Date;

public class TaskEvalute {
    private String  evId;
    private String  taskId;
    private String  garageId;
    private Date    evTime;
    private Byte    evScore;
    private String  scoreDetailId;
    private Double  evCost;
    private String  evMemo;
    private Integer hits;
    private Integer pointOfPraise;
    private String  createBy;
    private Date    createTime;
    private String  updateBy;
    private Date    updateTime;

    public String getEvId() {
        return evId;
    }

    public void setEvId(String evId) {
        this.evId = evId == null ? null : evId.trim();
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

    public Date getEvTime() {
        return evTime;
    }

    public void setEvTime(Date evTime) {
        this.evTime = evTime;
    }

    public Byte getEvScore() {
        return evScore;
    }

    public void setEvScore(Byte evScore) {
        this.evScore = evScore;
    }

    public String getScoreDetailId() {
        return scoreDetailId;
    }

    public void setScoreDetailId(String scoreDetailId) {
        this.scoreDetailId = scoreDetailId == null ? null : scoreDetailId.trim();
    }

    public Double getEvCost() {
        return evCost;
    }

    public void setEvCost(Double evCost) {
        this.evCost = evCost;
    }

    public String getEvMemo() {
        return evMemo;
    }

    public void setEvMemo(String evMemo) {
        this.evMemo = evMemo == null ? null : evMemo.trim();
    }

    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }

    public Integer getPointOfPraise() {
        return pointOfPraise;
    }

    public void setPointOfPraise(Integer pointOfPraise) {
        this.pointOfPraise = pointOfPraise;
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