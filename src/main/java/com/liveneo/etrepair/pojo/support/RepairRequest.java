package com.liveneo.etrepair.pojo.support;

public class RepairRequest {
    private CoreRequestHeadDto requestHead;
    private RequestDetail      requestDetails;

    public CoreRequestHeadDto getRequestHead() {
        return requestHead;
    }

    public void setRequestHead(CoreRequestHeadDto requestHead) {
        this.requestHead = requestHead;
    }

    public RequestDetail getRequestDetails() {
        return requestDetails;
    }

    public void setRequestDetails(RequestDetail requestDetails) {
        this.requestDetails = requestDetails;
    }
}
