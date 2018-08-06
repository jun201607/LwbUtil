// Generated code from Butter Knife. Do not modify!
package demo.lwb.com.myutils.mvp.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import demo.lwb.com.myutils.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DownloadFragment_ViewBinding implements Unbinder {
  private DownloadFragment target;

  private View view2131689689;

  private View view2131689690;

  private View view2131689691;

  @UiThread
  public DownloadFragment_ViewBinding(final DownloadFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.btn_start, "field 'btnStart' and method 'onViewClicked'");
    target.btnStart = Utils.castView(view, R.id.btn_start, "field 'btnStart'", Button.class);
    view2131689689 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_stop, "field 'btnStop' and method 'onViewClicked'");
    target.btnStop = Utils.castView(view, R.id.btn_stop, "field 'btnStop'", Button.class);
    view2131689690 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_cancle, "field 'btnCancle' and method 'onViewClicked'");
    target.btnCancle = Utils.castView(view, R.id.btn_cancle, "field 'btnCancle'", Button.class);
    view2131689691 = view;
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

    view2131689689.setOnClickListener(null);
    view2131689689 = null;
    view2131689690.setOnClickListener(null);
    view2131689690 = null;
    view2131689691.setOnClickListener(null);
    view2131689691 = null;
  }
}
