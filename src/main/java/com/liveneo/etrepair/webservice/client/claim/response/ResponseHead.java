package com.liveneo.etrepair.webservice.client.claim.response;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 案件置为正常处理返回信息
 * 
 * @author fcy
 *
 */
@XmlRootElement(name = "ResponseHead")
public class ResponseHead {
    /**
     * 结果代码
     */
    private String resultCode;
    /**
     * 服务代码
     */
    private String serviceCode;
    /**
     * 服务名称
     */
    private String serviceName;
    /**
     * 操作名称
     */
    private String operation;
    /**
     * 请求ID
     */
    private String requestID;
    /**
     * 错误信息
     */
    private String errorMessage;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
