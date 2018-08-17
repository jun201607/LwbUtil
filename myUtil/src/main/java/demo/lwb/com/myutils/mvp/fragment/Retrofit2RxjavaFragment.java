package demo.lwb.com.myutils.mvp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import demo.lwb.com.myutils.R;
import demo.lwb.com.myutils.Utils.LogUtils;
import demo.lwb.com.myutils.Utils.retrofit.MyObserver;
import demo.lwb.com.myutils.Utils.retrofit.RequestUtils;
import demo.lwb.com.myutils.base.BaseFragment;
import demo.lwb.com.myutils.bean.Demo;
import demo.lwb.com.myutils.mvp.presenter.BasePresenter;

public class Retrofit2RxjavaFragment extends BaseFragment {
    @BindView(R.id.btn_get)
    Button btnGet;
    @BindView(R.id.btn_post)
    Button btnPost;
    @BindView(R.id.btn_upLoadFile)
    Button btnUpLoadFile;
    @BindView(R.id.btn_downFile)
    Button btnDownFile;
    @BindView(R.id.tv_get)
    TextView tvGet;
    @BindView(R.id.tv_post)
    TextView tvPost;
    @BindView(R.id.tv_upLoadFile)
    TextView tvUpLoadFile;
    @BindView(R.id.tv_downFile)
    TextView tvDownFile;

    @Override
    public void setMiddleTitle() {

    }

    @Override
    protected BasePresenter bindPresenter() {
        return null;
    }

    @Override
    protected int bindLayout() {
        return R.layout.fragment_retrofit_rxjava;
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

    @OnClick({R.id.btn_get, R.id.btn_post, R.id.btn_upLoadFile, R.id.btn_downFile})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_get:
                getRequest();
                break;
            case R.id.btn_post:
                postRequest();
                break;
            case R.id.btn_upLoadFile:
                uploade();
                break;
            case R.id.btn_downFile:
                downFile();
                break;
        }
    }

    /**
     * post
     */
    private void postRequest() {

    }

    /**
     * down
     */
    private void downFile() {

    }

    /**
     * get
     */
    private void getRequest() {
        RequestUtils.getDemo(this, new MyObserver<Demo>(getActivity()) {
            @Override
            public void onSuccess(Demo result) {
                LogUtils.e(result.toString());
                tvGet.setText(result.toString());
            }

            @Override
            public void onFailure(Throwable e, String errorMsg) {
                LogUtils.e(errorMsg);
            }
        });
    }

    /**
     * upload
     */
    private void uploade() {

    }


}
