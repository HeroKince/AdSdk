package com.kince.sdk.ads.manager;

import android.content.Context;

/**
 *
 */
public class SDKManager {

    private static SDKManager instance = null;

    private Context mContext = null;

    private SDKManager(Context context) {
        this.mContext = context;
    }

    public static SDKManager getInstence(Context context) {
        if (instance == null)
            instance = new SDKManager(context);
        return instance;
    }

    /**
     * 初始化
     *
     * @param secretkey
     */
    public void init(String secretkey) {

    }

}
