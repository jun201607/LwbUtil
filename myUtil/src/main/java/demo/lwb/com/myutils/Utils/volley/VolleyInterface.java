package demo.lwb.com.myutils.Utils.volley;

import android.content.Context;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONObject;

import static com.android.volley.Response.*;

/**
 * Created by Administrator on 2017/9/6.
 */

public abstract class VolleyInterface {

    public static Listener mListener;
    public static ErrorListener mErrorListener;

    public VolleyInterface() {}

    public abstract void onSuccessString(String result);//成功的回调

    public abstract void onError(VolleyError error);//失败的回调

    public Listener successListener() {
        mListener = new Listener<String>() {
            @Override
            public void onResponse(String response) {
                onSuccessString(response);
            }
        };
        return mListener;
    }

    public ErrorListener errorListener() {
        mErrorListener = new ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//提示请求失败的对话框，避免重复书写
                onError(error);
            }
        };
        return mErrorListener;
    }
}
