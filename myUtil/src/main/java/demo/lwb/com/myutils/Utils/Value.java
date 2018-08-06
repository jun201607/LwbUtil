package demo.lwb.com.myutils.Utils;

import android.text.TextUtils;

/**
 * Created by lwb on 2018/2/8.
 * 为空判断
 */

public class Value {
    /**
     * 字符串为空判断
     * @param str
     * @return
     */
    public static boolean isEmpty(CharSequence str) {
        if (TextUtils.isEmpty(str) || str.equals("null")) {//后台可能会返回“null”
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断JSONObject是否为空
     */
    public static boolean isObjectEmpty(Object Object) {
        if (Object == null || Object.toString().length()== 0){
            return true;
        } else {
            return false;
        }
    }
}
