package news.fan;

import android.app.Application;
import android.content.Context;

import org.litepal.LitePal;
import org.litepal.LitePalApplication;
import org.litepal.exceptions.GlobalException;
import news.fan.component.ApplicationComponent;
import news.fan.component.DaggerApplicationComponent;
import news.fan.module.ApplicationModule;
import news.fan.module.HttpModule;
import news.fan.util.ContextUtils;

/**
 * Created by Administrator on 2018/3/3.
 */

public class MyApplication extends LitePalApplication {

    private static MyApplication intance;
    static Context sContext;
    private ApplicationComponent applicationComponent;
    public static int width = 0;
    public static int height = 0;

    public static MyApplication getInstance() {
        return MyApplication.intance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        intance = this;
        //DaggerApplicationComponent 是在编写好后，程序自动生成的，第一次不知道，坑了很久
        applicationComponent = DaggerApplicationComponent.builder()
                .httpModule(new HttpModule())
                .applicationModule(new ApplicationModule(intance))
                .build();
        LitePal.initialize(this);
        width = ContextUtils.getSreenWidth(intance);
        height = ContextUtils.getSreenHeight(intance);
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

}
