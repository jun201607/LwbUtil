package demo.lwb.com.myutils.Utils.volley;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import demo.lwb.com.myutils.base.BaseApplication;

/**
 * Created by Administrator on 2017/9/6.
 */

public class VolleyUtil {
    public static StringRequest stringRequest;
    public static JsonObjectRequest jsonObjectRequest;

    public static void getString(Context context,String url, String tag, VolleyInterface vif){
        BaseApplication.getHttpQueues().cancelAll(tag);//如果之前存在，先取消，避免重复的请求

        stringRequest = new StringRequest(Request.Method.GET,url,vif.successListener(),vif.errorListener());
        stringRequest.setTag(tag);
        BaseApplication.getHttpQueues().add(stringRequest);
        BaseApplication.getHttpQueues().start();
    }

    public static void getJson(Context context,String url, String tag, VolleyJsonInterface vif){
        BaseApplication.getHttpQueues().cancelAll(tag);//如果之前存在，先取消，避免重复的请求
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,vif.successListener(),vif.errorListener());
        jsonObjectRequest.setTag(tag);
        BaseApplication.getHttpQueues().add(jsonObjectRequest);
        BaseApplication.getHttpQueues().start();
    }

    public static void postString(Context context, String url, String tag, final Map<String,String> params, VolleyInterface vif){
        BaseApplication.getHttpQueues().cancelAll(tag);
        stringRequest = new StringRequest(url,vif.successListener(),vif.errorListener()){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return params;
            }
        };
        stringRequest.setTag(tag);
        BaseApplication.getHttpQueues().add(stringRequest);
        //MyApplication.getHttpQueues().start();
        //建议不要手动调用 RequestQueue 的 start() 方法，引起的问题“经常会报com.android.volley.NoConnectionError: java.io.InterruptedIOException”，然后就内容加载失败。。。

//        因为在 Volley.newRequestQueue() 方法中，已经调用了 start() 方法。
    }

    public static void postJson(Context context, String url, String tag, Map<String,String> map, VolleyJsonInterface vif){
        //将map转化为JSONObject对象
        JSONObject jsonObject = new JSONObject(map);
        BaseApplication.getHttpQueues().cancelAll(tag);
        jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject,vif.successListener(),vif.errorListener());
        jsonObjectRequest.setTag(tag);
        BaseApplication.getHttpQueues().add(jsonObjectRequest);
        //MyApplication.getHttpQueues().start();
        //建议不要手动调用 RequestQueue 的 start() 方法，引起的问题“经常会报com.android.volley.NoConnectionError: java.io.InterruptedIOException”，然后就内容加载失败。。。

//        因为在 Volley.newRequestQueue() 方法中，已经调用了 start() 方法。
    }

    /**
     * get请求拼接
     * @param url
     * @param params
     * @return
     */
    public static String urlParams(String url, LinkedHashMap<String,String> params){

        Iterator<String> keys = params.keySet().iterator();
        Iterator<String> values = params.values().iterator();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("?");

        for (int i=0;i<params.size();i++ ) {
            String value=null;
            try {
                value= URLEncoder.encode(values.next(),"utf-8");
            }catch (Exception e){
                e.printStackTrace();
            }

            stringBuffer.append(keys.next()+"="+value);
            if (i!=params.size()-1) {
                stringBuffer.append("&");
            }
        }
        return url + stringBuffer.toString();
    }
}
