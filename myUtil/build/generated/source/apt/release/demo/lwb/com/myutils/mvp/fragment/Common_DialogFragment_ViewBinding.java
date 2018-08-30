// Generated code from Butter Knife. Do not modify!
package demo.lwb.com.myutils.mvp.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class Common_DialogFragment_ViewBinding implements Unbinder {
  private Common_DialogFragment target;

  private View view2131755303;

  private View view2131755304;

  private View view2131755310;

  private View view2131755311;

  private View view2131755302;

  private View view2131755309;

  private View view2131755306;

  private View view2131755308;

  private View view2131755307;

  private View view2131755305;

  @UiThread
  public Common_DialogFragment_ViewBinding(final Common_DialogFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, 2131755303, "field 'buttonTran' and method 'onViewClicked'");
    target.buttonTran = Utils.castView(view, 2131755303, "field 'buttonTran'", Button.class);
    view2131755303 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755304, "field 'buttonDialogSure' and method 'onViewClicked'");
    target.buttonDialogSure = Utils.castView(view, 2131755304, "field 'buttonDialogSure'", Button.class);
    view2131755304 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755310, "field 'buttonDialogLoadingspinkit' and method 'onViewClicked'");
    target.buttonDialogLoadingspinkit = Utils.castView(view, 2131755310, "field 'buttonDialogLoadingspinkit'", Button.class);
    view2131755310 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755311, "field 'buttonDialogScaleView' and method 'onViewClicked'");
    target.buttonDialogScaleView = Utils.castView(view, 2131755311, "field 'buttonDialogScaleView'", Button.class);
    view2131755311 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755302, "field 'activityDialog' and method 'onViewClicked'");
    target.activityDialog = Utils.castView(view, 2131755302, "field 'activityDialog'", LinearLayout.class);
    view2131755302 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755309, "field 'buttonDialogLoadingProgressAcfunVideo' and method 'onViewClicked'");
    target.buttonDialogLoadingProgressAcfunVideo = Utils.castView(view, 2131755309, "field 'buttonDialogLoadingProgressAcfunVideo'", Button.class);
    view2131755309 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755306, "field 'buttonDialogEditTextSureCancle' and method 'onViewClicked'");
    target.buttonDialogEditTextSureCancle = Utils.castView(view, 2131755306, "field 'buttonDialogEditTextSureCancle'", Button.class);
    view2131755306 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755308, "field 'buttonDialogShapeLoading' and method 'onViewClicked'");
    target.buttonDialogShapeLoading = Utils.castView(view, 2131755308, "field 'buttonDialogShapeLoading'", Button.class);
    view2131755308 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755307, "field 'buttonDialogWheelYearMonthDay' and method 'onViewClicked'");
    target.buttonDialogWheelYearMonthDay = Utils.castView(view, 2131755307, "field 'buttonDialogWheelYearMonthDay'", Button.class);
    view2131755307 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755305, "field 'buttonDialogSureCancle' and method 'onViewClicked'");
    target.buttonDialogSureCancle = Utils.castView(view, 2131755305, "field 'buttonDialogSureCancle'", Button.class);
    view2131755305 = view;
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
    Common_DialogFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.buttonTran = null;
    target.buttonDialogSure = null;
    target.buttonDialogLoadingspinkit = null;
    target.buttonDialogScaleView = null;
    target.activityDialog = null;
    target.buttonDialogLoadingProgressAcfunVideo = null;
    target.buttonDialogEditTextSureCancle = null;
    target.buttonDialogShapeLoading = null;
    target.buttonDialogWheelYearMonthDay = null;
    target.buttonDialogSureCancle = null;

    view2131755303.setOnClickListener(null);
    view2131755303 = null;
    view2131755304.setOnClickListener(null);
    view2131755304 = null;
    view2131755310.setOnClickListener(null);
    view2131755310 = null;
    view2131755311.setOnClickListener(null);
    view2131755311 = null;
    view2131755302.setOnClickListener(null);
    view2131755302 = null;
    view2131755309.setOnClickListener(null);
    view2131755309 = null;
    view2131755306.setOnClickListener(null);
    view2131755306 = null;
    view2131755308.setOnClickListener(null);
    view2131755308 = null;
    view2131755307.setOnClickListener(null);
    view2131755307 = null;
    view2131755305.setOnClickListener(null);
    view2131755305 = null;
  }
}
