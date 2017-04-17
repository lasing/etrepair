package com.liveneo.etrepair.webservice.server.survey;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import org.springframework.beans.factory.annotation.Autowired;
import com.liveneo.etrepair.common.XStreamUtil;
import com.liveneo.etrepair.log.LVLogger;
import com.liveneo.etrepair.webservice.server.survey.request.DispatchRequest;
import com.liveneo.etrepair.webservice.server.survey.response.DispatchResponse;

@WebService(serviceName = "CaseInfoSoapBindingImplService", portName = "CaseInfoSoapBindingImplPort", targetNamespace = "http://survey.ws.etrepair.com",
        endpointInterface = "com.liveneo.etrepair.webservice.server.survey.CaseInfoSoapBinding")
@SOAPBinding(style = Style.DOCUMENT)
public class CaseInfoSoapBindingImpl implements CaseInfoSoapBinding {
    LVLogger                   logger = LVLogger.getLogger(this.getClass());
    @Autowired
    private DispatchCxfService dispatchCxfService;

    @Override
    public String sendClaimInfo(String dispatchRequest) {
        logger.info(dispatchRequest);
        DispatchRequest dispatchEntity = XStreamUtil.fromXML(dispatchRequest, DispatchRequest.class);
        DispatchResponse dispatchResponse = dispatchCxfService.sendClaimInfo(dispatchEntity);
        logger.info(XStreamUtil.toXML(dispatchResponse, DispatchResponse.class, null));
        return XStreamUtil.toXML(dispatchResponse, DispatchResponse.class, null);
    }
}
