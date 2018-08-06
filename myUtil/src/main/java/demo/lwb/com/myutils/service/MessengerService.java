package demo.lwb.com.myutils.service;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

public class MessengerService extends Service {
    private static final String TAG = "MessengerService";
    public static final int MSG_FROM_CLIENT = 1;
    public static final int MSG_FROM_SERVICE = 2;
    public MessengerService() {
    }
    @Override
    public IBinder onBind(Intent intent) {
       return  mMessenger.getBinder();
    }
    private final Messenger mMessenger=new Messenger(new MessengerHandle());
    public static class MessengerHandle extends Handler{
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case MessengerService.MSG_FROM_CLIENT:
                    Messenger client = msg.replyTo;
                    Message obtain = Message.obtain(null, MessengerService.MSG_FROM_SERVICE);
                    Bundle bundle = new Bundle();
                    bundle.putString("reply","服务端：消息已收到");
                    obtain.setData(bundle);
                    try {
                        client.send(obtain);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    break;
            }
            super.handleMessage(msg);
        }
    }
}
