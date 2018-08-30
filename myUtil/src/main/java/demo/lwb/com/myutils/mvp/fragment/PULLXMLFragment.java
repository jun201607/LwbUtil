package demo.lwb.com.myutils.mvp.fragment;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import demo.lwb.com.myutils.R;
import demo.lwb.com.myutils.Utils.RxPullXml;
import demo.lwb.com.myutils.base.BaseFragment;
import demo.lwb.com.myutils.bean.CityModel;
import demo.lwb.com.myutils.mvp.presenter.BasePresenter;

public class PULLXMLFragment extends BaseFragment {
    @BindView(R.id.btn_parse_xml)
    Button mBtnParseXml;
    @BindView(R.id.ed_xml_data)
    EditText mEdXmlData;
    @Override
    public void setMiddleTitle() {

    }

    @Override
    protected BasePresenter bindPresenter() {
        return null;
    }

    @Override
    protected int bindLayout() {
        return R.layout.fragment_pull_xmll;
    }

    @Override
    public void initView() {

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

    @OnClick(R.id.btn_parse_xml)
    public void onViewClicked() {

        getCities(getActivity());

    }
    public List<CityModel> getCities(Context mContext) {
        AssetManager assetManager = mContext.getAssets();
        List<CityModel> cityModels = new ArrayList<>();
        try {
            InputStream inputStream = assetManager.open("city_data.xml");
            cityModels = RxPullXml.newInstance().parseXMLWithPull(inputStream, mEdXmlData);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cityModels;
    }

}
