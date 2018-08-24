package demo.lwb.com.myutils.mvp.fragment;

import android.Manifest;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.OnClick;
import demo.lwb.com.myutils.R;
import demo.lwb.com.myutils.Utils.AppUtils;
import demo.lwb.com.myutils.Utils.LogUtils;
import demo.lwb.com.myutils.base.BaseFragment;
import demo.lwb.com.myutils.mvp.presenter.BasePresenter;
import demo.lwb.com.myutils.service.FileDownService;

/**
 * Created by lwb on 2018/3/22.
 * 下载
 */

public class DownloadFragment extends BaseFragment {
    @BindView(R.id.btn_start)
    Button btnStart;
    @BindView(R.id.btn_stop)
    Button btnStop;
    @BindView(R.id.btn_cancle)
    Button btnCancle;
    private String apkUrl="http://bos.pgzs.com/rbreszy/aladdin/b87b16d9182c4d1a8d70294c55e2b283/91Assistant_PC_V6_16/%E5%9E%83%E5%9C%BE%E8%AE%B0%E8%B4%A6_%E6%9E%81%E9%80%9F%E5%AE%89%E8%A3%85.exe";

    private FileDownService.FileDownBind fileDownBind;

    private ServiceConnection conn=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            fileDownBind = (FileDownService.FileDownBind) iBinder;
        }
        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    private static final int RequestCode_Permission=1;
    private static  final int Version_Code=2;
    private AlertDialog.Builder builder;

    /**
     * Frament退栈监听
     *
     * @param returnCode 返回码
     * @param bundle
     */
    @Override
    public void popBackListener(int returnCode, Bundle bundle) {

    }

    /**
     * 中心的标题设置
     */
    @Override
    public void setMiddleTitle() {

    }

    /**
     * 绑定P层
     *
     * @return
     */
    @Override
    protected BasePresenter bindPresenter() {
        return null;
    }

    /**
     * 绑定界面
     * @return
     */
    @Override
    protected int bindLayout() {
        return R.layout.fragment_download;
    }

    /**
     * UI显示方法，必须在子类onCreateView方法内调用
     */
    @Override
    public void initView() {
        Intent intent = new Intent(activity,FileDownService.class);
        activity.bindService(intent,conn, Context.BIND_AUTO_CREATE);
    }

    /**
     * data数据方法，必须在子类onCreateView方法内调用
     */
    @Override
    public void initData() {

    }

    /**
     * listener事件监听方法，必须在子类onCreateView方法内调用
     */
    @Override
    public void initListener() {

    }


    @OnClick({R.id.btn_start, R.id.btn_stop, R.id.btn_cancle})
    public void onViewClicked(View view) {
        if(fileDownBind==null){
            return;
        }
        switch (view.getId()) {
            case R.id.btn_start://开始下载
                //网络获取版本号
                //判断版本号是小于市场版本号
                int versionCode = AppUtils.getVersionCode(activity);
                if(versionCode<Version_Code){
                    builder = new AlertDialog.Builder(activity);
                    builder.setTitle(R.string.fin_new_Version);
                    builder.setMessage(R.string.is_update);
                    builder.setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            startDownload();
                        }
                    });
                    builder.setNegativeButton(R.string.cancle, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    builder.show();
                }
                break;
            case R.id.btn_stop://停止下载
                fileDownBind.pauseDownload();
                break;
            case R.id.btn_cancle://取消下载
                fileDownBind.cancelDownload();
                break;
        }
    }

    /**
     * 开始下载
     */
    private void startDownload() {
        if(ContextCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},RequestCode_Permission);
            LogUtils.e("申请权限");
        }else{
            fileDownBind.startDownload(apkUrl);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case RequestCode_Permission:
                if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    fileDownBind.startDownload(apkUrl);
                }else{
                    Toast.makeText(activity,"权限未打开",Toast.LENGTH_SHORT).show();
                }
                break;
            default:break;
        }
    }

    @Override
    public void onDestroy() {
        activity.unbindService(conn);
        super.onDestroy();
    }
}
