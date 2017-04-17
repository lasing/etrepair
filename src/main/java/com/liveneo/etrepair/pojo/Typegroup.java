package com.liveneo.etrepair.pojo;

import java.util.Date;

public class Typegroup {
    private String typeGroupId;
    private String typeGroupCode;
    private String typeGroupName;
    private String createBy;
    private Date   createTime;
    private String updateBy;
    private Date   updateTime;

    public String getTypeGroupId() {
        return typeGroupId;
    }

    public void setTypeGroupId(String typeGroupId) {
        this.typeGroupId = typeGroupId == null ? null : typeGroupId.trim();
    }

    public String getTypeGroupCode() {
        return typeGroupCode;
    }

    public void setTypeGroupCode(String typeGroupCode) {
        this.typeGroupCode = typeGroupCode == null ? null : typeGroupCode.trim();
    }

    public String getTypeGroupName() {
        return typeGroupName;
    }

    public void setTypeGroupName(String typeGroupName) {
        this.typeGroupName = typeGroupName == null ? null : typeGroupName.trim();
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