package com.liveneo.etrepair.pojo;

/**
 * @Desc：
 * @Title：Message
 * @address: http://www.liveneo.com.cn/
 * @author: zhaoyy
 * @version: 1.0 
 * @date: 2016年10月24日 下午5:07:47
 */
public class Message {
    /**
     * 案件号(没案件号时传ET)
     */
    private String caseNo;
    /**
     * 消息唯一码
     */
    private String msgUUID;
    /**
     * 消息类型(app自己定义，服务端原数据返回)
     */
    private String newstype;
    /**
     * 消息内容
     */
    private String content;
    /**
     * 用户编码
     */
    private String userCode;
    /**
     * 用户手机号
     */
    private String userMobile;
    /**
     * 推送客户端类型
     */
    private String clientType;

    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }

    public String getMsgUUID() {
        return msgUUID;
    }

    public void setMsgUUID(String msgUUID) {
        this.msgUUID = msgUUID;
    }

    public String getNewstype() {
        return newstype;
    }

    public void setNewstype(String newstype) {
        this.newstype = newstype;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }
}
