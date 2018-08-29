package demo.lwb.com.myutils.mvp.fragment;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import demo.lwb.com.myutils.R;
import demo.lwb.com.myutils.Utils.LogUtils;
import demo.lwb.com.myutils.Utils.PermissionUtils;
import demo.lwb.com.myutils.Utils.retrofit.MyObserver;
import demo.lwb.com.myutils.Utils.retrofit.RequestUtils;
import demo.lwb.com.myutils.Utils.retrofit.downFile.DownloadManagerUtils;
import demo.lwb.com.myutils.base.BaseFragment;
import demo.lwb.com.myutils.bean.Demo;
import demo.lwb.com.myutils.bean.LoginBean;
import demo.lwb.com.myutils.bean.UpImage;
import demo.lwb.com.myutils.constants.Url;
import demo.lwb.com.myutils.mvp.presenter.BasePresenter;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.Response;

public class Retrofit2RxjavaFragment extends BaseFragment implements DownloadManagerUtils.ProgressListener {
    public static final int RequestCode = 200;

    @BindView(R.id.btn_get)
    Button btnGet;
    @BindView(R.id.btn_post)
    Button btnPost;
    @BindView(R.id.btn_Delete)
    Button btnDelete;
    @BindView(R.id.btn_Put)
    Button btnPut;
    @BindView(R.id.btn_upLoadFile)
    Button btnUpLoadFile;
    @BindView(R.id.btn_downFile)
    Button btnDownFile;
    @BindView(R.id.btn_stopFile)
    Button btnStopFile;
    @BindView(R.id.tv_get)
    TextView tvGet;
    @BindView(R.id.btn_upLoadFiles)
    Button btnUpLoadFiles;
    @BindView(R.id.tv_progress)
    TextView tvProgress;
    @BindView(R.id.pb_progress)
    ProgressBar pbProgress;
    private String access_token;
    private List<File> files = new ArrayList<>();
    private int i = 0;
    private DownloadManagerUtils downloadManager;
    @Override
    public void setMiddleTitle() {

    }

    @Override
    protected BasePresenter bindPresenter() {
        return null;
    }

    @Override
    protected int bindLayout() {
        return R.layout.fragment_retrofit_rxjava;
    }

    @Override
    public void initView() {
        downloadManager = DownloadManagerUtils.getInstance();
        downloadManager.setProgressListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void popBackListener(int returnCode, Bundle bundle) {
    }

    @OnClick({R.id.btn_get, R.id.btn_post,  R.id.btn_stopFile,  R.id.btn_Delete,  R.id.btn_Put,  R.id.btn_upLoadFile,  R.id.btn_upLoadFiles, R.id.btn_downFile})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_get:
                getRequest();
                break;
            case R.id.btn_post:
                postRequest();
                break;
            case R.id.btn_Delete:
                deleteRequest();
                break;
            case R.id.btn_Put:
                putRequest();
                break;
            case R.id.btn_upLoadFile:
                uploade();
                break;
            case R.id.btn_upLoadFiles:
                uploades();
                break;
            case R.id.btn_downFile:
                downFile();
                break;
            case R.id.btn_stopFile:
                if (i % 2 == 0) {
                    downloadManager.pause();
                    btnStopFile.setText("继续下载");
                } else {
                    downloadManager.reStart();
                    btnStopFile.setText("暂停下载");
                }
                i++;
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionUtils.requestPermissResult(requestCode,RequestCode,getActivity(),grantResults,Manifest.permission.WRITE_EXTERNAL_STORAGE);
    }
    /**
     * PUT
     */
    private void putRequest() {
        RequestUtils.putDemo(this, access_token, new Observer<Response<Demo>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }
            @Override
            public void onNext(Response<Demo> demoResponse) {
                LogUtils.e("code"+demoResponse.code());
                tvGet.setText("code"+demoResponse.code());
            }
            @Override
            public void onError(Throwable e) {
            }
            @Override
            public void onComplete() {
            }
        });
    }

    /**
     * Delete
     */
    private void deleteRequest() {
        RequestUtils.deleteDemo(this, access_token, new Observer<Response<Demo>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Response<Demo> demoResponse) {
                LogUtils.e("code:"+demoResponse.code());
                tvGet.setText("code"+demoResponse.code());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    /**
     * 多文件上传
     */
    private void uploades() {
        files.clear();
        files.add(new File("/storage/emulated/0/Tencent/QQ_Images/null76b875f13b74d7db.jpg"));
        RequestUtils.upLoadImg(this, access_token, files, new Observer<Response<Demo>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Response<Demo> upImageResponse) {
                LogUtils.e("code" + upImageResponse.code());
                tvGet.setText(""+upImageResponse.code());
                LogUtils.e("body" + upImageResponse.body());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }


    private static final String TAG = "Retrofit2RxjavaFragment";
    /**
     * post
     * 测试通过后，私有网址已被我屏蔽
     * 请替换成自己的网址
     */
    private void postRequest() {
        RequestUtils.postDemo(this, "aaa", "sss", new Observer<Response<Demo>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Response<Demo> loginBeanResponse) {
                Log.e(TAG, "onNext: "+ loginBeanResponse.code());

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    /**
     * down
     */
    private void downFile() {
        //下载APK
//        DownloadUtils.downloadAPK(getActivity(), "APKurl", "");
        String[] str=new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE};
        boolean b = PermissionUtils.checkPermissionsGroup(getActivity(), str);
        if(!b){
            PermissionUtils.requestPermissions(getActivity(),str,RequestCode);
        }
        downloadManager.start(Url.fileURL);
    }

    /**
     * get
     */
    private void getRequest() {
        RequestUtils.getDemo(this, new MyObserver<Demo>(getActivity()) {
            @Override
            public void onSuccess(Demo result) {
                LogUtils.e(result.toString());
                tvGet.setText(result.toString());
            }
            @Override
            public void onFailure(Throwable e, String errorMsg) {
                LogUtils.e(errorMsg);
            }
        });
    }

    /**
     * upload
     */
    private void uploade() {
        RequestUtils.upImagView(this, access_token,"/storage/emulated/0/Tencent/QQ_Images/null76b875f13b74d7db.jpg", new Observer<Response<Demo>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }
            @Override
            public void onNext(Response<Demo> upImageResponse) {
                LogUtils.e("code"+upImageResponse.code());
                tvGet.setText(""+upImageResponse.code());
                LogUtils.e("body"+upImageResponse.body());
            }
            @Override
            public void onError(Throwable e) {
                LogUtils.e("onError"+e.getMessage().toString());
                tvGet.setText(e.getMessage().toString());
            }
            @Override
            public void onComplete() {

            }
        });
    }


    @Override
    public void progressChanged(long read, long contentLength, boolean done) {
        final int progress = (int) (100 * read / contentLength);
        pbProgress.setProgress(progress);
        tvProgress.setText(progress + "%");
    }
}
