package com.xiaoyezi.mvpdemo.model;

import com.google.gson.annotations.SerializedName;

public class ErrorModel {
    @SerializedName("err_no")
    private String errNo;

    @SerializedName("err_msg")
    private String errMsg;

    @SerializedName("err_type")
    private String errType;

    public String getErrNo() {
        return errNo;
    }

    public void setErrNo(String errNo) {
        this.errNo = errNo;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}
