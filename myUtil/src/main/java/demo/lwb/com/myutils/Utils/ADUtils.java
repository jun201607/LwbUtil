package demo.lwb.com.myutils.Utils;

import android.app.Activity;
import android.view.ViewGroup;

import com.qq.e.ads.banner.ADSize;
import com.qq.e.ads.banner.AbstractBannerADListener;
import com.qq.e.ads.banner.BannerView;
import com.qq.e.ads.interstitial.AbstractInterstitialADListener;
import com.qq.e.ads.interstitial.InterstitialAD;
import com.qq.e.comm.util.AdError;

import demo.lwb.com.myutils.constants.Constant;

/**
 * Created by lwb on 2018/6/6.
 * TODO 腾讯广告联盟
 */

public class ADUtils {
    private static BannerView bannerView;
    private static InterstitialAD iad;
    /**
     * Banner广告
     * @param context
     * @param view
     */
    public static void getBanner(Activity context, ViewGroup view) {
        if (bannerView != null) {
            view.removeView(bannerView);
            //当不需要展示Banner时用于主动释放Banner广告资源,调用后实例销毁，不可以再调用
            bannerView.destroy();
        }
        //构造函数
        bannerView = new BannerView(context, ADSize.BANNER, Constant.APPID, Constant.BannerPosID);
        //设置刷新频率,为0或30~120之间的数字，单位为s,0标识不自动轮播,默认30S
        bannerView.setRefresh(30);
        //设置是否展示关闭按钮,默认不展示
        //bannerView.setShowClose(true);
        //设置状态回调函数
        bannerView.setADListener(new AbstractBannerADListener() {
            @Override
            public void onNoAD(AdError error) {
                //广告加载失败，error对象包含了错误码和错误信息
                LogUtils.e(error.getErrorMsg().toString());
            }
            @Override
            public void onADReceiv() {
                //广告加载成功回调，表示广告相关的资源已经加载完毕，Ready To Show
                LogUtils.e("Banner广告");
            }
        });
        view.addView(bannerView);
        //加载广告
        bannerView.loadAD();
    }

    /**
     * 插屏广告
     */
    public static void showInterstitialAD(Activity activity) {
        if (iad != null) {
            iad.closePopupWindow();
            iad.destroy();
            iad = null;
        }
        if (iad == null) {
            iad = new InterstitialAD(activity, Constant.APPID, Constant.InterteristalPosID);
        }
        iad.setADListener(new AbstractInterstitialADListener() {
            @Override
            public void onNoAD(AdError error) {
               LogUtils.e(error.getErrorMsg());
            }
            @Override
            public void onADReceive() {
                LogUtils.e("插屏广告");
                iad.show();
            }
        });
        iad.loadAD();
    }
    /**
     * Popup插屏广告
     */
    public static void showAsPopup(Activity activity) {
        iad.setADListener(new AbstractInterstitialADListener() {
            @Override
            public void onNoAD(AdError error) {
                LogUtils.e(error.getErrorMsg());
            }
            @Override
            public void onADReceive() {
                LogUtils.e("插屏广告");
                iad.showAsPopupWindow();
            }
        });
        iad.loadAD();
    }
    /**
     * 关闭插屏广告
     */
    public static  void closeAsPopup() {
        if (iad != null) {
            iad.closePopupWindow();
        }
    }
}
