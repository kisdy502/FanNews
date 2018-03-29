package news.fan.dagger2mvp.ui;


/**
 * desc:
 * author: Will .
 * date: 2017/9/2 .
 */
public interface IBaseContract {

    interface IBasePresenter<T extends IBaseView> {

        void attachView(T view);

        void detachView();
    }


    interface IBaseView {
        //显示进度中
        void showLoading();

        //显示请求成功
        void showSuccess();

    }
}
