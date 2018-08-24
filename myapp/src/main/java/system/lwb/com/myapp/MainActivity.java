package system.lwb.com.myapp;

import android.Manifest;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.util.ArrayMap;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import system.lwb.com.myapp.Dwon.DownloadListener;
import system.lwb.com.myapp.Dwon.DownloadUtil;

public class MainActivity extends Activity implements View.OnClickListener {
    private static final String TAG = "MainActivity======";
    private Observable<Login> call;
    private Retrofit retrofit;
    private ApiService apiService;
    public static final int RequestCode = 200;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] str=new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE};
        boolean b = PermissionUtils.checkPermissionsGroup(this, str);
        if(!b){
            PermissionUtils.requestPermissions(this,str,RequestCode);
        }
        Button btn_click = (Button) findViewById(R.id.btn_click);
        btn_click.setOnClickListener(this);
        Button btn_click1 = (Button) findViewById(R.id.btn_click1);
        btn_click1.setOnClickListener(this);
        Button btn_click2 = (Button) findViewById(R.id.btn_click2);
        btn_click2.setOnClickListener(this);
        retrofit = new Retrofit.Builder()
                .client(new OkHttpClient())
//                .baseUrl("http://oavnqjdk1.bkt.clouddn.com/")
                .baseUrl("http://api.sdwhcn.com:5056/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);
    }

    private String access_token;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_click:
                downLoad();

                break;
            case R.id.btn_click1:

                break;
            case R.id.btn_click2:
                break;
        }
    }

    private void downLoad() {
        DownloadUtil downloadUtil = new DownloadUtil();
        downloadUtil.downloadFile("xxx/ads", new DownloadListener() {
            @Override
            public void onStart() {
                Log.e(TAG, "onStart: ");
            }

            @Override
            public void onProgress(int currentLength) {
                Log.e(TAG, "onLoading: " + currentLength);
            }

            @Override
            public void onFinish(String localPath) {
                Log.e(TAG, "onFinish: " + localPath);
            }

            @Override
            public void onFailure() {
                Log.e(TAG, "onFailure: ");
            }
        });
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionUtils.requestPermissResult(requestCode,RequestCode,this,grantResults,Manifest.permission.WRITE_EXTERNAL_STORAGE);
    }


}
