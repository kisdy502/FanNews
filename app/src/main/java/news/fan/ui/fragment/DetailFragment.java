package news.fan.ui.fragment;

import android.os.Bundle;
import android.view.View;

import java.util.List;

import news.fan.R;
import news.fan.bean.NewsDetail;
import news.fan.component.ApplicationComponent;
import news.fan.ui.inner.BaseFragment;
import news.fan.ui.constract.DetailContract;
import news.fan.ui.presenter.DetailPresenter;

/**
 * Created by Administrator on 2018/3/6.
 */

public class DetailFragment extends BaseFragment<DetailPresenter> implements DetailContract.View {

    public static DetailFragment newInstance(String newsid, int position) {
        Bundle args = new Bundle();
        args.putString("newsid", newsid);
        args.putInt("position", position);
        DetailFragment fragment = new DetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getContentLayout() {
        return R.layout.fragment_detail;
    }

    @Override
    public void initInjector(ApplicationComponent appComponent) {

    }

    @Override
    public void bindView(View view, Bundle savedInstanceState) {

    }

    @Override
    public void initData() {

    }

    @Override
    public void loadBannerData(NewsDetail newsDetail) {

    }

    @Override
    public void loadTopNewsData(NewsDetail newsDetail) {

    }

    @Override
    public void loadData(List<NewsDetail.ItemBean> itemBeanList) {

    }

    @Override
    public void loadMoreData(List<NewsDetail.ItemBean> itemBeanList) {

    }
}
