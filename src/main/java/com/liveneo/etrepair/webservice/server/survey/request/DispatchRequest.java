package com.liveneo.etrepair.webservice.server.survey.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("DispatchRequest")
public class DispatchRequest {
    private VsRequestHeadDto        vsRequestHeadDto;
    // 案件推送参数对象
    @XStreamAlias("SendClaimInfoRequest")
    private SendClaimInfoRequest    sendClaimInfoRequest;
    // 新增损失任务参数对象
    @XStreamAlias("AddLossItemRequest")
    private AddLossItemRequest      addLossItemRequest;
    // 任务状态变更
    @XStreamAlias("ChangeTaskStatusRequest")
    private ChangeTaskStatusRequest changeTaskStatusRequest;
    // 调度员或查勘员
    @XStreamAlias("SynUserInfo")
    private SynUserInfo             synUserInfo;
    // 修理厂
    @XStreamAlias("SynGarageInfo")
    private SynGarageInfo           synGarageInfo;
    // 查勘员
    @XStreamAlias("SynSurveyorInfo")
    private SynSurveyorInfo         synSurveyorInfo;
    @XStreamAlias("SynSurveyPowerInfo")
    private SynSurveyPowerInfo      synSurveyPowerInfo;

    public SynSurveyPowerInfo getSynSurveyPowerInfo() {
        return synSurveyPowerInfo;
    }

    public void setSynSurveyPowerInfo(SynSurveyPowerInfo synSurveyPowerInfo) {
        this.synSurveyPowerInfo = synSurveyPowerInfo;
    }

    public VsRequestHeadDto getVsRequestHeadDto() {
        return vsRequestHeadDto;
    }

    public void setVsRequestHeadDto(VsRequestHeadDto vsRequestHeadDto) {
        this.vsRequestHeadDto = vsRequestHeadDto;
    }

    public SendClaimInfoRequest getSendClaimInfoRequest() {
        return sendClaimInfoRequest;
    }

    public void setSendClaimInfoRequest(SendClaimInfoRequest SendClaimInfoRequest) {
        this.sendClaimInfoRequest = SendClaimInfoRequest;
    }

    public AddLossItemRequest getAddLossItemRequest() {
        return addLossItemRequest;
    }

    public void setAddLossItemRequest(AddLossItemRequest addLossItemRequest) {
        this.addLossItemRequest = addLossItemRequest;
    }

    public ChangeTaskStatusRequest getChangeTaskStatusRequest() {
        return changeTaskStatusRequest;
    }

    public void setChangeTaskStatusRequest(ChangeTaskStatusRequest changeTaskStatusRequest) {
        this.changeTaskStatusRequest = changeTaskStatusRequest;
    }

    public SynUserInfo getSynUserInfo() {
        return synUserInfo;
    }

    public void setSynUserInfo(SynUserInfo synUserInfo) {
        this.synUserInfo = synUserInfo;
    }

    public SynGarageInfo getSynGarageInfo() {
        return synGarageInfo;
    }

    public void setSynGarageInfo(SynGarageInfo synGarageInfo) {
        this.synGarageInfo = synGarageInfo;
    }

    public SynSurveyorInfo getSynSurveyorInfo() {
        return synSurveyorInfo;
    }

    public void setSynSurveyorInfo(SynSurveyorInfo synSurveyorInfo) {
        this.synSurveyorInfo = synSurveyorInfo;
    }
}
