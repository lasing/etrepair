package com.liveneo.etrepair.webservice.server.survey.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 用户岗位
 */
@XStreamAlias("RoleItem")
public class RoleItem {
    private String rolecode;
    private String rolename;

    public String getRolecode() {
        return rolecode;
    }

    public void setRolecode(String rolecode) {
        this.rolecode = rolecode;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
