package demo.lwb.com.myutils.Utils.retrofit;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import demo.lwb.com.myutils.constants.Url;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Retrofit封装
 */
public class RetrofitUtils {
    private static final int DEFAULT_TIME=10;
    private static RetrofitUtils mInstance;

    public static RetrofitUtils getInstance() {
        if (mInstance == null) {
            synchronized (RetrofitUtils.class) {
                if (mInstance == null) {
                    mInstance = new RetrofitUtils();
                }
            }
        }
        return mInstance;
    }

    /**
     * 初始化必要对象和参数
     */
    public Retrofit getRetrofit(String url) {
        // 初始化okhttp
        OkHttpClient client = new OkHttpClient().newBuilder()
                .readTimeout(DEFAULT_TIME, TimeUnit.SECONDS)
                .connectTimeout(DEFAULT_TIME, TimeUnit.SECONDS)
                .writeTimeout(DEFAULT_TIME,TimeUnit.SECONDS)
                .addInterceptor(new LogInterceptor())
                .retryOnConnectionFailure(true)
                .build();
        // 初始化Retrofit
       return  new Retrofit.Builder()
                .client(client)
                .baseUrl(url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

//    //返回一个泛型类
//    public static  <T>T getService(Class<T> service){
//        return getInstance().getRetrofit().create(service);
//    }


    public static ApiService  getApiService(){
        return getInstance().getRetrofit(Url.Baidu).create(ApiService.class);
    }

    public static ApiService  getApiService1(){
        return getInstance().getRetrofit(Url.RetrofitUrl).create(ApiService.class);
    }
}
