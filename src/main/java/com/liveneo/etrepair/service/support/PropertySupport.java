package com.liveneo.etrepair.service.support;

import com.liveneo.etrepair.service.support.base.BaseSupport;

public class PropertySupport extends BaseSupport {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String            code;
    private String            value;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
