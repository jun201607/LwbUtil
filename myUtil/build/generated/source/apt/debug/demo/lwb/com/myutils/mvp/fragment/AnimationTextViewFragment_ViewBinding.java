// Generated code from Butter Knife. Do not modify!
package demo.lwb.com.myutils.mvp.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import demo.lwb.com.myutils.R;
import demo.lwb.com.myutils.wight.MatchView.MatchButton;
import demo.lwb.com.myutils.wight.MatchView.MatchTextView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AnimationTextViewFragment_ViewBinding implements Unbinder {
  private AnimationTextViewFragment target;

  @UiThread
  public AnimationTextViewFragment_ViewBinding(AnimationTextViewFragment target, View source) {
    this.target = target;

    target.tvMatchTextView = Utils.findRequiredViewAsType(source, R.id.tv_MatchTextView, "field 'tvMatchTextView'", MatchTextView.class);
    target.tvMatchButton = Utils.findRequiredViewAsType(source, R.id.tv_MatchButton, "field 'tvMatchButton'", MatchButton.class);
    target.tv_button = Utils.findRequiredViewAsType(source, R.id.tv_button, "field 'tv_button'", Button.class);
    target.tv_button1 = Utils.findRequiredViewAsType(source, R.id.tv_button1, "field 'tv_button1'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AnimationTextViewFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvMatchTextView = null;
    target.tvMatchButton = null;
    target.tv_button = null;
    target.tv_button1 = null;
  }
}
