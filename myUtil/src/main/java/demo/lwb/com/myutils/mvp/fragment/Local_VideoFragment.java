package demo.lwb.com.myutils.mvp.fragment;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import demo.lwb.com.myutils.R;
import demo.lwb.com.myutils.Utils.LogUtils;
import demo.lwb.com.myutils.Utils.MyUtils;
import demo.lwb.com.myutils.adapter.LocalVideoAdapter;
import demo.lwb.com.myutils.base.BaseFragment;
import demo.lwb.com.myutils.bean.MediaBean;
import demo.lwb.com.myutils.manager.FramentManages;
import demo.lwb.com.myutils.mvp.presenter.BasePresenter;
import demo.lwb.com.myutils.mvp.presenter.HomeTab1Presenter;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lwb on 2018/6/21.
 */

public class Local_VideoFragment extends BaseFragment {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    List datas = new ArrayList();
    @BindView(R.id.tv_local_tip)
    TextView tvLocalTip;
    @BindView(R.id.ll_local_progress)
    LinearLayout llLocalProgress;
    @BindView(R.id.smartRefreshLayout)
    SmartRefreshLayout smartRefreshLayout;
    private LocalVideoAdapter adapter;
    private ContentResolver contentResolver;

    @Override
    public void popBackListener(int returnCode, Bundle bundle) {
        String title = bundle.getString("title");
        activity.toolbar.setTitle(title);
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
        return R.layout.fragment_local_video;
    }

    @Override
    public void initView() {
        LinearLayoutManager lm = new LinearLayoutManager(activity);
        lm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(lm);
        adapter = new LocalVideoAdapter(activity, datas);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
    }
    private Uri uri;
    @Override
    public void initData() {
        datas.clear();
        llLocalProgress.setVisibility(View.VISIBLE);
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                contentResolver = activity.getContentResolver();
                uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                String[] objs = {
                        MediaStore.Video.Media.DISPLAY_NAME,//名称
                        MediaStore.Video.Media.DURATION,//时长
                        MediaStore.Video.Media.SIZE,//大小
                        MediaStore.Video.Media.DATA,//地址
                        MediaStore.Video.Media.ARTIST,//演唱者
                };
                Cursor query = contentResolver.query(uri, objs, null, null, null);
                if (query != null) {
                    while (query.moveToNext()) {
                        MediaBean mediaBean = new MediaBean();
                        String name = query.getString(0);
                        long durtion = query.getLong(1);
                        long size = query.getLong(2);
                        String path = query.getString(3);
                        String artist = query.getString(4);
                        MediaMetadataRetriever media = new MediaMetadataRetriever();
                        media.setDataSource(path);
                        Bitmap bitmap  = media.getFrameAtTime(1, MediaMetadataRetriever.OPTION_CLOSEST_SYNC );
                        mediaBean.setName(name);
                        mediaBean.setTime(durtion);
                        mediaBean.setSize(size);
                        mediaBean.setPath(path);
                        mediaBean.setArtics(artist);
                        mediaBean.setBitmap(bitmap);
                        datas.add(mediaBean);
                    }
                    query.close();
                    e.onNext(1);
                }
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {

                        llLocalProgress.setVisibility(View.GONE);
                        if (datas.size() > 0) {
                            adapter.notifyDataSetChanged();
                            tvLocalTip.setVisibility(View.GONE);
                        } else {
                            tvLocalTip.setVisibility(View.VISIBLE);
                        }
                    }
                });
    }

    @Override
    public void initListener() {
        //下拉刷新
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                smartRefreshLayout.finishRefresh(2000);
                initData();
            }
        });

        adapter.setOnItemClickListener(new LocalVideoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, Object pos) {

                LogUtils.e("详情");
            }
        });

        adapter.setOnItemLongClickListener(new LocalVideoAdapter.OnItemLongClickListener() {
            @Override
            public void onItemLongClick(View view, final Object pos) {
                final LinearLayout ll_adapter_two = (LinearLayout) view.findViewById(R.id.ll_adapter_two);
                ll_adapter_two.setVisibility(View.VISIBLE);
                ll_adapter_two.setAnimation(MyUtils.moveToViewLocation());
                final Button delete = (Button) view.findViewById(R.id.btn_adapter_delete);
                delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //删除本地视频
                        deleteLocal(pos);
                    }
                });
                Button cancle = (Button) view.findViewById(R.id.btn_adapter_cancle);
                cancle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ll_adapter_two.setVisibility(View.GONE);
                        ll_adapter_two.setAnimation(MyUtils.moveToViewBottom());
                    }
                });
            }
        });

        //播放监听
        adapter.setOnPlayVideoListen(new LocalVideoAdapter.OnPlayVideo() {
            @Override
            public void playVideo(MediaBean media, int pos) {
                Bundle bundle = new Bundle();
                bundle.putString(HomeTab1Presenter.HomeTab1Detail,"视频详情");
                bundle.putString("uri",media.getPath());
                addFrament(R.id.fr_contain, FramentManages.Local_VideoDetail,bundle,true);

            }
        });

        activity.toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popback();
            }
        });
    }

    /**
     * 删除视频
     */
    private void deleteLocal(Object pos) {
        MediaBean Media = (MediaBean) pos;
        String where = MediaStore.Images.Media.DATA + "='"+Media.getPath()+ "'";
        getActivity().getContentResolver().delete(uri, where, null);
        datas.remove(Media);
        adapter.notifyDataSetChanged();
    }
}
