package news.fan.fordagger.mvp;

/**
 * Created by Administrator on 2018/3/28.
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

        //失败重试
        void showFaild();

    }
}

