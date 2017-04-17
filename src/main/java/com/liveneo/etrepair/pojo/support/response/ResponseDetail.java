package com.liveneo.etrepair.pojo.support.response;

import java.util.List;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

public class ResponseDetail {
    @XStreamImplicit(itemFieldName = "garageInfo")
    List<ReponseGarageInfo> garageInfo;

    public List<ReponseGarageInfo> getGarageInfo() {
        return garageInfo;
    }

    public void setGarageInfo(List<ReponseGarageInfo> garageInfo) {
        this.garageInfo = garageInfo;
    }
}
