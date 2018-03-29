package news.fan.component;




import dagger.Component;
import news.fan.MainActivity;
import news.fan.ui.fragment.DetailFragment;
import news.fan.ui.fragment.NewsFragment;
import news.fan.ui.fragment.VideoFragment;

/**
 * desc: .
 * author: Will .
 * date: 2017/9/2 .
 */
@Component(dependencies = ApplicationComponent.class)
public interface HttpComponent {
    void inject(NewsFragment newsFragment);
    void inject(VideoFragment videoFragment);
    void inject(DetailFragment detailFragment);
}
