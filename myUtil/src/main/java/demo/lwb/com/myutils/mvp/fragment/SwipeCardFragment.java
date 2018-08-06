package demo.lwb.com.myutils.mvp.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;

import butterknife.BindView;
import demo.lwb.com.myutils.R;
import demo.lwb.com.myutils.Utils.CardConfig;
import demo.lwb.com.myutils.adapter.SwipeCardAdapter;
import demo.lwb.com.myutils.base.BaseFragment;
import demo.lwb.com.myutils.bean.SwipeCardBean;
import demo.lwb.com.myutils.manager.SwipeCardLayoutManager;
import demo.lwb.com.myutils.mvp.presenter.BasePresenter;
import demo.lwb.com.myutils.wight.SwipeCardCallBack;

/**
 * Created by lwb on 2018/6/13.
 */

public class SwipeCardFragment extends BaseFragment {
    @BindView(R.id.activity_review)
    RecyclerView activityReview;
    private SwipeCardAdapter mAdatper;
    private ArrayList<SwipeCardBean> mList;
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
        return R.layout.fragment_swipecard;
    }

    /**
     * UI显示方法，必须在子类onCreateView方法内调用
     */
    @Override
    public void initView() {
        mList = new ArrayList<>();
    }

    /**
     * data数据方法，必须在子类onCreateView方法内调用
     */
    @Override
    public void initData() {
        int[] intimage = {R.mipmap.a, R.mipmap.b, R.mipmap.c, R.mipmap.d,
                R.mipmap.e};
        for (int i = 0; i < 5; i++) {
            SwipeCardBean swpe = new SwipeCardBean();
            swpe.resoutimage = intimage[i];
            swpe.title = "美丽" + i;
            mList.add(swpe);
        }
        setData();
    }

    private void setData() {
        SwipeCardLayoutManager swmanamger = new SwipeCardLayoutManager(getActivity());
        activityReview.setLayoutManager(swmanamger);
        mAdatper = new SwipeCardAdapter(mList, activity);
        activityReview.setAdapter(mAdatper);
        CardConfig.initConfig(getActivity());
        ItemTouchHelper.Callback callback=new SwipeCardCallBack(mList,mAdatper,activityReview);
        ItemTouchHelper helper=new ItemTouchHelper(callback);
        helper.attachToRecyclerView(activityReview);
    }
    /**
     * listener事件监听方法，必须在子类onCreateView方法内调用
     */
    @Override
    public void initListener() {

    }

}
