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

public class AidlFragment_ViewBinding implements Unbinder {
  private AidlFragment target;

  private View view2131689680;

  private View view2131689681;

  @UiThread
  public AidlFragment_ViewBinding(final AidlFragment target, View source) {
    this.target = target;

    View view;
    target.etNumber = Utils.findRequiredViewAsType(source, R.id.et_number, "field 'etNumber'", EditText.class);
    target.etBookName = Utils.findRequiredViewAsType(source, R.id.et_book_name, "field 'etBookName'", EditText.class);
    target.llContent = Utils.findRequiredViewAsType(source, R.id.ll_content, "field 'llContent'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.btn_add, "field 'btnAdd' and method 'onViewClicked'");
    target.btnAdd = Utils.castView(view, R.id.btn_add, "field 'btnAdd'", Button.class);
    view2131689680 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.ll_add, "field 'llAdd' and method 'onViewClicked'");
    target.llAdd = Utils.castView(view, R.id.ll_add, "field 'llAdd'", LinearLayout.class);
    view2131689681 = view;
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
    AidlFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.etNumber = null;
    target.etBookName = null;
    target.llContent = null;
    target.btnAdd = null;
    target.llAdd = null;

    view2131689680.setOnClickListener(null);
    view2131689680 = null;
    view2131689681.setOnClickListener(null);
    view2131689681 = null;
  }
}
