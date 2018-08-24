package demo.lwb.com.myutils.mvp.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import demo.lwb.com.myutils.R;
import demo.lwb.com.myutils.base.BaseFragment;
import demo.lwb.com.myutils.mvp.presenter.BasePresenter;
import demo.lwb.com.myutils.wight.MatchView.MatchButton;
import demo.lwb.com.myutils.wight.MatchView.MatchTextView;

/**
 * Created by lwb on 2017/12/27.
 * 动画AnimationTextView
 */

public class AnimationTextViewFragment extends BaseFragment {

    @BindView(R.id.tv_MatchTextView)
    MatchTextView tvMatchTextView;
    @BindView(R.id.tv_MatchButton)
    MatchButton tvMatchButton;
    @BindView(R.id.tv_button)
    Button tv_button;
    @BindView(R.id.tv_button1)
    Button tv_button1;

    private Bundle arguments;


    @Override
    public void initView() {

        tv_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvMatchTextView.hide();
                tvMatchButton.hide();

            }
        });

        tv_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvMatchTextView.show();
                tvMatchButton.show();
            }
        });

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
        return R.layout.fragment_animation_textview;
    }

    @Override
    public void popBackListener(int returnCode, Bundle bundle) {

    }



}
