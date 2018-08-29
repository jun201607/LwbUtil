// Generated code from Butter Knife. Do not modify!
package demo.lwb.com.myutils.mvp.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SmartRefreshLayoutFragment_ViewBinding implements Unbinder {
  private SmartRefreshLayoutFragment target;

  @UiThread
  public SmartRefreshLayoutFragment_ViewBinding(SmartRefreshLayoutFragment target, View source) {
    this.target = target;

    target.smartRefreshLayout = Utils.findRequiredViewAsType(source, 2131755351, "field 'smartRefreshLayout'", SmartRefreshLayout.class);
    target.recyclerView = Utils.findRequiredViewAsType(source, 2131755284, "field 'recyclerView'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SmartRefreshLayoutFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.smartRefreshLayout = null;
    target.recyclerView = null;
  }
}
