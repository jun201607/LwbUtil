// Generated code from Butter Knife. Do not modify!
package demo.lwb.com.myutils.mvp.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import demo.lwb.com.myutils.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MagicindicatorFragment_ViewBinding implements Unbinder {
  private MagicindicatorFragment target;

  private View view2131689612;

  private View view2131689613;

  private View view2131689614;

  private View view2131689615;

  private View view2131689616;

  private View view2131689617;

  private View view2131689618;

  private View view2131689619;

  @UiThread
  public MagicindicatorFragment_ViewBinding(final MagicindicatorFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.scrollable_tab, "method 'onViewClicked'");
    view2131689612 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.fixed_tab, "method 'onViewClicked'");
    view2131689613 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.dynamic_tab, "method 'onViewClicked'");
    view2131689614 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.no_tab_only_indicator, "method 'onViewClicked'");
    view2131689615 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.work_with_fragment_container, "method 'onViewClicked'");
    view2131689616 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tab_with_badge_view, "method 'onViewClicked'");
    view2131689617 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.load_custom_layout, "method 'onViewClicked'");
    view2131689618 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.custom_navigator, "method 'onViewClicked'");
    view2131689619 = view;
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


    view2131689612.setOnClickListener(null);
    view2131689612 = null;
    view2131689613.setOnClickListener(null);
    view2131689613 = null;
    view2131689614.setOnClickListener(null);
    view2131689614 = null;
    view2131689615.setOnClickListener(null);
    view2131689615 = null;
    view2131689616.setOnClickListener(null);
    view2131689616 = null;
    view2131689617.setOnClickListener(null);
    view2131689617 = null;
    view2131689618.setOnClickListener(null);
    view2131689618 = null;
    view2131689619.setOnClickListener(null);
    view2131689619 = null;
  }
}
