package news.fan.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import news.fan.MyApplication;

/**
 * Created by Administrator on 2018/3/4.
 */

@Module
public class ApplicationModule {

    private Context mContext;

    public ApplicationModule(Context context) {
        this.mContext = context;
    }

    @Provides
    MyApplication provideApplication() {
        return (MyApplication) mContext.getApplicationContext();
    }

    @Provides
    Context provideContext() {
        return mContext;
    }
}
