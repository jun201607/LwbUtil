package demo.lwb.com.myutils.aidl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;

import java.util.concurrent.CountDownLatch;

import demo.lwb.com.myutils.bean.IBinderPool;
import demo.lwb.com.myutils.service.BookManagerService;

/**
 * Created by lwb on 2018/4/23.
 * AIDL----Binder池具体实现
 */

public class BinderPool {
    private static final String TAG="BinderPool";
    public static final int BINDER_NONE=-1;
    public static final int BINDER_BOOK=0;
    public static final int BINDER_COMPUTE=1;
    private final Context mContext;
    private static BinderPool sInstance;
    private CountDownLatch mConnectBinderPoolCountDownLatch;
    private IBinderPool mBinderPool;

    private BinderPool(Context context) {
        mContext = context.getApplicationContext();
        connectBinderPoolService();
    }
    /**
     * 线程同步的懒汉式单例模式
     * @param context
     * @return
     */
    public static BinderPool getInstance(Context context){
        if(sInstance==null){
            synchronized (BinderPool.class){
                if(sInstance==null){
                    sInstance = new BinderPool(context);
                }
            }
        }
        return sInstance;
    }

    /**
     * binder 连接服务
     * 这个方法主要用于客户端与服务端建立连接，在方法内部出现了CountDownLatch类，这个类是用于线程同步的，
     * 由于bindService()是异步操作，所以如果要确保客户端在执行其他操作之前已经绑定好服务端，就应该先实现线程同步。
     * CountDownLatch类有三个主要方法：
     * 构造方法 CountDownLatch(int num)：这里传递一个num值，为countdownlatch内部的计时器赋值。
     * countdown():每当调用一次这个方法，countdownlatch实例内部计时器数值 - 1。
     * await():让当前线程等待，如果内部计时器变为0，那么唤醒当前线程。
     */
    private synchronized void connectBinderPoolService() {
        mConnectBinderPoolCountDownLatch = new CountDownLatch(1);
        Intent service = new Intent(mContext, BookManagerService.class);
        mContext.bindService(service,mBinderPoolConnection,Context.BIND_AUTO_CREATE);
        try {
            mConnectBinderPoolCountDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据具体的binderCode值来获得某个特定的Binder，并返回。
     * @param binderCode
     * @return
     */
    public IBinder queryBinder(int binderCode){
        IBinder binder=null;
            try {
                if(mBinderPool!=null) {
                    binder = mBinderPool.queryBinder(binderCode);
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
       return binder;
    }

    private ServiceConnection mBinderPoolConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
//            客户端获得了服务端Binder连接池的一个代理对象
             mBinderPool = IBinderPool.Stub.asInterface(iBinder);
            try {
                mBinderPool.asBinder().linkToDeath(mBinderPoolDeathRecipient,0);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            mConnectBinderPoolCountDownLatch.countDown();
        }
        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
    /**
     * 为IBinder设置死亡监听，如果连接意外中断，会自动重新连接。
     */
    private IBinder.DeathRecipient mBinderPoolDeathRecipient=new IBinder.DeathRecipient(){
        @Override
        public void binderDied() {
            mBinderPool.asBinder().unlinkToDeath(mBinderPoolDeathRecipient,0);
            mBinderPool=null;
            connectBinderPoolService();
        }
    };

    /**
     * binder池实现
     */
    public static class BinderPoolImpl extends IBinderPool.Stub{
        public BinderPoolImpl() {
            super();
        }
        @Override
        public IBinder queryBinder(int binderCode) throws RemoteException {
            IBinder binder=null;
            switch (binderCode){
                case BINDER_BOOK:{
                    binder = new IBookImpl();
                    break;
                }
                case BINDER_COMPUTE:{
                    binder = new IcomputeImpl();
                    break;
                }
                default:break;
            }
            return binder;
        }
    }
}
