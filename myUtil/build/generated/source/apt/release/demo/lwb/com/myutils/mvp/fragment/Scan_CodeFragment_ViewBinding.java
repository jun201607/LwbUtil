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

  private View view2131755341;

  private View view2131755342;

  private View view2131755343;

  @UiThread
  public Scan_CodeFragment_ViewBinding(final Scan_CodeFragment target, View source) {
    this.target = target;

    View view;
    target.mCropLayout = Utils.findRequiredViewAsType(source, 2131755344, "field 'mCropLayout'", RelativeLayout.class);
    target.mQrLineView = Utils.findRequiredViewAsType(source, 2131755345, "field 'mQrLineView'", ImageView.class);
    target.surfaceView = Utils.findRequiredViewAsType(source, 2131755339, "field 'surfaceView'", SurfaceView.class);
    target.mContainer = Utils.findRequiredViewAsType(source, 2131755338, "field 'mContainer'", RelativeLayout.class);
    view = Utils.findRequiredView(source, 2131755341, "method 'onViewClicked'");
    view2131755341 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755342, "method 'onViewClicked'");
    view2131755342 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755343, "method 'onViewClicked'");
    view2131755343 = view;
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

    target.mCropLayout = null;
    target.mQrLineView = null;
    target.surfaceView = null;
    target.mContainer = null;

    view2131755341.setOnClickListener(null);
    view2131755341 = null;
    view2131755342.setOnClickListener(null);
    view2131755342 = null;
    view2131755343.setOnClickListener(null);
    view2131755343 = null;
  }
}
