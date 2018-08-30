// Generated code from Butter Knife. Do not modify!
package demo.lwb.com.myutils.mvp.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.lang.IllegalStateException;
import java.lang.Override;

public class Local_VideoFragment_ViewBinding implements Unbinder {
  private Local_VideoFragment target;

  @UiThread
  public Local_VideoFragment_ViewBinding(Local_VideoFragment target, View source) {
    this.target = target;

    target.recyclerView = Utils.findRequiredViewAsType(source, 2131755301, "field 'recyclerView'", RecyclerView.class);
    target.tvLocalTip = Utils.findRequiredViewAsType(source, 2131755321, "field 'tvLocalTip'", TextView.class);
    target.llLocalProgress = Utils.findRequiredViewAsType(source, 2131755322, "field 'llLocalProgress'", LinearLayout.class);
    target.smartRefreshLayout = Utils.findRequiredViewAsType(source, 2131755436, "field 'smartRefreshLayout'", SmartRefreshLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    Local_VideoFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.recyclerView = null;
    target.tvLocalTip = null;
    target.llLocalProgress = null;
    target.smartRefreshLayout = null;
  }
}
