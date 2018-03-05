package news.fan.component;

import android.content.Context;

import dagger.Component;
import news.fan.MyApplication;
import news.fan.module.ApplicationModule;
import news.fan.module.HttpModule;
import news.fan.net.JanDanApi;
import news.fan.net.NewsApi;

/**
 * Created by Administrator on 2018/3/3.
 */

@Component(modules = {ApplicationModule.class, HttpModule.class})
public interface ApplicationComponent {

    MyApplication getApplication();

    Context getContext();

    NewsApi getNetEaseApi();

    JanDanApi getJanDanApi();



}
