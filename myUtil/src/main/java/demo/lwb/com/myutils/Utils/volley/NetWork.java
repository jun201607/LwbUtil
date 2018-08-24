package demo.lwb.com.myutils.Utils.volley;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import demo.lwb.com.myutils.Utils.LogUtils;

/**
 * Created by lwb on 2018/1/9.
 */

public class NetWork {

    private static ProgressDialog show;

    /**
     * HttpURLConnection get请求
     * @param activity
     */
    public static void getURLConnection(final Activity activity){
        show = ProgressDialog.show(activity, null, "正在请求中...");
        new Thread(){
            @Override
            public void run() {
                try {
                    String path="";//路径
                    URL url = new URL(path);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(5000);
                    connection.setReadTimeout(6000);
                    connection.connect();
                    int responseCode = connection.getResponseCode();
                    if(responseCode==200){
                        InputStream is = connection.getInputStream();
                        ByteArrayOutputStream bs = new ByteArrayOutputStream();
                        byte[] bytes = new byte[1024];
                        int len=-1;
                        while ((len=is.read(bytes))!=-1){
                            bs.write(bytes,0,len);
                        }
                        final String result = bs.toString();

                        bs.close();
                        is.close();
                        activity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                LogUtils.e(result);
                                show.dismiss();
                            }
                        });
                    }
                    connection.disconnect();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                    show.dismiss();
                } catch (IOException e) {
                    e.printStackTrace();
                    show.dismiss();
                }
            }
        }.start();
    }
    /**
     * HttpURLConnection post请求
     * @param activity
     */
    public static void postURLConnection(final Activity activity){
//        1、显示ProgressDialog
        show = ProgressDialog.show(activity, null, "正在请求中...");
//        2、启动分线程
        new Thread(){
            @Override
            public void run() {
                try {
                    String path="";//路径
                    URL url = new URL(path);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("POST");
                    connection.setConnectTimeout(5000);
                    connection.setReadTimeout(5000);
                    connection.connect();

                    OutputStream os = connection.getOutputStream();
                    String data="";
                    os.write(data.getBytes("utf-8"));
                    int responseCode = connection.getResponseCode();
                    if(responseCode==200){
                        InputStream is = connection.getInputStream();
                        ByteArrayOutputStream bs = new ByteArrayOutputStream();
                        byte[] bytes = new byte[1024];
                        int len=-1;
                        while ((len=is.read(bytes))!=-1){
                            bs.write(bytes,0,len);
                        }
                        final String result = bs.toString();

                        bs.close();
                        is.close();
                        activity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                LogUtils.e(result);
                                show.dismiss();
                            }
                        });
                    }
                    connection.disconnect();
                    os.close();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                    show.dismiss();
                } catch (IOException e) {
                    e.printStackTrace();
                    show.dismiss();
                }
            }
        }.start();
    }

    /**
     * volley get请求
     */
    public static void volleyGet(Activity activity,String path){
        RequestQueue requestQueue = Volley.newRequestQueue(activity);
        show = ProgressDialog.show(activity, null, "正在请求中...");
        StringRequest stringRequest = new StringRequest(path,new Response.Listener<String>(){

            @Override
            public void onResponse(String s) {
              show.dismiss();
            }
        },null);
        requestQueue.add(stringRequest);
    }
    /**
     * volley post请求
     */
    public static void volleyPost(Activity activity,String path){
        RequestQueue requestQueue = Volley.newRequestQueue(activity);
        show = ProgressDialog.show(activity, null, "正在请求中...");
        StringRequest stringRequest = new StringRequest(Request.Method.POST,path,new Response.Listener<String>(){

            @Override
            public void onResponse(String s) {
                show.dismiss();
            }
        },null){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> map = new HashMap<>();
                map.put("key","value");
                map.put("key","value");
                return map;
            }
        };
        requestQueue.add(stringRequest);
    }

    /**
     * 异步任务 请求
     */
    public static void myAsyncTask(final Activity activity){

        new AsyncTask<Void,Void,Void>(){
            @Override
            protected void onPreExecute() {
                show = new ProgressDialog(activity);
                show.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                show.show();

                File apkFile = new File(activity.getExternalFilesDir(null), "update.apk");
            }

            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    String path="";//路径
                    URL url = new URL(path);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("POST");
                    connection.setConnectTimeout(5000);
                    connection.setReadTimeout(5000);
                    connection.connect();

                    OutputStream os = connection.getOutputStream();
                    String data="";
                    os.write(data.getBytes("utf-8"));
                    int responseCode = connection.getResponseCode();
                    if(responseCode==200){
                        InputStream is = connection.getInputStream();
                        ByteArrayOutputStream bs = new ByteArrayOutputStream();
                        byte[] bytes = new byte[1024];
                        int len=-1;
                        while ((len=is.read(bytes))!=-1){
                            bs.write(bytes,0,len);
                        }
                        final String result = bs.toString();

                        bs.close();
                        is.close();
                        activity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                LogUtils.e(result);
                                show.dismiss();
                            }
                        });
                    }
                    connection.disconnect();
                    os.close();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                    show.dismiss();
                } catch (IOException e) {
                    e.printStackTrace();
                    show.dismiss();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                show.dismiss();

            }
        }.execute();
    }

}
