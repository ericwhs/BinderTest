package com.guiyutest.bindertest;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/**
 * Created by weiyi on 15-1-18.
 */
public abstract class StubService extends Binder implements MyTransInterface {
    public abstract void LogService();

    @Override
    public IBinder asBinder() {
        return null;
    }

    @Override
    protected boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        return super.onTransact(code, data, reply, flags);
    }


}
