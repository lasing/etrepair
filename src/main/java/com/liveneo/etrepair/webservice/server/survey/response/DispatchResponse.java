package com.liveneo.etrepair.webservice.server.survey.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 响应消息体
 */
@XStreamAlias("DispatchResponse")
public class DispatchResponse {
    @XStreamAlias("ResponseHead")
    private ResponseHead responseHead;

    public ResponseHead getResponseHead() {
        if ("000".equals(responseHead.getResultCode())) {
            responseHead.setErrorMessage("成功");
        }
        return responseHead;
    }

    public void setResponseHead(ResponseHead responseHead) {
        this.responseHead = responseHead;
    }
}
