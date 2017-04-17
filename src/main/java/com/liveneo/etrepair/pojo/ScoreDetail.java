package com.liveneo.etrepair.pojo;

import java.util.Date;

public class ScoreDetail {
    private String scoreDetailId;
    private String evId;
    private String evItemId;
    private Byte   evScore;
    private String createBy;
    private Date   createTime;

    public String getScoreDetailId() {
        return scoreDetailId;
    }

    public void setScoreDetailId(String scoreDetailId) {
        this.scoreDetailId = scoreDetailId == null ? null : scoreDetailId.trim();
    }

    public String getEvId() {
        return evId;
    }

    public void setEvId(String evId) {
        this.evId = evId == null ? null : evId.trim();
    }

    public String getEvItemId() {
        return evItemId;
    }

    public void setEvItemId(String evItemId) {
        this.evItemId = evItemId == null ? null : evItemId.trim();
    }

    public Byte getEvScore() {
        return evScore;
    }

    public void setEvScore(Byte evScore) {
        this.evScore = evScore;
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