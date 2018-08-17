package demo.lwb.com.myutils.Utils.retrofit;

import android.content.Context;

import com.trello.rxlifecycle2.components.support.RxFragment;

import java.io.File;

import demo.lwb.com.myutils.Utils.FileUtils;
import demo.lwb.com.myutils.bean.Demo;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * 项目请求 归纳类
 */
public class RequestUtils {
    /**
     * retrofit2 请求demo
     * @param context
     * @param observer
     */
    public static void getDemo(RxFragment context,MyObserver<Demo> observer){
        RetrofitUtils.getApiService()
                .getUser().compose(RxHelper.observableIO2Main(context))
                .subscribe(observer);
    }


    public static void UpImagView(RxFragment context,Observer<ResponseBody>  observer){
        File file =new File("/storage/sdcard/Desert.jpg");

//        RequestBody reqFile = RequestBody.create(MediaType.parse("image/*"), file);
        RequestBody requestFile =
                RequestBody.create(MediaType.parse("multipart/form-data"), file);

        MultipartBody.Part body =
                MultipartBody.Part.createFormData("picture", file.getName(), requestFile);

        String descriptionString = "hello, this is description speaking";
        RequestBody description = RequestBody.create(MediaType.parse("multipart/form-data"), descriptionString);
        RetrofitUtils.getApiService().upload(description,body).compose(RxHelper.observableIO2Main(context))
                .subscribe(observer);

    }

}
