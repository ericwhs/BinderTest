package com.guiyutest.bindertest;

import android.os.IBinder;

/**
 * Created by weiyi on 15-1-18.
 */
public class ProxyClient implements MyTransInterface {
    @Override
    public void LogService() {
        
    }

    @Override
    public IBinder asBinder() {
        return null;
    }
}
