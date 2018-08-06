package demo.lwb.com.myutils.aidl;

import android.os.RemoteException;

import demo.lwb.com.myutils.bean.Icompute;

/**
 * Created by lwb on 2018/4/23.
 * 业务模块2
 */

public class IcomputeImpl extends Icompute.Stub{
    @Override
    public int add(int a, int b) throws RemoteException {
        return a+b;
    }
}
