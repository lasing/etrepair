package com.liveneo.etrepair.pojo;

import java.util.List;

// 个推消息实体
public class SendInfo extends BaseRequest {
    private List<Message> msgList;

    public List<Message> getMsgList() {
        return msgList;
    }

    public void setMsgList(List<Message> msgList) {
        this.msgList = msgList;
    }
}