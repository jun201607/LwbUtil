package system.lwb.com.myapp;

import android.Manifest;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import retrofit2.Retrofit;

public class MainActivity extends Activity {
    private static final String TAG = "MainActivity======";
    public static final int RequestCode = 200;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] str=new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE};
        boolean b = PermissionUtils.checkPermissionsGroup(this, str);
        if(!b){
            PermissionUtils.requestPermissions(this,str,RequestCode);
        }
    }


}
