package demo.lwb.com.myutils.Utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/**
 * 单线程消息处理队列
 * 调用方式
   SingleThread singleThread = new SingleThread();
   singleThread.start();
   发送信息
   singleThread.sendMessage();
 * Created by Administrator on 2017/8/13.
 */

public class SingleThread extends Thread{
    int i=0;
    private Handler handler;
    /**
     * 发送消息
     */
    public void sendMessage(){
        Message message = new Message();
        message.arg1=1;
        handler.sendMessage(message);
    }

    @Override
    public void run() {
        Looper.prepare();
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
            }
        };

        Looper.loop();
    }
}
