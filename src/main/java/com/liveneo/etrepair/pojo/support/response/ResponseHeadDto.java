package com.liveneo.etrepair.pojo.support.response;

public class ResponseHeadDto {
    protected String serviceCode;  // 服务代码(ET网络送修系统)
    protected String serviceName;  // 服务名称
    protected String interfaceCode; // 接口编号
    protected String interfaceName; // 接口名称
    protected String sendCode;     // 数据发送方编号
    protected String sendName;     // 数据发送方名称
    protected String usrSignature; // 用户签名(空)
    protected String password;     // 加密数据
    protected String dateTime;     // 发送时间（时间戳）

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

    public String getInterfaceCode() {
        return interfaceCode;
    }

    public void setInterfaceCode(String interfaceCode) {
        this.interfaceCode = interfaceCode;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getSendCode() {
        return sendCode;
    }

    public void setSendCode(String sendCode) {
        this.sendCode = sendCode;
    }

    public String getSendName() {
        return sendName;
    }

    public void setSendName(String sendName) {
        this.sendName = sendName;
    }

    public String getUsrSignature() {
        return usrSignature;
    }

    public void setUsrSignature(String usrSignature) {
        this.usrSignature = usrSignature;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
