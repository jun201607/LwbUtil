package demo.lwb.com.myutils.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import demo.lwb.com.myutils.aidl.BinderPool;

public class BookManagerService extends Service {
    private static final String TAG = "BookManagerService";



    @Override
    public void onCreate() {
        super.onCreate();
    }


    private Binder mBinder=new BinderPool.BinderPoolImpl();
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }
}
