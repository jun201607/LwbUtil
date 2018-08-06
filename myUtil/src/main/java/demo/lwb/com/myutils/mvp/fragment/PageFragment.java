package demo.lwb.com.myutils.mvp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import demo.lwb.com.myutils.R;
import demo.lwb.com.myutils.base.BaseFragment;
import demo.lwb.com.myutils.constants.Constant;
import demo.lwb.com.myutils.mvp.presenter.BasePresenter;

/**
 * Created by lwb on 2018/6/5.
 */

public class PageFragment extends BaseFragment {


    @BindView(R.id.imageView1)
    ImageView imageView1;
    @BindView(R.id.textView1)
    TextView textView1;
    @BindView(R.id.textView2)
    TextView textView2;
    boolean visible = true;
    public static final Fragment newInstance() {
        PageFragment fragment = new PageFragment();
//        Bundle bundle = new Bundle();
//        bundle.putSerializable("OAuthUtils", OAuthUtils);
//        bundle.putString("url", url);
//        fragment.setArguments(bundle);
        return fragment;
    }

    /**
     * Frament退栈监听
     *
     * @param returnCode 返回码
     * @param bundle
     */
    @Override
    public void popBackListener(int returnCode, Bundle bundle) {

    }


    /**
     * 初始化UI
     */
    @Override
    public void initView() {
        Bundle bundle = getArguments();
        int res = bundle.getInt(Constant.KEY, R.mipmap.a);
        imageView1.setImageResource(res);
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!visible) {
                    visible = true;
                    textView1.setVisibility(View.VISIBLE);
                    textView2.setVisibility(View.VISIBLE);
                } else {
                    visible = false;
                    textView1.setVisibility(View.INVISIBLE);
                    textView2.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    /**
     * data数据方法，必须在子类onCreateView方法内调用
     */
    @Override
    public void initData() {

    }

    /**
     * listener事件监听方法，必须在子类onCreateView方法内调用
     */
    @Override
    public void initListener() {

    }


    /**
     * 中心的标题设置
     */
    @Override
    public void setMiddleTitle() {

    }

    /**
     * 绑定P层
     *
     * @return
     */
    @Override
    protected BasePresenter bindPresenter() {
        return null;
    }

    /**
     * 绑定布局
     *
     * @return
     */
    @Override
    protected int bindLayout() {
        return R.layout.fragment_page;
    }


}
