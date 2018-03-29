package news.fan.fordagger;

import dagger.Component;

/**
 * Created by Administrator on 2018/3/28.
 */

@Component(modules = MainModule.class)
public interface MainComponent {
    void inject(MainActivity activity);
}
