package news.fan.fordagger.mvp;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2018/3/28.
 */

@Module
public class ApplicationModule {

    @Provides
    LoginPresenter providerLoginPresenter() {
       return new LoginPresenter();
    }
}
