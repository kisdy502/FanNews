package news.fan.dagger2mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import news.fan.dagger2mvp.component.ApplicationComponent;
import news.fan.dagger2mvp.component.DaggerApplicationComponent;
import news.fan.dagger2mvp.component.DaggerHttpComponent;
import news.fan.dagger2mvp.ui.BaseActivity;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        mPresenter.getData("admin");
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showSuccess() {

    }

    @Override
    public void loadData(String result) {
        Log.d("main", result);
    }


    @Override
    public void initInjector(ApplicationComponent appComponent) {
        DaggerHttpComponent
                .builder()
                .applicationComponent(MyApplicaiton.getInstance().getmApplicationComponent())
                .build().inject(this);
    }
}
