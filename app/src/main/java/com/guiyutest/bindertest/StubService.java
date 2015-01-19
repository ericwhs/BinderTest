package com.guiyutest.bindertest;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/**
 * Created by weiyi on 15-1-18.
 */
public abstract class StubService extends Binder implements IMyTransInterface {
    public static final java.lang.String DESCRIPTOR = "com.guiyutest.bindertest.IMyTrasInterfacke";


    public abstract void LogService();

    public StubService() {
        this.attachInterface(this,DESCRIPTOR);
    }

    public static IMyTransInterface asInterface(IBinder obj){
        if(obj == null){
            return null;
        }
        IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
        if((iin != null) && (iin instanceof IMyTransInterface)){
            return (IMyTransInterface)iin;
        }
        return new ProxyClient(obj);
    }



    @Override
    public IBinder asBinder() {
        return this;
    }

    @Override
    protected boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
        switch (code) {
            case INTERFACE_TRANSACTION:
                reply.writeString(DESCRIPTOR);
                return true;
            case ProxyClient.TRANSACTION_LogService:
                data.enforceInterface(DESCRIPTOR);
                this.LogService();
                reply.writeNoException();
                return true;
        }
        return super.onTransact(code, data, reply, flags);
    }


}
