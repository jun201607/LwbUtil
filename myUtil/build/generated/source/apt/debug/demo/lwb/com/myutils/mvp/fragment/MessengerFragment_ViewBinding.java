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
import demo.lwb.com.myutils.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MessengerFragment_ViewBinding implements Unbinder {
  private MessengerFragment target;

  private View view2131689713;

  private View view2131689678;

  @UiThread
  public MessengerFragment_ViewBinding(final MessengerFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.bt_send, "field 'btSend' and method 'onViewClicked'");
    target.btSend = Utils.castView(view, R.id.bt_send, "field 'btSend'", Button.class);
    view2131689713 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.etPut = Utils.findRequiredViewAsType(source, R.id.et_put, "field 'etPut'", EditText.class);
    view = Utils.findRequiredView(source, R.id.ll_content, "field 'llContent' and method 'onViewClicked'");
    target.llContent = Utils.castView(view, R.id.ll_content, "field 'llContent'", LinearLayout.class);
    view2131689678 = view;
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

    view2131689713.setOnClickListener(null);
    view2131689713 = null;
    view2131689678.setOnClickListener(null);
    view2131689678 = null;
  }
}
