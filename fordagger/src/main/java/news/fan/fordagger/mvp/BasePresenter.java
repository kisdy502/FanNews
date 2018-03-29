package news.fan.fordagger.mvp;

import javax.inject.Inject;

import news.fan.fordagger.MainContract;

/**
 * Created by Administrator on 2018/3/28.
 */

public class BasePresenter<T extends IBaseContract.IBaseView> implements IBaseContract.IBasePresenter<T> {

    protected T mView;


    @Override
    public void attachView(T view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        if (mView != null) {
            mView = null;
        }
    }
}
