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

  private View view2131755283;

  private View view2131755279;

  private View view2131755284;

  private View view2131755277;

  private View view2131755280;

  private View view2131755278;

  private View view2131755285;

  private View view2131755282;

  @UiThread
  public Retrofit2RxjavaFragment_ViewBinding(final Retrofit2RxjavaFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, 2131755283, "field 'btnUpLoadFiles' and method 'onViewClicked'");
    target.btnUpLoadFiles = Utils.castView(view, 2131755283, "field 'btnUpLoadFiles'", Button.class);
    view2131755283 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755279, "field 'btnDelete' and method 'onViewClicked'");
    target.btnDelete = Utils.castView(view, 2131755279, "field 'btnDelete'", Button.class);
    view2131755279 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvGet = Utils.findRequiredViewAsType(source, 2131755281, "field 'tvGet'", TextView.class);
    view = Utils.findRequiredView(source, 2131755284, "field 'btnDownFile' and method 'onViewClicked'");
    target.btnDownFile = Utils.castView(view, 2131755284, "field 'btnDownFile'", Button.class);
    view2131755284 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755277, "field 'btnGet' and method 'onViewClicked'");
    target.btnGet = Utils.castView(view, 2131755277, "field 'btnGet'", Button.class);
    view2131755277 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755280, "field 'btnPut' and method 'onViewClicked'");
    target.btnPut = Utils.castView(view, 2131755280, "field 'btnPut'", Button.class);
    view2131755280 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755278, "field 'btnPost' and method 'onViewClicked'");
    target.btnPost = Utils.castView(view, 2131755278, "field 'btnPost'", Button.class);
    view2131755278 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvProgress = Utils.findRequiredViewAsType(source, 2131755287, "field 'tvProgress'", TextView.class);
    view = Utils.findRequiredView(source, 2131755285, "field 'btnStopFile' and method 'onViewClicked'");
    target.btnStopFile = Utils.castView(view, 2131755285, "field 'btnStopFile'", Button.class);
    view2131755285 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755282, "field 'btnUpLoadFile' and method 'onViewClicked'");
    target.btnUpLoadFile = Utils.castView(view, 2131755282, "field 'btnUpLoadFile'", Button.class);
    view2131755282 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.pbProgress = Utils.findRequiredViewAsType(source, 2131755286, "field 'pbProgress'", ProgressBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    Retrofit2RxjavaFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.btnUpLoadFiles = null;
    target.btnDelete = null;
    target.tvGet = null;
    target.btnDownFile = null;
    target.btnGet = null;
    target.btnPut = null;
    target.btnPost = null;
    target.tvProgress = null;
    target.btnStopFile = null;
    target.btnUpLoadFile = null;
    target.pbProgress = null;

    view2131755283.setOnClickListener(null);
    view2131755283 = null;
    view2131755279.setOnClickListener(null);
    view2131755279 = null;
    view2131755284.setOnClickListener(null);
    view2131755284 = null;
    view2131755277.setOnClickListener(null);
    view2131755277 = null;
    view2131755280.setOnClickListener(null);
    view2131755280 = null;
    view2131755278.setOnClickListener(null);
    view2131755278 = null;
    view2131755285.setOnClickListener(null);
    view2131755285 = null;
    view2131755282.setOnClickListener(null);
    view2131755282 = null;
  }
}
