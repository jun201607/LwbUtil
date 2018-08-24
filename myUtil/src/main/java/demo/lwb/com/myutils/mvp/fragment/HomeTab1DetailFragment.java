package demo.lwb.com.myutils.mvp.fragment;

import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import demo.lwb.com.myutils.R;
import demo.lwb.com.myutils.base.BaseFragment;
import demo.lwb.com.myutils.mvp.presenter.BasePresenter;


/**
 * Created by WESTAKE on 2017/5/19.
 * 工具详情
 */
public class HomeTab1DetailFragment extends BaseFragment {

    @BindView(R.id.tv_Utils_detail)
    TextView tvUtilsDetail;
    private Bundle arguments;

    @Override
    public void initView() {
        //内容
        String content="获取应用程序名称----getAppName（）";
        tvUtilsDetail.setText(content);

    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {

    }


    @Override
    public void setMiddleTitle() {

    }

    @Override
    protected BasePresenter bindPresenter() {
        return null;
    }

    @Override
    protected int bindLayout() {
        return R.layout.fragment_home_tab1_detail;
    }

    @Override
    public void popBackListener(int returnCode, Bundle bundle) {

    }


}
