// Generated code from Butter Knife. Do not modify!
package demo.lwb.com.myutils.mvp.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HomeTab3Fragment_ViewBinding implements Unbinder {
  private HomeTab3Fragment target;

  @UiThread
  public HomeTab3Fragment_ViewBinding(HomeTab3Fragment target, View source) {
    this.target = target;

    target.recyclerView = Utils.findRequiredViewAsType(source, 2131755301, "field 'recyclerView'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HomeTab3Fragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.recyclerView = null;
  }
}
