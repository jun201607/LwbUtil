// Generated code from Butter Knife. Do not modify!
package demo.lwb.com.myutils.mvp.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import demo.lwb.com.myutils.wight.MatchView.MatchButton;
import demo.lwb.com.myutils.wight.MatchView.MatchTextView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AnimationTextViewFragment_ViewBinding implements Unbinder {
  private AnimationTextViewFragment target;

  @UiThread
  public AnimationTextViewFragment_ViewBinding(AnimationTextViewFragment target, View source) {
    this.target = target;

    target.tvMatchButton = Utils.findRequiredViewAsType(source, 2131755276, "field 'tvMatchButton'", MatchButton.class);
    target.tv_button = Utils.findRequiredViewAsType(source, 2131755277, "field 'tv_button'", Button.class);
    target.tv_button1 = Utils.findRequiredViewAsType(source, 2131755278, "field 'tv_button1'", Button.class);
    target.tvMatchTextView = Utils.findRequiredViewAsType(source, 2131755275, "field 'tvMatchTextView'", MatchTextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AnimationTextViewFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvMatchButton = null;
    target.tv_button = null;
    target.tv_button1 = null;
    target.tvMatchTextView = null;
  }
}
