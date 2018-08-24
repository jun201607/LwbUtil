// Generated code from Butter Knife. Do not modify!
package demo.lwb.com.myutils.mvp.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FloatingActionFragment_ViewBinding implements Unbinder {
  private FloatingActionFragment target;

  private View view2131755249;

  @UiThread
  public FloatingActionFragment_ViewBinding(final FloatingActionFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, 2131755249, "field 'floatingActionButton' and method 'onViewClicked'");
    target.floatingActionButton = Utils.castView(view, 2131755249, "field 'floatingActionButton'", FloatingActionButton.class);
    view2131755249 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    FloatingActionFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.floatingActionButton = null;

    view2131755249.setOnClickListener(null);
    view2131755249 = null;
  }
}
