// Generated code from Butter Knife. Do not modify!
package demo.lwb.com.myutils.mvp.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class Web_ViewFragment_ViewBinding implements Unbinder {
  private Web_ViewFragment target;

  private View view2131755462;

  @UiThread
  public Web_ViewFragment_ViewBinding(final Web_ViewFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, 2131755462, "field 'btnClick' and method 'onViewClicked'");
    target.btnClick = Utils.castView(view, 2131755462, "field 'btnClick'", Button.class);
    view2131755462 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
    target.wvWebview = Utils.findRequiredViewAsType(source, 2131755464, "field 'wvWebview'", WebView.class);
    target.etWebviewSelset = Utils.findRequiredViewAsType(source, 2131755463, "field 'etWebviewSelset'", EditText.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    Web_ViewFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.btnClick = null;
    target.wvWebview = null;
    target.etWebviewSelset = null;

    view2131755462.setOnClickListener(null);
    view2131755462 = null;
  }
}
