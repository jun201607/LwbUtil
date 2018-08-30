// Generated code from Butter Knife. Do not modify!
package demo.lwb.com.myutils.mvp.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.BottomNavigationView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import java.lang.IllegalStateException;
import java.lang.Override;

public class BottomNavigationBarFragment_ViewBinding implements Unbinder {
  private BottomNavigationBarFragment target;

  @UiThread
  public BottomNavigationBarFragment_ViewBinding(BottomNavigationBarFragment target, View source) {
    this.target = target;

    target.bottomNavigationBar = Utils.findRequiredViewAsType(source, 2131755296, "field 'bottomNavigationBar'", BottomNavigationBar.class);
    target.bottomNavigationView = Utils.findRequiredViewAsType(source, 2131755297, "field 'bottomNavigationView'", BottomNavigationView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    BottomNavigationBarFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.bottomNavigationBar = null;
    target.bottomNavigationView = null;
  }
}
