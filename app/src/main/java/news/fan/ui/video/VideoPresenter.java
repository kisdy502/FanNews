package news.fan.ui.video;

import javax.inject.Inject;

import news.fan.net.NewsApi;
import news.fan.ui.BasePresenter;
import news.fan.ui.video.VideoContract;

/**
 * Created by Administrator on 2018/3/5.
 */

public class VideoPresenter extends BasePresenter<VideoContract.View> implements VideoContract.Presenter {

    private NewsApi mNewsApi;

    @Inject
    VideoPresenter(NewsApi newsApi) {
        this.mNewsApi = newsApi;
    }

    @Override
    public void getVideoChannel() {

    }

    @Override
    public void getVideoDetails(int page, String listType, String typeId) {

    }
}
