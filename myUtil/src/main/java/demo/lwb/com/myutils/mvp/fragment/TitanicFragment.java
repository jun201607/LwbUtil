package demo.lwb.com.myutils.mvp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import demo.lwb.com.myutils.R;
import demo.lwb.com.myutils.base.BaseFragment;
import demo.lwb.com.myutils.mvp.presenter.BasePresenter;
import demo.lwb.com.myutils.mvp.presenter.HomeTab1Presenter;
import demo.lwb.com.myutils.wight.titanic.Titanic;
import demo.lwb.com.myutils.wight.titanic.TitanicTextView;
import demo.lwb.com.myutils.wight.titanic.Typefaces;


/**
 * Created by WESTAKE on 2017/5/19.
 * 水波纹TextView
 */
public class TitanicFragment extends BaseFragment {
    @BindView(R.id.Titanic_TextView)
    demo.lwb.com.myutils.wight.titanic.TitanicTextView TitanicTextView;
    private Bundle arguments;


    @Override
    public void initView() {
        TitanicTextView.setTypeface(Typefaces.get(activity, "Satisfy-Regular.ttf"));
        Titanic titanic = new Titanic();
        titanic.start(TitanicTextView);
//        titanic.cancel();/取消
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
        return R.layout.fragment_titanic;
    }

    @Override
    public void popBackListener(int returnCode, Bundle bundle) {

    }



}
