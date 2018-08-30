package demo.lwb.com.myutils.mvp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import demo.lwb.com.myutils.R;
import demo.lwb.com.myutils.Utils.dialog.RxDialog;
import demo.lwb.com.myutils.Utils.dialog.RxDialogAcfunVideoLoading;
import demo.lwb.com.myutils.Utils.dialog.RxDialogEditSureCancel;
import demo.lwb.com.myutils.Utils.dialog.RxDialogLoading;
import demo.lwb.com.myutils.Utils.dialog.RxDialogScaleView;
import demo.lwb.com.myutils.Utils.dialog.RxDialogShapeLoading;
import demo.lwb.com.myutils.Utils.dialog.RxDialogSure;
import demo.lwb.com.myutils.Utils.dialog.RxDialogSureCancel;
import demo.lwb.com.myutils.Utils.dialog.RxDialogWheelYearMonthDay;
import demo.lwb.com.myutils.base.BaseFragment;
import demo.lwb.com.myutils.mvp.presenter.BasePresenter;

/**
 * 常用dialog 来自RxTool
 */
public class Common_DialogFragment extends BaseFragment {
    @BindView(R.id.button_tran)
    Button buttonTran;
    @BindView(R.id.button_DialogSure)
    Button buttonDialogSure;
    @BindView(R.id.button_DialogSureCancle)
    Button buttonDialogSureCancle;
    @BindView(R.id.button_DialogEditTextSureCancle)
    Button buttonDialogEditTextSureCancle;
    @BindView(R.id.button_DialogWheelYearMonthDay)
    Button buttonDialogWheelYearMonthDay;
    @BindView(R.id.button_DialogShapeLoading)
    Button buttonDialogShapeLoading;
    @BindView(R.id.button_DialogLoadingProgressAcfunVideo)
    Button buttonDialogLoadingProgressAcfunVideo;
    @BindView(R.id.button_DialogLoadingspinkit)
    Button buttonDialogLoadingspinkit;
    @BindView(R.id.button_DialogScaleView)
    Button buttonDialogScaleView;
    @BindView(R.id.activity_dialog)
    LinearLayout activityDialog;
    private RxDialogWheelYearMonthDay mRxDialogWheelYearMonthDay;

    @Override
    public void setMiddleTitle() {

    }

    @Override
    protected BasePresenter bindPresenter() {
        return null;
    }

    @Override
    protected int bindLayout() {
        return R.layout.fragment_dialog;
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

    @OnClick({R.id.button_tran, R.id.button_DialogSure, R.id.button_DialogSureCancle, R.id.button_DialogEditTextSureCancle, R.id.button_DialogWheelYearMonthDay, R.id.button_DialogShapeLoading, R.id.button_DialogLoadingProgressAcfunVideo, R.id.button_DialogLoadingspinkit, R.id.button_DialogScaleView, R.id.activity_dialog})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button_tran://透明的弹窗
                RxDialog rxDialog = new RxDialog(getActivity(), R.style.tran_dialog);
                View view1 = LayoutInflater.from(getContext()).inflate(R.layout.image, null);
                ImageView pageItem = view1.findViewById(R.id.page_item);
                pageItem.setImageResource(R.mipmap.coin);
                rxDialog.setContentView(view1);
                rxDialog.show();
                break;
            case R.id.button_DialogSure: //提示弹窗
                final RxDialogSure rxDialogSure = new RxDialogSure(getActivity());
                rxDialogSure.getLogoView().setImageResource(R.mipmap.logo);
                rxDialogSure.getSureView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        rxDialogSure.cancel();
                    }
                });
                rxDialogSure.show();
                break;
            case R.id.button_DialogSureCancle://确认取消的弹窗
                final RxDialogSureCancel rxDialogSureCancel = new RxDialogSureCancel(getActivity());
                rxDialogSureCancel.getTitleView().setBackgroundResource(R.mipmap.logo);
                rxDialogSureCancel.getSureView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        rxDialogSureCancel.cancel();
                    }
                });
                rxDialogSureCancel.getCancelView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        rxDialogSureCancel.cancel();
                    }
                });
                rxDialogSureCancel.show();
                break;
            case R.id.button_DialogEditTextSureCancle://输入框的弹窗
                final RxDialogEditSureCancel rxDialogEditSureCancel = new RxDialogEditSureCancel(getActivity());
                rxDialogEditSureCancel.getTitleView().setBackgroundResource(R.mipmap.logo);
                rxDialogEditSureCancel.getSureView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        rxDialogEditSureCancel.cancel();
                    }
                });
                rxDialogEditSureCancel.getCancelView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        rxDialogEditSureCancel.cancel();
                    }
                });
                rxDialogEditSureCancel.show();
                break;
            case R.id.button_DialogWheelYearMonthDay://可选择年月(日)
                if (mRxDialogWheelYearMonthDay == null) {
                    initWheelYearMonthDayDialog();
                }
                mRxDialogWheelYearMonthDay.show();
                break;
            case R.id.button_DialogShapeLoading://三种形状的跳跃变换
                RxDialogShapeLoading rxDialogShapeLoading = new RxDialogShapeLoading(getActivity());
                rxDialogShapeLoading.show();
                break;
            case R.id.button_DialogLoadingProgressAcfunVideo://一只可爱的A站舰娘在拼命的奔跑
                new RxDialogAcfunVideoLoading(getActivity()).show();
                break;
            case R.id.button_DialogLoadingspinkit://一个常用加载Dialog
                RxDialogLoading rxDialogLoading = new RxDialogLoading(getActivity());
                rxDialogLoading.show();
                break;
            case R.id.button_DialogScaleView:
                RxDialogScaleView rxDialogScaleView = new RxDialogScaleView(getActivity());
                rxDialogScaleView.setImage(R.mipmap.a);
                rxDialogScaleView.show();
                break;
        }
    }

    private void initWheelYearMonthDayDialog() {
        // ------------------------------------------------------------------选择日期开始
        mRxDialogWheelYearMonthDay = new RxDialogWheelYearMonthDay(getActivity(), 1994, 2018);
        mRxDialogWheelYearMonthDay.getSureView().setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View arg0) {
                        if (mRxDialogWheelYearMonthDay.getCheckBoxDay().isChecked()) {
                            buttonDialogWheelYearMonthDay.setText(
                                    mRxDialogWheelYearMonthDay.getSelectorYear() + "年"
                                            + mRxDialogWheelYearMonthDay.getSelectorMonth() + "月"
                                            + mRxDialogWheelYearMonthDay.getSelectorDay() + "日");
                        } else {
                            buttonDialogWheelYearMonthDay.setText(
                                    mRxDialogWheelYearMonthDay.getSelectorYear() + "年"
                                            + mRxDialogWheelYearMonthDay.getSelectorMonth() + "月");
                        }
                        mRxDialogWheelYearMonthDay.cancel();
                    }
                });
        mRxDialogWheelYearMonthDay.getCancleView().setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View arg0) {
                        mRxDialogWheelYearMonthDay.cancel();
                    }
                });
        // ------------------------------------------------------------------选择日期结束
    }

}
