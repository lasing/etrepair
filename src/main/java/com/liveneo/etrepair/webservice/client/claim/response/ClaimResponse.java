package com.liveneo.etrepair.webservice.client.claim.response;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 响应消息体
 * 
 * @author fcy
 *
 */
@XmlRootElement(name = "ClaimResponse")
public class ClaimResponse {
    /**
     * 响应消息体
     */
    private ResponseHead        responseHead;
    /**
     * 短信列表
     */
    private List<CaseSMS>       lstCaseSMS;
    /**
     * 案件置为正常处理返回信息
     */
    private List<ThirdCarInfo>  thirtCarLossIdList;
    private ClaimInfoResponse   ClaimInfoResponse;
    private SurveyRightResponse SurveyRightResponse;

    @XmlElement(name = "SurveyRightResponse")
    public SurveyRightResponse getSurveyRightResponse() {
        return SurveyRightResponse;
    }

    public void setSurveyRightResponse(SurveyRightResponse surveyRightResponse) {
        SurveyRightResponse = surveyRightResponse;
    }

    @XmlElement(name = "ClaimInfoResponse")
    public ClaimInfoResponse getClaimInfoResponse() {
        return ClaimInfoResponse;
    }

    public void setClaimInfoResponse(ClaimInfoResponse claimInfoResponse) {
        ClaimInfoResponse = claimInfoResponse;
    }

    @XmlElement(name = "ResponseHead")
    public ResponseHead getResponseHead() {
        return responseHead;
    }

    public void setResponseHead(ResponseHead responseHead) {
        this.responseHead = responseHead;
    }

    @XmlElementWrapper(name = "LstCaseSMS")
    @XmlElement(name = "CaseSMS")
    public List<CaseSMS> getLstCaseSMS() {
        return lstCaseSMS;
    }

    public void setLstCaseSMS(List<CaseSMS> lstCaseSMS) {
        this.lstCaseSMS = lstCaseSMS;
    }

    @XmlElementWrapper(name = "ThirtCarLossIdList")
    @XmlElement(name = "ThirdCarInfo")
    public List<ThirdCarInfo> getThirtCarLossIdList() {
        return thirtCarLossIdList;
    }

    public void setThirtCarLossIdList(List<ThirdCarInfo> thirtCarLossIdList) {
        this.thirtCarLossIdList = thirtCarLossIdList;
    }
}
