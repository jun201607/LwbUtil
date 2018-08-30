// Generated code from Butter Knife. Do not modify!
package demo.lwb.com.myutils.mvp.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class Scan_CodeFragment_ViewBinding implements Unbinder {
  private Scan_CodeFragment target;

  private View view2131755426;

  private View view2131755427;

  private View view2131755428;

  @UiThread
  public Scan_CodeFragment_ViewBinding(final Scan_CodeFragment target, View source) {
    this.target = target;

    View view;
    target.surfaceView = Utils.findRequiredViewAsType(source, 2131755424, "field 'surfaceView'", SurfaceView.class);
    target.mContainer = Utils.findRequiredViewAsType(source, 2131755423, "field 'mContainer'", RelativeLayout.class);
    target.mQrLineView = Utils.findRequiredViewAsType(source, 2131755430, "field 'mQrLineView'", ImageView.class);
    target.mCropLayout = Utils.findRequiredViewAsType(source, 2131755429, "field 'mCropLayout'", RelativeLayout.class);
    view = Utils.findRequiredView(source, 2131755426, "method 'onViewClicked'");
    view2131755426 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755427, "method 'onViewClicked'");
    view2131755427 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755428, "method 'onViewClicked'");
    view2131755428 = view;
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
    Scan_CodeFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.surfaceView = null;
    target.mContainer = null;
    target.mQrLineView = null;
    target.mCropLayout = null;

    view2131755426.setOnClickListener(null);
    view2131755426 = null;
    view2131755427.setOnClickListener(null);
    view2131755427 = null;
    view2131755428.setOnClickListener(null);
    view2131755428 = null;
  }
}
