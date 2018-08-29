// Generated code from Butter Knife. Do not modify!
package demo.lwb.com.myutils.mvp.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MessengerFragment_ViewBinding implements Unbinder {
  private MessengerFragment target;

  private View view2131755309;

  private View view2131755271;

  @UiThread
  public MessengerFragment_ViewBinding(final MessengerFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, 2131755309, "field 'btSend' and method 'onViewClicked'");
    target.btSend = Utils.castView(view, 2131755309, "field 'btSend'", Button.class);
    view2131755309 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.etPut = Utils.findRequiredViewAsType(source, 2131755310, "field 'etPut'", EditText.class);
    view = Utils.findRequiredView(source, 2131755271, "field 'llContent' and method 'onViewClicked'");
    target.llContent = Utils.castView(view, 2131755271, "field 'llContent'", LinearLayout.class);
    view2131755271 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    MessengerFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.btSend = null;
    target.etPut = null;
    target.llContent = null;

    view2131755309.setOnClickListener(null);
    view2131755309 = null;
    view2131755271.setOnClickListener(null);
    view2131755271 = null;
  }
}