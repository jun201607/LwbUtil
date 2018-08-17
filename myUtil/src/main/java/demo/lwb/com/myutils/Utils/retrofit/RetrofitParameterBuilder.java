package demo.lwb.com.myutils.Utils.retrofit;

import android.net.Uri;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public class RetrofitParameterBuilder {
    private static RetrofitParameterBuilder mParameterBuilder;
    private static Map<String, RequestBody> params;

    /**
     * 构建私有方法
     */
    private RetrofitParameterBuilder() {

    }

    /**
     * 初始化对象
     */
    public static RetrofitParameterBuilder newBuilder(){
        if (mParameterBuilder==null){
            mParameterBuilder = new RetrofitParameterBuilder();
            if (params==null){
                params = new HashMap<>();
            }
        }
        return mParameterBuilder;
    }

    /**
     * 添加参数
     * 根据传进来的Object对象来判断是String还是File类型的参数
     */
    public RetrofitParameterBuilder addParameter(String key, Object o) {
        if (o instanceof String) {
            RequestBody body = RequestBody.create(MediaType.parse("text/plain"), (String) o);
            params.put(key, body);
        } else if (o instanceof File) {
            RequestBody body = RequestBody.create(MediaType.parse("multipart/form-data;charset=UTF-8"), (File) o);
            params.put(key + "\"; filename=\"" + ((File) o).getName() + "", body);
        }
        return this;
    }

    /**
     * 初始化图片的Uri来构建参数
     * 一般不常用
     * 主要用在拍照和图库中获取图片路径的时候
     */
    public RetrofitParameterBuilder addFilesByUri(String key, List<Uri> uris) {

        for (int i = 0; i < uris.size(); i++) {
            File file = new File(uris.get(i).getPath());
            RequestBody body = RequestBody.create(MediaType.parse("multipart/form-data;charset=UTF-8"), file);
            params.put(key + i + "\"; filename=\"" + file.getName() + "", body);
        }

        return this;
    }

    /**
     * 网络请求完成之后，别忘了在回调函数中调一下这个方法
     * 如果你用的是RxJava，可以再onCompleted和onError中调一下
     * 如果不清空，可能会出现一个问题，就是下一次的网络请求回带有上次网络请求的参数
     * 因为我这里创建的构造参数的方法是类似于单例，实例不会再次创建
     * 这里是需要注意的地方
     */
    public void cleanParams(){
        if (params!=null){
            params.clear();
        }
    }

    /**
     * 构建RequestBody
     * 可以添加公共参数
     */
    public Map<String, RequestBody> bulider() {

        //添加公共的参数，如Token验证
//        RequestBody body = RequestBody.create(MediaType.parse("text/plain"), (String) token);
//        params.put(“token”, body);

        return params;
    }
}
