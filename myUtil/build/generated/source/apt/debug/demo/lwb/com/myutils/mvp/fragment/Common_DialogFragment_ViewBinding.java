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

  private View view2131755320;

  private View view2131755316;

  private View view2131755319;

  private View view2131755324;

  private View view2131755315;

  private View view2131755317;

  private View view2131755322;

  private View view2131755323;

  private View view2131755321;

  private View view2131755318;

  @UiThread
  public Common_DialogFragment_ViewBinding(final Common_DialogFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, 2131755320, "field 'buttonDialogWheelYearMonthDay' and method 'onViewClicked'");
    target.buttonDialogWheelYearMonthDay = Utils.castView(view, 2131755320, "field 'buttonDialogWheelYearMonthDay'", Button.class);
    view2131755320 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755316, "field 'buttonTran' and method 'onViewClicked'");
    target.buttonTran = Utils.castView(view, 2131755316, "field 'buttonTran'", Button.class);
    view2131755316 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755319, "field 'buttonDialogEditTextSureCancle' and method 'onViewClicked'");
    target.buttonDialogEditTextSureCancle = Utils.castView(view, 2131755319, "field 'buttonDialogEditTextSureCancle'", Button.class);
    view2131755319 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755324, "field 'buttonDialogScaleView' and method 'onViewClicked'");
    target.buttonDialogScaleView = Utils.castView(view, 2131755324, "field 'buttonDialogScaleView'", Button.class);
    view2131755324 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755315, "field 'activityDialog' and method 'onViewClicked'");
    target.activityDialog = Utils.castView(view, 2131755315, "field 'activityDialog'", LinearLayout.class);
    view2131755315 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755317, "field 'buttonDialogSure' and method 'onViewClicked'");
    target.buttonDialogSure = Utils.castView(view, 2131755317, "field 'buttonDialogSure'", Button.class);
    view2131755317 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755322, "field 'buttonDialogLoadingProgressAcfunVideo' and method 'onViewClicked'");
    target.buttonDialogLoadingProgressAcfunVideo = Utils.castView(view, 2131755322, "field 'buttonDialogLoadingProgressAcfunVideo'", Button.class);
    view2131755322 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755323, "field 'buttonDialogLoadingspinkit' and method 'onViewClicked'");
    target.buttonDialogLoadingspinkit = Utils.castView(view, 2131755323, "field 'buttonDialogLoadingspinkit'", Button.class);
    view2131755323 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755321, "field 'buttonDialogShapeLoading' and method 'onViewClicked'");
    target.buttonDialogShapeLoading = Utils.castView(view, 2131755321, "field 'buttonDialogShapeLoading'", Button.class);
    view2131755321 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, 2131755318, "field 'buttonDialogSureCancle' and method 'onViewClicked'");
    target.buttonDialogSureCancle = Utils.castView(view, 2131755318, "field 'buttonDialogSureCancle'", Button.class);
    view2131755318 = view;
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

    target.buttonDialogWheelYearMonthDay = null;
    target.buttonTran = null;
    target.buttonDialogEditTextSureCancle = null;
    target.buttonDialogScaleView = null;
    target.activityDialog = null;
    target.buttonDialogSure = null;
    target.buttonDialogLoadingProgressAcfunVideo = null;
    target.buttonDialogLoadingspinkit = null;
    target.buttonDialogShapeLoading = null;
    target.buttonDialogSureCancle = null;

    view2131755320.setOnClickListener(null);
    view2131755320 = null;
    view2131755316.setOnClickListener(null);
    view2131755316 = null;
    view2131755319.setOnClickListener(null);
    view2131755319 = null;
    view2131755324.setOnClickListener(null);
    view2131755324 = null;
    view2131755315.setOnClickListener(null);
    view2131755315 = null;
    view2131755317.setOnClickListener(null);
    view2131755317 = null;
    view2131755322.setOnClickListener(null);
    view2131755322 = null;
    view2131755323.setOnClickListener(null);
    view2131755323 = null;
    view2131755321.setOnClickListener(null);
    view2131755321 = null;
    view2131755318.setOnClickListener(null);
    view2131755318 = null;
  }
}
