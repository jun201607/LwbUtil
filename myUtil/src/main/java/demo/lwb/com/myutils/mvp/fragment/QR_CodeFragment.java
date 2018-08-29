package demo.lwb.com.myutils.mvp.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import demo.lwb.com.myutils.R;
import demo.lwb.com.myutils.Utils.MyUtils;
import demo.lwb.com.myutils.Utils.PermissionUtils;
import demo.lwb.com.myutils.Utils.StringUtil;
import demo.lwb.com.myutils.Utils.camera.RxBarCode;
import demo.lwb.com.myutils.Utils.camera.RxQRCode;
import demo.lwb.com.myutils.base.BaseFragment;
import demo.lwb.com.myutils.manager.FramentManages;
import demo.lwb.com.myutils.mvp.presenter.BasePresenter;
import demo.lwb.com.myutils.mvp.presenter.HomeTab1Presenter;

public class QR_CodeFragment extends BaseFragment {
    @BindView(R.id.btn_scan_code)
    Button btnScanCode;
    @BindView(R.id.btn_qr_code)
    Button btnQrCode;
    @BindView(R.id.btn_bar_code)
    Button btnBarCode;
    @BindView(R.id.et_contain)
    EditText et_contain;
    @BindView(R.id.img_Qr)
    ImageView img_Qr;
    @BindView(R.id.tv_time_second)
    TextView tv_time_second;

    @BindView(R.id.img_dyn_qr)
    ImageView img_dyn_qr;
    private static android.os.Handler Handler = new Handler();
    private static Runnable mRunnable = null;
    private int second = 60;
    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 60000:
                    initData();
                    break;
                default:
                    break;
            }
        }
    };
    @Override
    public void setMiddleTitle() {

    }

    @Override
    protected BasePresenter bindPresenter() {
        return null;
    }

    @Override
    protected int bindLayout() {
        return R.layout.fragment_qr_code;
    }

    @Override
    public void initView() {
        AuthCode(tv_time_second, second);
    }

    private void AuthCode(final TextView view, final int timeSecond) {
        mRunnable = new Runnable() {
            int mSumNum = timeSecond;
            @Override
            public void run() {
                Handler.postDelayed(mRunnable, 1000);
                view.setText(mSumNum + "");
                view.setEnabled(false);
                mSumNum--;
                if (mSumNum < 0) {
                    view.setText(0 + "");
                    view.setEnabled(true);
                    Message message = new Message();
                    message.what = 60000;
                    mHandler.sendMessage(message);
                    // 干掉这个定时器，下次减不会累加
                    Handler.removeCallbacks(mRunnable);
                    AuthCode(tv_time_second, second);
                }
            }
        };
        Handler.postDelayed(mRunnable, 1000);
    }
    @Override
    public void initData() {
    }

    @Override
    public void initListener() {

    }

    @Override
    public void popBackListener(int returnCode, Bundle bundle) {

    }

    private int ResultCamera = 1 ;
    @OnClick({R.id.btn_scan_code, R.id.btn_qr_code, R.id.btn_bar_code,R.id.ll_refresh})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_scan_code:
                /**
                 * 来自rxTool  慎用 代码量庞大
                 */
                if (PermissionUtils.checkPersmission(getActivity(), PermissionUtils.CAMERA)) {
                    addFrament(R.id.fr_contain, FramentManages.Scan_Code, null, true);
                }else{
                    PermissionUtils.requestPermissions(getActivity(), new String[]{PermissionUtils.CAMERA}, ResultCamera);
                }
                break;
            case R.id.btn_qr_code:
                initQrCode();
                //动态
                RxQRCode.createQRCode("时间戳:" + System.currentTimeMillis(), 800, 800, img_dyn_qr);
                break;
            case R.id.btn_bar_code:
                initBarCode();
                //动态
                img_dyn_qr.setImageBitmap(RxBarCode.createBarCode("" + System.currentTimeMillis(), 1000, 300));
                break;
            case R.id.ll_refresh:
                Handler.removeCallbacks(mRunnable);
                initData();
                tv_time_second.setText(second + "");
                AuthCode(tv_time_second, second);
                break;
        }
    }

    /**
     * 扫描二维码
     */
    private void initQrCode() {
        String str = et_contain.getText().toString();
        if (StringUtil.isNullString(str)) {
            MyUtils.toast("二维码文字内容不能为空！");
        } else {
            //二维码生成方式一  推荐此方法
            RxQRCode.builder(str).
                    backColor(0xFFFFFFFF).
                    codeColor(0xFF000000).
                    codeSide(600).
                    into(img_Qr);

            //二维码生成方式二 默认宽和高都为800 背景为白色 二维码为黑色
            // RxQRCode.createQRCode(str,mIvQrCode);

            img_Qr.setVisibility(View.VISIBLE);
        }
    }
    /**
     * 扫描条形码
     */
    private void initBarCode() {
        String str1 = et_contain.getText().toString();
        if (StringUtil.isNullString(str1)) {
            MyUtils.toast("条形码文字内容不能为空！");
        } else {
            //条形码生成方式一  推荐此方法
            RxBarCode.builder(str1).
                    backColor(0x00000000).
                    codeColor(0xFF000000).
                    codeWidth(1000).
                    codeHeight(300).
                    into(img_Qr);

            //条形码生成方式二  默认宽为1000 高为300 背景为白色 二维码为黑色
            //mIvBarCode.setImageBitmap(RxBarCode.createBarCode(str1, 1000, 300));
            img_Qr.setVisibility(View.VISIBLE);
        }
    }
}
