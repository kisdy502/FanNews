package news.fan.dagger2mvp;


import news.fan.dagger2mvp.ui.IBaseContract;

/**
 * desc: .
 * author: Will .
 * date: 2017/9/7 .
 */
public interface MainContract  {

    interface View extends IBaseContract.IBaseView {

        void loadData(String result);

    }

    interface Presenter extends IBaseContract.IBasePresenter<View> {
        void getData(String name);

    }

}
