/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: C:\\Users\\admin\\Desktop\\LwbUtils-master\\myUtil\\src\\main\\aidl\\demo\\lwb\\com\\myutils\\bean\\Icompute.aidl
 */
package demo.lwb.com.myutils.bean;
//业务模块2

public interface Icompute extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements demo.lwb.com.myutils.bean.Icompute
{
private static final java.lang.String DESCRIPTOR = "demo.lwb.com.myutils.bean.Icompute";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an demo.lwb.com.myutils.bean.Icompute interface,
 * generating a proxy if needed.
 */
public static demo.lwb.com.myutils.bean.Icompute asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof demo.lwb.com.myutils.bean.Icompute))) {
return ((demo.lwb.com.myutils.bean.Icompute)iin);
}
return new demo.lwb.com.myutils.bean.Icompute.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_add:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
int _result = this.add(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements demo.lwb.com.myutils.bean.Icompute
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public int add(int a, int b) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(a);
_data.writeInt(b);
mRemote.transact(Stub.TRANSACTION_add, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_add = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
public int add(int a, int b) throws android.os.RemoteException;
}
