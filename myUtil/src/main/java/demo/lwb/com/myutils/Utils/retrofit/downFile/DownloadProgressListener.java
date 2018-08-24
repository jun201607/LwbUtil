package demo.lwb.com.myutils.Utils.retrofit.downFile;

/**
 * Created by ${R.js} on 2018/3/22.
 */

public interface DownloadProgressListener {

    /**
     * @param read 已下载长度
     * @param contentLength 总长度
     * @param done 是否下载完毕
     */
    void progress(long read, long contentLength, boolean done);

}
