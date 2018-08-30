// Generated code from Butter Knife. Do not modify!
package demo.lwb.com.myutils.mvp.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class Local_VideoDetailFragment_ViewBinding implements Unbinder {
  private Local_VideoDetailFragment target;

  private View view2131755335;

  private View view2131755333;

  private View view2131755328;

  private View view2131755326;

  @UiThread
  public Local_VideoDetailFragment_ViewBinding(final Local_VideoDetailFragment target,
      View source) {
    this.target = target;

    View view;
    target.videoView = Utils.findRequiredViewAsType(source, 2131755324, "field 'videoView'", VideoView.class);
    target.llControllerBarLayout = Utils.findRequiredViewAsType(source, 2131755325, "field 'llControllerBarLayout'", LinearLayout.class);
    target.llRightLayout = Utils.findRequiredViewAsType(source, 2131755331, "field 'llRightLayout'", LinearLayout.class);
    view = Utils.findRequiredView(source, 2131755335, "field 'btSwitch' and method 'onViewClicked'");
    target.btSwitch = Utils.castView(view, 2131755335, "field 'btSwitch'", Button.class);
    view2131755335 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755333, "field 'sbVolSeekbar' and method 'onViewClicked'");
    target.sbVolSeekbar = Utils.castView(view, 2131755333, "field 'sbVolSeekbar'", SeekBar.class);
    view2131755333 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvTimeTotal = Utils.findRequiredViewAsType(source, 2131755330, "field 'tvTimeTotal'", TextView.class);
    view = Utils.findRequiredView(source, 2131755328, "field 'btStartPause' and method 'onViewClicked'");
    target.btStartPause = Utils.castView(view, 2131755328, "field 'btStartPause'", Button.class);
    view2131755328 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvVolName = Utils.findRequiredViewAsType(source, 2131755332, "field 'tvVolName'", TextView.class);
    target.tvTimeCurrent = Utils.findRequiredViewAsType(source, 2131755329, "field 'tvTimeCurrent'", TextView.class);
    target.rlVideolayout = Utils.findRequiredViewAsType(source, 2131755323, "field 'rlVideolayout'", RelativeLayout.class);
    target.llLeftLayout = Utils.findRequiredViewAsType(source, 2131755327, "field 'llLeftLayout'", LinearLayout.class);
    view = Utils.findRequiredView(source, 2131755326, "field 'sbProgressSeekbar' and method 'onViewClicked'");
    target.sbProgressSeekbar = Utils.castView(view, 2131755326, "field 'sbProgressSeekbar'", SeekBar.class);
    view2131755326 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.vLine = Utils.findRequiredView(source, 2131755334, "field 'vLine'");
  }

  @Override
  @CallSuper
  public void unbind() {
    Local_VideoDetailFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.videoView = null;
    target.llControllerBarLayout = null;
    target.llRightLayout = null;
    target.btSwitch = null;
    target.sbVolSeekbar = null;
    target.tvTimeTotal = null;
    target.btStartPause = null;
    target.tvVolName = null;
    target.tvTimeCurrent = null;
    target.rlVideolayout = null;
    target.llLeftLayout = null;
    target.sbProgressSeekbar = null;
    target.vLine = null;

    view2131755335.setOnClickListener(null);
    view2131755335 = null;
    view2131755333.setOnClickListener(null);
    view2131755333 = null;
    view2131755328.setOnClickListener(null);
    view2131755328 = null;
    view2131755326.setOnClickListener(null);
    view2131755326 = null;
  }
}
