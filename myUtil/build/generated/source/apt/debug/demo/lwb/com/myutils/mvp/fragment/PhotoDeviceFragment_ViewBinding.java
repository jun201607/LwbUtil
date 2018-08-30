// Generated code from Butter Knife. Do not modify!
package demo.lwb.com.myutils.mvp.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PhotoDeviceFragment_ViewBinding implements Unbinder {
  private PhotoDeviceFragment target;

  @UiThread
  public PhotoDeviceFragment_ViewBinding(PhotoDeviceFragment target, View source) {
    this.target = target;

    target.tvDeviceMac = Utils.findRequiredViewAsType(source, 2131755359, "field 'tvDeviceMac'", TextView.class);
    target.tvDeviceImei = Utils.findRequiredViewAsType(source, 2131755356, "field 'tvDeviceImei'", TextView.class);
    target.tvDeviceDensity = Utils.findRequiredViewAsType(source, 2131755350, "field 'tvDeviceDensity'", TextView.class);
    target.tvDeviceVersionName = Utils.findRequiredViewAsType(source, 2131755354, "field 'tvDeviceVersionName'", TextView.class);
    target.tvDeviceIso = Utils.findRequiredViewAsType(source, 2131755374, "field 'tvDeviceIso'", TextView.class);
    target.tvDeviceWidth = Utils.findRequiredViewAsType(source, 2131755352, "field 'tvDeviceWidth'", TextView.class);
    target.tvDeviceSoftwareMccMnc = Utils.findRequiredViewAsType(source, 2131755360, "field 'tvDeviceSoftwareMccMnc'", TextView.class);
    target.tvDeviceSoftwareSimCountryIso = Utils.findRequiredViewAsType(source, 2131755362, "field 'tvDeviceSoftwareSimCountryIso'", TextView.class);
    target.tvDeviceVoiceMailNumber = Utils.findRequiredViewAsType(source, 2131755368, "field 'tvDeviceVoiceMailNumber'", TextView.class);
    target.tvDeviceSoftwareVersion = Utils.findRequiredViewAsType(source, 2131755358, "field 'tvDeviceSoftwareVersion'", TextView.class);
    target.tvDeviceBuildBrand = Utils.findRequiredViewAsType(source, 2131755372, "field 'tvDeviceBuildBrand'", TextView.class);
    target.llInfoRoot = Utils.findRequiredViewAsType(source, 2131755347, "field 'llInfoRoot'", LinearLayout.class);
    target.tvDeviceImsi = Utils.findRequiredViewAsType(source, 2131755357, "field 'tvDeviceImsi'", TextView.class);
    target.tvDeviceAdnroidId = Utils.findRequiredViewAsType(source, 2131755369, "field 'tvDeviceAdnroidId'", TextView.class);
    target.tvDeviceBuildManuFacturer = Utils.findRequiredViewAsType(source, 2131755371, "field 'tvDeviceBuildManuFacturer'", TextView.class);
    target.tvDeviceSoftwareMccMncName = Utils.findRequiredViewAsType(source, 2131755361, "field 'tvDeviceSoftwareMccMncName'", TextView.class);
    target.tvDeviceSimOperatorName = Utils.findRequiredViewAsType(source, 2131755366, "field 'tvDeviceSimOperatorName'", TextView.class);
    target.tvDeviceVersionCode = Utils.findRequiredViewAsType(source, 2131755355, "field 'tvDeviceVersionCode'", TextView.class);
    target.tvDeviceBuildBrandModel = Utils.findRequiredViewAsType(source, 2131755370, "field 'tvDeviceBuildBrandModel'", TextView.class);
    target.tvDeviceSubscriberId = Utils.findRequiredViewAsType(source, 2131755367, "field 'tvDeviceSubscriberId'", TextView.class);
    target.tvDeviceSerialNumber = Utils.findRequiredViewAsType(source, 2131755373, "field 'tvDeviceSerialNumber'", TextView.class);
    target.tvDeviceSimState = Utils.findRequiredViewAsType(source, 2131755365, "field 'tvDeviceSimState'", TextView.class);
    target.activityMain = Utils.findRequiredViewAsType(source, 2131755346, "field 'activityMain'", LinearLayout.class);
    target.tvDeviceHeight = Utils.findRequiredViewAsType(source, 2131755353, "field 'tvDeviceHeight'", TextView.class);
    target.tvDeviceIsPhone = Utils.findRequiredViewAsType(source, 2131755348, "field 'tvDeviceIsPhone'", TextView.class);
    target.tvDeviceSimSerialNumber = Utils.findRequiredViewAsType(source, 2131755364, "field 'tvDeviceSimSerialNumber'", TextView.class);
    target.tvDeviceSimOperator = Utils.findRequiredViewAsType(source, 2131755363, "field 'tvDeviceSimOperator'", TextView.class);
    target.tvDevicePhone = Utils.findRequiredViewAsType(source, 2131755375, "field 'tvDevicePhone'", TextView.class);
    target.tvDeviceSoftwarePhoneType = Utils.findRequiredViewAsType(source, 2131755349, "field 'tvDeviceSoftwarePhoneType'", TextView.class);
    target.tvDeviceManuFacturer = Utils.findRequiredViewAsType(source, 2131755351, "field 'tvDeviceManuFacturer'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PhotoDeviceFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvDeviceMac = null;
    target.tvDeviceImei = null;
    target.tvDeviceDensity = null;
    target.tvDeviceVersionName = null;
    target.tvDeviceIso = null;
    target.tvDeviceWidth = null;
    target.tvDeviceSoftwareMccMnc = null;
    target.tvDeviceSoftwareSimCountryIso = null;
    target.tvDeviceVoiceMailNumber = null;
    target.tvDeviceSoftwareVersion = null;
    target.tvDeviceBuildBrand = null;
    target.llInfoRoot = null;
    target.tvDeviceImsi = null;
    target.tvDeviceAdnroidId = null;
    target.tvDeviceBuildManuFacturer = null;
    target.tvDeviceSoftwareMccMncName = null;
    target.tvDeviceSimOperatorName = null;
    target.tvDeviceVersionCode = null;
    target.tvDeviceBuildBrandModel = null;
    target.tvDeviceSubscriberId = null;
    target.tvDeviceSerialNumber = null;
    target.tvDeviceSimState = null;
    target.activityMain = null;
    target.tvDeviceHeight = null;
    target.tvDeviceIsPhone = null;
    target.tvDeviceSimSerialNumber = null;
    target.tvDeviceSimOperator = null;
    target.tvDevicePhone = null;
    target.tvDeviceSoftwarePhoneType = null;
    target.tvDeviceManuFacturer = null;
  }
}
