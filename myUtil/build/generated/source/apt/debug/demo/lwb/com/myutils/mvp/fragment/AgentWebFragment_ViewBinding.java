// Generated code from Butter Knife. Do not modify!
package demo.lwb.com.myutils.mvp.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AgentWebFragment_ViewBinding implements Unbinder {
  private AgentWebFragment target;

  private View view2131755290;

  @UiThread
  public AgentWebFragment_ViewBinding(final AgentWebFragment target, View source) {
    this.target = target;

    View view;
    target.llAgentview = Utils.findRequiredViewAsType(source, 2131755289, "field 'llAgentview'", LinearLayout.class);
    view = Utils.findRequiredView(source, 2131755290, "field 'btnClear' and method 'onViewClicked'");
    target.btnClear = Utils.castView(view, 2131755290, "field 'btnClear'", Button.class);
    view2131755290 = view;
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
    AgentWebFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.llAgentview = null;
    target.btnClear = null;

    view2131755290.setOnClickListener(null);
    view2131755290 = null;
  }
}
