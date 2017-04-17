package com.liveneo.etrepair.pojo;

/**
 * @Desc：公共参数
 * @Title：BaseRequest
 * @address: http://www.liveneo.com.cn/
 * @author: zhaoyy
 * @version: 1.0 
 * @date: 2016年10月24日 下午3:39:12
 */
public class BaseRequest {
    private String projectCode;     // 项目编码
    private String uuid;       // 生成32位唯一码
    private String curTime;    // 当前时间
    private String token;      // 认证票据

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCurTime() {
        return curTime;
    }

    public void setCurTime(String curTime) {
        this.curTime = curTime;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
