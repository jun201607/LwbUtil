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

public class MagicindicatorFragment_ViewBinding implements Unbinder {
  private MagicindicatorFragment target;

  private View view2131755157;

  private View view2131755158;

  private View view2131755159;

  private View view2131755160;

  private View view2131755161;

  private View view2131755162;

  private View view2131755163;

  private View view2131755164;

  @UiThread
  public MagicindicatorFragment_ViewBinding(final MagicindicatorFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, 2131755157, "method 'onViewClicked'");
    view2131755157 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755158, "method 'onViewClicked'");
    view2131755158 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755159, "method 'onViewClicked'");
    view2131755159 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755160, "method 'onViewClicked'");
    view2131755160 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755161, "method 'onViewClicked'");
    view2131755161 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755162, "method 'onViewClicked'");
    view2131755162 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755163, "method 'onViewClicked'");
    view2131755163 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755164, "method 'onViewClicked'");
    view2131755164 = view;
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


    view2131755157.setOnClickListener(null);
    view2131755157 = null;
    view2131755158.setOnClickListener(null);
    view2131755158 = null;
    view2131755159.setOnClickListener(null);
    view2131755159 = null;
    view2131755160.setOnClickListener(null);
    view2131755160 = null;
    view2131755161.setOnClickListener(null);
    view2131755161 = null;
    view2131755162.setOnClickListener(null);
    view2131755162 = null;
    view2131755163.setOnClickListener(null);
    view2131755163 = null;
    view2131755164.setOnClickListener(null);
    view2131755164 = null;
  }
}
