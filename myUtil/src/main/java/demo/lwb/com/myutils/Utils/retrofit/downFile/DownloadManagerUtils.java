package demo.lwb.com.myutils.Utils.retrofit.downFile;

import android.os.Environment;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import demo.lwb.com.myutils.Utils.FileUtils;
import demo.lwb.com.myutils.Utils.LogUtils;
import demo.lwb.com.myutils.Utils.MyUtils;
import demo.lwb.com.myutils.Utils.retrofit.ApiService;
import demo.lwb.com.myutils.constants.Url;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 下载管理
 * Created by ${R.js} on 2018/3/22.
 */

public class DownloadManagerUtils implements DownloadProgressListener {
    private static final String TAG = "DownloadManagerUtils";
    private DownloadInfo info;
    private ProgressListener progressObserver;
    private File outFile;
    private Disposable subscribe;
    private ApiService service;
    private long currentRead;

    private DownloadManagerUtils() {
        info = new DownloadInfo();
        outFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "wojiushizheyang.mp3");
        info.setSavePath(outFile.getAbsolutePath());
    }

    public static DownloadManagerUtils getInstance() {
        return Holder.manager;
    }

    public static class Holder {
        private static DownloadManagerUtils manager = new DownloadManagerUtils();
    }

    @Override
    public void progress(long read, final long contentLength, final boolean done) {
        // 该方法仍然是在子线程，如果想要调用进度回调，需要切换到主线程，否则的话，会在子线程更新UI，直接错误
        // 如果断电续传，重新请求的文件大小是从断点处到最后的大小，不是整个文件的大小，info中的存储的总长度是
        // 整个文件的大小，所以某一时刻总文件的大小可能会大于从某个断点处请求的文件的总大小。此时read的大小为
        // 之前读取的加上现在读取的
        if (info.getContentLength() > contentLength) {
            read = read + (info.getContentLength() - contentLength);
        } else {
            info.setContentLength(contentLength);
        }
        info.setReadLength(read);

        Observable.just(1).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                if (progressObserver != null) {
                    progressObserver.progressChanged(info.getReadLength(), info.getContentLength(), done);
                }
            }
        });
    }

    /**
     * 开始下载
     * @param url
     */
    public void start(String url) {
        LogUtils.e( MyUtils.getBasUrl(url));
        info.setUrl(url);
        final DownloadInterceptor interceptor = new DownloadInterceptor(this);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(8, TimeUnit.SECONDS);
        builder.addInterceptor(interceptor);
        Retrofit retrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(MyUtils.getBasUrl(Url.fileURL))
                .build();
        if (service == null) {
            service = retrofit.create(ApiService.class);
            info.setService(service);
        } else {
            service = info.getService();
        }
        downLoad();
    }

    /**
     * 开始下载
     */
    private void downLoad() {

         subscribe = service.download("bytes=" + info.getReadLength() + "-", info.getUrl())
                /*指定线程*/
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .retryWhen(new RetryWhenNetworkException())
                /* 读取下载写入文件，并把ResponseBody转成DownInfo */
                .map(new Function<ResponseBody, DownloadInfo>() {
                    @Override
                    public DownloadInfo apply(ResponseBody responseBody) throws Exception {
                        try {
                            LogUtils.e(responseBody.toString());
                            //写入文件
                            FileUtils.writeCache(responseBody, new File(info.getSavePath()), info);
                        } catch (IOException e) {
                            LogUtils.e("异常:"+ e.toString());
                        }
                        return info;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<DownloadInfo>(){
                    @Override
                    public void accept(DownloadInfo downloadInfo) throws Exception {
                        LogUtils.e("accept: " + downloadInfo.toString());
                    }
                });
    }

    /**
     * 暂停下载
     */
    public void pause() {
        if (subscribe != null)
            subscribe.dispose();
    }

    /**
     * 继续下载
     */
    public void reStart() {
        downLoad();
    }

    /**
     * 进度监听
     */
    public interface ProgressListener {
        void progressChanged(long read, long contentLength, boolean done);
    }

    public void setProgressListener(ProgressListener progressObserver) {
        this.progressObserver = progressObserver;
    }
}
