package news.fan.fordagger;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018/3/28.
 */

public class MainPresenter {

    MainContract.View mView;

    @Inject
    MainPresenter(MainContract.View view) {
        mView = view;
    }

}
