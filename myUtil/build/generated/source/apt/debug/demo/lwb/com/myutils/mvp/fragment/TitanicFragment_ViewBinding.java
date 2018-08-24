// Generated code from Butter Knife. Do not modify!
package demo.lwb.com.myutils.mvp.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import demo.lwb.com.myutils.wight.titanic.TitanicTextView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TitanicFragment_ViewBinding implements Unbinder {
  private TitanicFragment target;

  @UiThread
  public TitanicFragment_ViewBinding(TitanicFragment target, View source) {
    this.target = target;

    target.TitanicTextView = Utils.findRequiredViewAsType(source, 2131755290, "field 'TitanicTextView'", TitanicTextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    TitanicFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.TitanicTextView = null;
  }
}
