package demo.lwb.com.myutils.mvp.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.Unbinder;
import demo.lwb.com.myutils.R;
import demo.lwb.com.myutils.Utils.LogUtils;
import demo.lwb.com.myutils.base.BaseFragment;
import demo.lwb.com.myutils.mvp.message.MessageEvent;
import demo.lwb.com.myutils.mvp.presenter.BasePresenter;
import demo.lwb.com.myutils.mvp.presenter.HomeTab1Presenter;

/**
 * Created by lwb on 2017/12/28.
 * TODO EventBus
 * https://www.jianshu.com/p/da9e193e8b03
 * https://github.com/greenrobot/EventBus
 */

public class EventBusFragment extends BaseFragment {

    @BindView(R.id.btn_EventBus)
    Button btnEventBus;
    @BindView(R.id.tv_EventBus)
    TextView tvEventBus;
    Unbinder unbinder;
    private Bundle arguments;


    @Override
    public void initView() {
        EventBus.getDefault().register(this);

        btnEventBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LogUtils.e("发布事件");
                EventBus.getDefault().post(new MessageEvent("接收事件"));
            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {

    }


    @Override
    public void setMiddleTitle() {

    }

    @Override
    protected BasePresenter bindPresenter() {
        return null;
    }

    @Override
    protected int bindLayout() {
        return R.layout.fragment_eventbus;
    }

    @Override
    public void popBackListener(int returnCode, Bundle bundle) {

    }

    //如果使用onEventMainThread作为订阅函数，那么不论事件是在哪个线程中发布出来的，onEventMainThread都会在UI线程中执行，接收事件就会在UI线程中运行，
    //这个在Android中是非常有用的，因为在Android中只能在UI线程中跟新UI，所以在onEvnetMainThread方法中是不能执行耗时操作的。
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(MessageEvent messageEvent) {
        LogUtils.e("onEventMainThread" + messageEvent.getMessage());
        tvEventBus.setText(messageEvent.getMessage());
    }

    //如果使用onEvent作为订阅函数，那么该事件在哪个线程发布出来的，onEvent就会在这个线程中运行，也就是说发布事件和接收事件线程在同一个线程。
    //使用这个方法时，在onEvent方法中不能执行耗时操作，如果执行耗时操作容易导致事件分发延迟。
    @Subscribe(threadMode = ThreadMode.POSTING)
    public void onEventPostThread(MessageEvent messageEvent) {
        LogUtils.e("onEventPostThread" + messageEvent.getMessage());
        tvEventBus.setText(messageEvent.getMessage());
    }

    //如果使用onEventBackgrond作为订阅函数，那么如果事件是在UI线程中发布出来的，那么onEventBackground就会在子线程中运行，如果事件本来就是子线程中发布出来的，那么onEventBackground函数直接在该子线程中执行。
    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onEventBackgroundThread(MessageEvent messageEvent) {
        LogUtils.e("onEventBackgroundThread" + messageEvent.getMessage());
        tvEventBus.setText(messageEvent.getMessage());
    }

    //使用这个函数作为订阅函数，那么无论事件在哪个线程发布，都会创建新的子线程在执行onEventAsync.
    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void onEventAsync(MessageEvent messageEvent) {
        LogUtils.e("onEventAsync" + messageEvent.getMessage());
        tvEventBus.setText(messageEvent.getMessage());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


}
