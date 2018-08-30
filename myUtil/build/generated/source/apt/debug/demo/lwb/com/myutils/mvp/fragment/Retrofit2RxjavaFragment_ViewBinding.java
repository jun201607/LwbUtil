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

  private View view2131755433;

  private View view2131755432;

  private View view2131755431;

  private View view2131755427;

  private View view2131755426;

  private View view2131755430;

  private View view2131755425;

  private View view2131755428;

  @UiThread
  public Retrofit2RxjavaFragment_ViewBinding(final Retrofit2RxjavaFragment target, View source) {
    this.target = target;

    View view;
    target.pbProgress = Utils.findRequiredViewAsType(source, 2131755434, "field 'pbProgress'", ProgressBar.class);
    view = Utils.findRequiredView(source, 2131755433, "field 'btnStopFile' and method 'onViewClicked'");
    target.btnStopFile = Utils.castView(view, 2131755433, "field 'btnStopFile'", Button.class);
    view2131755433 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755432, "field 'btnDownFile' and method 'onViewClicked'");
    target.btnDownFile = Utils.castView(view, 2131755432, "field 'btnDownFile'", Button.class);
    view2131755432 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755431, "field 'btnUpLoadFiles' and method 'onViewClicked'");
    target.btnUpLoadFiles = Utils.castView(view, 2131755431, "field 'btnUpLoadFiles'", Button.class);
    view2131755431 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvGet = Utils.findRequiredViewAsType(source, 2131755429, "field 'tvGet'", TextView.class);
    view = Utils.findRequiredView(source, 2131755427, "field 'btnDelete' and method 'onViewClicked'");
    target.btnDelete = Utils.castView(view, 2131755427, "field 'btnDelete'", Button.class);
    view2131755427 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755426, "field 'btnPost' and method 'onViewClicked'");
    target.btnPost = Utils.castView(view, 2131755426, "field 'btnPost'", Button.class);
    view2131755426 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755430, "field 'btnUpLoadFile' and method 'onViewClicked'");
    target.btnUpLoadFile = Utils.castView(view, 2131755430, "field 'btnUpLoadFile'", Button.class);
    view2131755430 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755425, "field 'btnGet' and method 'onViewClicked'");
    target.btnGet = Utils.castView(view, 2131755425, "field 'btnGet'", Button.class);
    view2131755425 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755428, "field 'btnPut' and method 'onViewClicked'");
    target.btnPut = Utils.castView(view, 2131755428, "field 'btnPut'", Button.class);
    view2131755428 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvProgress = Utils.findRequiredViewAsType(source, 2131755435, "field 'tvProgress'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    Retrofit2RxjavaFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.pbProgress = null;
    target.btnStopFile = null;
    target.btnDownFile = null;
    target.btnUpLoadFiles = null;
    target.tvGet = null;
    target.btnDelete = null;
    target.btnPost = null;
    target.btnUpLoadFile = null;
    target.btnGet = null;
    target.btnPut = null;
    target.tvProgress = null;

    view2131755433.setOnClickListener(null);
    view2131755433 = null;
    view2131755432.setOnClickListener(null);
    view2131755432 = null;
    view2131755431.setOnClickListener(null);
    view2131755431 = null;
    view2131755427.setOnClickListener(null);
    view2131755427 = null;
    view2131755426.setOnClickListener(null);
    view2131755426 = null;
    view2131755430.setOnClickListener(null);
    view2131755430 = null;
    view2131755425.setOnClickListener(null);
    view2131755425 = null;
    view2131755428.setOnClickListener(null);
    view2131755428 = null;
  }
}
