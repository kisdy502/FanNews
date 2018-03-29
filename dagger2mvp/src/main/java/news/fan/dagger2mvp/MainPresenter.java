package news.fan.dagger2mvp;

import javax.inject.Inject;

import news.fan.dagger2mvp.ui.BasePresenter;

/**
 * Created by Administrator on 2018/3/29.
 */

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract.Presenter {

    NewsApi mNewsApi;

    @Inject
    public MainPresenter(NewsApi newsApi) {
        this.mNewsApi = newsApi;
    }

    @Override
    public void getData(String name) {
        String result = name + "ok";
        mView.loadData(result);


    }
}
