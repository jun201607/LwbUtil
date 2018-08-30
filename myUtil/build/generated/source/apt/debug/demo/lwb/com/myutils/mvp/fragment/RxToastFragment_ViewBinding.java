// Generated code from Butter Knife. Do not modify!
package demo.lwb.com.myutils.mvp.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RxToastFragment_ViewBinding implements Unbinder {
  private RxToastFragment target;

  private View view2131755441;

  private View view2131755442;

  private View view2131755443;

  private View view2131755444;

  private View view2131755445;

  private View view2131755446;

  private View view2131755359;

  @UiThread
  public RxToastFragment_ViewBinding(final RxToastFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, 2131755441, "method 'onViewClicked'");
    view2131755441 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755442, "method 'onViewClicked'");
    view2131755442 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755443, "method 'onViewClicked'");
    view2131755443 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755444, "method 'onViewClicked'");
    view2131755444 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755445, "method 'onViewClicked'");
    view2131755445 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755446, "method 'onViewClicked'");
    view2131755446 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755359, "method 'onViewClicked'");
    view2131755359 = view;
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
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    target = null;


    view2131755441.setOnClickListener(null);
    view2131755441 = null;
    view2131755442.setOnClickListener(null);
    view2131755442 = null;
    view2131755443.setOnClickListener(null);
    view2131755443 = null;
    view2131755444.setOnClickListener(null);
    view2131755444 = null;
    view2131755445.setOnClickListener(null);
    view2131755445 = null;
    view2131755446.setOnClickListener(null);
    view2131755446 = null;
    view2131755359.setOnClickListener(null);
    view2131755359 = null;
  }
}
