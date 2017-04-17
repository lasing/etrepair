package com.liveneo.etrepair.webservice.server.survey.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias(value = "ResponseHead")
public class ResponseHead {
    private String resultCode;
    private String errorMessage;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
