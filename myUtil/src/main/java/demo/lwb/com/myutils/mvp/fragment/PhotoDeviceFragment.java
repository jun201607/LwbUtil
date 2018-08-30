package demo.lwb.com.myutils.mvp.fragment;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import demo.lwb.com.myutils.R;
import demo.lwb.com.myutils.Utils.RxDeviceTool;
import demo.lwb.com.myutils.base.BaseFragment;
import demo.lwb.com.myutils.mvp.presenter.BasePresenter;

/**
 * 设备信息 来自RxTool
 */
public class PhotoDeviceFragment extends BaseFragment {
    @BindView(R.id.tv_device_is_phone)
    TextView tvDeviceIsPhone;
    @BindView(R.id.tv_device_software_phone_type)
    TextView tvDeviceSoftwarePhoneType;
    @BindView(R.id.tv_device_density)
    TextView tvDeviceDensity;
    @BindView(R.id.tv_device_manu_facturer)
    TextView tvDeviceManuFacturer;
    @BindView(R.id.tv_device_width)
    TextView tvDeviceWidth;
    @BindView(R.id.tv_device_height)
    TextView tvDeviceHeight;
    @BindView(R.id.tv_device_version_name)
    TextView tvDeviceVersionName;
    @BindView(R.id.tv_device_version_code)
    TextView tvDeviceVersionCode;
    @BindView(R.id.tv_device_imei)
    TextView tvDeviceImei;
    @BindView(R.id.tv_device_imsi)
    TextView tvDeviceImsi;
    @BindView(R.id.tv_device_software_version)
    TextView tvDeviceSoftwareVersion;
    @BindView(R.id.tv_device_mac)
    TextView tvDeviceMac;
    @BindView(R.id.tv_device_software_mcc_mnc)
    TextView tvDeviceSoftwareMccMnc;
    @BindView(R.id.tv_device_software_mcc_mnc_name)
    TextView tvDeviceSoftwareMccMncName;
    @BindView(R.id.tv_device_software_sim_country_iso)
    TextView tvDeviceSoftwareSimCountryIso;
    @BindView(R.id.tv_device_sim_operator)
    TextView tvDeviceSimOperator;
    @BindView(R.id.tv_device_sim_serial_number)
    TextView tvDeviceSimSerialNumber;
    @BindView(R.id.tv_device_sim_state)
    TextView tvDeviceSimState;
    @BindView(R.id.tv_device_sim_operator_name)
    TextView tvDeviceSimOperatorName;
    @BindView(R.id.tv_device_subscriber_id)
    TextView tvDeviceSubscriberId;
    @BindView(R.id.tv_device_voice_mail_number)
    TextView tvDeviceVoiceMailNumber;
    @BindView(R.id.tv_device_adnroid_id)
    TextView tvDeviceAdnroidId;
    @BindView(R.id.tv_device_build_brand_model)
    TextView tvDeviceBuildBrandModel;
    @BindView(R.id.tv_device_build_manu_facturer)
    TextView tvDeviceBuildManuFacturer;
    @BindView(R.id.tv_device_build_brand)
    TextView tvDeviceBuildBrand;
    @BindView(R.id.tv_device_serial_number)
    TextView tvDeviceSerialNumber;
    @BindView(R.id.tv_device_iso)
    TextView tvDeviceIso;
    @BindView(R.id.tv_device_phone)
    TextView tvDevicePhone;
    @BindView(R.id.ll_info_root)
    LinearLayout llInfoRoot;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;

    @Override
    public void setMiddleTitle() {

    }

    @Override
    protected BasePresenter bindPresenter() {
        return null;
    }

    @Override
    protected int bindLayout() {
        return R.layout.fragment_photo_device;
    }

    @Override
    public void initView() {
        if (RxDeviceTool.isPhone(getActivity())) {
            tvDeviceIsPhone.setText("是");
        } else {
            tvDeviceIsPhone.setText("否");
        }
        tvDeviceSoftwarePhoneType.setText(RxDeviceTool.getPhoneType(getActivity()) + "");
        tvDeviceDensity.setText(RxDeviceTool.getScreenDensity(getActivity()) + "");
        tvDeviceManuFacturer.setText(RxDeviceTool.getUniqueSerialNumber() + "");
        tvDeviceWidth.setText(RxDeviceTool.getScreenWidth(getActivity()) + " ");
        tvDeviceHeight.setText(RxDeviceTool.getScreenHeight(getActivity()) + " ");
        tvDeviceVersionName.setText(RxDeviceTool.getAppVersionName(getActivity()) + "");
        tvDeviceVersionCode.setText(RxDeviceTool.getAppVersionNo(getActivity()) + "");
        tvDeviceImei.setText(RxDeviceTool.getDeviceIdIMEI(getActivity()) + "");
        tvDeviceImsi.setText(RxDeviceTool.getIMSI(getActivity()) + "");
        tvDeviceSoftwareVersion.setText(RxDeviceTool.getDeviceSoftwareVersion(getActivity()) + "");
        tvDeviceMac.setText(RxDeviceTool.getMacAddress(getActivity()));
        tvDeviceSoftwareMccMnc.setText(RxDeviceTool.getNetworkOperator(getActivity()) + "");
        tvDeviceSoftwareMccMncName.setText(RxDeviceTool.getNetworkOperatorName(getActivity()) + "");
        tvDeviceSoftwareSimCountryIso.setText(RxDeviceTool.getNetworkCountryIso(getActivity()) + "");
        tvDeviceSimOperator.setText(RxDeviceTool.getSimOperator(getActivity()) + "");
        tvDeviceSimSerialNumber.setText(RxDeviceTool.getSimSerialNumber(getActivity()) + "");
        tvDeviceSimState.setText(RxDeviceTool.getSimState(getActivity()) + "");
        tvDeviceSimOperatorName.setText(RxDeviceTool.getSimOperatorName(getActivity()) + "");
        tvDeviceSubscriberId.setText(RxDeviceTool.getSubscriberId(getActivity()) + "");
        tvDeviceVoiceMailNumber.setText(RxDeviceTool.getVoiceMailNumber(getActivity()) + "");
        tvDeviceAdnroidId.setText(RxDeviceTool.getAndroidId(getActivity()) + "");
        tvDeviceBuildBrandModel.setText(RxDeviceTool.getBuildBrandModel() + "");
        tvDeviceBuildManuFacturer.setText(RxDeviceTool.getBuildMANUFACTURER() + "");
        tvDeviceBuildBrand.setText(RxDeviceTool.getBuildBrand() + "");
        tvDeviceSerialNumber.setText(RxDeviceTool.getSerialNumber() + "");
        tvDeviceIso.setText(RxDeviceTool.getNetworkCountryIso(getActivity()) + "");
        tvDevicePhone.setText(RxDeviceTool.getLine1Number(getActivity()) + "");
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void popBackListener(int returnCode, Bundle bundle) {

    }

}
