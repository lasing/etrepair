package com.liveneo.etrepair.model.app;

import java.util.Date;

public class MobileVersionDto {
    private String versionId;       // 终端版本号
    private Date   createDate;      // 版本创建时间
    private String uptPkgFile;      // 更新包文件名称
    private String downloadUrl;     // 更新包下载Url
    private String versionContent;  // 版本更新内容
    private Date   effectDate;      // 生效时间
    private String mandatoryUpgrade; // 更新模式

    public String getVersionId() {
        return versionId;
    }

    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUptPkgFile() {
        return uptPkgFile;
    }

    public void setUptPkgFile(String uptPkgFile) {
        this.uptPkgFile = uptPkgFile;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getVersionContent() {
        return versionContent;
    }

    public void setVersionContent(String versionContent) {
        this.versionContent = versionContent;
    }

    public Date getEffectDate() {
        return effectDate;
    }

    public void setEffectDate(Date effectDate) {
        this.effectDate = effectDate;
    }

    public String getMandatoryUpgrade() {
        return mandatoryUpgrade;
    }

    public void setMandatoryUpgrade(String mandatoryUpgrade) {
        this.mandatoryUpgrade = mandatoryUpgrade;
    }
}
