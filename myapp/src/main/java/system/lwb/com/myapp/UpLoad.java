package system.lwb.com.myapp;

public class UpLoad {

    @Override
    public String toString() {
        return "UpLoad{" +
                "id=" + id +
                ", hash='" + hash + '\'' +
                ", file_name='" + file_name + '\'' +
                ", mime='" + mime + '\'' +
                ", extension='" + extension + '\'' +
                ", size=" + size +
                ", width=" + width +
                ", height=" + height +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    /**
     * id : 1
     * hash : 6d1d78e777d5adaeef0c223a58fd7586277971a8
     * file_name : 6d1d78e777d5adaeef0c223a58fd7586277971a8.jpeg
     * mime : image/jpeg
     * extension : jpeg
     * size : 7859
     * width : 300
     * height : 300
     * created_at : 2017-10-18 15:04:56
     * updated_at : 2017-10-18 15:04:56
     * url : http://images.sdwhcn.com/6d1d78e777d5adaeef0c223a58fd7586277971a8.jpeg
     */

    private int id;
    private String hash;
    private String file_name;
    private String mime;
    private String extension;
    private int size;
    private int width;
    private int height;
    private String created_at;
    private String updated_at;
    private String url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getMime() {
        return mime;
    }

    public void setMime(String mime) {
        this.mime = mime;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
