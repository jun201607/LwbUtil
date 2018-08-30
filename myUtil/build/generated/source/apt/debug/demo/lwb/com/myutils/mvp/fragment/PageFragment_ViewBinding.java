// Generated code from Butter Knife. Do not modify!
package demo.lwb.com.myutils.mvp.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PageFragment_ViewBinding implements Unbinder {
  private PageFragment target;

  @UiThread
  public PageFragment_ViewBinding(PageFragment target, View source) {
    this.target = target;

    target.textView2 = Utils.findRequiredViewAsType(source, 2131755358, "field 'textView2'", TextView.class);
    target.textView1 = Utils.findRequiredViewAsType(source, 2131755357, "field 'textView1'", TextView.class);
    target.imageView1 = Utils.findRequiredViewAsType(source, 2131755233, "field 'imageView1'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PageFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.textView2 = null;
    target.textView1 = null;
    target.imageView1 = null;
  }
}
