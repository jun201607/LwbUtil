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

  private View view2131755329;

  private View view2131755332;

  private View view2131755328;

  private View view2131755334;

  private View view2131755333;

  private View view2131755330;

  private View view2131755327;

  private View view2131755335;

  @UiThread
  public Retrofit2RxjavaFragment_ViewBinding(final Retrofit2RxjavaFragment target, View source) {
    this.target = target;

    View view;
    target.pbProgress = Utils.findRequiredViewAsType(source, 2131755336, "field 'pbProgress'", ProgressBar.class);
    view = Utils.findRequiredView(source, 2131755329, "field 'btnDelete' and method 'onViewClicked'");
    target.btnDelete = Utils.castView(view, 2131755329, "field 'btnDelete'", Button.class);
    view2131755329 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755332, "field 'btnUpLoadFile' and method 'onViewClicked'");
    target.btnUpLoadFile = Utils.castView(view, 2131755332, "field 'btnUpLoadFile'", Button.class);
    view2131755332 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755328, "field 'btnPost' and method 'onViewClicked'");
    target.btnPost = Utils.castView(view, 2131755328, "field 'btnPost'", Button.class);
    view2131755328 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvGet = Utils.findRequiredViewAsType(source, 2131755331, "field 'tvGet'", TextView.class);
    view = Utils.findRequiredView(source, 2131755334, "field 'btnDownFile' and method 'onViewClicked'");
    target.btnDownFile = Utils.castView(view, 2131755334, "field 'btnDownFile'", Button.class);
    view2131755334 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755333, "field 'btnUpLoadFiles' and method 'onViewClicked'");
    target.btnUpLoadFiles = Utils.castView(view, 2131755333, "field 'btnUpLoadFiles'", Button.class);
    view2131755333 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755330, "field 'btnPut' and method 'onViewClicked'");
    target.btnPut = Utils.castView(view, 2131755330, "field 'btnPut'", Button.class);
    view2131755330 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755327, "field 'btnGet' and method 'onViewClicked'");
    target.btnGet = Utils.castView(view, 2131755327, "field 'btnGet'", Button.class);
    view2131755327 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvProgress = Utils.findRequiredViewAsType(source, 2131755337, "field 'tvProgress'", TextView.class);
    view = Utils.findRequiredView(source, 2131755335, "field 'btnStopFile' and method 'onViewClicked'");
    target.btnStopFile = Utils.castView(view, 2131755335, "field 'btnStopFile'", Button.class);
    view2131755335 = view;
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
    Retrofit2RxjavaFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.pbProgress = null;
    target.btnDelete = null;
    target.btnUpLoadFile = null;
    target.btnPost = null;
    target.tvGet = null;
    target.btnDownFile = null;
    target.btnUpLoadFiles = null;
    target.btnPut = null;
    target.btnGet = null;
    target.tvProgress = null;
    target.btnStopFile = null;

    view2131755329.setOnClickListener(null);
    view2131755329 = null;
    view2131755332.setOnClickListener(null);
    view2131755332 = null;
    view2131755328.setOnClickListener(null);
    view2131755328 = null;
    view2131755334.setOnClickListener(null);
    view2131755334 = null;
    view2131755333.setOnClickListener(null);
    view2131755333 = null;
    view2131755330.setOnClickListener(null);
    view2131755330 = null;
    view2131755327.setOnClickListener(null);
    view2131755327 = null;
    view2131755335.setOnClickListener(null);
    view2131755335 = null;
  }
}
