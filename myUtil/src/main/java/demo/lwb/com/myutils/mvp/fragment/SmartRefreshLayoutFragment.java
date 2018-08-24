package demo.lwb.com.myutils.mvp.fragment;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import demo.lwb.com.myutils.R;
import demo.lwb.com.myutils.Utils.LogUtils;
import demo.lwb.com.myutils.adapter.SmartRefreshLayoutAdapter;
import demo.lwb.com.myutils.base.BaseFragment;
import demo.lwb.com.myutils.mvp.presenter.BasePresenter;

/**
 * Created by lwb on 2018/3/30.
 * 下拉刷新上拉加载SmartRefreshLayout
 * gitHub:https://github.com/scwang90/SmartRefreshLayout
 * 來源博客 https://segmentfault.com/a/1190000010066071
 *
 */

public class SmartRefreshLayoutFragment extends BaseFragment {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.smartRefreshLayout)
    SmartRefreshLayout smartRefreshLayout;
    List<String> datas=new ArrayList<>();

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
        return R.layout.fragment_smart_refreshlayout;
    }

    /**
     * UI显示方法，必须在子类onCreateView方法内调用
     */
    @Override
    public void initView() {
        LinearLayoutManager LayoutManager = new LinearLayoutManager(activity);
        LayoutManager.setOrientation(LinearLayout.VERTICAL);
        recyclerView.setLayoutManager(LayoutManager);
        datas.addAll(Arrays.asList(activity.getResources().getStringArray(R.array.ViewUtils)));
        SmartRefreshLayoutAdapter adapter = new SmartRefreshLayoutAdapter(activity,datas);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(activity,LinearLayout.VERTICAL));
        addHeader();
    }

    /**
     * 添加Header
     */
    private void addHeader(){
        //设置 Header 为 Material风格
        smartRefreshLayout.setRefreshHeader(new MaterialHeader(activity).setShowBezierWave(true));
        //设置 Footer 为 球脉冲
        smartRefreshLayout.setRefreshFooter(new BallPulseFooter(activity).setSpinnerStyle(SpinnerStyle.Scale));
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

        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                smartRefreshLayout.finishRefresh(2000);
                LogUtils.e("下拉刷新");
            }
        });
        smartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {
                smartRefreshLayout.finishLoadMore(2000);
                LogUtils.e("上拉加載");
            }
        });
    }
}
