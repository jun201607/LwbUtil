package system.lwb.com.myapp;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * retrofit2 Api接口 Demo
 */
public interface ApiService {
        /**
         * TODO Get请求
         */
        //第一种方式：GET不带参数
        @GET("demo1.txt")
        Call<ResponseBody> getUser();


        @Headers("Accept:application/json")
        @POST("auth/login")
        @FormUrlEncoded
        Observable<Login> postUser(@Field("username") String username, @Field("password") String password);


//        @Headers("Accept:application/json")
//        @POST("member/avatar")
//        @FormUrlEncoded
//        Call<Login> postUser(@Headers());


        @Multipart
        @POST("member/avatar")
        Observable<Response<UpLoad>> uploadImage(@HeaderMap Map<String, String> headers, @Part MultipartBody.Part file);


        @POST("meditation/start")
        Observable<Response<UpLoad>> postStart(@Header("Authorization") String auth);



        @DELETE("member_follow_member/{id}")
        Observable<Response<UpLoad>> delete(@Header("Authorization") String auth, @Path("id") int id);


        @PUT("member")
        Observable<Response<UpLoad>> put(@HeaderMap Map<String, String> headers,
                                         @Query("nickname") String nickname,
                                         @Query("gender") int sex,
                                         @Query("generation") String age,
                                         @Query("signature") String signature,
                                         @Query("area") String area);

        /**
         * 下载视频
         *
         * @param fileUrl
         * @return
         */
        @Streaming //大文件时要加不然会OOM
        @GET
        Call<ResponseBody> downloadFile(@Url String fileUrl);
}
