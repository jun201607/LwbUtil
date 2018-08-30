package demo.lwb.com.myutils.mvp.presenter;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import demo.lwb.com.myutils.R;
import demo.lwb.com.myutils.adapter.HomeTab1Adapter;
import demo.lwb.com.myutils.base.BaseAdapter;
import demo.lwb.com.myutils.manager.FramentManages;
import demo.lwb.com.myutils.mvp.demo.PublicFragmentActivity;

/**
 * Created by lwb on 2017/12/24.
 */

public class HomeTab1Presenter extends BasePresenter{
    public static final String HomeTab1Detail="HomeTab1_title";
    private FragmentActivity mActivity;
    List<String> datas=new ArrayList<String>();
    private HomeTab1Adapter adapter;

    public HomeTab1Presenter(FragmentActivity activity) {
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
        datas.addAll(Arrays.asList(mActivity.getResources().getStringArray(R.array.Utils)));
        adapter.notifyDataSetChanged();
    }

    public void setOnItemClick(){
        adapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, Object bean) {
                Bundle bundle=new Bundle();
                bundle.putString(HomeTab1Detail,(String) bean);
               switch ((String) bean){
                   case FramentManages.Titanic:
                       mActivity.startActivity(PublicFragmentActivity.createIntent(mActivity, FramentManages.Titanic, bundle));
                   case FramentManages.AnimationTextView:
                       mActivity.startActivity(PublicFragmentActivity.createIntent(mActivity, FramentManages.AnimationTextView, bundle));
                       break;
                   case FramentManages.LabelView:
                       mActivity.startActivity(PublicFragmentActivity.createIntent(mActivity, FramentManages.LabelView, bundle));
                       break;
                   case FramentManages.EventBus:
                       mActivity.startActivity(PublicFragmentActivity.createIntent(mActivity, FramentManages.EventBus, bundle));
                       break;
                   case FramentManages.DownloadUtils:
                       mActivity.startActivity(PublicFragmentActivity.createIntent(mActivity, FramentManages.DownloadUtils, bundle));
                       break;
                   case FramentManages.Toolbar:
                       mActivity.startActivity(PublicFragmentActivity.createIntent(mActivity, FramentManages.Toolbar, bundle));
                       break;
                   case FramentManages.DrawerLayout:
                       mActivity.startActivity(PublicFragmentActivity.createIntent(mActivity, FramentManages.DrawerLayout, bundle));
                       break;
                   case FramentManages.FloatingActionButton:
                       mActivity.startActivity(PublicFragmentActivity.createIntent(mActivity, FramentManages.FloatingActionButton, bundle));
                       break;
                   case FramentManages.CardView:
                       mActivity.startActivity(PublicFragmentActivity.createIntent(mActivity, FramentManages.CardView, bundle));
                       break;
                   case FramentManages.SmartRefreshLayout:
                       mActivity.startActivity(PublicFragmentActivity.createIntent(mActivity, FramentManages.SmartRefreshLayout, bundle));
                       break;
                   case FramentManages.Messenger:
                       mActivity.startActivity(PublicFragmentActivity.createIntent(mActivity, FramentManages.Messenger, bundle));
                       break;
                   case FramentManages.AIDL:
                       mActivity.startActivity(PublicFragmentActivity.createIntent(mActivity, FramentManages.AIDL, bundle));
                       break;
                   case FramentManages.BottomNavigationBar:
                       mActivity.startActivity(PublicFragmentActivity.createIntent(mActivity, FramentManages.BottomNavigationBar, bundle));
                       break;
                   case FramentManages.Magicindicator:
                       mActivity.startActivity(PublicFragmentActivity.createIntent(mActivity, FramentManages.Magicindicator, bundle));
                       break;
                   case FramentManages.jellyViewPager:
                       mActivity.startActivity(PublicFragmentActivity.createIntent(mActivity, FramentManages.jellyViewPager, bundle));
                       break;
                   case FramentManages.SwipeCard:
                       mActivity.startActivity(PublicFragmentActivity.createIntent(mActivity, FramentManages.SwipeCard, bundle));
                       break;
                   case FramentManages.OpenGl_Triangle:
                       mActivity.startActivity(PublicFragmentActivity.createIntent(mActivity, FramentManages.OpenGl_Triangle, bundle));
                       break;
                   case FramentManages.OpenGl_Square:
                       mActivity.startActivity(PublicFragmentActivity.createIntent(mActivity, FramentManages.OpenGl_Square, bundle));
                       break;
                   case FramentManages.Local_Video:
                       mActivity.startActivity(PublicFragmentActivity.createIntent(mActivity, FramentManages.Local_Video, bundle));
                       break;
                   case FramentManages.WebView:
                       mActivity.startActivity(PublicFragmentActivity.createIntent(mActivity, FramentManages.WebView, bundle));
                       break;
                   case FramentManages.AgentWeb:
                       mActivity.startActivity(PublicFragmentActivity.createIntent(mActivity, FramentManages.AgentWeb, bundle));
                       break;
                   case FramentManages.Retrofit2Rxjava:
                       mActivity.startActivity(PublicFragmentActivity.createIntent(mActivity, FramentManages.Retrofit2Rxjava, bundle));
                       break;
                   case FramentManages.CameraAlbum:
                       mActivity.startActivity(PublicFragmentActivity.createIntent(mActivity, FramentManages.CameraAlbum, bundle));
                       break;
                   case FramentManages.QR_Code:
                       mActivity.startActivity(PublicFragmentActivity.createIntent(mActivity, FramentManages.QR_Code, bundle));
                       break;
                   case FramentManages.Dialog:
                       mActivity.startActivity(PublicFragmentActivity.createIntent(mActivity, FramentManages.Dialog, bundle));
                       break;
                   case FramentManages.PhotoDevice:
                       mActivity.startActivity(PublicFragmentActivity.createIntent(mActivity, FramentManages.PhotoDevice, bundle));
                       break;
                   case FramentManages.ProgressBar:
                       mActivity.startActivity(PublicFragmentActivity.createIntent(mActivity, FramentManages.ProgressBar, bundle));
                       break;
                   default:
                       mActivity.startActivity(PublicFragmentActivity.createIntent(mActivity, FramentManages.UtilsDetail, bundle));
                       break;
               }
            }
        });
    }

}
