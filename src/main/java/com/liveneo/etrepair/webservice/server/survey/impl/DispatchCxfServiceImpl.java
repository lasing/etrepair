package com.liveneo.etrepair.webservice.server.survey.impl;

import org.springframework.stereotype.Service;
import com.liveneo.etrepair.webservice.server.survey.DispatchCxfService;
import com.liveneo.etrepair.webservice.server.survey.request.DispatchRequest;
import com.liveneo.etrepair.webservice.server.survey.response.DispatchResponse;

@Service(value = "dispatchCxfService")
public class DispatchCxfServiceImpl implements DispatchCxfService {
    /**
     * 案件信息推送C01
     */
    @Override
    public DispatchResponse sendClaimInfo(DispatchRequest dispatchRequest) {
        return null;
    }
}
