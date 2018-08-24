package demo.lwb.com.myutils.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import io.socket.client.IO;
import io.socket.client.Manager;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import io.socket.engineio.client.Transport;
/**
 * Created by Administrator on 2017/12/11.
 */

public class SocketService extends Service {
    private static final String TAG = SocketService.class.getSimpleName();

    private Socket mSocket;

    private boolean isConnected;

    @Override
    public void onCreate() {
        super.onCreate();
        initSocketHttp();
        connectSocket();
    }

    /**
     * 初始化Socket,Http的连接方式
     */
    private void initSocketHttp() {
        try {
            mSocket = IO.socket( "http://192.168.205.125:10443" ); // 初始化Socket
        } catch ( URISyntaxException e ) {
            e.printStackTrace();
        }
    }

    private void connectSocket() {
        try {
            mSocket.connect();
            JSONObject jsonObject = new JSONObject();
            jsonObject.put( "userName", "小王" ); // 这里一般是设置登录名
            mSocket.emit( "loginName", jsonObject ); // 发送登录人
        } catch ( JSONException e ) {
            e.printStackTrace();
        }
        mSocket.on( Socket.EVENT_CONNECT, onConnect );// 连接成功
        mSocket.on( Socket.EVENT_DISCONNECT, onDisconnect );// 断开连接
        mSocket.on( Socket.EVENT_CONNECT_ERROR, onConnectError );// 连接异常
        mSocket.on( Socket.EVENT_CONNECT_TIMEOUT, onConnectTimeoutError );// 连接超时
        mSocket.on( "newMessage", onConnectMsg );// 监听消息事件回调
//        mSocket.io().on(Manager.EVENT_TRANSPORT, new Emitter.Listener() {
        mSocket.io().on(Manager.EVENT_TRANSPORT, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                Transport transport = (Transport)args[0];
                transport.on(Transport.EVENT_REQUEST_HEADERS, new Emitter.Listener() {
                    @Override
                    public void call(Object... args) {
                        @SuppressWarnings("unchecked")
                        Map<String, List<String>> headers = (Map<String, List<String>>)args[0];
                        // modify request headers
                        headers.put("Cookie", Arrays.asList("foo=1;"));
                    }
                });

                transport.on(Transport.EVENT_RESPONSE_HEADERS, new Emitter.Listener() {
                    @Override
                    public void call(Object... args) {
                        @SuppressWarnings("unchecked")
                        Map<String, List<String>> headers = (Map<String, List<String>>)args[0];
                        // access response headers
                        String cookie = headers.get("Set-Cookie").get(0);
                    }
                });
            }
        });
    }

    private void disConnectSocket() {
        mSocket.disconnect();
        mSocket.off( Socket.EVENT_CONNECT, onConnect );// 连接成功
        mSocket.off( Socket.EVENT_DISCONNECT, onDisconnect );// 断开连接
        mSocket.off( Socket.EVENT_CONNECT_ERROR, onConnectError );// 连接异常
        mSocket.off( Socket.EVENT_CONNECT_TIMEOUT, onConnectTimeoutError );// 连接超时
        mSocket.off( "newMessage", onConnectMsg );// 监听消息事件回调
    }

    private Emitter.Listener onConnectMsg = new Emitter.Listener() {
        @Override
        public void call( final Object... args ) {
            // 在这里处理你的消息
            Log.e( TAG, "服务器返回来的消息 : " + args[0] );
        }
    };


    /**
     * 实现消息回调接口
     */
    private Emitter.Listener onConnect = new Emitter.Listener() {
        @Override
        public void call( final Object... args ) {
            Log.e( TAG, "连接成功 " + args[0] );
            if (!isConnected) { // 如果已经断开，重新发送
                try {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put( "userName", "小王" ); // 这里一般是设置登录名
                    mSocket.emit( "loginName", jsonObject ); // 发送登录人
                } catch ( JSONException e ) {
                    e.printStackTrace();
                }
                isConnected = true;
            }
        }
    };



    private Emitter.Listener onDisconnect = new Emitter.Listener() {
        @Override
        public void call( Object... args ) {
            Log.e( TAG, "断开连接 " + args[0] );
            isConnected = false;
        }
    };

    private Emitter.Listener onConnectError = new Emitter.Listener() {
        @Override
        public void call( final Object... args ) {
            Log.e( TAG, "连接 失败" + args[0] );
        }
    };

    private Emitter.Listener onConnectTimeoutError = new Emitter.Listener() {
        @Override
        public void call( final Object... args ) {
            Log.e( TAG, "连接 超时" + args[0] );

        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent ) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        disConnectSocket();
    }
}
