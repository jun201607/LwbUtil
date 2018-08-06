package demo.lwb.com.myutils.mvp.fragment;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import demo.lwb.com.myutils.R;
import demo.lwb.com.myutils.adapter.CardViewAdapter;
import demo.lwb.com.myutils.base.BaseFragment;
import demo.lwb.com.myutils.constants.Constant;
import demo.lwb.com.myutils.mvp.presenter.BasePresenter;

/**
 * Created by lwb on 2018/3/30.
 * 卡片式布局
 */

public class CardViewFragment extends BaseFragment {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    List<String> datas=new ArrayList();
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
     * 绑定界面
     *
     * @return
     */
    @Override
    protected int bindLayout() {
        return R.layout.fragment_cardview;
    }

    /**
     * UI显示方法，必须在子类onCreateView方法内调用
     */
    @Override
    public void initView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(activity);
        linearLayoutManager.setOrientation(LinearLayout.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        datas.addAll(Arrays.asList(activity.getResources().getStringArray(R.array.ViewUtils)));
        CardViewAdapter cardViewAdapter = new CardViewAdapter(activity,datas);
        recyclerView.setAdapter(cardViewAdapter);
//        recyclerView.addItemDecoration(new DividerItemDecoration(activity,LinearLayoutManager.VERTICAL));
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

}
