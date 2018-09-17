package com.xiaoyezi.mvpdemo.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by liushuai on 2018/9/11.
 */
public class UpdateInfoModel extends BaseModel {
    @SerializedName("latest_version")
    private String latestVersion;

    @SerializedName("force_update")
    private String forceUpdate;

    @SerializedName("download_url")
    private String downloadUrl;

    @SerializedName("ver_desc")
    private String verDesc;

    public String getLatestVersion() {
        return latestVersion;
    }

    public void setLatestVersion(String latestVersion) {
        this.latestVersion = latestVersion;
    }

    public String getForceUpdate() {
        return forceUpdate;
    }

    public void setForceUpdate(String forceUpdate) {
        this.forceUpdate = forceUpdate;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getVerDesc() {
        return verDesc;
    }

    public void setVerDesc(String verDesc) {
        this.verDesc = verDesc;
    }
}
