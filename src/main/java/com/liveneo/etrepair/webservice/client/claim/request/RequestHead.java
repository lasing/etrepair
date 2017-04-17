package com.liveneo.etrepair.webservice.client.claim.request;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 请求交易头信息
 * 
 * @author fcy
 *
 */
@XmlRootElement(name = "RequestHead")
public class RequestHead {
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
     * 调用方系统代码
     */
    private String clientCode;
    /**
     * 调用系统名称
     */
    private String clientName;
    /**
     * 认证密码，MD5加密
     */
    private String password;
    /**
     * 服务方系统代码
     */
    private String serverCode;
    /**
     * 请求ID
     */
    private String requestID;
    /**
     * 用户签名
     */
    private String usrSignature;
    /**
     * 用户代码
     */
    private String userCode;
    /**
     * 用户名称
     */
    private String userName;

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

    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getServerCode() {
        return serverCode;
    }

    public void setServerCode(String serverCode) {
        this.serverCode = serverCode;
    }

    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    public String getUsrSignature() {
        return usrSignature;
    }

    public void setUsrSignature(String usrSignature) {
        this.usrSignature = usrSignature;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
