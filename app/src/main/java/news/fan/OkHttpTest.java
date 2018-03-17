package news.fan;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2018/3/7.
 */

public class OkHttpTest {

    public void send() throws IOException {
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Log.d("okHttp", "我是自定义的拦截器");
                return chain.proceed(chain.request());
            }
        }).build();
        Request request = new Request.Builder().url("https://raw.github.com/square/okhttp/master/README.md").addHeader("packageName", "fan.news").build();
        Response response = client.newCall(request).execute();
        if (response != null && response.code() == 200) {
            Log.d("okHttp", "code:" + response.code());
            Log.d("okHttp", "response:" + response.body().string());
        }

    }
}