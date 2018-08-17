package demo.lwb.com.myutils.Utils.retrofit;



import demo.lwb.com.myutils.Utils.LogUtils;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 数据返回统一处理  https://www.jianshu.com/p/ff619fea7e22
 * @param <T>
 */
public abstract class BaseObserver<T> implements Observer<Response<T>> {
    @Override
    public void onNext(Response<T> tResponse) {
        LogUtils.e(tResponse.toString());
        if(tResponse.getRes_code()==1){
            onSuccess(tResponse.getDemo());
        }else{
            onFailure(new Exception(tResponse.getErr_msg()), tResponse.getErr_msg());
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
