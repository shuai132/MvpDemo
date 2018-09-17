package com.xiaoyezi.mvpdemo.api;

import com.google.gson.annotations.SerializedName;

public class ApiResponse<T> {
    @SerializedName("code")
    public int code;
    @SerializedName("data")
    public T data;
}
