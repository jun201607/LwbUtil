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

  private View view2131755325;

  private View view2131755326;

  private View view2131755327;

  @UiThread
  public DownloadFragment_ViewBinding(final DownloadFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, 2131755325, "field 'btnStart' and method 'onViewClicked'");
    target.btnStart = Utils.castView(view, 2131755325, "field 'btnStart'", Button.class);
    view2131755325 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755326, "field 'btnStop' and method 'onViewClicked'");
    target.btnStop = Utils.castView(view, 2131755326, "field 'btnStop'", Button.class);
    view2131755326 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755327, "field 'btnCancle' and method 'onViewClicked'");
    target.btnCancle = Utils.castView(view, 2131755327, "field 'btnCancle'", Button.class);
    view2131755327 = view;
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

    target.btnStart = null;
    target.btnStop = null;
    target.btnCancle = null;

    view2131755325.setOnClickListener(null);
    view2131755325 = null;
    view2131755326.setOnClickListener(null);
    view2131755326 = null;
    view2131755327.setOnClickListener(null);
    view2131755327 = null;
  }
}
