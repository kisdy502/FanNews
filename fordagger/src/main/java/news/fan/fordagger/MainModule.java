package news.fan.fordagger;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2018/3/28.
 */
@Module
public class MainModule {

    MainContract.View mView;

    public MainModule(MainContract.View view) {
        mView = view;
    }

    @Provides
    MainContract.View provideMainView() {
        return mView;
    }
}
