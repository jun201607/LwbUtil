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

    target.tvDeviceVoiceMailNumber = Utils.findRequiredViewAsType(source, 2131755381, "field 'tvDeviceVoiceMailNumber'", TextView.class);
    target.tvDeviceAdnroidId = Utils.findRequiredViewAsType(source, 2131755382, "field 'tvDeviceAdnroidId'", TextView.class);
    target.tvDeviceSimOperator = Utils.findRequiredViewAsType(source, 2131755376, "field 'tvDeviceSimOperator'", TextView.class);
    target.activityMain = Utils.findRequiredViewAsType(source, 2131755359, "field 'activityMain'", LinearLayout.class);
    target.tvDeviceSerialNumber = Utils.findRequiredViewAsType(source, 2131755386, "field 'tvDeviceSerialNumber'", TextView.class);
    target.tvDeviceSimSerialNumber = Utils.findRequiredViewAsType(source, 2131755377, "field 'tvDeviceSimSerialNumber'", TextView.class);
    target.tvDeviceSimOperatorName = Utils.findRequiredViewAsType(source, 2131755379, "field 'tvDeviceSimOperatorName'", TextView.class);
    target.tvDeviceSoftwareMccMnc = Utils.findRequiredViewAsType(source, 2131755373, "field 'tvDeviceSoftwareMccMnc'", TextView.class);
    target.tvDeviceVersionCode = Utils.findRequiredViewAsType(source, 2131755368, "field 'tvDeviceVersionCode'", TextView.class);
    target.tvDeviceBuildBrand = Utils.findRequiredViewAsType(source, 2131755385, "field 'tvDeviceBuildBrand'", TextView.class);
    target.tvDeviceImei = Utils.findRequiredViewAsType(source, 2131755369, "field 'tvDeviceImei'", TextView.class);
    target.tvDeviceMac = Utils.findRequiredViewAsType(source, 2131755372, "field 'tvDeviceMac'", TextView.class);
    target.tvDeviceSubscriberId = Utils.findRequiredViewAsType(source, 2131755380, "field 'tvDeviceSubscriberId'", TextView.class);
    target.llInfoRoot = Utils.findRequiredViewAsType(source, 2131755360, "field 'llInfoRoot'", LinearLayout.class);
    target.tvDeviceHeight = Utils.findRequiredViewAsType(source, 2131755366, "field 'tvDeviceHeight'", TextView.class);
    target.tvDeviceImsi = Utils.findRequiredViewAsType(source, 2131755370, "field 'tvDeviceImsi'", TextView.class);
    target.tvDeviceDensity = Utils.findRequiredViewAsType(source, 2131755363, "field 'tvDeviceDensity'", TextView.class);
    target.tvDeviceSoftwareSimCountryIso = Utils.findRequiredViewAsType(source, 2131755375, "field 'tvDeviceSoftwareSimCountryIso'", TextView.class);
    target.tvDeviceBuildBrandModel = Utils.findRequiredViewAsType(source, 2131755383, "field 'tvDeviceBuildBrandModel'", TextView.class);
    target.tvDeviceIso = Utils.findRequiredViewAsType(source, 2131755387, "field 'tvDeviceIso'", TextView.class);
    target.tvDeviceVersionName = Utils.findRequiredViewAsType(source, 2131755367, "field 'tvDeviceVersionName'", TextView.class);
    target.tvDeviceManuFacturer = Utils.findRequiredViewAsType(source, 2131755364, "field 'tvDeviceManuFacturer'", TextView.class);
    target.tvDeviceSimState = Utils.findRequiredViewAsType(source, 2131755378, "field 'tvDeviceSimState'", TextView.class);
    target.tvDeviceIsPhone = Utils.findRequiredViewAsType(source, 2131755361, "field 'tvDeviceIsPhone'", TextView.class);
    target.tvDeviceWidth = Utils.findRequiredViewAsType(source, 2131755365, "field 'tvDeviceWidth'", TextView.class);
    target.tvDeviceSoftwareMccMncName = Utils.findRequiredViewAsType(source, 2131755374, "field 'tvDeviceSoftwareMccMncName'", TextView.class);
    target.tvDeviceSoftwareVersion = Utils.findRequiredViewAsType(source, 2131755371, "field 'tvDeviceSoftwareVersion'", TextView.class);
    target.tvDeviceBuildManuFacturer = Utils.findRequiredViewAsType(source, 2131755384, "field 'tvDeviceBuildManuFacturer'", TextView.class);
    target.tvDevicePhone = Utils.findRequiredViewAsType(source, 2131755388, "field 'tvDevicePhone'", TextView.class);
    target.tvDeviceSoftwarePhoneType = Utils.findRequiredViewAsType(source, 2131755362, "field 'tvDeviceSoftwarePhoneType'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PhotoDeviceFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvDeviceVoiceMailNumber = null;
    target.tvDeviceAdnroidId = null;
    target.tvDeviceSimOperator = null;
    target.activityMain = null;
    target.tvDeviceSerialNumber = null;
    target.tvDeviceSimSerialNumber = null;
    target.tvDeviceSimOperatorName = null;
    target.tvDeviceSoftwareMccMnc = null;
    target.tvDeviceVersionCode = null;
    target.tvDeviceBuildBrand = null;
    target.tvDeviceImei = null;
    target.tvDeviceMac = null;
    target.tvDeviceSubscriberId = null;
    target.llInfoRoot = null;
    target.tvDeviceHeight = null;
    target.tvDeviceImsi = null;
    target.tvDeviceDensity = null;
    target.tvDeviceSoftwareSimCountryIso = null;
    target.tvDeviceBuildBrandModel = null;
    target.tvDeviceIso = null;
    target.tvDeviceVersionName = null;
    target.tvDeviceManuFacturer = null;
    target.tvDeviceSimState = null;
    target.tvDeviceIsPhone = null;
    target.tvDeviceWidth = null;
    target.tvDeviceSoftwareMccMncName = null;
    target.tvDeviceSoftwareVersion = null;
    target.tvDeviceBuildManuFacturer = null;
    target.tvDevicePhone = null;
    target.tvDeviceSoftwarePhoneType = null;
  }
}
