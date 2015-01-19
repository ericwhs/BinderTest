package com.guiyutest.bindertest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class BinderService extends Service {
    private static final String TAG = "BinderService";


    //implement the interface
    private StubService mBinder = new StubService() {
        @Override
        public void LogService() {
            Log.d(TAG,"pid=" + android.os.Process.myPid());
        }
    };



    //expose the interface to client
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }
}
