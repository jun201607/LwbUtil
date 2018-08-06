package demo.lwb.com.myutils.mvp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import demo.lwb.com.myutils.R;
import demo.lwb.com.myutils.mvp.presenter.HomeTab1Presenter;


/**
 * Created by WESTAKE on 2017/5/19.
 * 工具
 */
public class HomeTab1Fragment extends Fragment {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private HomeTab1Presenter homeTab1Presenter;
    private Unbinder bind;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_home_tab1, container, false);
        bind = ButterKnife.bind(this,mView);
        initView();
        return mView;
    }

    public void initView() {
         homeTab1Presenter = new HomeTab1Presenter(getActivity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), OrientationHelper.VERTICAL));
        homeTab1Presenter.newAdapter(recyclerView);
        homeTab1Presenter.getData();
        homeTab1Presenter.setOnItemClick();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        bind.unbind();
    }
}
