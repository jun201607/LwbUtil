package demo.lwb.com.myutils.Utils.retrofit;

import java.util.Map;

import demo.lwb.com.myutils.bean.Demo;
import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * retrofit2 Api接口 Demo
 */
public interface ApiService {

//          添加请求头Header
//        Call<ResponseBody> getUser(@Header("Token") String Token, @Url String url)
//        Call<User> getUser(@HeaderMap Map<String, String> headers)
//          添加参数Map
//        Map<String, String> params = new HashMap<>();
//        params.put("client_id", "zhangsan");
//        params.put("client_secret", "12345@");
//          添加RequestBody
//        JSONObject requestObject = new JSONObject();
//        try {
//            requestObject .put("client_id", "zhangsan");
//            requestObject .put("client_secret", "12345@");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        RequestBody requestBody = RequestBody.create(okhttp3.MediaType.parse("application/json;charset=utf-8"), requestObject.toString());


        /**
         * TODO Get请求
         */
        //第一种方式：GET不带参数
        @GET("demo1.txt")
        Observable<Response<Demo>> getUser();
        @GET
        Observable<Response<Demo>> getUser(@Url String url);
        //第二种方式：GET带参数
        @GET("api/data/{type}/{count}/{page}")
        Observable<Response<Demo>> getUser(@Path("type") String type, @Path("count") int count, @Path("page") int page);
        //第三种方式：GET带请求参数：https://api.github.com/users/whatever?client_id=xxxx&client_secret=yyyy
        @GET("users/whatever")
        Observable<Response<Demo>> getUser(@Query("client_id") String id, @Query("client_secret") String secret);
        @GET("users/whatever")
        Observable<Response<Demo>> getUser(@QueryMap Map<String, String> info);

        /**
         * TODO POST请求
         */
        //第一种方式：@Body
        @Headers({"Content-Type:application/json", "Accept:application/json"})
        @POST("login")
        Observable<Response<Demo>> postUser(@Body RequestBody body);
        //第二种方式：@Field
        @POST("login")
        @FormUrlEncoded
        Observable<Response<Demo>> postUser(@Field("username") String username, @Field("password") String password);
        //多个参数
        Observable<Response<Demo>> postUser(@FieldMap Map<String, String> map);

        /**
         * TODO 文件上传 https://blog.csdn.net/tinyzhao/article/details/52685233
         */
        @Multipart
        @POST("upload")
        Observable<ResponseBody> upload(@Part("description") RequestBody description,@Part MultipartBody.Part file);

        /**
         * 多文件上传
         * @param params
         * @param description
         * @return
         */
        @Multipart
        @POST("register")
        Observable<ResponseBody> upload(@PartMap Map<String, RequestBody> params, @Part("description") RequestBody description);
//        Observable<ResponseBody> upload(@Part() List<MultipartBody.Part> parts);

}
