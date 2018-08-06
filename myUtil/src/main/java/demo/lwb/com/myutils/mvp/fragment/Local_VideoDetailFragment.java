package demo.lwb.com.myutils.mvp.fragment;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import demo.lwb.com.myutils.R;
import demo.lwb.com.myutils.Utils.DensityUtils;
import demo.lwb.com.myutils.Utils.LogUtils;
import demo.lwb.com.myutils.Utils.MyUtils;
import demo.lwb.com.myutils.base.BaseFragment;
import demo.lwb.com.myutils.mvp.presenter.BasePresenter;

import static android.content.Context.AUDIO_SERVICE;

/**
 * Created by lwb on 2018/6/23.
 */

public class Local_VideoDetailFragment extends BaseFragment {
    @BindView(R.id.video_view)
    VideoView videoView;
    @BindView(R.id.sb_progress_seekbar)
    SeekBar sbProgressSeekbar;
    @BindView(R.id.bt_start_pause)
    Button btStartPause;
    @BindView(R.id.tv_time_current)
    TextView tvTimeCurrent;
    @BindView(R.id.tv_time_total)
    TextView tvTimeTotal;
    @BindView(R.id.ll_left_layout)
    LinearLayout llLeftLayout;
    @BindView(R.id.tv_vol_name)
    TextView tvVolName;
    @BindView(R.id.sb_vol_seekbar)
    SeekBar sbVolSeekbar;
    @BindView(R.id.v_line)
    View vLine;
    @BindView(R.id.bt_switch)
    Button btSwitch;
    @BindView(R.id.ll_right_layout)
    LinearLayout llRightLayout;
    @BindView(R.id.ll_controllerBar_layout)
    LinearLayout llControllerBarLayout;
    @BindView(R.id.rl_videolayout)
    RelativeLayout rlVideolayout;

    private String uri;

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
        return R.layout.fragment_local_video_detail;
    }

    @Override
    public void initView() {
        uri = getArguments().getString("uri");
        if (uri != null) {
            videoView.setVideoURI(Uri.parse(uri));
        }

        //准备好的监听
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                LogUtils.e("准备好");
                videoView.start();
                initVideoPlay();

            }
        });
        //出错监听
        videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                showShortToast("视屏出错");
                return false;

            }
        });
        //完成监听
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                LogUtils.e("完成");
            }
        });

    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {
        activity.toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //返回键
                Bundle bundle = new Bundle();
                bundle.putString("title", "本地视频");
                popback(1, bundle);
            }
        });
    }


    @OnClick({R.id.sb_progress_seekbar, R.id.bt_start_pause, R.id.sb_vol_seekbar, R.id.bt_switch})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.sb_progress_seekbar:
                break;
            case R.id.bt_start_pause:
                if (videoView.isPlaying()) {
                    btStartPause.setText("Start");
                    videoView.pause();
                    //停止刷新UI
                    mHandler.removeMessages(UPDATE_UI);

                } else {
                    btStartPause.setText("Pause");
                    videoView.start();
                    //开启刷新UI
                    mHandler.sendEmptyMessage(UPDATE_UI);
                }
                break;
            case R.id.sb_vol_seekbar:
                break;
            case R.id.bt_switch:
                if (isFullScreen) {
                    //切换为竖屏
                    activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                } else {
                    //切换为横屏
                    activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                }
                break;
        }
    }
    //刷新机制的标志
    private static final int UPDATE_UI = 1;
    /**
     * 定义Handler刷新时间
     * 得到并设置当前视频播放的时间
     * 得到并设置视频播放的总时间
     * 设置SeekBar总进度和当前视频播放的进度
     * 并反复执行Handler刷新时间
     * 指定标识用于关闭Handler
     */
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == UPDATE_UI) {
                int currentPosition = videoView.getCurrentPosition();
                int totalduration = videoView.getDuration();
                MyUtils.updateTime(tvTimeCurrent, currentPosition);
                MyUtils.updateTime(tvTimeTotal, totalduration);
                sbProgressSeekbar.setMax(totalduration);
                sbProgressSeekbar.setProgress(currentPosition);
                mHandler.sendEmptyMessageDelayed(UPDATE_UI, 500);

            }
        }
    };

    /**
     * 初始化播放和刷新时间机制
     */
    private void initVideoPlay() {
        videoView.start();
        //第一个参数是标志，第二个参数是刷新间隔时间
        mHandler.sendEmptyMessageDelayed(UPDATE_UI, 500);
    }

    @Override
    public void onPause() {
        super.onPause();
        //停止刷新UI
        mHandler.removeMessages(UPDATE_UI);
    }

    /**
     * 拖动SeekBar同步SeekBar和Time和VideoView
     */
    private void synchScrollSeekBarAndTime() {
        sbProgressSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            //进度改变的时候同步Time
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                MyUtils.updateTime(tvTimeCurrent, progress);
            }

            //拖动的时候关闭刷新机制
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                mHandler.removeMessages(UPDATE_UI);
            }

            //拖动停止同步VideoView和开启刷新机制
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int progress = seekBar.getProgress();
                videoView.seekTo(progress);
                mHandler.sendEmptyMessage(UPDATE_UI);
            }
        });
    }


    //定义两个变量：代表当前屏幕的宽和屏幕的高
    private int screen_width, screen_height;

    /**
     * 获取屏幕的宽和屏幕的高
     */
    private void initScreenWidthAndHeight() {
        screen_width = getResources().getDisplayMetrics().widthPixels;
        screen_height = getResources().getDisplayMetrics().heightPixels;
    }

    /**
     * 设置VideoView和最外层相对布局的宽和高
     * @param width : 像素的单位
     * @param height : 像素的单位
     */
    private void setVideoViewScale(int width, int height) {
        //获取VideoView宽和高
        ViewGroup.LayoutParams layoutParams = videoView.getLayoutParams();
        //赋值给VideoView的宽和高
        layoutParams.width = width;
        layoutParams.height = height;
        //设置VideoView的宽和高
        videoView.setLayoutParams(layoutParams);
         //同上
         ViewGroup.LayoutParams layoutParams1 = rlVideolayout.getLayoutParams();
         layoutParams.width = width;
         layoutParams.height = height;
         rlVideolayout.setLayoutParams(layoutParams1);
     }

     /**
     * 监听屏幕方向的改变,横竖屏的时候分别做处理
     * @param newConfig
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //当屏幕方向是横屏的时候,我们应该对VideoView以及包裹VideoView的布局（也就是对整体）进行拉伸
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
//            setVideoViewScale(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            //横屏的时候显示
            tvVolName.setVisibility(View.VISIBLE);
            vLine.setVisibility(View.VISIBLE);
            sbVolSeekbar.setVisibility(View.VISIBLE);
            //横屏的时候为true
            isFullScreen = true;
        }//当屏幕方向是竖屏的时候，竖屏的时候的高我们需要把dp转为px
        else {
//            setVideoViewScale(ViewGroup.LayoutParams.MATCH_PARENT, DensityUtils.dip2px(activity, 240));
            //竖屏的时候吟唱
            tvVolName.setVisibility(View.GONE);
            vLine.setVisibility(View.GONE);
            sbVolSeekbar.setVisibility(View.GONE);
            //竖屏的时候为
            isFullScreen = false;
        }
    }

    //初始化音频管理器
    private AudioManager mAudioManager;
    /**
     * 初始化音频管理器;获取设备最大音量和当前音量并设置
     */
    private void initAudioManager() {
        mAudioManager = (AudioManager) activity.getSystemService(AUDIO_SERVICE);
        int streamMaxVolume = mAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int streamVolume = mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        sbVolSeekbar.setMax(streamMaxVolume);
        sbVolSeekbar.setProgress(streamVolume);
    }
    //  定义一个横竖屏切换的变量
    private boolean isFullScreen = false;

}
