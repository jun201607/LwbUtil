// Generated code from Butter Knife. Do not modify!
package demo.lwb.com.myutils.mvp.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DrawerLayoutFragment_ViewBinding implements Unbinder {
  private DrawerLayoutFragment target;

  private View view2131755312;

  @UiThread
  public DrawerLayoutFragment_ViewBinding(final DrawerLayoutFragment target, View source) {
    this.target = target;

    View view;
    target.drawerLayout = Utils.findRequiredViewAsType(source, 2131755315, "field 'drawerLayout'", DrawerLayout.class);
    view = Utils.findRequiredView(source, 2131755312, "field 'btnStart' and method 'onViewClicked'");
    target.btnStart = Utils.castView(view, 2131755312, "field 'btnStart'", Button.class);
    view2131755312 = view;
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
    DrawerLayoutFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.drawerLayout = null;
    target.btnStart = null;

    view2131755312.setOnClickListener(null);
    view2131755312 = null;
  }
}
