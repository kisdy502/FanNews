package news.fan.fordagger.mvp;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2018/3/28.
 */

@Module
public class ApplicationModule {

    IBaseContract.IBaseView mView;

    public ApplicationModule(IBaseContract.IBaseView view){
        mView = view;
    }

    @Provides
    IBaseContract.IBaseView providerView() {
        return mView;
    }
}
