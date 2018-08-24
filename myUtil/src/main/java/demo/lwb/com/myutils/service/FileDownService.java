package demo.lwb.com.myutils.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.Environment;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import java.io.File;
import demo.lwb.com.myutils.R;
import demo.lwb.com.myutils.Utils.FileDownloadUtils;
import demo.lwb.com.myutils.interfaces.FileDownLoadListener;
import demo.lwb.com.myutils.mvp.demo.DemoActivity;

/**
 * 文件下载服务
 */
public class FileDownService extends Service {
    private FileDownloadUtils fileDownloadUtils;
    private String downloadUrl;
    private FileDownLoadListener listener = new FileDownLoadListener() {
        @Override
        public void onProgress(int progress) {
            getNotificationManager().notify(1,getNotification("Downloading...",progress));
        }
        @Override
        public void onSuccess() {
            fileDownloadUtils = null;
            //下载成功时将前台服务通知关闭，并创建一个下载成功的通知。
            stopForeground(true);
            getNotificationManager().notify(1,getNotification("Download Success",-1));
        }
        @Override
        public void onFailed() {
            fileDownloadUtils=null;
            stopForeground(true);
            getNotificationManager().notify(1,getNotification("Download Failed",-1));
        }
        @Override
        public void onPaused() {
            fileDownloadUtils=null;
        }
        @Override
        public void onCanceled() {
            fileDownloadUtils=null;
            stopForeground(true);
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        FileDownBind upApkBind = new FileDownBind();
        return upApkBind;
    }
    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
    }
    private NotificationManager getNotificationManager(){
        return (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
    }
    private Notification getNotification(String title,int progress){
        Intent intent = new Intent(this, DemoActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher));
        builder.setContentIntent(pi);
        builder.setContentTitle(title);
        if(progress > 0){
            //当progress大于或等于0时才需显示下载进度
            builder.setContentText(progress+"%");
            builder.setProgress(100,progress,false);
        }
        return builder.build();
    }

    public class FileDownBind extends Binder{
        public void startDownload(String url){
            if(fileDownloadUtils==null){
                downloadUrl=url;
                fileDownloadUtils=new FileDownloadUtils(listener);
                fileDownloadUtils.execute(downloadUrl);
                startForeground(1,getNotification("Downloading...",0));
            }
        }
        public void pauseDownload(){
            if(fileDownloadUtils != null){
                fileDownloadUtils.pauseDownload();
            }
        }

        public void cancelDownload(){
            if(fileDownloadUtils !=null){
                fileDownloadUtils.cancelDownload();
            }else{
                if(downloadUrl != null){
                    String fileName = downloadUrl.substring(downloadUrl.lastIndexOf("/"));
                    String directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
                    File file = new File(directory + fileName);
                    if(file.exists()){
                        file.delete();
                    }
                    getNotificationManager().cancel(1);
                    stopForeground(true);
                }
            }
        }
    }
}
