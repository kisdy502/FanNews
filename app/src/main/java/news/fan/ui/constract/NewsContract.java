package news.fan.ui.constract;

import java.util.List;
import news.fan.bean.Channel;
import news.fan.ui.inner.BaseContract;

/**
 * Created by Administrator on 2018/3/5.
 */

public interface NewsContract{

    interface View extends BaseContract.BaseView {

        void loadData(List<Channel> channels, List<Channel> otherChannels);

    }

    interface Presenter extends BaseContract.BasePresenter<View>{
        /**
         * 初始化频道
         */
        void getChannel();

    }

}
