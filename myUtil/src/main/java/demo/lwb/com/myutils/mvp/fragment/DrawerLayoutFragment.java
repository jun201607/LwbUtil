package demo.lwb.com.myutils.mvp.fragment;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.widget.Button;

import butterknife.BindView;
import butterknife.OnClick;
import demo.lwb.com.myutils.R;
import demo.lwb.com.myutils.base.BaseFragment;
import demo.lwb.com.myutils.mvp.presenter.BasePresenter;

/**
 * Created by lwb on 2018/3/28.
 * 滑动菜单栏
 */

public class DrawerLayoutFragment extends BaseFragment {
    @BindView(R.id.btn_start)
    Button btnStart;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

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
        return R.layout.fragment_drawerlayout;
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

    @OnClick(R.id.btn_start)
    public void onViewClicked() {
        drawerLayout.openDrawer(GravityCompat.START);
//        drawerLayout.closeDrawer(GravityCompat.START);
    }
}
