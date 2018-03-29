package news.fan.dagger2mvp.component;

import android.content.Context;

import dagger.Component;
import dagger.Provides;
import news.fan.dagger2mvp.MyApplicaiton;
import news.fan.dagger2mvp.NewsApi;
import news.fan.dagger2mvp.module.ApplicationModule;
import news.fan.dagger2mvp.module.HttpModule;

/**
 * Created by Administrator on 2018/3/29.
 */
@Component(modules = {ApplicationModule.class, HttpModule.class})
public interface ApplicationComponent {

    MyApplicaiton getApplication();

    Context getContext();

    NewsApi getNewsApi();


}
