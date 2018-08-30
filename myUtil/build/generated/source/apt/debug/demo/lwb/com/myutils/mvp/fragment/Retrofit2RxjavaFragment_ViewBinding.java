// Generated code from Butter Knife. Do not modify!
package demo.lwb.com.myutils.mvp.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class Retrofit2RxjavaFragment_ViewBinding implements Unbinder {
  private Retrofit2RxjavaFragment target;

  private View view2131755412;

  private View view2131755415;

  private View view2131755418;

  private View view2131755414;

  private View view2131755420;

  private View view2131755417;

  private View view2131755413;

  private View view2131755419;

  @UiThread
  public Retrofit2RxjavaFragment_ViewBinding(final Retrofit2RxjavaFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, 2131755412, "field 'btnGet' and method 'onViewClicked'");
    target.btnGet = Utils.castView(view, 2131755412, "field 'btnGet'", Button.class);
    view2131755412 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755415, "field 'btnPut' and method 'onViewClicked'");
    target.btnPut = Utils.castView(view, 2131755415, "field 'btnPut'", Button.class);
    view2131755415 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755418, "field 'btnUpLoadFiles' and method 'onViewClicked'");
    target.btnUpLoadFiles = Utils.castView(view, 2131755418, "field 'btnUpLoadFiles'", Button.class);
    view2131755418 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755414, "field 'btnDelete' and method 'onViewClicked'");
    target.btnDelete = Utils.castView(view, 2131755414, "field 'btnDelete'", Button.class);
    view2131755414 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755420, "field 'btnStopFile' and method 'onViewClicked'");
    target.btnStopFile = Utils.castView(view, 2131755420, "field 'btnStopFile'", Button.class);
    view2131755420 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.pbProgress = Utils.findRequiredViewAsType(source, 2131755421, "field 'pbProgress'", ProgressBar.class);
    target.tvProgress = Utils.findRequiredViewAsType(source, 2131755422, "field 'tvProgress'", TextView.class);
    view = Utils.findRequiredView(source, 2131755417, "field 'btnUpLoadFile' and method 'onViewClicked'");
    target.btnUpLoadFile = Utils.castView(view, 2131755417, "field 'btnUpLoadFile'", Button.class);
    view2131755417 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755413, "field 'btnPost' and method 'onViewClicked'");
    target.btnPost = Utils.castView(view, 2131755413, "field 'btnPost'", Button.class);
    view2131755413 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755419, "field 'btnDownFile' and method 'onViewClicked'");
    target.btnDownFile = Utils.castView(view, 2131755419, "field 'btnDownFile'", Button.class);
    view2131755419 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvGet = Utils.findRequiredViewAsType(source, 2131755416, "field 'tvGet'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    Retrofit2RxjavaFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.btnGet = null;
    target.btnPut = null;
    target.btnUpLoadFiles = null;
    target.btnDelete = null;
    target.btnStopFile = null;
    target.pbProgress = null;
    target.tvProgress = null;
    target.btnUpLoadFile = null;
    target.btnPost = null;
    target.btnDownFile = null;
    target.tvGet = null;

    view2131755412.setOnClickListener(null);
    view2131755412 = null;
    view2131755415.setOnClickListener(null);
    view2131755415 = null;
    view2131755418.setOnClickListener(null);
    view2131755418 = null;
    view2131755414.setOnClickListener(null);
    view2131755414 = null;
    view2131755420.setOnClickListener(null);
    view2131755420 = null;
    view2131755417.setOnClickListener(null);
    view2131755417 = null;
    view2131755413.setOnClickListener(null);
    view2131755413 = null;
    view2131755419.setOnClickListener(null);
    view2131755419 = null;
  }
}
