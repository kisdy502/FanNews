package news.fan.component;




import dagger.Component;
import news.fan.ui.news.NewsFragment;
import news.fan.ui.video.VideoFragment;

/**
 * desc: .
 * author: Will .
 * date: 2017/9/2 .
 */
@Component(dependencies = ApplicationComponent.class)
public interface HttpComponent {
    void inject(NewsFragment newsFragment);
    void inject(VideoFragment videoFragment);
}