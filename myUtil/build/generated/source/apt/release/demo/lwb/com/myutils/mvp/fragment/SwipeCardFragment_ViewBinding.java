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

public class SwipeCardFragment_ViewBinding implements Unbinder {
  private SwipeCardFragment target;

  @UiThread
  public SwipeCardFragment_ViewBinding(SwipeCardFragment target, View source) {
    this.target = target;

    target.activityReview = Utils.findRequiredViewAsType(source, 2131755352, "field 'activityReview'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SwipeCardFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.activityReview = null;
  }
}
