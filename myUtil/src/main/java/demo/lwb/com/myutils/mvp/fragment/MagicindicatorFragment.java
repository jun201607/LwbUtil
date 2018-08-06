package demo.lwb.com.myutils.mvp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import butterknife.OnClick;
import butterknife.Unbinder;
import demo.lwb.com.myutils.R;
import demo.lwb.com.myutils.base.BaseFragment;
import demo.lwb.com.myutils.mvp.presenter.BasePresenter;
import demo.lwb.com.myutils.viewpageindicator.BadgeTabExampleActivity;
import demo.lwb.com.myutils.viewpageindicator.CustomNavigatorExampleActivity;
import demo.lwb.com.myutils.viewpageindicator.DynamicTabExampleActivity;
import demo.lwb.com.myutils.viewpageindicator.FixedTabExampleActivity;
import demo.lwb.com.myutils.viewpageindicator.FragmentContainerExampleActivity;
import demo.lwb.com.myutils.viewpageindicator.LoadCustomLayoutExampleActivity;
import demo.lwb.com.myutils.viewpageindicator.NoTabOnlyIndicatorExampleActivity;
import demo.lwb.com.myutils.viewpageindicator.ScrollableTabExampleActivity;

/**
 * Created by lwb on 2018/6/7.
 */

public class MagicindicatorFragment extends BaseFragment {
    Unbinder unbinder;

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
        return R.layout.fragment_magicindicator;
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


    @OnClick({R.id.scrollable_tab, R.id.fixed_tab, R.id.dynamic_tab, R.id.no_tab_only_indicator, R.id.work_with_fragment_container, R.id.tab_with_badge_view, R.id.load_custom_layout, R.id.custom_navigator})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.scrollable_tab:
                startActivity(new Intent(getContext(), ScrollableTabExampleActivity.class));
                break;
            case R.id.fixed_tab:
                startActivity(new Intent(getContext(), FixedTabExampleActivity.class));
                break;
            case R.id.dynamic_tab:
                startActivity(new Intent(getContext(), DynamicTabExampleActivity.class));
                break;
            case R.id.no_tab_only_indicator:
                startActivity(new Intent(getContext(), NoTabOnlyIndicatorExampleActivity.class));
                break;
            case R.id.work_with_fragment_container:
                startActivity(new Intent(getContext(), BadgeTabExampleActivity.class));
                break;
            case R.id.tab_with_badge_view:
                startActivity(new Intent(getContext(), FragmentContainerExampleActivity.class));
                break;
            case R.id.load_custom_layout:
                startActivity(new Intent(getContext(), LoadCustomLayoutExampleActivity.class));
                break;
            case R.id.custom_navigator:
                startActivity(new Intent(getContext(), CustomNavigatorExampleActivity.class));
                break;
        }
    }
}
