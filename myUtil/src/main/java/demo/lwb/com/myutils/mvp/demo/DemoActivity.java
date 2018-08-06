/*Copyright ©2015 TommyLemon(https://github.com/TommyLemon)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.*/

package demo.lwb.com.myutils.mvp.demo;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import demo.lwb.com.myutils.R;
import demo.lwb.com.myutils.Utils.LogUtils;
import demo.lwb.com.myutils.adapter.ViewPagerHomeAdapter;
import demo.lwb.com.myutils.base.BaseFragmentActivity;
import demo.lwb.com.myutils.mvp.presenter.BasePresenter;

/**
 * 使用方法：复制>粘贴>改名>改代码
 * activity示例；如果是FragmentActivity应该继承BaseFragmentActivity
 * @warn 复制到其它工程内使用时务必修改import R文件路径为所在应用包名
 * @use toActivity(DemoActivity.createIntent(...));
 */
public class DemoActivity extends BaseFragmentActivity implements View.OnClickListener {
    private static final String TAG = "DemoActivity";
    public static final String INTENT_DemoActivity = "DemoActivity";
    private static final int READ_EXTERNAL_STORAGE = 1;
    private ImageView[] mBorderimageViews;  //外部的边框
    private TextView[] mTitleViews;
    //灰色以及相对应的RGB值
    private int mGrayColor;
    private int mGrayRed;
    private int mGrayGreen;
    private int mGrayBlue;
    //绿色以及相对应的RGB值
    private int mGreenColor;
    private int mGreenRed;
    private int mGreenGreen;
    private int mGreenBlue;
    private ViewPager pagerView;

    /**
     * 启动这个Activity的Intent
     *
     * @param context
     * @return
     */
    public static Intent createIntent(Context context) {
        return new Intent(context, DemoActivity.class);
    }

    /**
     * 启动这个Activity的Intent 带参数
     *
     * @param context
     * @return
     */
    public static Intent createIntent(Context context, String arg) {
        return new Intent(context, DemoActivity.class).putExtra(INTENT_DemoActivity, arg);
    }

    /**
     * 启动这个Activity的Intent 带参数
     *
     * @param context
     * @return
     */
    public static Intent createIntent(Context context, ArrayList<String> phoneList) {
        return new Intent(context, DemoActivity.class).putExtra(INTENT_DemoActivity, phoneList);
    }


    @Override
    protected BasePresenter bindPresenter() {
        return null;
    }

    @Override
    protected void initUI() {
        requestPermission();
        initView();
        initData();
        initListener();
    }

    public void initView() {
        initColor();
        //底部图标
        initBottomUI();
        //内容
        //初始化viewPage
        initViewPage();


    }

    /**
     * 初始化viewPage
     */
    private void initViewPage() {
        ViewPagerHomeAdapter adapter = new ViewPagerHomeAdapter(getSupportFragmentManager());
        pagerView.setAdapter(adapter);
        setSelection(0);
        pagerView.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (positionOffset > 0) {
                    if (positionOffset < 0.5) {
                        //  滑动到一半前，上一页的边框保持绿色不变，下一页的边框由灰色变为绿色
                        mBorderimageViews[position].setColorFilter(mGreenColor, PorterDuff.Mode.SRC_IN);
                        mBorderimageViews[position + 1].setColorFilter(getGrayToGreen(positionOffset), PorterDuff.Mode.SRC_IN);
                        //   上一页的内容保持由实心变为透明，下一页的内容保持透明
//                        mContentImageViews[position].setAlpha((1 - 2 * positionOffset));
//                        mContentImageViews[position + 1].setAlpha(0f);
                        //文字颜色变化
                        mTitleViews[position].setTextColor(mGreenColor);
                        mTitleViews[position + 1].setTextColor(getGrayToGreen(positionOffset));

                    } else {
                        //滑动到一半后，上一页的边框由绿变为灰色，，下一页边框保持绿色不变
                        mBorderimageViews[position].setColorFilter(getGreenToGray(positionOffset), PorterDuff.Mode.SRC_IN);
                        mBorderimageViews[position + 1].setColorFilter(mGreenColor, PorterDuff.Mode.SRC_IN);
                        //上一页的内容保持透明，下一页的内容由透明变为实心绿色
//                        mContentImageViews[position].setAlpha(0f);
//                        mContentImageViews[position + 1].setAlpha(2 * positionOffset - 1);
                        mTitleViews[position].setTextColor(getGreenToGray(positionOffset));
                        mTitleViews[position + 1].setTextColor(mGreenColor);
                    }
                }
            }

            @Override
            public void onPageSelected(int position) {
                setSelection(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * 底部图标
     */
    private void initBottomUI() {
        pagerView = (ViewPager) findViewById(R.id.pager_view);
        ImageView img_tab1 = (ImageView) findViewById(R.id.img_tab1);
        ImageView img_tab2 = (ImageView) findViewById(R.id.img_tab2);
        ImageView img_tab3 = (ImageView) findViewById(R.id.img_tab3);
        TextView tv_tab1 = (TextView) findViewById(R.id.tv_tab1);
        TextView tv_tab2= (TextView) findViewById(R.id.tv_tab2);
        TextView tv_tab3 = (TextView) findViewById(R.id.tv_tab3);
        LinearLayout ll_bottom_util = (LinearLayout) findViewById(R.id.ll_bottom_util);
        LinearLayout ll_bottom_view = (LinearLayout) findViewById(R.id.ll_bottom_view);
        LinearLayout ll_bottom_other = (LinearLayout) findViewById(R.id.ll_bottom_other);
        ll_bottom_util.setOnClickListener(this);
        ll_bottom_view.setOnClickListener(this);
        ll_bottom_other.setOnClickListener(this);
        mBorderimageViews = new ImageView[]{img_tab1, img_tab2, img_tab3};
        //底部标题
        mTitleViews = new TextView[]{tv_tab1, tv_tab2, tv_tab3};
    }

    /**
     * 设置索引  当前导航页边框绿色，内容实心绿，其他页边框灰色，内容透明
     *
     * @param position
     */
    private void setSelection(int position) {
        for (int i = 0; i < mBorderimageViews.length; i++) {
            if (i == position) {
                mBorderimageViews[i].setColorFilter(mGreenColor, PorterDuff.Mode.SRC_IN);
                mTitleViews[i].setTextColor(mGreenColor);
            } else {
                mBorderimageViews[i].setColorFilter(mGrayColor, PorterDuff.Mode.SRC_IN);
                mTitleViews[i].setTextColor(mGrayColor);
            }
        }
    }

    private void initColor() {
        mGrayColor = getResources().getColor(R.color.gray);
        mGrayRed = Color.red(mGrayColor);
        mGrayGreen = Color.green(mGrayColor);
        mGrayBlue = Color.blue(mGrayColor);
        mGreenColor = getResources().getColor(R.color.green);
        mGreenRed = Color.red(mGreenColor);
        mGreenGreen = Color.green(mGreenColor);
        mGreenBlue = Color.blue(mGreenColor);
    }

    /**
     * 偏移量在 0——0.5区间 ，左边一项颜色不变，右边一项颜色从灰色变为绿色，根据两点式算出RGB变化函数，组合出颜色
     *
     * @param positionOffset
     * @return
     */
    private int getGrayToGreen(float positionOffset) {
        int red = (int) (positionOffset * (mGreenRed - mGrayRed) * 2 + mGrayRed);
        int green = (int) (positionOffset * (mGreenGreen - mGrayGreen) * 2 + mGrayGreen);
        int blue = (int) ((positionOffset) * (mGreenBlue - mGrayBlue) * 2 + mGrayBlue);
        return Color.argb(255, red, green, blue);
    }

    /**
     * 偏移量在 0.5--1 区间，颜色从绿色变成灰色，根据两点式算出变化RGB随偏移量变化函数，组合出颜色
     *
     * @param positionOffset
     * @return
     */
    private int getGreenToGray(float positionOffset) {
        int red = (int) (positionOffset * (mGrayRed - mGreenRed) * 2 + 2 * mGreenRed - mGrayRed);
        int green = (int) (positionOffset * (mGrayGreen - mGreenGreen) * 2 + 2 * mGreenGreen - mGrayGreen);
        int blue = (int) (positionOffset * (mGrayBlue - mGreenBlue) * 2 + 2 * mGreenBlue - mGrayBlue);
        return Color.argb(255, red, green, blue);
    }


    public void initData() {

    }

    @Override
    protected int bindLayout() {
        return R.layout.demo_activity;
    }


    public void initListener() {

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_bottom_util:
                pagerView.setCurrentItem(0);
                break;
            case R.id.ll_bottom_view:
                pagerView.setCurrentItem(1);
                break;
            case R.id.ll_bottom_other:
                pagerView.setCurrentItem(2);
                break;
        }
    }

    private boolean exit=false;
    Handler handler= new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what==1){
                exit=false;
            }
        }
    };
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {

        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
             if(!exit){
                 exit=true;
                 handler.sendEmptyMessageDelayed(1,2000);
                 return true;
             }
                break;
            default:
                break;
        }
        return super.onKeyUp(keyCode, event);
    }

    private void requestPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            // 第一次请求权限时，用户如果拒绝，下一次请求shouldShowRequestPermissionRationale()返回true
            // 向用户解释为什么需要这个权限
            //申请相机权限
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, READ_EXTERNAL_STORAGE);
        }else {

        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == READ_EXTERNAL_STORAGE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            } else {
                //用户勾选了不再询问
                //提示用户手动打开权限
                if (!ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
                    Toast.makeText(this, "读取权限取消", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}