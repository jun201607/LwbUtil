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

  private View view2131755264;

  private View view2131755266;

  private View view2131755259;

  private View view2131755257;

  @UiThread
  public Local_VideoDetailFragment_ViewBinding(final Local_VideoDetailFragment target,
      View source) {
    this.target = target;

    View view;
    target.rlVideolayout = Utils.findRequiredViewAsType(source, 2131755254, "field 'rlVideolayout'", RelativeLayout.class);
    view = Utils.findRequiredView(source, 2131755264, "field 'sbVolSeekbar' and method 'onViewClicked'");
    target.sbVolSeekbar = Utils.castView(view, 2131755264, "field 'sbVolSeekbar'", SeekBar.class);
    view2131755264 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvVolName = Utils.findRequiredViewAsType(source, 2131755263, "field 'tvVolName'", TextView.class);
    view = Utils.findRequiredView(source, 2131755266, "field 'btSwitch' and method 'onViewClicked'");
    target.btSwitch = Utils.castView(view, 2131755266, "field 'btSwitch'", Button.class);
    view2131755266 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.llLeftLayout = Utils.findRequiredViewAsType(source, 2131755258, "field 'llLeftLayout'", LinearLayout.class);
    target.tvTimeTotal = Utils.findRequiredViewAsType(source, 2131755261, "field 'tvTimeTotal'", TextView.class);
    target.vLine = Utils.findRequiredView(source, 2131755265, "field 'vLine'");
    target.llControllerBarLayout = Utils.findRequiredViewAsType(source, 2131755256, "field 'llControllerBarLayout'", LinearLayout.class);
    target.videoView = Utils.findRequiredViewAsType(source, 2131755255, "field 'videoView'", VideoView.class);
    target.tvTimeCurrent = Utils.findRequiredViewAsType(source, 2131755260, "field 'tvTimeCurrent'", TextView.class);
    view = Utils.findRequiredView(source, 2131755259, "field 'btStartPause' and method 'onViewClicked'");
    target.btStartPause = Utils.castView(view, 2131755259, "field 'btStartPause'", Button.class);
    view2131755259 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.llRightLayout = Utils.findRequiredViewAsType(source, 2131755262, "field 'llRightLayout'", LinearLayout.class);
    view = Utils.findRequiredView(source, 2131755257, "field 'sbProgressSeekbar' and method 'onViewClicked'");
    target.sbProgressSeekbar = Utils.castView(view, 2131755257, "field 'sbProgressSeekbar'", SeekBar.class);
    view2131755257 = view;
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

    target.rlVideolayout = null;
    target.sbVolSeekbar = null;
    target.tvVolName = null;
    target.btSwitch = null;
    target.llLeftLayout = null;
    target.tvTimeTotal = null;
    target.vLine = null;
    target.llControllerBarLayout = null;
    target.videoView = null;
    target.tvTimeCurrent = null;
    target.btStartPause = null;
    target.llRightLayout = null;
    target.sbProgressSeekbar = null;

    view2131755264.setOnClickListener(null);
    view2131755264 = null;
    view2131755266.setOnClickListener(null);
    view2131755266 = null;
    view2131755259.setOnClickListener(null);
    view2131755259 = null;
    view2131755257.setOnClickListener(null);
    view2131755257 = null;
  }
}
