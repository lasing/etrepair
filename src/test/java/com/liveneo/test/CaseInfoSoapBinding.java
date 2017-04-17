package com.liveneo.test;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName="CaseInfoSoapBinding",targetNamespace="http://survey.ws.repair.com")
public interface CaseInfoSoapBinding {

	/**
     * c01将报案信息推送到调度系统
     */
    public String sendClaimInfo(@WebParam(name = "DispatchRequest") String DispatchRequest);
}
