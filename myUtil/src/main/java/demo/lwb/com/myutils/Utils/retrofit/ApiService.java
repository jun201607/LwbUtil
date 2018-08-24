package demo.lwb.com.myutils.Utils.retrofit;

import java.util.List;
import java.util.Map;

import demo.lwb.com.myutils.bean.Demo;
import demo.lwb.com.myutils.bean.LoginBean;
import demo.lwb.com.myutils.bean.UpImage;
import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
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
        Observable<Response<BaseResponse<Demo>>> getUser();//中间的BaseResponse 是自己根据后台数据封装的规范 可以进行修改
        @GET
        Observable<Response<Demo>> getUser(@Url String url); //正常情况   添加ResPonse可以根据Response.Code来判断错误类型
        @GET
        Observable<Demo> getUser1(@Url String url); //简洁方式   直接获取所需数据
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
//        @Headers({"Content-Type:application/json", "Accept:application/json"})
        @Headers("Accept:application/json")
        @POST("login")
        Observable<Response<Demo>> postUser(@Body RequestBody body);
        //第二种方式：@Field

        @Headers("Accept:application/json")
        @POST("auth/login")
        @FormUrlEncoded
        Observable<retrofit2.Response<LoginBean>> postUser(@Field("username") String username, @Field("password") String password);
        //多个参数
        Observable<Response<Demo>> postUser(@FieldMap Map<String, String> map);



        /**
         * TODO DELETE
         */
        @DELETE("member_follow_member/{id}")
        Observable<Response<Demo>> delete(@Header("Authorization") String auth, @Path("id") int id);


        /**
         * TODO PUT
         */
        @PUT("member")
        Observable<Response<Demo>> put(@HeaderMap Map<String, String> headers,
                                         @Query("nickname") String nickname,
                                         @Query("gender") int sex,
                                         @Query("generation") String age,
                                         @Query("signature") String signature,
                                         @Query("area") String area);


        /**
         * TODO 文件上传
         */
        @Multipart
        @POST("upload")
        Observable<ResponseBody> upload(@Part("description") RequestBody description,@Part MultipartBody.Part file);

        //亲测可用
        @Multipart
        @POST("member/avatar")
        Observable<Response<UpImage>> uploadImage(@HeaderMap Map<String, String> headers, @Part MultipartBody.Part file);



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

        //亲测可用
        @Multipart
        @POST("member/avatar")
        Observable<Response<UpImage>> uploadImage1(@HeaderMap Map<String, String> headers, @Part List<MultipartBody.Part> file);


        /**https://blog.csdn.net/impure/article/details/79658098
         * @return Observable
         * @Streaming 这个注解必须添加，否则文件全部写入内存，文件过大会造成内存溢出
         */
        @Streaming
        @GET
        Observable<ResponseBody> download(@Header("RANGE") String start, @Url String url);

}
