package demo.lwb.com.myutils.Utils.retrofit;



import demo.lwb.com.myutils.Utils.LogUtils;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.Response;

/**
 * 数据返回统一处理  https://www.jianshu.com/p/ff619fea7e22
 * @param <T>
 */
public abstract class BaseObserver<T> implements Observer<Response<BaseResponse<T>>> {
    @Override
    public void onNext(Response<BaseResponse<T>> tResponse) {
        LogUtils.e("code:==="+tResponse.code());
        LogUtils.e("errorBody===:"+tResponse.errorBody());
        LogUtils.e("Body===:"+tResponse.body());
        BaseResponse<T> body = tResponse.body();
        if(body.getRes_code()==1){
            onSuccess(body.getDemo());
        }else{
            onFailure(new Exception(body.getErr_msg()), body.getErr_msg());
        }
    }

    @Override
    public void onError(Throwable e) {
        onFailure(e,RxExceptionUtil.exceptionHandler(e));
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    public abstract void onSuccess(T result);

    public abstract void onFailure(Throwable e,String errorMsg);

}
