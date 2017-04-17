package com.liveneo.etrepair.webservice.server.survey;

import com.liveneo.etrepair.webservice.server.survey.request.DispatchRequest;
import com.liveneo.etrepair.webservice.server.survey.response.DispatchResponse;

public interface DispatchCxfService {
    /**
     * 案件推送接口
     * @param dispatchRequest
     * @return
     */
    DispatchResponse sendClaimInfo(DispatchRequest dispatchRequest);
}
