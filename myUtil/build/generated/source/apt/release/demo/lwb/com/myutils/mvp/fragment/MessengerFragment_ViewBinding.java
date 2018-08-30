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

  private View view2131755288;

  private View view2131755336;

  @UiThread
  public MessengerFragment_ViewBinding(final MessengerFragment target, View source) {
    this.target = target;

    View view;
    target.etPut = Utils.findRequiredViewAsType(source, 2131755337, "field 'etPut'", EditText.class);
    view = Utils.findRequiredView(source, 2131755288, "field 'llContent' and method 'onViewClicked'");
    target.llContent = Utils.castView(view, 2131755288, "field 'llContent'", LinearLayout.class);
    view2131755288 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755336, "field 'btSend' and method 'onViewClicked'");
    target.btSend = Utils.castView(view, 2131755336, "field 'btSend'", Button.class);
    view2131755336 = view;
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

    target.etPut = null;
    target.llContent = null;
    target.btSend = null;

    view2131755288.setOnClickListener(null);
    view2131755288 = null;
    view2131755336.setOnClickListener(null);
    view2131755336 = null;
  }
}
