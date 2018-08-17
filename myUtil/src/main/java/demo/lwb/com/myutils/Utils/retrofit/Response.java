package demo.lwb.com.myutils.Utils.retrofit;

/**
 * 统一响应
 * @param <T>
 */
public class Response<T> {

    @Override
    public String toString() {
        return "Response{" +
                "res_code=" + res_code +
                ", err_code=" + err_code +
                ", err_msg='" + err_msg + '\'' +
                ", Demo=" + Demo +
                '}';
    }

    /**
     * res_code : 1
     * err_code : 404
     * err_msg : 错误
     * Demo : {"id":"1","appid":"App_98ef9c4f53e243f6bd3ce05d0acf9b52","name":"登录","showtype":"login","showurl":"aaaa"}
     */

    private int res_code;
    private int err_code;
    private String err_msg;
    private T Demo;

    public int getRes_code() {
        return res_code;
    }

    public void setRes_code(int res_code) {
        this.res_code = res_code;
    }

    public int getErr_code() {
        return err_code;
    }

    public void setErr_code(int err_code) {
        this.err_code = err_code;
    }

    public String getErr_msg() {
        return err_msg;
    }

    public void setErr_msg(String err_msg) {
        this.err_msg = err_msg;
    }

    public T getDemo() {
        return Demo;
    }

    public void setDemo(T Demo) {
        this.Demo = Demo;
    }


}
