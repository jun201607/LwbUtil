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

  private View view2131755450;

  private View view2131755451;

  private View view2131755452;

  @UiThread
  public Scan_CodeFragment_ViewBinding(final Scan_CodeFragment target, View source) {
    this.target = target;

    View view;
    target.surfaceView = Utils.findRequiredViewAsType(source, 2131755448, "field 'surfaceView'", SurfaceView.class);
    target.mCropLayout = Utils.findRequiredViewAsType(source, 2131755453, "field 'mCropLayout'", RelativeLayout.class);
    target.mQrLineView = Utils.findRequiredViewAsType(source, 2131755454, "field 'mQrLineView'", ImageView.class);
    target.mContainer = Utils.findRequiredViewAsType(source, 2131755447, "field 'mContainer'", RelativeLayout.class);
    view = Utils.findRequiredView(source, 2131755450, "method 'onViewClicked'");
    view2131755450 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755451, "method 'onViewClicked'");
    view2131755451 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755452, "method 'onViewClicked'");
    view2131755452 = view;
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
    target.mCropLayout = null;
    target.mQrLineView = null;
    target.mContainer = null;

    view2131755450.setOnClickListener(null);
    view2131755450 = null;
    view2131755451.setOnClickListener(null);
    view2131755451 = null;
    view2131755452.setOnClickListener(null);
    view2131755452 = null;
  }
}
