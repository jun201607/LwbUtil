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
import demo.lwb.com.myutils.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DrawerLayoutFragment_ViewBinding implements Unbinder {
  private DrawerLayoutFragment target;

  private View view2131689689;

  @UiThread
  public DrawerLayoutFragment_ViewBinding(final DrawerLayoutFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.btn_start, "field 'btnStart' and method 'onViewClicked'");
    target.btnStart = Utils.castView(view, R.id.btn_start, "field 'btnStart'", Button.class);
    view2131689689 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
    target.drawerLayout = Utils.findRequiredViewAsType(source, R.id.drawer_layout, "field 'drawerLayout'", DrawerLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DrawerLayoutFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.btnStart = null;
    target.drawerLayout = null;

    view2131689689.setOnClickListener(null);
    view2131689689 = null;
  }
}
