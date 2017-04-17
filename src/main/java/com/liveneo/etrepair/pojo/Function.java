package com.liveneo.etrepair.pojo;

import java.util.Date;

public class Function {
    private Integer functionId;
    private Byte    functionLevel;
    private String  functionCode;
    private String  functionName;
    private Integer functionOrder;
    private String  functionUrl;
    private Integer parentFunctionId;
    private String  iconId;
    private String  isEnable;
    private String  createBy;
    private Date    createTime;
    private String  updateBy;
    private Date    updateTime;
    private String  iconClass;
    private String  iconName;
    private String  parentfunctionname;
    private Integer _parentId;
    private String  state;

    public String getIconClass() {
        return iconClass;
    }

    public void setIconClass(String iconClass) {
        this.iconClass = iconClass;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

    public String getParentfunctionname() {
        return parentfunctionname;
    }

    public void setParentfunctionname(String parentfunctionname) {
        this.parentfunctionname = parentfunctionname;
    }

    public Integer get_parentId() {
        return _parentId;
    }

    public void set_parentId(Integer _parentId) {
        this._parentId = _parentId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Integer functionId) {
        this.functionId = functionId;
    }

    public Byte getFunctionLevel() {
        return functionLevel;
    }

    public void setFunctionLevel(Byte functionLevel) {
        this.functionLevel = functionLevel;
    }

    public String getFunctionCode() {
        return functionCode;
    }

    public void setFunctionCode(String functionCode) {
        this.functionCode = functionCode == null ? null : functionCode.trim();
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName == null ? null : functionName.trim();
    }

    public Integer getFunctionOrder() {
        return functionOrder;
    }

    public void setFunctionOrder(Integer functionOrder) {
        this.functionOrder = functionOrder;
    }

    public String getFunctionUrl() {
        return functionUrl;
    }

    public void setFunctionUrl(String functionUrl) {
        this.functionUrl = functionUrl == null ? null : functionUrl.trim();
    }

    public Integer getParentFunctionId() {
        return parentFunctionId;
    }

    public void setParentFunctionId(Integer parentFunctionId) {
        this.parentFunctionId = parentFunctionId;
    }

    public String getIconId() {
        return iconId;
    }

    public void setIconId(String iconId) {
        this.iconId = iconId == null ? null : iconId.trim();
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