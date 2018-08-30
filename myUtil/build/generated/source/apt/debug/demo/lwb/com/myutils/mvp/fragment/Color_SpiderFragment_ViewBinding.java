// Generated code from Butter Knife. Do not modify!
package demo.lwb.com.myutils.mvp.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.SeekBar;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import demo.lwb.com.myutils.Utils.colorpicker.slider.AlphaSlider;
import demo.lwb.com.myutils.Utils.colorpicker.slider.LightnessSlider;
import demo.lwb.com.myutils.Utils.colorpicker.spider.ColorPickerView;
import demo.lwb.com.myutils.Utils.colorpicker.spider.RxCobwebView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class Color_SpiderFragment_ViewBinding implements Unbinder {
  private Color_SpiderFragment target;

  @UiThread
  public Color_SpiderFragment_ViewBinding(Color_SpiderFragment target, View source) {
    this.target = target;

    target.colorPickerView = Utils.findRequiredViewAsType(source, 2131755309, "field 'colorPickerView'", ColorPickerView.class);
    target.seekbarSpiderNumber = Utils.findRequiredViewAsType(source, 2131755308, "field 'seekbarSpiderNumber'", SeekBar.class);
    target.vLightnessSlider = Utils.findRequiredViewAsType(source, 2131755311, "field 'vLightnessSlider'", LightnessSlider.class);
    target.seekbarLevel = Utils.findRequiredViewAsType(source, 2131755307, "field 'seekbarLevel'", SeekBar.class);
    target.vLightnessSliderLevel = Utils.findRequiredViewAsType(source, 2131755314, "field 'vLightnessSliderLevel'", LightnessSlider.class);
    target.vAlphaSliderLevel = Utils.findRequiredViewAsType(source, 2131755313, "field 'vAlphaSliderLevel'", AlphaSlider.class);
    target.colorPickerViewLevel = Utils.findRequiredViewAsType(source, 2131755312, "field 'colorPickerViewLevel'", ColorPickerView.class);
    target.cobwebView = Utils.findRequiredViewAsType(source, 2131755306, "field 'cobwebView'", RxCobwebView.class);
    target.vAlphaSlider = Utils.findRequiredViewAsType(source, 2131755310, "field 'vAlphaSlider'", AlphaSlider.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    Color_SpiderFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.colorPickerView = null;
    target.seekbarSpiderNumber = null;
    target.vLightnessSlider = null;
    target.seekbarLevel = null;
    target.vLightnessSliderLevel = null;
    target.vAlphaSliderLevel = null;
    target.colorPickerViewLevel = null;
    target.cobwebView = null;
    target.vAlphaSlider = null;
  }
}
