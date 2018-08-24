package demo.lwb.com.myutils.constants;

import android.os.Environment;

public class Url {
    /**
     * 默认连接
     */
    public final static String Baidu="https://www.baidu.com/";

    public final static String fileURL="http://oavnqjdk1.bkt.clouddn.com/wojiushizheyang.mp3";
    public final static String RetrofitUrl= "http://oavnqjdk1.bkt.clouddn.com/";
    public final static String baseUrl= "*****************";//请替换成自己的网址
    /**
     * 默认保存路径
     */
    public static final String PATH= Environment.getExternalStorageState().equalsIgnoreCase(Environment.MEDIA_MOUNTED) ? Environment.getExternalStorageDirectory().getAbsolutePath() : "/mnt/sdcard";//保存到SD卡


}
