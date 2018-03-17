package news.fan.hookactivity;

import android.app.Application;

/**
 * Created by Administrator on 2018/3/12.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        HookUtil hookUtil = new HookUtil(ProxyActivity.class, this);
        hookUtil.hookAms();
        hookUtil.hookSystemHandler();
    }
}
