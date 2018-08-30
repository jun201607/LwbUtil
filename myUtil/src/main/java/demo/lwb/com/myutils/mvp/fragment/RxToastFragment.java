package demo.lwb.com.myutils.mvp.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import butterknife.OnClick;
import demo.lwb.com.myutils.R;
import demo.lwb.com.myutils.Utils.RxToast;
import demo.lwb.com.myutils.base.BaseFragment;
import demo.lwb.com.myutils.mvp.presenter.BasePresenter;

/**
 * RxToat 来自Rxtools
 */
public class RxToastFragment extends BaseFragment {
    @Override
    public void setMiddleTitle() {

    }

    @Override
    protected BasePresenter bindPresenter() {
        return null;
    }

    @Override
    protected int bindLayout() {
        return R.layout.fragment_rxtoast;
    }

    @Override
    public void initView() {

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
    @OnClick({ R.id.button_error_toast, R.id.button_success_toast, R.id.button_info_toast, R.id.button_warning_toast, R.id.button_normal_toast_wo_icon, R.id.button_normal_toast_w_icon, R.id.activity_main})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.button_error_toast:
                RxToast.error(getActivity(), "这是一个提示错误的Toast！", Toast.LENGTH_SHORT, true).show();
                break;
            case R.id.button_success_toast:
                RxToast.success(getActivity(), "这是一个提示成功的Toast!", Toast.LENGTH_SHORT, true).show();
                break;
            case R.id.button_info_toast:
                RxToast.info(getActivity(), "这是一个提示信息的Toast.", Toast.LENGTH_SHORT, true).show();
                break;
            case R.id.button_warning_toast:
                RxToast.warning(getActivity(), "这是一个提示警告的Toast.", Toast.LENGTH_SHORT, true).show();
                break;
            case R.id.button_normal_toast_wo_icon:
                RxToast.normal(getActivity(), "这是一个普通的没有ICON的Toast");
                break;
            case R.id.button_normal_toast_w_icon:
                Drawable icon = getResources().getDrawable(R.mipmap.set);
                RxToast.normal(getActivity(), "这是一个普通的包含ICON的Toast", icon);
                break;
            case R.id.activity_main:
                break;
        }
    }
}
