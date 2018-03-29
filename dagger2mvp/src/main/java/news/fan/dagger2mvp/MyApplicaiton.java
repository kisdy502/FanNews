package news.fan.dagger2mvp;

import android.app.Application;
import android.content.res.Configuration;

import news.fan.dagger2mvp.component.ApplicationComponent;
import news.fan.dagger2mvp.component.DaggerApplicationComponent;
import news.fan.dagger2mvp.module.ApplicationModule;
import news.fan.dagger2mvp.module.HttpModule;

/**
 * Created by Administrator on 2018/3/29.
 */

public class MyApplicaiton extends Application {

    private static MyApplicaiton instance;
    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        mApplicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .httpModule(new HttpModule())
                .build();
    }

    public ApplicationComponent getmApplicationComponent() {
        return mApplicationComponent;
    }

    public static MyApplicaiton getInstance() {
        return instance;
    }
}
