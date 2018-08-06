package demo.lwb.com.myutils.mvp.fragment;

import android.net.Uri;
import android.os.Bundle;

import demo.lwb.com.myutils.R;
import demo.lwb.com.myutils.base.BaseFragment;
import demo.lwb.com.myutils.mvp.presenter.BasePresenter;

/**
 * Created by lwb on 2018/4/18.
 * 使用ContentProvider跨进程通信
 */

public class ContentProviderFragment extends BaseFragment {
    /**
     * Frament退栈监听
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
        return R.layout.fragment_content_provider;
    }

    /**
     * UI显示方法，必须在子类onCreateView方法内调用
     */
    @Override
    public void initView() {

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
}
