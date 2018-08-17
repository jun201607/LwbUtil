package demo.lwb.com.myutils.Utils.retrofit;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;

final class FastJsonRequestBodyConverter<T> implements Converter<T, RequestBody> {

    private final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");

    private SerializeConfig mSerializeConfig;

    public FastJsonRequestBodyConverter(SerializeConfig serializeConfig) {
        this.mSerializeConfig = serializeConfig;
    }

    @Override
    public RequestBody convert(T value) throws IOException {
        return RequestBody.create(MEDIA_TYPE, JSON.toJSONBytes(value, mSerializeConfig));
    }
}
