package system.lwb.com.myapp.Dwon;

public interface  DownloadListener {
    /**
     * 下载开始
     */
    void onStart();

    /**
     * 下载进度
     * @param currentLength
     */
    void onProgress(int currentLength);

    /**
     * 下载结束
     * @param localPath
     */
    void onFinish(String localPath);

    /**
     * 下载失败
     */
    void onFailure();
}
