package demo.lwb.com.myutils.Utils.retrofit;

import com.alibaba.fastjson.serializer.SerializeConfig;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

public class FastJsonConverterFactory extends Converter.Factory {

    private final SerializeConfig mSerializeConfig;

    private FastJsonConverterFactory(SerializeConfig serializeConfig) {
        if (serializeConfig == null)
            throw new NullPointerException("mSerializeConfig == null");
        this.mSerializeConfig = serializeConfig;
    }

    public static FastJsonConverterFactory create() {
        return create(SerializeConfig.getGlobalInstance());
    }

    public static FastJsonConverterFactory create(SerializeConfig serializeConfig) {
        return new FastJsonConverterFactory(serializeConfig);
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        return new FastJsonRequestBodyConverter<>(mSerializeConfig);
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return new FastJsonResponseBodyConvert<>(type);
    }
}