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

public class AidlFragment_ViewBinding implements Unbinder {
  private AidlFragment target;

  private View view2131755291;

  private View view2131755290;

  @UiThread
  public AidlFragment_ViewBinding(final AidlFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, 2131755291, "field 'llAdd' and method 'onViewClicked'");
    target.llAdd = Utils.castView(view, 2131755291, "field 'llAdd'", LinearLayout.class);
    view2131755291 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.etBookName = Utils.findRequiredViewAsType(source, 2131755289, "field 'etBookName'", EditText.class);
    target.etNumber = Utils.findRequiredViewAsType(source, 2131755287, "field 'etNumber'", EditText.class);
    view = Utils.findRequiredView(source, 2131755290, "field 'btnAdd' and method 'onViewClicked'");
    target.btnAdd = Utils.castView(view, 2131755290, "field 'btnAdd'", Button.class);
    view2131755290 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.llContent = Utils.findRequiredViewAsType(source, 2131755288, "field 'llContent'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AidlFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.llAdd = null;
    target.etBookName = null;
    target.etNumber = null;
    target.btnAdd = null;
    target.llContent = null;

    view2131755291.setOnClickListener(null);
    view2131755291 = null;
    view2131755290.setOnClickListener(null);
    view2131755290 = null;
  }
}
