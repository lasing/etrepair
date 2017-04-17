package com.liveneo.etrepair.webservice.client.claim.request;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 联系人信息
 * 
 * @author fcy
 *
 */
@XmlRootElement(name = "Contact")
public class Contact {
    /**
     * 联系人电话
     */
    private String name;
    /**
     * 联系人方式
     */
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
