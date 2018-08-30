// Generated code from Butter Knife. Do not modify!
package demo.lwb.com.myutils.mvp.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import demo.lwb.com.myutils.Utils.progressbar.RxIconRoundProgressBar;
import demo.lwb.com.myutils.Utils.progressbar.RxRoundProgress;
import demo.lwb.com.myutils.Utils.progressbar.RxRoundProgressBar;
import demo.lwb.com.myutils.Utils.progressbar.RxTextRoundProgressBar;
import demo.lwb.com.myutils.wight.RxProgressBar;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ProgressBarFragment_ViewBinding implements Unbinder {
  private ProgressBarFragment target;

  private View view2131755378;

  private View view2131755377;

  private View view2131755379;

  @UiThread
  public ProgressBarFragment_ViewBinding(final ProgressBarFragment target, View source) {
    this.target = target;

    View view;
    target.rxRoundPd17 = Utils.findRequiredViewAsType(source, 2131755396, "field 'rxRoundPd17'", RxTextRoundProgressBar.class);
    target.rxRoundPd1 = Utils.findRequiredViewAsType(source, 2131755380, "field 'rxRoundPd1'", RxRoundProgressBar.class);
    target.activityRoundProgressBar = Utils.findRequiredViewAsType(source, 2131755376, "field 'activityRoundProgressBar'", LinearLayout.class);
    target.rxRoundPd12 = Utils.findRequiredViewAsType(source, 2131755391, "field 'rxRoundPd12'", RxIconRoundProgressBar.class);
    target.rxRoundPd8 = Utils.findRequiredViewAsType(source, 2131755387, "field 'rxRoundPd8'", RxIconRoundProgressBar.class);
    target.rxRoundPd14 = Utils.findRequiredViewAsType(source, 2131755393, "field 'rxRoundPd14'", RxIconRoundProgressBar.class);
    target.mRxRoundProgress1 = Utils.findRequiredViewAsType(source, 2131755403, "field 'mRxRoundProgress1'", RxRoundProgress.class);
    target.pbLineOfCredit = Utils.findRequiredViewAsType(source, 2131755401, "field 'pbLineOfCredit'", ProgressBar.class);
    target.rxRoundPd6 = Utils.findRequiredViewAsType(source, 2131755385, "field 'rxRoundPd6'", RxRoundProgressBar.class);
    target.rxRoundPd2 = Utils.findRequiredViewAsType(source, 2131755381, "field 'rxRoundPd2'", RxRoundProgressBar.class);
    target.progressTwo = Utils.findRequiredViewAsType(source, 2131755398, "field 'progressTwo'", RxRoundProgressBar.class);
    target.textView5 = Utils.findRequiredViewAsType(source, 2131755402, "field 'textView5'", TextView.class);
    target.rxRoundPd3 = Utils.findRequiredViewAsType(source, 2131755382, "field 'rxRoundPd3'", RxRoundProgressBar.class);
    target.rxRoundPd15 = Utils.findRequiredViewAsType(source, 2131755394, "field 'rxRoundPd15'", RxTextRoundProgressBar.class);
    target.rxRoundPd7 = Utils.findRequiredViewAsType(source, 2131755386, "field 'rxRoundPd7'", RxRoundProgressBar.class);
    view = Utils.findRequiredView(source, 2131755378, "field 'roundFlikerbar' and method 'onViewClicked'");
    target.roundFlikerbar = Utils.castView(view, 2131755378, "field 'roundFlikerbar'", RxProgressBar.class);
    view2131755378 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.rxRoundPd16 = Utils.findRequiredViewAsType(source, 2131755395, "field 'rxRoundPd16'", RxTextRoundProgressBar.class);
    target.rxRoundPd5 = Utils.findRequiredViewAsType(source, 2131755384, "field 'rxRoundPd5'", RxRoundProgressBar.class);
    target.rxRoundPd4 = Utils.findRequiredViewAsType(source, 2131755383, "field 'rxRoundPd4'", RxRoundProgressBar.class);
    target.textView = Utils.findRequiredViewAsType(source, 2131755400, "field 'textView'", TextView.class);
    view = Utils.findRequiredView(source, 2131755377, "field 'flikerbar' and method 'onViewClicked'");
    target.flikerbar = Utils.castView(view, 2131755377, "field 'flikerbar'", RxProgressBar.class);
    view2131755377 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.rxRoundPd9 = Utils.findRequiredViewAsType(source, 2131755388, "field 'rxRoundPd9'", RxIconRoundProgressBar.class);
    target.rxRoundPd11 = Utils.findRequiredViewAsType(source, 2131755390, "field 'rxRoundPd11'", RxIconRoundProgressBar.class);
    target.rxRoundPd10 = Utils.findRequiredViewAsType(source, 2131755389, "field 'rxRoundPd10'", RxIconRoundProgressBar.class);
    target.rxRoundPd13 = Utils.findRequiredViewAsType(source, 2131755392, "field 'rxRoundPd13'", RxIconRoundProgressBar.class);
    target.progressOne = Utils.findRequiredViewAsType(source, 2131755397, "field 'progressOne'", RxIconRoundProgressBar.class);
    target.progressThree = Utils.findRequiredViewAsType(source, 2131755399, "field 'progressThree'", RxTextRoundProgressBar.class);
    view = Utils.findRequiredView(source, 2131755379, "method 'onViewClicked'");
    view2131755379 = view;
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
    ProgressBarFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rxRoundPd17 = null;
    target.rxRoundPd1 = null;
    target.activityRoundProgressBar = null;
    target.rxRoundPd12 = null;
    target.rxRoundPd8 = null;
    target.rxRoundPd14 = null;
    target.mRxRoundProgress1 = null;
    target.pbLineOfCredit = null;
    target.rxRoundPd6 = null;
    target.rxRoundPd2 = null;
    target.progressTwo = null;
    target.textView5 = null;
    target.rxRoundPd3 = null;
    target.rxRoundPd15 = null;
    target.rxRoundPd7 = null;
    target.roundFlikerbar = null;
    target.rxRoundPd16 = null;
    target.rxRoundPd5 = null;
    target.rxRoundPd4 = null;
    target.textView = null;
    target.flikerbar = null;
    target.rxRoundPd9 = null;
    target.rxRoundPd11 = null;
    target.rxRoundPd10 = null;
    target.rxRoundPd13 = null;
    target.progressOne = null;
    target.progressThree = null;

    view2131755378.setOnClickListener(null);
    view2131755378 = null;
    view2131755377.setOnClickListener(null);
    view2131755377 = null;
    view2131755379.setOnClickListener(null);
    view2131755379 = null;
  }
}
