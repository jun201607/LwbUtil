package demo.lwb.com.myutils.mvp.fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.just.agentweb.AgentWeb;
import com.just.agentweb.AgentWebConfig;
import com.just.agentweb.DefaultWebClient;
import com.just.agentweb.IAgentWebSettings;
import com.just.agentweb.download.AgentWebDownloader;
import com.just.agentweb.download.DownloadListenerAdapter;
import com.just.agentweb.download.DownloadingService;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import demo.lwb.com.myutils.R;
import demo.lwb.com.myutils.Utils.LogUtils;
import demo.lwb.com.myutils.Utils.PermissionUtils;
import demo.lwb.com.myutils.base.BaseFragment;
import demo.lwb.com.myutils.constants.Constant;
import demo.lwb.com.myutils.constants.Url;
import demo.lwb.com.myutils.mvp.presenter.BasePresenter;

public class AgentWebFragment extends BaseFragment {
    private static final String TAG = "AgentWebFragment";
    @BindView(R.id.ll_Agentview)
    LinearLayout llAgentview;
    AgentWeb mAgentWeb;
    @BindView(R.id.btn_clear)
    Button btnClear;
    private static final int RequestCode = 200;
    @Override
    public void setMiddleTitle() {

    }

    @Override
    protected BasePresenter bindPresenter() {
        return null;
    }

    @Override
    protected int bindLayout() {
        return R.layout.fragment_agentweb;
    }

    @Override
    public void initView() {


        String[] permission = {Manifest.permission.CAMERA,Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE,};
        if(!PermissionUtils.checkPermissionsGroup(getActivity(), permission)){
            PermissionUtils.requestPermissions(getActivity(),permission,RequestCode);
        }

        //传入Activity
        mAgentWeb = AgentWeb.with(this)
                //传入AgentWeb 的父控件 ，如果父控件为 RelativeLayout ， 那么第二参数需要传入 RelativeLayout.LayoutParams
                .setAgentWebParent(llAgentview, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))
                .useDefaultIndicator(-1, 3)// 使用默认进度条
                .setWebViewClient(mWebViewClient)
                .setWebChromeClient(mWebChromeClient)
//                .setPermissionInterceptor(mPermissionInterceptor)
                .setSecurityType(AgentWeb.SecurityType.STRICT_CHECK)
//                .setAgentWebUIController(new UIController(getActivity()))
                .setMainFrameErrorView(R.layout.agentweb_error_page, -1)
//                .useMiddlewareWebChrome(getMiddlewareWebChrome())
//                .useMiddlewareWebClient(getMiddlewareWebClient())
                .setOpenOtherPageWays(DefaultWebClient.OpenOtherPageWays.DISALLOW)
                .interceptUnkownUrl()
                .createAgentWeb()
                .ready()
                .go(Url.Baidu);


        //获取 WebView
        WebView webView = mAgentWeb.getWebCreator().getWebView();
    }


    private WebViewClient mWebViewClient = new WebViewClient() {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            //do you  work
        }
    };
    private WebChromeClient mWebChromeClient = new WebChromeClient() {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            //do you work
        }

        @Override
        public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
            callback.invoke(origin,true,true);
            super.onGeolocationPermissionsShowPrompt(origin, callback);
        }
    };

    @Override
    public void initData() {
        // 调用JS方法
//        function callByAndroid(){
//            console.log("callByAndroid")
//        }
        mAgentWeb.getJsAccessEntrace().quickCallJs("callByAndroid");
        // 调用Android 方法
//        mAgentWeb.getJsInterfaceHolder().addJavaObject("android", new AndroidInterface(mAgentWeb, this));
//        window.android.callAndroid();

    }

    @Override
    public void initListener() {
//        返回上一页
//        if (!mAgentWeb.back()){
//            AgentWebFragment.this.getActivity().finish();
//        }
    }

    //文件下载监听
    protected DownloadListenerAdapter mDownloadListenerAdapter = new DownloadListenerAdapter() {
        private DownloadingService mDownloadingService;

        @Override
        public boolean onStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength, AgentWebDownloader.Extra extra) {
            extra.setOpenBreakPointDownload(true)
                    .setIcon(R.drawable.ic_file_download_black_24dp)
                    .setConnectTimeOut(6000)
                    .setBlockMaxTime(2000)
                    .setDownloadTimeOut(60L * 5L * 1000L)
                    .setAutoOpen(true)
                    .setForceDownload(false);
            return false;
        }


        @Override
        public void onBindService(String url, DownloadingService downloadingService) {
            super.onBindService(url, downloadingService);
            mDownloadingService = downloadingService;
            LogUtils.e("onBindService:" + url + "  DownloadingService:" + downloadingService);
        }


        @Override
        public void onUnbindService(String url, DownloadingService downloadingService) {
            super.onUnbindService(url, downloadingService);
            mDownloadingService = null;
            LogUtils.e("onUnbindService:" + url);
        }


        @Override
        public void onProgress(String url, long loaded, long length, long usedTime) {
            int mProgress = (int) ((loaded) / Float.valueOf(length) * 100);
            LogUtils.e("onProgress:" + mProgress);
            super.onProgress(url, loaded, length, usedTime);
        }


        @Override
        public boolean onResult(String path, String url, Throwable throwable) {
            if (null == throwable) {
                //do you work
            } else {

            }
            return false;
        }
    };

    @Override
    public void popBackListener(int returnCode, Bundle bundle) {

    }

    @Override
    public void onPause() {
        mAgentWeb.getWebLifeCycle().onPause();
        super.onPause();
    }

    @Override
    public void onResume() {
        mAgentWeb.getWebLifeCycle().onResume();
        super.onResume();
    }

    @Override
    public void onDestroy() {
        mAgentWeb.getWebLifeCycle().onDestroy();
        super.onDestroy();
    }


    @OnClick(R.id.btn_clear)
    public void onViewClicked() {
        AgentWebConfig.clearDiskCache(this.getContext());
    }


    public class AndroidInterface extends Object{

        public AndroidInterface(AgentWeb mAgentWeb, AgentWebFragment agentWebFragment) {

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == RequestCode) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                tvPermissionStatus.setTextColor(Color.GREEN);
//                tvPermissionStatus.setText("相机权限已申请");
            } else {
                //用户勾选了不再询问
                //提示用户手动打开权限
                if (!ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),Manifest.permission.ACCESS_COARSE_LOCATION)) {
                    Toast.makeText(getActivity(), "定位功能已被禁止", Toast.LENGTH_SHORT).show();
                }else if(!ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),Manifest.permission.CAMERA)){
                    Toast.makeText(getActivity(), "相机功能已被禁止", Toast.LENGTH_SHORT).show();
                }else if(!ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),Manifest.permission.WRITE_EXTERNAL_STORAGE)){
                    Toast.makeText(getActivity(), "存储功能已被禁止", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
