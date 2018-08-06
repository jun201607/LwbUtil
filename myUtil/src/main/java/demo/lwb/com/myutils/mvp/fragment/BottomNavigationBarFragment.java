package demo.lwb.com.myutils.mvp.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.ashokvarma.bottomnavigation.ShapeBadgeItem;
import com.ashokvarma.bottomnavigation.TextBadgeItem;
import butterknife.BindView;
import demo.lwb.com.myutils.R;
import demo.lwb.com.myutils.Utils.LogUtils;
import demo.lwb.com.myutils.base.BaseFragment;
import demo.lwb.com.myutils.mvp.presenter.BasePresenter;

/**
 * Created by lwb on 2018/5/2.
 * 底部导航栏BottomNavigationBar
 */

public class BottomNavigationBarFragment extends BaseFragment {

    @BindView(R.id.bottomNavigationBar)
    BottomNavigationBar bottomNavigationBar;
    @BindView(R.id.bottomNavigationView)
    BottomNavigationView bottomNavigationView;

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
        return R.layout.fragment_bottom_navigation_bar;
    }

    /**
     * UI显示方法，必须在子类onCreateView方法内调用
     */
    @Override
    public void initView() {
        bottomNavigationBar();
        bottomNavigationView();
    }

    private void bottomNavigationBar() {
        //小图标
        ShapeBadgeItem mShapeBadgeItem = new ShapeBadgeItem()
                .setShapeColorResource(R.color.colorPrimary)
                .setGravity(Gravity.TOP | Gravity.END)
                .setHideOnSelect(false);
        //消息小图标
        TextBadgeItem mTextBadgeItem = new TextBadgeItem()
                .setBorderWidth(4)
                .setBackgroundColorResource(R.color.colorAccent)
                .setAnimationDuration(200)
                .setText("3")
                .setHideOnSelect(false);
        //设置模式 是否有换挡动画
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_SHIFTING );
        //设置是否有水波纹效果
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);
        //选中颜色 图标和文字
        bottomNavigationBar.setActiveColor(R.color.blue);
        //设置图片与文字item1
        BottomNavigationItem bottomNavigationItem = new BottomNavigationItem(R.mipmap.ic_launcher, "工具");
        bottomNavigationItem.setInactiveIcon(ContextCompat.getDrawable(activity,R.mipmap.img_util));
        bottomNavigationItem.setBadgeItem(mShapeBadgeItem);
        //设置图片与文字item2
        BottomNavigationItem bottomNavigationItem2 = new BottomNavigationItem(R.mipmap.ic_launcher, "View");
        bottomNavigationItem2.setInactiveIcon(ContextCompat.getDrawable(activity,R.mipmap.img_view));
        bottomNavigationItem2.setBadgeItem(mTextBadgeItem);
        //设置图片与文字item3
        BottomNavigationItem bottomNavigationItem3 = new BottomNavigationItem(R.mipmap.ic_launcher, "其他");
        bottomNavigationItem3.setInactiveIcon(ContextCompat.getDrawable(activity,R.mipmap.img_other));
        bottomNavigationItem3.setBadgeItem(mTextBadgeItem);
        //设置图片与文字item4
        BottomNavigationItem bottomNavigationItem4 = new BottomNavigationItem(R.mipmap.ic_launcher, "Item");
        bottomNavigationItem4.setInactiveIcon(ContextCompat.getDrawable(activity,R.mipmap.img_other));
        bottomNavigationItem4.setBadgeItem(mTextBadgeItem);
        //添加item
        bottomNavigationBar.addItem(bottomNavigationItem);
        bottomNavigationBar.addItem(bottomNavigationItem2);
        bottomNavigationBar.addItem(bottomNavigationItem3);
        bottomNavigationBar.addItem(bottomNavigationItem4);
        //设置默认选中按钮
        bottomNavigationBar.setFirstSelectedPosition(0);
        //所有的设置需在调用该方法前完成
        bottomNavigationBar.initialise();
        //设置Tab点击事件
        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) { //未选中 -> 选中
                LogUtils.e("onTabSelected"+position);
            }
            @Override
            public void onTabUnselected(int position) { //选中 -> 未选中
                LogUtils.e("onTabUnselected"+position);
            }
            @Override
            public void onTabReselected(int position) { //选中 -> 选中
                LogUtils.e("onTabReselected"+position);
            }
        });
    }

    private void bottomNavigationView() {
        //设置默认选中item
        bottomNavigationView.getMenu().getItem(1).setChecked(true);
        //设置导航条目选中监听
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item_bottom_1:
                        Toast.makeText(activity, activity.getString(R.string.Util), Toast.LENGTH_SHORT);
                        break;
                    case R.id.item_bottom_2:
                        Toast.makeText(activity, "View", Toast.LENGTH_SHORT);
                        break;
                    case R.id.item_bottom_3:
                        Toast.makeText(activity, activity.getString(R.string.other), Toast.LENGTH_SHORT);
                        break;
                }
                return true;
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
