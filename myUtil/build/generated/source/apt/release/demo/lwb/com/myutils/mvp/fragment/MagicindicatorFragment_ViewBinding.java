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

  private View view2131755187;

  private View view2131755188;

  private View view2131755189;

  private View view2131755190;

  private View view2131755191;

  private View view2131755192;

  private View view2131755193;

  private View view2131755194;

  @UiThread
  public MagicindicatorFragment_ViewBinding(final MagicindicatorFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, 2131755187, "method 'onViewClicked'");
    view2131755187 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755188, "method 'onViewClicked'");
    view2131755188 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755189, "method 'onViewClicked'");
    view2131755189 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755190, "method 'onViewClicked'");
    view2131755190 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755191, "method 'onViewClicked'");
    view2131755191 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755192, "method 'onViewClicked'");
    view2131755192 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755193, "method 'onViewClicked'");
    view2131755193 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755194, "method 'onViewClicked'");
    view2131755194 = view;
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


    view2131755187.setOnClickListener(null);
    view2131755187 = null;
    view2131755188.setOnClickListener(null);
    view2131755188 = null;
    view2131755189.setOnClickListener(null);
    view2131755189 = null;
    view2131755190.setOnClickListener(null);
    view2131755190 = null;
    view2131755191.setOnClickListener(null);
    view2131755191 = null;
    view2131755192.setOnClickListener(null);
    view2131755192 = null;
    view2131755193.setOnClickListener(null);
    view2131755193 = null;
    view2131755194.setOnClickListener(null);
    view2131755194 = null;
  }
}
