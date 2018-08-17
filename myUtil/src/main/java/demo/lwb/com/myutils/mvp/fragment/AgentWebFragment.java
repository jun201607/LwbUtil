package demo.lwb.com.myutils.mvp.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;

import com.just.agentweb.AgentWeb;
import com.just.agentweb.AgentWebConfig;
import com.just.agentweb.DefaultWebClient;
import com.just.agentweb.download.AgentWebDownloader;
import com.just.agentweb.download.DownloadListenerAdapter;
import com.just.agentweb.download.DownloadingService;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import demo.lwb.com.myutils.R;
import demo.lwb.com.myutils.Utils.LogUtils;
import demo.lwb.com.myutils.base.BaseFragment;
import demo.lwb.com.myutils.constants.Constant;
import demo.lwb.com.myutils.mvp.presenter.BasePresenter;

public class AgentWebFragment extends BaseFragment {
    private static final String TAG = "AgentWebFragment";
    @BindView(R.id.ll_Agentview)
    LinearLayout llAgentview;
    AgentWeb mAgentWeb;
    @BindView(R.id.btn_clear)
    Button btnClear;

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


        //传入Activity
        mAgentWeb = AgentWeb.with(this)
                //传入AgentWeb 的父控件 ，如果父控件为 RelativeLayout ， 那么第二参数需要传入 RelativeLayout.LayoutParams
                .setAgentWebParent(llAgentview, new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))
                .useDefaultIndicator(-1, 3)// 使用默认进度条
//                .setAgentWebWebSettings(getSettings())
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
                .go(Constant.Baidu1);


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
}
