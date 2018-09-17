package com.xiaoyezi.mvpdemo.rx;

import com.xiaoyezi.mvpdemo.api.ApiException;
import com.xiaoyezi.mvpdemo.api.ApiResponse;

import io.reactivex.functions.Function;

public class ResponseTransformer<T> implements Function<ApiResponse<T>, T> {
    @Override
    public T apply(ApiResponse<T> apiResponse) throws Exception {
        if (apiResponse.code != 0) {
            throw new ApiException(apiResponse.code, "");
        }
        return apiResponse.data;
    }
}

