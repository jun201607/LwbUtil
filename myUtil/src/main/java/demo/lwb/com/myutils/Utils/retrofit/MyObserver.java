package demo.lwb.com.myutils.Utils.retrofit;

import android.app.ProgressDialog;
import android.content.Context;

import demo.lwb.com.myutils.Utils.NetStatusUtils;
import io.reactivex.disposables.Disposable;

/**
 * 加入加载框
 * @param <T>
 */
public abstract class MyObserver<T> extends BaseObserver<T> {
    private boolean mShowDialog;
    private ProgressDialog dialog;
    private Context mContext;
    private Disposable d;

    public MyObserver(Context context, Boolean showDialog) {
        mContext = context;
        mShowDialog = showDialog;
    }

    public MyObserver(Context context) {
        this(context,true);
    }

    @Override
    public void onSubscribe(Disposable d) {
        this.d = d;
        if (!NetStatusUtils.isConnected(mContext)) {
            if (d.isDisposed()) {
                d.dispose();
            }
        } else {
            if (dialog == null && mShowDialog == true) {
                dialog = new ProgressDialog(mContext);
                dialog.setMessage("正在加载中");
                dialog.show();
            }
        }
    }
    @Override
    public void onError(Throwable e) {
        if (d.isDisposed()) {
            d.dispose();
        }
        hidDialog();
        super.onError(e);
    }

    @Override
    public void onComplete() {
        if (d.isDisposed()) {
            d.dispose();
        }
        hidDialog();
        super.onComplete();
    }


    public void hidDialog() {
        if (dialog != null && mShowDialog == true)
            dialog.dismiss();
        dialog = null;
    }
}
