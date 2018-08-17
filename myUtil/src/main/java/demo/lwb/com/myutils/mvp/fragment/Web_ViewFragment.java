package demo.lwb.com.myutils.mvp.fragment;

import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JavascriptInterface;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import demo.lwb.com.myutils.R;
import demo.lwb.com.myutils.Utils.AdvancedWebView;
import demo.lwb.com.myutils.Utils.LogUtils;
import demo.lwb.com.myutils.base.BaseFragment;
import demo.lwb.com.myutils.constants.Constant;
import demo.lwb.com.myutils.mvp.presenter.BasePresenter;

public class Web_ViewFragment extends BaseFragment implements AdvancedWebView.Listener {
    protected static final String DATABASES_SUB_FOLDER = "/databases";
    @BindView(R.id.et_webview_selset)
    EditText etWebviewSelset;
    @BindView(R.id.wv_webview)
    WebView wvWebview;
    @BindView(R.id.btn_click)
    Button btnClick;

    @Override
    public void setMiddleTitle() {

    }

    @Override
    protected BasePresenter bindPresenter() {
        return null;
    }

    @Override
    protected int bindLayout() {
        return R.layout.fragment_webview;
    }

    @Override
    public void initView() {
        initWebSetting();
        wvWebview.loadUrl(Constant.Baidu1);
        //调用Android方法
        callAndroid();
        //调用js方法
        callJS();

        wvWebview.setWebChromeClient(new MyWebChromeClient());
        wvWebview.setWebViewClient(new MyWebViewClient());
    }

    /**
     * 调用js方法
     * 通过WebView的loadUrl（）
     * 通过WebView的evaluateJavascript（） Android 4.4 后才可使用
     * <script>
     * function callJS(){
     * alert("Android调用了JS的callJS方法");
     * }
     * </script>
     */
    private void callJS() {
        //Android 4.4 后才可使用
        //优点：该方法比另一种方法效率更高、使用更简洁。
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            wvWebview.evaluateJavascript("javascript:callJS()", new ValueCallback<String>() {
                @Override
                public void onReceiveValue(String value) {
                    //此处为 js 返回的结果
                }
            });
        } else {//Android 4.4 前使用该方法
            wvWebview.loadUrl("javascript:callJS()");
        }
    }

    /**
     * 调用Android方法
     * 由于对象映射，所以调用test对象等于调用Android映射的对象
     * function callAndroid(){
     * test.hello("js调用了android中的hello方法");
     * }
     */
    private void callAndroid() {
//        第一种方式
        wvWebview.addJavascriptInterface(new AndroidtoJs(), "test");
//        第二种方式
//        function callAndroid(){
//            /*约定的url协议为：js://webview?arg1=111&arg2=222*/
//            document.location = "js://webview?arg1=111&arg2=222";
//         }
//        当该JS通过Android的mWebView.loadUrl("file:///android_asset/javascript.html")加载后，就会回调shouldOverrideUrlLoading （）

//        第三种方式
//        function clickprompt(){
//              var result = prompt("js://demo?arg1=111&arg2=222");
//              alert("demo" + result);
//        }
//        然后调用   onJsPrompt

    }

//    private void initWebChromeClient() {
//        wvWebview.setWebViewClient(new SafeWebChromeClient());
//    }
//
//    private void initWebClient() {
//        wvWebview.setWebViewClient(new SafeWebViewClient());
//    }

    private void initWebSetting() {
        final String filesDir = getContext().getFilesDir().getPath();
        final String databaseDir = filesDir.substring(0, filesDir.lastIndexOf("/")) + DATABASES_SUB_FOLDER;
        WebSettings webSettings = wvWebview.getSettings();
        if (webSettings == null) return;
        // 支持 Js 使用
        webSettings.setJavaScriptEnabled(true);
        //启用地理定位
        webSettings.setGeolocationEnabled(true);
        //设置定位的数据库路径
        webSettings.setGeolocationDatabasePath(databaseDir);
        // 开启DOM缓存
        webSettings.setDomStorageEnabled(true);
        // 开启数据库缓存
        webSettings.setDatabaseEnabled(true);
        // 支持自动加载图片
        webSettings.setLoadsImagesAutomatically(true);
        // 设置 WebView 的缓存模式
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
        // 支持启用缓存模式
        webSettings.setAppCacheEnabled(true);
        // Android 私有缓存存储，如果你不调用setAppCachePath方法，WebView将不会产生这个目录
//        webSettings.setAppCachePath(getCacheDir().getAbsolutePath());
        // 数据库路径
        if (Build.VERSION.SDK_INT < 19) {
            webSettings.setDatabasePath(databaseDir);
        }
        // 支持缩放
        webSettings.setSupportZoom(true);
        // 设置 UserAgent 属性
        webSettings.setUserAgentString("");
        // 允许加载本地 html 文件/false
        webSettings.setAllowFileAccess(true);
        // 允许通过 file url 加载的 Javascript 读取其他的本地文件,Android 4.1 之前默认是true，在 Android 4.1 及以后默认是false,也就是禁止
        webSettings.setAllowFileAccessFromFileURLs(false);
        // 允许通过 file url 加载的 Javascript 可以访问其他的源，包括其他的文件和 http，https 等其他的源，
        // Android 4.1 之前默认是true，在 Android 4.1 及以后默认是false,也就是禁止
        // 如果此设置是允许，则 setAllowFileAccessFromFileURLs 不起做用
        webSettings.setAllowUniversalAccessFromFileURLs(false);
    }

    private void initWebView() {
//        wvWebview.onResume();//在调用 onPause()后，可以调用该方法来恢复 WebView 的运行。
//        wvWebview.resumeTimers();//恢复pauseTimers时的所有操作。(注：pauseTimer和resumeTimers 方法必须一起使用，否则再使用其它场景下的 WebView 会有问题)
//        wvWebview.onPause();//类似 Activity 生命周期，页面进入后台不可见状态
//        wvWebview.pauseTimers();//该方法面向全局整个应用程序的webview，它会暂停所有webview的layout，parsing，JavaScript Timer。当程序进入后台时，该方法的调用可以降低CPU功耗。
//        wvWebview.destroy();//销毁 WebView
//        wvWebview.clearHistory();//清空历史
//        wvWebview.clearCache(true);//包括硬盘
//        wvWebview.reload();//重新加载当前请求
//        wvWebview.removeAllViews();//清除子view。
//        wvWebview.clearSslPreferences();//清除ssl信息。
//        wvWebview.clearMatches();//清除网页查找的高亮匹配字符。
//        wvWebview.removeJavascriptInterface(String interfaceName);//删除interfaceName 对应的注入对象
//        wvWebview.addJavascriptInterface(Object object,String interfaceName);//注入 java 对象。
//        wvWebview.setVerticalScrollBarEnabled(true);//设置垂直方向滚动条。
//        wvWebview.setHorizontalScrollBarEnabled(true);//设置横向滚动条。
//        wvWebview.loadUrl(String url, Map<String, String> additionalHttpHeaders);//加载制定url并携带http header数据。。
//        wvWebview.stopLoading();//停止 WebView 当前加载。
//        wvWebview.freeMemory();//释放内存，不过貌似不好用。
//        wvWebview.clearFormData();//清除自动完成填充的表单数据。需要注意的是，该方法仅仅清除当前表单域自动完成填充的表单数据，并不会清除WebView存储到本地的数据。
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

    @Override
    public void onPageStarted(String url, Bitmap favicon) {

    }

    @Override
    public void onPageFinished(String url) {

    }

    @Override
    public void onPageError(int errorCode, String description, String failingUrl) {

    }

    @Override
    public void onDownloadRequested(String url, String suggestedFilename, String mimeType, long contentLength, String contentDisposition, String userAgent) {

    }

    @Override
    public void onExternalPageRequest(String url) {

    }

    @OnClick(R.id.btn_click)
    public void onViewClicked() {
        String s = etWebviewSelset.getText().toString();
        if (s.startsWith("www")) {
            wvWebview.loadUrl("https://" + s);
        }else {
            wvWebview.loadUrl(s);
        }
    }

    public class MyWebViewClient extends WebViewClient {
        /**
         * 当WebView得页面Scale值发生改变时回调
         */
        @Override
        public void onScaleChanged(WebView view, float oldScale, float newScale) {
            super.onScaleChanged(view, oldScale, newScale);
        }

        /**
         * 是否在 WebView 内加载页面
         */
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            // 步骤2：根据协议的参数，判断是否是所需要的url
            // 一般根据scheme（协议格式） & authority（协议名）判断（前两个参数）
            //假定传入进来的 url = "js://webview?arg1=111&arg2=222"（同时也是约定好的需要拦截的）
            Uri uri = Uri.parse(url);
            // 如果url的协议 = 预先约定的 js 协议
            // 就解析往下解析参数
            if (uri.getScheme().equals("js")) {
                // 如果 authority  = 预先约定协议里的 webview，即代表都符合约定的协议
                // 所以拦截url,下面JS开始调用Android需要的方法
                if (uri.getAuthority().equals("webview")) {
                    // 步骤3：
                    // 执行JS所需要调用的逻辑
                    System.out.println("js调用了Android的方法");
                    // 可以在协议上带有参数并传递到Android上
                    HashMap<String, String> params = new HashMap<>();
                    Set<String> collection = uri.getQueryParameterNames();
                }
                return true;
            }
            return super.shouldOverrideUrlLoading(view, url);
        }

        /**
         * WebView 开始加载页面时回调，一次Frame加载对应一次回调
         */
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        /**
         * WebView 完成加载页面时回调，一次Frame加载对应一次回调
         */
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }

        /**
         * WebView 加载页面资源时会回调，每一个资源产生的一次网络加载，除非本地有当前 url 对应有缓存，否则就会加载。
         */
        @Override
        public void onLoadResource(WebView view, String url) {
            super.onLoadResource(view, url);
        }

        /**
         * WebView 可以拦截某一次的 request 来返回我们自己加载的数据，这个方法在后面缓存会有很大作用。
         */
        @Override
        public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
            return super.shouldInterceptRequest(view, request);
        }

        /**
         * WebView 访问 url 出错
         */
        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
        }

        /**
         * WebView ssl 访问证书出错，handler.cancel()取消加载，handler.proceed()对然错误也继续加载
         */
        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            super.onReceivedSslError(view, handler, error);
        }
    }

    public class MyWebChromeClient extends WebChromeClient {
        /**
         * 输出 Web 端日志
         */
        @Override
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            LogUtils.e(consoleMessage.toString());
            return super.onConsoleMessage(consoleMessage);
        }
        /**
         * 当前 WebView 加载网页进度
         */
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
        }
        /**
         * Js 中调用 alert() 函数，产生的对话框
         */
        @Override
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            LogUtils.e(message+"===="+result.toString());
            return super.onJsAlert(view, url, message, result);
        }

        /**
         * 处理 Js 中的 Confirm 对话框
         */
        @Override
        public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
            LogUtils.e(message);
            return super.onJsConfirm(view, url, message, result);
        }

        /**
         * 处理 JS 中的 Prompt对话框
         */
        @Override
        public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
            LogUtils.e(message);
            // 根据协议的参数，判断是否是所需要的url(原理同方式2)
            // 一般根据scheme（协议格式） & authority（协议名）判断（前两个参数）
            //假定传入进来的 url = "js://webview?arg1=111&arg2=222"（同时也是约定好的需要拦截的）
            Uri uri = Uri.parse(message);
            // 如果url的协议 = 预先约定的 js 协议
            // 就解析往下解析参数
            if (uri.getScheme().equals("js")) {
                // 如果 authority  = 预先约定协议里的 webview，即代表都符合约定的协议
                // 所以拦截url,下面JS开始调用Android需要的方法
                if (uri.getAuthority().equals("webview")) {
                    // 执行JS所需要调用的逻辑
                    System.out.println("js调用了Android的方法");
                    // 可以在协议上带有参数并传递到Android上
                    HashMap<String, String> params = new HashMap<>();
                    Set<String> collection = uri.getQueryParameterNames();

                    //参数result:代表消息框的返回值(输入值)
                    result.confirm("js调用了Android的方法成功啦");
                }
                return true;
            }
            return super.onJsPrompt(view, url, message, defaultValue, result);
        }

        /**
         * 接收web页面的icon
         */
        @Override
        public void onReceivedIcon(WebView view, Bitmap icon) {
            super.onReceivedIcon(view, icon);
        }

        /**
         * 接收web页面的 Title
         */
        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
        }

        @Override
        public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
            callback.invoke(origin, true, false);
            super.onGeolocationPermissionsShowPrompt(origin, callback);
        }
    }


    public class AndroidtoJs extends Object {
        // 定义JS需要调用的方法
        // 被JS调用的方法必须加入@JavascriptInterface注解
        @JavascriptInterface
        public void hello(String msg) {
            System.out.println("JS调用了Android的hello方法");
        }
    }

}
