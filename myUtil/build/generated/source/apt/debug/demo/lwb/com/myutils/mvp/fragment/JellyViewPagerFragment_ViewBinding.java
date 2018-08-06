// Generated code from Butter Knife. Do not modify!
package demo.lwb.com.myutils.mvp.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import demo.lwb.com.myutils.R;
import demo.lwb.com.myutils.wight.JellyViewPager.JellyViewPager;
import java.lang.IllegalStateException;
import java.lang.Override;

public class JellyViewPagerFragment_ViewBinding implements Unbinder {
  private JellyViewPagerFragment target;

  @UiThread
  public JellyViewPagerFragment_ViewBinding(JellyViewPagerFragment target, View source) {
    this.target = target;

    target.jellyViewPager = Utils.findRequiredViewAsType(source, R.id.jellyViewPager, "field 'jellyViewPager'", JellyViewPager.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    JellyViewPagerFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.jellyViewPager = null;
  }
}
