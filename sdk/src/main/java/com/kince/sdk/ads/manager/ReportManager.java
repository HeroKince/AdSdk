package com.kince.sdk.ads.manager;

import com.kince.sdk.ads.network.okhttp3.CommonOkHttpClient;
import com.kince.sdk.ads.network.okhttp3.HttpConstant;
import com.kince.sdk.ads.network.okhttp3.listener.DisposeDataHandle;
import com.kince.sdk.ads.network.okhttp3.listener.DisposeDataListener;
import com.kince.sdk.ads.network.okhttp3.request.CommonRequest;
import com.kince.sdk.ads.network.okhttp3.request.RequestParams;
import com.kince.sdk.ads.network.okhttp3.HttpConstant.Params;

/**
 * 功能   ：负责所有监测请求的发送
 */
public class ReportManager {

    /**
     * 默认的事件回调处理
     */
    private static DisposeDataHandle handle = new DisposeDataHandle(
            new DisposeDataListener() {
                @Override
                public void onSuccess(Object responseObj) {
                }

                @Override
                public void onError(Object errorObj) {
                }
            });

    /**
     * 发送广告是否正常解析及展示监测
     */
    public static void sendAdMonitor(boolean isPad, String sid, String ie, String appVersion, Params step, String result) {
        RequestParams params = new RequestParams();
        params.put(Params.lvs.getKey(), Params.lvs.getValue());
        params.put(Params.st.getKey(), Params.st.getValue());
        params.put(Params.os.getKey(), Params.os.getValue());
        params.put(Params.p.getKey(), Params.p.getValue());
        params.put(Params.appid.getKey(), Params.appid.getValue());
        if (isPad) {
            params.put(Params.bt_pad.getKey(), Params.bt_pad.getValue());
        } else {
            params.put(Params.bt_phone.getKey(), Params.bt_phone.getValue());
        }
        params.put(step.getKey(),
                step.getValue());
        params.put(HttpConstant.STEP_CD, result);
        params.put(HttpConstant.SID, sid);
        params.put(HttpConstant.IE, ie);
        params.put(HttpConstant.AVS, appVersion);

        CommonOkHttpClient.sendRequest(CommonRequest.createGetRequest(HttpConstant.ATM_MONITOR, params), handle);
    }

}
