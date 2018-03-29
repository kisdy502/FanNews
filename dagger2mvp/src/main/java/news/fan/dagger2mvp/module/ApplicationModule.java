package news.fan.dagger2mvp.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import news.fan.dagger2mvp.MyApplicaiton;

/**
 * Created by Administrator on 2018/3/29.
 */

@Module
public class ApplicationModule {

    private Context mContext;

    public ApplicationModule(Context context) {
        this.mContext = context;
    }

    @Provides
    MyApplicaiton provideApplication() {
        return (MyApplicaiton) mContext.getApplicationContext();
    }

    @Provides
    Context provideContext() {
        return mContext;
    }

}
