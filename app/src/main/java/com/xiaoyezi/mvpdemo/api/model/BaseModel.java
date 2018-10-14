package com.xiaoyezi.mvpdemo.api.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class BaseModel {
    @SerializedName("errors")
    private ArrayList<ErrorModel> errors;

    public ArrayList<ErrorModel> getErrors() {
        return errors;
    }
}
