package com.kince.sdk.ads.network.okhttp3.listener;

/**
 * 功能   ：网络请求结果的自定义监听接口
 */

public interface DisposeDataListener {

    /**
     * 请求成功回调事件
     */
    void onSuccess(Object responseObj);
    /**
     * 请求失败回调时间
     */
    void onError(Object errorObj);
}
