package demo.lwb.com.myutils.Utils;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.provider.Settings;
import android.widget.Toast;

import java.util.List;

/**
 * 获取GPS 经纬度
 * 原生GPS 室外才可以用
 */
public class GPSUtils {

    private static GPSUtils instance;
    private Context mContext;
    private LocationManager locationManager;

    private GPSUtils(Context context) {
        this.mContext = context;
    }

    public static GPSUtils getInstance(Context context) {
        if (instance == null) {
            instance = new GPSUtils(context);
        }
        return instance;
    }

    /**
     * 获取经纬度
     *
     * @return
     */
    public String getLngAndLat(OnLocationResultListener onLocationResultListener) {
        double latitude = 0.0;
        double longitude = 0.0;

        mOnLocationListener = onLocationResultListener;

        String locationProvider = null;
        locationManager = (LocationManager) mContext.getSystemService(Context.LOCATION_SERVICE);
        //获取所有可用的位置提供器
        List<String> providers = locationManager.getProviders(true);

        if (providers.contains(LocationManager.GPS_PROVIDER)) {
            //如果是GPS
            locationProvider = LocationManager.GPS_PROVIDER;
        } else if (providers.contains(LocationManager.NETWORK_PROVIDER)) {
            //如果是Network
            locationProvider = LocationManager.NETWORK_PROVIDER;
        } else {
            Intent i = new Intent();
            i.setAction(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            mContext.startActivity(i);
            return null;
        }

        //获取Location
        if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return "位置权限未打开";
        }
        Location location = locationManager.getLastKnownLocation(locationProvider);
        if (location != null) {
            //不为空,显示地理位置经纬度
            if (mOnLocationListener != null) {
                mOnLocationListener.onLocationResult(location);
            }
        }
        //监视地理位置变化
        locationManager.requestLocationUpdates(locationProvider, 5000, 1, locationListener);
        return null;
    }


    public LocationListener locationListener = new LocationListener() {

        // Provider的状态在可用、暂时不可用和无服务三个状态直接切换时触发此函数
        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            switch (status){

                case LocationProvider.AVAILABLE:

                    break;

                case LocationProvider.OUT_OF_SERVICE:
                    if (mOnLocationListener != null) {
                        mOnLocationListener.OnStatus(LocationProvider.OUT_OF_SERVICE);
                    }
//                    Toast.makeText(mContext,"当前GPS不在服务内",Toast.LENGTH_SHORT).show();
                    break;

                case LocationProvider.TEMPORARILY_UNAVAILABLE:
                    if (mOnLocationListener != null) {
                        mOnLocationListener.OnStatus(LocationProvider.TEMPORARILY_UNAVAILABLE);
                    }
//                    Toast.makeText(mContext,"当前GPS为暂停服务状态",Toast.LENGTH_SHORT).show();
                    break;
            }
        }

        // Provider被enable时触发此函数，比如GPS被打开
        @Override
        public void onProviderEnabled(String provider) {
            if (mOnLocationListener != null) {
                mOnLocationListener.isOpenGPS(true);
            }
        }

        // Provider被disable时触发此函数，比如GPS被关闭
        @Override
        public void onProviderDisabled(String provider) {
            if (mOnLocationListener != null) {
                mOnLocationListener.isOpenGPS(false);
            }
        }

        //当坐标改变时触发此函数，如果Provider传进相同的坐标，它就不会被触发
        @Override
        public void onLocationChanged(Location location) {
            if (mOnLocationListener != null) {
                mOnLocationListener.OnLocationChange(location);
            }
        }
    };

    public void removeListener() {
        locationManager.removeUpdates(locationListener);
    }

    private OnLocationResultListener mOnLocationListener;

    public interface OnLocationResultListener {
        void onLocationResult(Location location);

        void OnLocationChange(Location location);

        void isOpenGPS(boolean open);

        void OnStatus(int status);
    }
}