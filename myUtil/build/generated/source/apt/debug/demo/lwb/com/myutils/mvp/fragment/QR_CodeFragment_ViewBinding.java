// Generated code from Butter Knife. Do not modify!
package demo.lwb.com.myutils.mvp.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class QR_CodeFragment_ViewBinding implements Unbinder {
  private QR_CodeFragment target;

  private View view2131755417;

  private View view2131755418;

  private View view2131755419;

  private View view2131755423;

  @UiThread
  public QR_CodeFragment_ViewBinding(final QR_CodeFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, 2131755417, "field 'btnScanCode' and method 'onViewClicked'");
    target.btnScanCode = Utils.castView(view, 2131755417, "field 'btnScanCode'", Button.class);
    view2131755417 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.img_Qr = Utils.findRequiredViewAsType(source, 2131755421, "field 'img_Qr'", ImageView.class);
    target.tv_time_second = Utils.findRequiredViewAsType(source, 2131755424, "field 'tv_time_second'", TextView.class);
    view = Utils.findRequiredView(source, 2131755418, "field 'btnQrCode' and method 'onViewClicked'");
    target.btnQrCode = Utils.castView(view, 2131755418, "field 'btnQrCode'", Button.class);
    view2131755418 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.et_contain = Utils.findRequiredViewAsType(source, 2131755420, "field 'et_contain'", EditText.class);
    view = Utils.findRequiredView(source, 2131755419, "field 'btnBarCode' and method 'onViewClicked'");
    target.btnBarCode = Utils.castView(view, 2131755419, "field 'btnBarCode'", Button.class);
    view2131755419 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.img_dyn_qr = Utils.findRequiredViewAsType(source, 2131755422, "field 'img_dyn_qr'", ImageView.class);
    view = Utils.findRequiredView(source, 2131755423, "method 'onViewClicked'");
    view2131755423 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    QR_CodeFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.btnScanCode = null;
    target.img_Qr = null;
    target.tv_time_second = null;
    target.btnQrCode = null;
    target.et_contain = null;
    target.btnBarCode = null;
    target.img_dyn_qr = null;

    view2131755417.setOnClickListener(null);
    view2131755417 = null;
    view2131755418.setOnClickListener(null);
    view2131755418 = null;
    view2131755419.setOnClickListener(null);
    view2131755419 = null;
    view2131755423.setOnClickListener(null);
    view2131755423 = null;
  }
}
