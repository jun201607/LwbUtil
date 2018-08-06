package demo.lwb.com.myutils.mvp.fragment;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import butterknife.BindView;
import demo.lwb.com.myutils.R;
import demo.lwb.com.myutils.adapter.TestFragPagerAdapter;
import demo.lwb.com.myutils.base.BaseFragment;
import demo.lwb.com.myutils.mvp.presenter.BasePresenter;
import demo.lwb.com.myutils.wight.JellyViewPager.JellyViewPager;

/**
 * Created by lwb on 2018/6/13.
 */

public class JellyViewPagerFragment extends BaseFragment {
    @BindView(R.id.jellyViewPager)
    JellyViewPager jellyViewPager;

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
        return R.layout.fragment_jelly_viewpager;
    }

    /**
     * UI显示方法，必须在子类onCreateView方法内调用
     */
    @Override
    public void initView() {
        jellyViewPager.setAdapter(new TestFragPagerAdapter(getActivity().getSupportFragmentManager()));
        jellyViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrollStateChanged(int state) {
                switch (state) {
                    case 1: //正在滑动
                        break;
                    case 2: //滑动结束
                        break;
                }
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageSelected(int arg0) {
            }

        });
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
