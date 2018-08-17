package demo.lwb.com.myutils.Utils.retrofit;

import com.alibaba.fastjson.JSON;
import java.lang.reflect.Type;


import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

final class FastJsonResponseBodyConvert<T> implements Converter<ResponseBody, T> {

    private Type mType;

    public FastJsonResponseBodyConvert(Type type) {
        this.mType = type;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        return JSON.parseObject(value.string(), mType);
    }

}
