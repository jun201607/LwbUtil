package demo.lwb.com.myutils.mvp.presenter;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import demo.lwb.com.myutils.R;
import demo.lwb.com.myutils.adapter.HomeTab1Adapter;
import demo.lwb.com.myutils.constants.Constant;

/**
 * Created by Administrator on 2017/12/24.
 */

public class HomeTab2Presenter extends BasePresenter{
    public static final String HomeTab1Detail="HomeTab1_title";
    private FragmentActivity mActivity;
    List<String> datas=new ArrayList<String>();
    private HomeTab1Adapter adapter;

    public HomeTab2Presenter(FragmentActivity activity) {
        mActivity = activity;
    }

    @Override
    public void unBindP() {
        mActivity=null;
    }

    public void newAdapter(RecyclerView recyclerView){
        adapter = new HomeTab1Adapter(mActivity, datas);
        recyclerView.setAdapter(adapter);
    }

    public void getData(){
        datas.addAll(Arrays.asList(mActivity.getResources().getStringArray(R.array.ViewUtils)));
        adapter.notifyDataSetChanged();
    }

}
