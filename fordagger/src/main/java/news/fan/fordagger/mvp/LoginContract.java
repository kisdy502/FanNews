package news.fan.fordagger.mvp;

/**
 * Created by Administrator on 2018/3/28.
 */

public interface LoginContract {

    interface View extends IBaseContract.IBaseView {

    }

    interface Presenter extends IBaseContract.IBasePresenter<View> {
        void login(String userName, String password);

    }

}
