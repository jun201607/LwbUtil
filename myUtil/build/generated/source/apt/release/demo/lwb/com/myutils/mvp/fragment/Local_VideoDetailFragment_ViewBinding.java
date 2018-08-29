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

  private View view2131755299;

  private View view2131755306;

  private View view2131755308;

  private View view2131755301;

  @UiThread
  public Local_VideoDetailFragment_ViewBinding(final Local_VideoDetailFragment target,
      View source) {
    this.target = target;

    View view;
    target.tvTimeCurrent = Utils.findRequiredViewAsType(source, 2131755302, "field 'tvTimeCurrent'", TextView.class);
    target.llControllerBarLayout = Utils.findRequiredViewAsType(source, 2131755298, "field 'llControllerBarLayout'", LinearLayout.class);
    target.videoView = Utils.findRequiredViewAsType(source, 2131755297, "field 'videoView'", VideoView.class);
    view = Utils.findRequiredView(source, 2131755299, "field 'sbProgressSeekbar' and method 'onViewClicked'");
    target.sbProgressSeekbar = Utils.castView(view, 2131755299, "field 'sbProgressSeekbar'", SeekBar.class);
    view2131755299 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.vLine = Utils.findRequiredView(source, 2131755307, "field 'vLine'");
    target.llLeftLayout = Utils.findRequiredViewAsType(source, 2131755300, "field 'llLeftLayout'", LinearLayout.class);
    view = Utils.findRequiredView(source, 2131755306, "field 'sbVolSeekbar' and method 'onViewClicked'");
    target.sbVolSeekbar = Utils.castView(view, 2131755306, "field 'sbVolSeekbar'", SeekBar.class);
    view2131755306 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.llRightLayout = Utils.findRequiredViewAsType(source, 2131755304, "field 'llRightLayout'", LinearLayout.class);
    view = Utils.findRequiredView(source, 2131755308, "field 'btSwitch' and method 'onViewClicked'");
    target.btSwitch = Utils.castView(view, 2131755308, "field 'btSwitch'", Button.class);
    view2131755308 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.rlVideolayout = Utils.findRequiredViewAsType(source, 2131755296, "field 'rlVideolayout'", RelativeLayout.class);
    target.tvTimeTotal = Utils.findRequiredViewAsType(source, 2131755303, "field 'tvTimeTotal'", TextView.class);
    target.tvVolName = Utils.findRequiredViewAsType(source, 2131755305, "field 'tvVolName'", TextView.class);
    view = Utils.findRequiredView(source, 2131755301, "field 'btStartPause' and method 'onViewClicked'");
    target.btStartPause = Utils.castView(view, 2131755301, "field 'btStartPause'", Button.class);
    view2131755301 = view;
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
    Local_VideoDetailFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvTimeCurrent = null;
    target.llControllerBarLayout = null;
    target.videoView = null;
    target.sbProgressSeekbar = null;
    target.vLine = null;
    target.llLeftLayout = null;
    target.sbVolSeekbar = null;
    target.llRightLayout = null;
    target.btSwitch = null;
    target.rlVideolayout = null;
    target.tvTimeTotal = null;
    target.tvVolName = null;
    target.btStartPause = null;

    view2131755299.setOnClickListener(null);
    view2131755299 = null;
    view2131755306.setOnClickListener(null);
    view2131755306 = null;
    view2131755308.setOnClickListener(null);
    view2131755308 = null;
    view2131755301.setOnClickListener(null);
    view2131755301 = null;
  }
}
