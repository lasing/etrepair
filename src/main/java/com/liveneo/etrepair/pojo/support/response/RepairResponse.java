package com.liveneo.etrepair.pojo.support.response;

/**
 * 响应消息体
 */
public class RepairResponse {
    private ResponseDetail  responseDetails;
    private ResponseHeadDto responseHead;

    public ResponseDetail getResponseDetails() {
        return responseDetails;
    }

    public void setResponseDetails(ResponseDetail responseDetails) {
        this.responseDetails = responseDetails;
    }

    public ResponseHeadDto getResponseHead() {
        return responseHead;
    }

    public void setResponseHead(ResponseHeadDto responseHead) {
        this.responseHead = responseHead;
    }
}
