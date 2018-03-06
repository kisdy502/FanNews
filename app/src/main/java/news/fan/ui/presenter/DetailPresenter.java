package news.fan.ui.presenter;

import javax.inject.Inject;

import news.fan.net.NewsApi;
import news.fan.ui.inner.BasePresenter;
import news.fan.ui.constract.DetailContract;

/**
 * Created by Administrator on 2018/3/6.
 */

public class DetailPresenter extends BasePresenter<DetailContract.View> implements DetailContract.Presenter {


    NewsApi mNewsApi;

    @Inject
    public DetailPresenter(NewsApi newsApi) {
        this.mNewsApi = newsApi;
    }

    @Override
    public void getData(String id, String action, int pullNum) {

    }
}
