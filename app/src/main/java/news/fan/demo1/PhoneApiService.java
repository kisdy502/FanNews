package news.fan.demo1;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2018/3/3.
 */

public interface PhoneApiService {
    //get请求方式
    @GET("/apistore/idservice/id")
    public Call<CardModel> getCardGetState(
            //动态添加请求header
            @Header("apikey") String apikey,
            //请求参数，形如?id=XXXX
            @Query("id") String id);
}
