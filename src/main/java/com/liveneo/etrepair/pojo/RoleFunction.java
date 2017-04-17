package com.liveneo.etrepair.pojo;

import java.util.Date;

public class RoleFunction {
    private String  roleFunctionId;
    private String  operationDesc;
    private Integer functionId;
    private String  roleId;
    private Byte    isreadonly;
    private String  createBy;
    private Date    createTime;

    public String getRoleFunctionId() {
        return roleFunctionId;
    }

    public void setRoleFunctionId(String roleFunctionId) {
        this.roleFunctionId = roleFunctionId == null ? null : roleFunctionId.trim();
    }

    public String getOperationDesc() {
        return operationDesc;
    }

    public void setOperationDesc(String operationDesc) {
        this.operationDesc = operationDesc == null ? null : operationDesc.trim();
    }

    public Integer getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Integer functionId) {
        this.functionId = functionId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public Byte getIsreadonly() {
        return isreadonly;
    }

    public void setIsreadonly(Byte isreadonly) {
        this.isreadonly = isreadonly;
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