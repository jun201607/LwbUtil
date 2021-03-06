package demo.lwb.com.myutils.Utils;

import android.app.Activity;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PermissionUtils {
    public static final String CAMERA = android.Manifest.permission.CAMERA;
    public static final String WRITE_EXTERNAL_STORAGE = android.Manifest.permission.WRITE_EXTERNAL_STORAGE;


    private static final String TAG = "PermissionUtils";
    private static final String BRAND_VIVO = "vivo";
    private static final String BRAND_XIAOMI = "xiaomi";
    private static final String BRAND_HUAWEI = "HUAWEI";
    private static final String BRAND_GOOGLE = "google";
    /**
     * 申请权限
     * @param activity
     * @param permissions
     * @param requestCode
     */
    public static void requestPermissions(Activity activity, String[] permissions, int requestCode) {
        // 先检查是否已经授权
        if (!checkPermissionsGroup(activity, permissions)) {
            ActivityCompat.requestPermissions(activity, permissions, requestCode);
        }
    }

    public String checkBrand() {
        return Build.BRAND;
    }

    /**
     * 检查单个权限
     * @param context
     * @param permission
     * @return
     */
    public static boolean checkPersmission(Context context, String permission) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return true;
        }

        if (ContextCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
            return false;
        }

        return true;
    }

    /**
     * 检查多个权限
     * @param context
     * @param permissions
     * @return
     */
    public static boolean checkPermissionsGroup(Context context, String[] permissions) {
        boolean result = false;
        for (String permission : permissions) {
            result = checkPersmission(context, permission);
            LogUtils.e("result"+result);
        }
        return result;
    }


    /**
     *
     * 通过AppOpsManager判断小米手机授权情况
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static boolean checkXiaomi(Context context, String[] opstrArrays) {
        AppOpsManager appOpsManager = (AppOpsManager)context.getSystemService(Context.APP_OPS_SERVICE);
        String packageName = context.getPackageName();
        for (String opstr : opstrArrays) {
            int locationOp = appOpsManager.checkOp(opstr, Binder.getCallingUid(), packageName);
            if (locationOp == AppOpsManager.MODE_IGNORED) {
                return false;
            }
        }

        return true;
    }
    public static boolean checkIsOppoRom() {
        //https://github.com/zhaozepeng/FloatWindowPermission/pull/26
        return Build.MANUFACTURER.contains("OPPO") || Build.MANUFACTURER.contains("oppo");
    }
    public static boolean checkIsMeizuRom() {
        //return Build.MANUFACTURER.contains("Meizu");
        String meizuFlymeOSFlag  = getSystemProperty("ro.build.display.id");
        if (TextUtils.isEmpty(meizuFlymeOSFlag)){
            return false;
        }else if (meizuFlymeOSFlag.contains("flyme") || meizuFlymeOSFlag.toLowerCase().contains("flyme")){
            return  true;
        }else {
            return false;
        }
    }

    public static String getSystemProperty(String propName) {
        String line;
        BufferedReader input = null;
        try {
            Process p = Runtime.getRuntime().exec("getprop " + propName);
            input = new BufferedReader(new InputStreamReader(p.getInputStream()), 1024);
            line = input.readLine();
            input.close();
        } catch (IOException ex) {
            LogUtils.e("Unable to read sysprop " + propName);
            return null;
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    LogUtils.e("Exception while closing InputStream");
                }
            }
        }
        return line;
    }


    /**
     * 结果返回
     * @param requestCode
     * @param RequestCode
     * @param context
     * @param grantResults
     * @param permission
     */
    public static void requestPermissResult(int requestCode, int RequestCode, Activity context, @NonNull int[] grantResults, String permission) {
        if (requestCode == RequestCode) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                tvPermissionStatus.setTextColor(Color.GREEN);
//                tvPermissionStatus.setText("相机权限已申请");
            } else {
                //用户勾选了不再询问
                //提示用户手动打开权限
                if (!ActivityCompat.shouldShowRequestPermissionRationale(context,permission)) {
//                    Toast.makeText(this, "定位功能已被禁止", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
