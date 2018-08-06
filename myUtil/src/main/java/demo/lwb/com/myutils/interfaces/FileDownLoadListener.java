package demo.lwb.com.myutils.interfaces;

/**
 * Created by Administrator on 2018/3/24.
 * 下载监听
 */

public interface FileDownLoadListener {
    /**
     * 显示进度条
     * @param progress
     */
    void onProgress(int progress);

    /**
     * 显示成功
     */
    void onSuccess();

    /**
     * 显示失败
     */
    void onFailed();

    /**
     * 暂停操作
     */
    void onPaused();

    /**
     * 取消操作
     */
    void onCanceled();
}
