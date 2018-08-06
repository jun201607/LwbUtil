// Generated code from Butter Knife. Do not modify!
package demo.lwb.com.myutils.mvp.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import demo.lwb.com.myutils.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HomeTab1DetailFragment_ViewBinding implements Unbinder {
  private HomeTab1DetailFragment target;

  @UiThread
  public HomeTab1DetailFragment_ViewBinding(HomeTab1DetailFragment target, View source) {
    this.target = target;

    target.tvUtilsDetail = Utils.findRequiredViewAsType(source, R.id.tv_Utils_detail, "field 'tvUtilsDetail'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HomeTab1DetailFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvUtilsDetail = null;
  }
}
