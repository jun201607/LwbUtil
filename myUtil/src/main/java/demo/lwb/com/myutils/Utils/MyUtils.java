package demo.lwb.com.myutils.Utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import android.widget.Toast;

import demo.lwb.com.myutils.base.BaseApplication;

/**
 * Created by BlueSky on 2018/6/5.
 */

public class MyUtils {
    private  static long firstTime=0;
    /**
     * 双击退出
     */
    public static void againstClick(Activity context){
        long secondTime = System.currentTimeMillis();
        if(secondTime-firstTime>2000){
            Toast.makeText(context,"再按一次退出程序",Toast.LENGTH_SHORT).show();
            firstTime=secondTime;
        }else{
            context.finish();
        }
    }

    /**
     * 从控件所在位置移动到控件的底部
     * @return
     */
    public static TranslateAnimation moveToViewBottom() {
        TranslateAnimation mHiddenAction = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                0.0f, Animation.RELATIVE_TO_SELF, 1.0f);
        mHiddenAction.setDuration(500);
        return mHiddenAction;
    }

    /**
     * 从控件的底部移动到控件所在位置
     *
     * @return
     */
    public static TranslateAnimation moveToViewLocation() {
        TranslateAnimation mHiddenAction = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                1.0f, Animation.RELATIVE_TO_SELF, 0.0f);
        mHiddenAction.setDuration(500);
        return mHiddenAction;
    }

    /**
     * 时间的格式化
     * @param textView
     * @param millisecond
     */
    public static void updateTime(TextView textView, int millisecond) {
        int second = millisecond / 1000; //总共换算的秒
        int hh = second / 3600;  //小时
        int mm = second % 3600 / 60; //分钟
        int ss = second % 60; //时分秒中的秒的得数

        String str = null;
        if (hh != 0) {
            //如果是个位数的话，前面可以加0  时分秒
            str = String.format("%02d:%02d:%02d", hh, mm, ss);
        } else {
            str = String.format("%02d:%02d", mm, ss);
        }
        textView.setText(str);
    }


    /**
     * 读取baseurl
     * @param url
     * @return
     */
    public static String getBasUrl(String url) {
        String head = "";
        int index = url.indexOf("://");
        if (index != -1) {
            head = url.substring(0, index + 3);
            url = url.substring(index + 3);
        }
        index = url.indexOf("/");
        if (index != -1) {
            url = url.substring(0, index + 1);
        }
        return head + url;
    }

    /**
     * Toast
     * @param content
     */
    public static void toast(String content){
        Toast.makeText(BaseApplication.getInstances(),content,Toast.LENGTH_SHORT).show();
    }

}
