package com.liveneo.etrepair.webservice.server.survey.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * VIP服务项目
 */
@XStreamAlias("ServiceItem")
public class ServiceItem {
    private String orgName;
    private String serviceName;
    private String serviceItem;

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceItem() {
        return serviceItem;
    }

    public void setServiceItem(String serviceItem) {
        this.serviceItem = serviceItem;
    }
}
