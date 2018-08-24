package demo.lwb.com.myutils.mvp.fragment;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import demo.lwb.com.myutils.R;
import demo.lwb.com.myutils.base.BaseFragment;
import demo.lwb.com.myutils.mvp.presenter.BasePresenter;
import demo.lwb.com.myutils.service.MessengerService;

/**
 * Created by lwb on 2018/4/17.
 * 使用Messenger跨进程通信
 */

public class MessengerFragment extends BaseFragment {
    @BindView(R.id.bt_send)
    Button btSend;
    @BindView(R.id.et_put)
    EditText etPut;
    @BindView(R.id.ll_content)
    LinearLayout llContent;

    /**
     * Frament退栈监听
     *
     * @param returnCode 返回码
     * @param bundle
     */
    @Override
    public void popBackListener(int returnCode, Bundle bundle) {
    }
    /**
     * 中心的标题设置
     */
    @Override
    public void setMiddleTitle() {
    }
    /**
     * 绑定P层
     *
     * @return
     */
    @Override
    protected BasePresenter bindPresenter() {
        return null;
    }

    /**
     * 绑定界面
     *
     * @return
     */
    @Override
    protected int bindLayout() {
        return R.layout.fragment_messenger;
    }
    private Messenger messenger;
    private ServiceConnection mConnection=new ServiceConnection(){
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            messenger = new Messenger(iBinder);
        }
        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
    /**
     * UI显示方法，必须在子类onCreateView方法内调用
     */
    @Override
    public void initView() {
        Intent intent = new Intent(activity, MessengerService.class);
        activity.bindService(intent,mConnection, Context.BIND_AUTO_CREATE);
    }

    /**
     * data数据方法，必须在子类onCreateView方法内调用
     */
    @Override
    public void initData() {

    }

    /**
     * listener事件监听方法，必须在子类onCreateView方法内调用
     */
    @Override
    public void initListener() {

    }

    @Override
    public void onDestroyView() {
        activity.unbindService(mConnection);
        super.onDestroyView();
    }

    @OnClick({R.id.bt_send, R.id.ll_content})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_send:
                String content = etPut.getText().toString();
                Message msg=Message.obtain(null,MessengerService.MSG_FROM_CLIENT);
                Bundle data = new Bundle();
                data.putString("msg",content);
                msg.setData(data);
                msg.replyTo=mGetReply;
                try {
                    messenger.send(msg);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                putContent("客户端："+content);
                break;
            case R.id.ll_content:
                break;
        }
    }
    /**
     * 显示内容
     * @param content
     */
    public void putContent(String content) {
        TextView tv = new TextView(activity);
        tv.setText(content);
        llContent.addView(tv);
    }
    /**
     * 接收处理服务端消息
     */
    private Messenger mGetReply= new Messenger(new MessengerHandler());
    private class MessengerHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case MessengerService.MSG_FROM_SERVICE:
                    putContent(msg.getData().getString("reply"));
                    break;
            }
            super.handleMessage(msg);
        }
    }
}
