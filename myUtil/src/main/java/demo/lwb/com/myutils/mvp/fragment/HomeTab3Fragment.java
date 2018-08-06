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
import demo.lwb.com.myutils.mvp.presenter.HomeTab3Presenter;


/**
 * Created by WESTAKE on 2017/5/19.
 * 其他
 */
public class HomeTab3Fragment extends Fragment {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private HomeTab3Presenter homeTab3Presenter;
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
        homeTab3Presenter = new HomeTab3Presenter(getActivity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), OrientationHelper.VERTICAL));
        homeTab3Presenter.newAdapter(recyclerView);
        homeTab3Presenter.getData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        bind.unbind();
    }
}
