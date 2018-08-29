// Generated code from Butter Knife. Do not modify!
package demo.lwb.com.myutils.mvp.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class EventBusFragment_ViewBinding implements Unbinder {
  private EventBusFragment target;

  @UiThread
  public EventBusFragment_ViewBinding(EventBusFragment target, View source) {
    this.target = target;

    target.btnEventBus = Utils.findRequiredViewAsType(source, 2131755289, "field 'btnEventBus'", Button.class);
    target.tvEventBus = Utils.findRequiredViewAsType(source, 2131755290, "field 'tvEventBus'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    EventBusFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.btnEventBus = null;
    target.tvEventBus = null;
  }
}
