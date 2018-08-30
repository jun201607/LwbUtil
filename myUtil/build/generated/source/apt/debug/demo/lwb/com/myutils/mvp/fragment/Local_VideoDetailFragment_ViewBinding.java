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

  private View view2131755348;

  private View view2131755346;

  private View view2131755341;

  private View view2131755339;

  @UiThread
  public Local_VideoDetailFragment_ViewBinding(final Local_VideoDetailFragment target,
      View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, 2131755348, "field 'btSwitch' and method 'onViewClicked'");
    target.btSwitch = Utils.castView(view, 2131755348, "field 'btSwitch'", Button.class);
    view2131755348 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvTimeCurrent = Utils.findRequiredViewAsType(source, 2131755342, "field 'tvTimeCurrent'", TextView.class);
    target.tvTimeTotal = Utils.findRequiredViewAsType(source, 2131755343, "field 'tvTimeTotal'", TextView.class);
    target.videoView = Utils.findRequiredViewAsType(source, 2131755337, "field 'videoView'", VideoView.class);
    target.tvVolName = Utils.findRequiredViewAsType(source, 2131755345, "field 'tvVolName'", TextView.class);
    view = Utils.findRequiredView(source, 2131755346, "field 'sbVolSeekbar' and method 'onViewClicked'");
    target.sbVolSeekbar = Utils.castView(view, 2131755346, "field 'sbVolSeekbar'", SeekBar.class);
    view2131755346 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.rlVideolayout = Utils.findRequiredViewAsType(source, 2131755336, "field 'rlVideolayout'", RelativeLayout.class);
    view = Utils.findRequiredView(source, 2131755341, "field 'btStartPause' and method 'onViewClicked'");
    target.btStartPause = Utils.castView(view, 2131755341, "field 'btStartPause'", Button.class);
    view2131755341 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755339, "field 'sbProgressSeekbar' and method 'onViewClicked'");
    target.sbProgressSeekbar = Utils.castView(view, 2131755339, "field 'sbProgressSeekbar'", SeekBar.class);
    view2131755339 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.llRightLayout = Utils.findRequiredViewAsType(source, 2131755344, "field 'llRightLayout'", LinearLayout.class);
    target.vLine = Utils.findRequiredView(source, 2131755347, "field 'vLine'");
    target.llLeftLayout = Utils.findRequiredViewAsType(source, 2131755340, "field 'llLeftLayout'", LinearLayout.class);
    target.llControllerBarLayout = Utils.findRequiredViewAsType(source, 2131755338, "field 'llControllerBarLayout'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    Local_VideoDetailFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.btSwitch = null;
    target.tvTimeCurrent = null;
    target.tvTimeTotal = null;
    target.videoView = null;
    target.tvVolName = null;
    target.sbVolSeekbar = null;
    target.rlVideolayout = null;
    target.btStartPause = null;
    target.sbProgressSeekbar = null;
    target.llRightLayout = null;
    target.vLine = null;
    target.llLeftLayout = null;
    target.llControllerBarLayout = null;

    view2131755348.setOnClickListener(null);
    view2131755348 = null;
    view2131755346.setOnClickListener(null);
    view2131755346 = null;
    view2131755341.setOnClickListener(null);
    view2131755341 = null;
    view2131755339.setOnClickListener(null);
    view2131755339 = null;
  }
}
