package news.fan.dagger2mvp.component;

import dagger.Component;
import news.fan.dagger2mvp.MainActivity;

/**
 * Created by Administrator on 2018/3/29.
 */

@Component(dependencies = ApplicationComponent.class)
public interface HttpComponent {

    void inject(MainActivity mainActivity);

}