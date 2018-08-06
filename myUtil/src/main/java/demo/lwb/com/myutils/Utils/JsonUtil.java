/*Copyright ©2015 TommyLemon(https://github.com/TommyLemon)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.*/

package demo.lwb.com.myutils.Utils;

import android.util.Log;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

/**
 * 1判断json格式是否正确
 * 2获取有效的json
 */
public class JsonUtil {
	private static final String TAG = "Json";
    /**判断json格式是否正确
	 * @param s
	 * @return
	 */
	public static boolean isJsonCorrect(String s) {
		Log.i(TAG, "isJsonCorrect  <<<<     " + s + "     >>>>>>>");
		if (s == null || s.equals("[]") 
				|| s.equals("{}") || s.equals("") || s.equals("[null]") || s.equals("{null}") || s.equals("null")) {
			return false;
		}
		return true;
	}

	/**获取有效的json
	 * @param s
	 * @return
	 */
	public static String getCorrectJson(String s) {
		return isJsonCorrect(s) ? s : "";
	}
	
	/**
	 * 字符串转JSON对象
	 * @param s
	 * @return
	 */
	public static JSONObject parseObject(String s) {
		try {
			return JSON.parseObject(getCorrectJson(s));
		} catch (Exception e) {
			Log.e(TAG, "parseObject  catch \n" + e.getMessage());
		}
		return null;
	}
	
	/** 字符串转类
	 * @param s
	 * @param clazz
	 * @return
	 */
	public static <T> T parseObject(String s, Class<T> clazz) {
		try {
			return JSON.parseObject(getCorrectJson(s), clazz);
		} catch (Exception e) {
			Log.e(TAG, "parseObject  catch \n" + e.getMessage());
		}
		return null;
	}

	/** 对象转字符串
	 * @param obj
	 * @return
	 */
	public static String toJSONString(Object obj) {
		try {
			return JSON.toJSONString(obj);
		} catch (Exception e) {
			Log.e(TAG, "toJSONString  catch \n" + e.getMessage());
		}
		return null;
	}

	/**
	 * 字符串数组转类
	 * @param s
	 * @param clazz
	 * @return
	 */
	public static <T> List<T> parseArray(String s, Class<T> clazz) {
		try {
			return JSON.parseArray(getCorrectJson(s), clazz);
		} catch (Exception e) {
			Log.e(TAG, "parseArray  catch \n" + e.getMessage());
		}
		return null;
	}
    /**
     * 对象转换Json字符串数组
     * @param t
     * @return
     */
    public static <T> String objectToJson(T t){
        if (t instanceof String) {
            return t.toString();
        } else {
            return JSON.toJSONString(t);

        }
    }
    /**
     * 将List集合转换为json字符串
     * @param list  List集合
     * @return
     */
    public static<T> String listToJson(List<T> list){
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = null;
        try {
            for (int i = 0; i < list.size(); i++) {
                String s = objectToJson(list.get(i));
                jsonObject = parseObject(s);
                jsonArray.add(jsonObject);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            if (jsonObject != null) {
                jsonObject = null;
            }
        }
        return jsonArray.toString();
    }

}
