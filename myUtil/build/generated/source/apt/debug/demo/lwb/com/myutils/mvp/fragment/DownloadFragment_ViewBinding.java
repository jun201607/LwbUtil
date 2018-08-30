// Generated code from Butter Knife. Do not modify!
package demo.lwb.com.myutils.mvp.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DownloadFragment_ViewBinding implements Unbinder {
  private DownloadFragment target;

  private View view2131755314;

  private View view2131755312;

  private View view2131755313;

  @UiThread
  public DownloadFragment_ViewBinding(final DownloadFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, 2131755314, "field 'btnCancle' and method 'onViewClicked'");
    target.btnCancle = Utils.castView(view, 2131755314, "field 'btnCancle'", Button.class);
    view2131755314 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755312, "field 'btnStart' and method 'onViewClicked'");
    target.btnStart = Utils.castView(view, 2131755312, "field 'btnStart'", Button.class);
    view2131755312 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755313, "field 'btnStop' and method 'onViewClicked'");
    target.btnStop = Utils.castView(view, 2131755313, "field 'btnStop'", Button.class);
    view2131755313 = view;
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
    DownloadFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.btnCancle = null;
    target.btnStart = null;
    target.btnStop = null;

    view2131755314.setOnClickListener(null);
    view2131755314 = null;
    view2131755312.setOnClickListener(null);
    view2131755312 = null;
    view2131755313.setOnClickListener(null);
    view2131755313 = null;
  }
}
