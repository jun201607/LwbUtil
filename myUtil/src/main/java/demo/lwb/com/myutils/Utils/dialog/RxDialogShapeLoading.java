package demo.lwb.com.myutils.Utils.dialog;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import demo.lwb.com.myutils.R;
import demo.lwb.com.myutils.Utils.MyUtils;
import demo.lwb.com.myutils.Utils.dialog.shapeloadingview.RxShapeLoadingView;

/**
 * @author Vondear
 * @date 2017/3/16
 */

public class RxDialogShapeLoading extends RxDialog {

    private RxShapeLoadingView mLoadingView;
    private View mDialogContentView;

    public RxDialogShapeLoading(Context context, int themeResId) {
        super(context, themeResId);
        initView(context);
    }

    public RxDialogShapeLoading(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        initView(context);
    }

    public RxDialogShapeLoading(Context context) {
        super(context);
        initView(context);
    }

    public RxDialogShapeLoading(Activity context) {
        super(context);
        initView(context);
    }

    public RxDialogShapeLoading(Context context, float alpha, int gravity) {
        super(context, alpha, gravity);
        initView(context);
    }

    private void initView(Context context) {
        mDialogContentView = LayoutInflater.from(context).inflate(R.layout.dialog_shape_loading_view, null);
        mLoadingView = mDialogContentView.findViewById(R.id.loadView);
        setContentView(mDialogContentView);
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

    public void setLoadingText(CharSequence charSequence) {
        mLoadingView.setLoadingText(charSequence);
    }

    public RxShapeLoadingView getLoadingView() {
        return mLoadingView;
    }

    public View getDialogContentView() {
        return mDialogContentView;
    }

    public enum RxCancelType {normal, error, success, info}
}
