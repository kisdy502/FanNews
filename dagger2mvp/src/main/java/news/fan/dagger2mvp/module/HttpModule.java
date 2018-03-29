package news.fan.dagger2mvp.module;

import dagger.Module;
import dagger.Provides;
import news.fan.dagger2mvp.NewsApi;

/**
 * desc:
 * author: Will .
 * date: 2017/9/2 .
 */
@Module
public class HttpModule {

    @Provides
    NewsApi provideNewsApi() {
        return NewsApi.getInstance();
    }
}
