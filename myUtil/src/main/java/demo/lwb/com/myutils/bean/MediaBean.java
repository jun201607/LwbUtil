package demo.lwb.com.myutils.bean;

import android.graphics.Bitmap;

/**
 * Created by Administrator on 2018/6/21.
 */

public class MediaBean {
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getArtics() {
        return artics;
    }

    public void setArtics(String artics) {
        this.artics = artics;
    }

    private String name;
    private long time;
    private long size;
    private String artics;
    private Bitmap bitmap;
}
