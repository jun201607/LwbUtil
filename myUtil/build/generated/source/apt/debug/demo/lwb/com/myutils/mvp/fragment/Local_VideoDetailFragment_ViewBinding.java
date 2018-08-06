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
import demo.lwb.com.myutils.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class Local_VideoDetailFragment_ViewBinding implements Unbinder {
  private Local_VideoDetailFragment target;

  private View view2131689703;

  private View view2131689705;

  private View view2131689710;

  private View view2131689712;

  @UiThread
  public Local_VideoDetailFragment_ViewBinding(final Local_VideoDetailFragment target,
      View source) {
    this.target = target;

    View view;
    target.videoView = Utils.findRequiredViewAsType(source, R.id.video_view, "field 'videoView'", VideoView.class);
    view = Utils.findRequiredView(source, R.id.sb_progress_seekbar, "field 'sbProgressSeekbar' and method 'onViewClicked'");
    target.sbProgressSeekbar = Utils.castView(view, R.id.sb_progress_seekbar, "field 'sbProgressSeekbar'", SeekBar.class);
    view2131689703 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.bt_start_pause, "field 'btStartPause' and method 'onViewClicked'");
    target.btStartPause = Utils.castView(view, R.id.bt_start_pause, "field 'btStartPause'", Button.class);
    view2131689705 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvTimeCurrent = Utils.findRequiredViewAsType(source, R.id.tv_time_current, "field 'tvTimeCurrent'", TextView.class);
    target.tvTimeTotal = Utils.findRequiredViewAsType(source, R.id.tv_time_total, "field 'tvTimeTotal'", TextView.class);
    target.llLeftLayout = Utils.findRequiredViewAsType(source, R.id.ll_left_layout, "field 'llLeftLayout'", LinearLayout.class);
    target.tvVolName = Utils.findRequiredViewAsType(source, R.id.tv_vol_name, "field 'tvVolName'", TextView.class);
    view = Utils.findRequiredView(source, R.id.sb_vol_seekbar, "field 'sbVolSeekbar' and method 'onViewClicked'");
    target.sbVolSeekbar = Utils.castView(view, R.id.sb_vol_seekbar, "field 'sbVolSeekbar'", SeekBar.class);
    view2131689710 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.vLine = Utils.findRequiredView(source, R.id.v_line, "field 'vLine'");
    view = Utils.findRequiredView(source, R.id.bt_switch, "field 'btSwitch' and method 'onViewClicked'");
    target.btSwitch = Utils.castView(view, R.id.bt_switch, "field 'btSwitch'", Button.class);
    view2131689712 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.llRightLayout = Utils.findRequiredViewAsType(source, R.id.ll_right_layout, "field 'llRightLayout'", LinearLayout.class);
    target.llControllerBarLayout = Utils.findRequiredViewAsType(source, R.id.ll_controllerBar_layout, "field 'llControllerBarLayout'", LinearLayout.class);
    target.rlVideolayout = Utils.findRequiredViewAsType(source, R.id.rl_videolayout, "field 'rlVideolayout'", RelativeLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    Local_VideoDetailFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.videoView = null;
    target.sbProgressSeekbar = null;
    target.btStartPause = null;
    target.tvTimeCurrent = null;
    target.tvTimeTotal = null;
    target.llLeftLayout = null;
    target.tvVolName = null;
    target.sbVolSeekbar = null;
    target.vLine = null;
    target.btSwitch = null;
    target.llRightLayout = null;
    target.llControllerBarLayout = null;
    target.rlVideolayout = null;

    view2131689703.setOnClickListener(null);
    view2131689703 = null;
    view2131689705.setOnClickListener(null);
    view2131689705 = null;
    view2131689710.setOnClickListener(null);
    view2131689710 = null;
    view2131689712.setOnClickListener(null);
    view2131689712 = null;
  }
}
