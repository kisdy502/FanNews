package news.fan.demo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import news.fan.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TestActivity extends AppCompatActivity {
    public static final String TAG = "Test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

    }

    private void request() {
        Retrofit retrofit = new Retrofit.Builder()
                //baseurl表示服务器的主机地址
                .baseUrl("http://apis.baidu.com")
                //指定解析方式，此处使用gson解析，请求后直接返回实体对象
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PhoneApiService pApiService = retrofit.create(PhoneApiService.class);

        Call<CardModel> call = pApiService.getCardGetState("9c32fd04cda3a80c3cff414c7e50e2f5", "430224198508085219");

        call.enqueue(new Callback<CardModel>() {


            @Override
            public void onResponse(Call<CardModel> arg0, Response<CardModel> response) {
                CardModel model = response.body();
                Log.d(TAG, "post地址：" + model.getRetData().getAddress());
                Toast.makeText(TestActivity.this, "" + model.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<CardModel> arg0, Throwable arg1) {
                Log.e(TAG, "errorInfo:" + arg1.toString());
                Toast.makeText(TestActivity.this, "" + arg1.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void btnClick(View view) {
        request();
    }
}
