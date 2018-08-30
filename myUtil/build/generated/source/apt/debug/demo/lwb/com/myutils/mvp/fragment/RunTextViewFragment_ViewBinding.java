// Generated code from Butter Knife. Do not modify!
package demo.lwb.com.myutils.mvp.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import demo.lwb.com.myutils.wight.RxRunTextView;
import demo.lwb.com.myutils.wight.RxTextViewVertical;
import demo.lwb.com.myutils.wight.RxTextViewVerticalMore;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RunTextViewFragment_ViewBinding implements Unbinder {
  private RunTextViewFragment target;

  @UiThread
  public RunTextViewFragment_ViewBinding(RunTextViewFragment target, View source) {
    this.target = target;

    target.activityRunTextView = Utils.findRequiredViewAsType(source, 2131755436, "field 'activityRunTextView'", LinearLayout.class);
    target.tvRuntitle = Utils.findRequiredViewAsType(source, 2131755437, "field 'tvRuntitle'", RxRunTextView.class);
    target.mRxVText = Utils.findRequiredViewAsType(source, 2131755034, "field 'mRxVText'", RxTextViewVertical.class);
    target.upview1 = Utils.findRequiredViewAsType(source, 2131755438, "field 'upview1'", RxTextViewVerticalMore.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RunTextViewFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.activityRunTextView = null;
    target.tvRuntitle = null;
    target.mRxVText = null;
    target.upview1 = null;
  }
}
