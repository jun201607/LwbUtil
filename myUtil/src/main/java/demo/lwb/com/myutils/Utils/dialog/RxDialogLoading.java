package demo.lwb.com.myutils.Utils.dialog;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import demo.lwb.com.myutils.R;
import demo.lwb.com.myutils.Utils.MyUtils;

/**
 * @author Vondear
 * @date 2017/3/16
 */

public class RxDialogLoading extends RxDialog {

    private ProgressBar mLoadingView;
    private View mDialogContentView;
    private TextView mTextView;

    public RxDialogLoading(Context context, int themeResId) {
        super(context, themeResId);
        initView(context);
    }

    public RxDialogLoading(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        initView(context);
    }

    public RxDialogLoading(Context context) {
        super(context);
        initView(context);
    }

    public RxDialogLoading(Activity context) {
        super(context);
        initView(context);
    }

    public RxDialogLoading(Context context, float alpha, int gravity) {
        super(context, alpha, gravity);
        initView(context);
    }

    private void initView(Context context) {
        mDialogContentView = LayoutInflater.from(context).inflate(R.layout.dialog_loading_spinkit, null);
        mLoadingView = mDialogContentView.findViewById(R.id.spin_kit);
        mTextView = mDialogContentView.findViewById(R.id.name);
        setContentView(mDialogContentView);
    }

    public void setLoadingText(CharSequence charSequence) {
        mTextView.setText(charSequence);
    }


    public void cancel(RxCancelType code, String str) {
        cancel();
        switch (code) {
            case normal:
                MyUtils.toast(str);
                break;
            case error:
                MyUtils.toast(str);
                break;
            case success:
                MyUtils.toast(str);
                break;
            case info:
                MyUtils.toast(str);
                break;
            default:
                MyUtils.toast(str);
                break;
        }
    }

    public void cancel(String str) {
        cancel();
        MyUtils.toast(str);
    }

    public ProgressBar getLoadingView() {
        return mLoadingView;
    }

    public View getDialogContentView() {
        return mDialogContentView;
    }

    public TextView getTextView() {
        return mTextView;
    }

    public enum RxCancelType {normal, error, success, info}
}
