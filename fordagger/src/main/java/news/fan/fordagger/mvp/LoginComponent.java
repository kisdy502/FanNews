package news.fan.fordagger.mvp;

import dagger.Component;

/**
 * Created by Administrator on 2018/3/28.
 */
@Component(modules = ApplicationModule.class)
public interface LoginComponent {
    void inject(LoginActivity loginActivity);
}
