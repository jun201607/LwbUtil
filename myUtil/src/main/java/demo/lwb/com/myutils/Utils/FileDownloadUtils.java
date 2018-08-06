package demo.lwb.com.myutils.Utils;

import android.os.AsyncTask;
import android.os.Environment;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

import demo.lwb.com.myutils.interfaces.FileDownLoadListener;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 文件下载工具类
 * @author
 */
public class FileDownloadUtils extends AsyncTask<String,Integer,Integer>
{
    public static final int TYPE_SUCCESS=0;
    public static final int TYPE_FAILED=1;
    public static final int TYPE_PAUSED=2;
    public static final int TYPE_CANCELED=3;
    private FileDownLoadListener listener;
    private boolean isCanceled=false;
    private boolean isPaused=false;
    private int lastProgress;
    public FileDownloadUtils( FileDownLoadListener listener){
        this.listener=listener;
    }
    @Override
    protected Integer doInBackground(String... params) {
        InputStream is = null;
        RandomAccessFile savedFile = null;
        File file = null;
        try {
            long downloadedLength =0;
            String downloadUrl = params[0];
            String fileName = downloadUrl.substring(downloadUrl.lastIndexOf("/"));
            //获取存储路径
            String directory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
            //创建存储文件名
            file = new File(directory + fileName);
            //判断是否存在
            if(file.exists()){
                //获取已经下载的字节长度
                downloadedLength=file.length();
            }
            long contentLength=getContentLength(downloadUrl);
            //文件的字节数为0时  下载失败
            if(contentLength==0){
                return TYPE_FAILED;
                //文件的字节数和已经存在的文件字节数相同 说明已经存在 下载成功
            }else if(contentLength==downloadedLength){
                return  TYPE_SUCCESS;
            }
            //否则文件继续下载  当文件不存在 则从头开始下载  存在 则从断点处继续下载
            OkHttpClient client = new OkHttpClient();
            Request request=new Request.Builder()
                    .addHeader("RANGE","bytes="+downloadedLength+"-")
                    .url(downloadUrl)
                    .build();
            Response response = client.newCall(request).execute();
            if(response!=null){
                is = response.body().byteStream();
                savedFile = new RandomAccessFile(file,"rw");
                savedFile.seek(downloadedLength);
                byte[] b = new byte[1024];
                int total=0;
                int len;
                while ((len = is.read(b))!=-1){
                    if(isCanceled){
                        return TYPE_CANCELED;
                    }else if(isPaused){
                        return  TYPE_PAUSED;
                    }else {
                        total += len;
                        savedFile.write(b,0,len);
                        int progress = (int)((total + downloadedLength) * 100/contentLength);
                        publishProgress(progress);
                    }
                }
                response.body().close();
                return TYPE_SUCCESS;
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if (is != null){
                    is.close();
                }
                if(savedFile != null){
                    savedFile.close();
                }
                if(isCanceled && file !=null)
                {
                    file.delete();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return TYPE_FAILED;
    }
    @Override
    protected void onProgressUpdate(Integer... values) {
        int progress = values[0];
        if(progress > lastProgress){
            listener.onProgress(progress);
            lastProgress = progress;
        }
    }
    @Override
    protected void onPostExecute(Integer status) {
        switch (status){
            case TYPE_SUCCESS:
                listener.onSuccess();
                break;
            case TYPE_FAILED:
                listener.onFailed();
                break;
            case TYPE_PAUSED:
                listener.onPaused();
                break;
            case TYPE_CANCELED:
                listener.onCanceled();
                break;
            default:break;
        }
    }

    public void pauseDownload(){
        isPaused=true;
    }
    public void cancelDownload(){
        isCanceled=true;
    }

    /**
     * 得到下载文件的字节数
     * @param downloadUrl
     * @return
     */
    private long getContentLength(String downloadUrl) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request =new Request.Builder()
                .url(downloadUrl)
                .build();
        //获取响应值
        Response response = client.newCall(request).execute();
        //根据响应值判断下载文件后网址是否存在
        if(response !=null && response.isSuccessful()){
            //获取下载文件的字节数
            long contentLength=response.body().contentLength();
            response.close();
            return  contentLength;
        }
        return 0;
    }
}

