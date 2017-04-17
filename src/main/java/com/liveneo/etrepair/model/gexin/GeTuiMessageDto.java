package com.liveneo.etrepair.model.gexin;

import java.util.Date;

/**
 * 个推推送消息dto
 * @author zxh
 *
 */
public class GeTuiMessageDto {
    private String uuid;       // 消息唯一标示
    private String newstype;   // 消息类型
    private String caseNo;     // 案件号
    private String taskId;     // 任务Id
    private Date   sendTime;   // 发送时间
    private String newsMessage; // 消息内容

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getNewstype() {
        return newstype;
    }

    public void setNewstype(String newstype) {
        this.newstype = newstype;
    }

    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getNewsMessage() {
        return newsMessage;
    }

    public void setNewsMessage(String newsMessage) {
        this.newsMessage = newsMessage;
    }
}
