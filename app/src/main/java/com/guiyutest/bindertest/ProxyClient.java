package com.guiyutest.bindertest;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/**
 * Created by weiyi on 15-1-18.
 */
public class ProxyClient implements IMyTransInterface {
    public static final int TRANSACTION_LogService = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
    private IBinder mRemote;

    ProxyClient(IBinder mRemote) {
        this.mRemote = mRemote;
    }

    @Override
    public IBinder asBinder() {
        return mRemote;
    }

    @Override
    public void LogService() {
        Parcel _data = Parcel.obtain();
        Parcel _reply = Parcel.obtain();
        try{
            _data.writeInterfaceToken(StubService.DESCRIPTOR);
            mRemote.transact(TRANSACTION_LogService,_data,_reply,0);
            _reply.readException();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

      }

}
