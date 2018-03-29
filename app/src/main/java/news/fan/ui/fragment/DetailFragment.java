package news.fan.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.flyco.animation.SlideEnter.SlideRightEnter;
import com.flyco.animation.SlideExit.SlideRightExit;
import com.github.florent37.viewanimator.AnimationListener;
import com.github.florent37.viewanimator.ViewAnimator;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import news.fan.R;
import news.fan.bean.NewsDetail;
import news.fan.component.ApplicationComponent;
import news.fan.component.DaggerHttpComponent;
import news.fan.net.NewsApi;
import news.fan.ui.adapter.NewsDetailAdapter;
import news.fan.ui.inner.BaseFragment;
import news.fan.ui.constract.DetailContract;
import news.fan.ui.presenter.DetailPresenter;
import news.fan.util.ImageLoaderUtil;

/**
 * Created by Administrator on 2018/3/6.
 */

public class DetailFragment extends BaseFragment<DetailPresenter> implements DetailContract.View {

    private static final String TAG = "JdDetailFragment";

    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.mPtrFrameLayout)
    PtrFrameLayout mPtrFrameLayout;
    @BindView(R.id.tv_toast)
    TextView mTvToast;
    @BindView(R.id.rl_top_toast)
    RelativeLayout mRlTopToast;

    private String newsid;
    private int position;
    private List<NewsDetail.ItemBean> beanList;
    private List<NewsDetail.ItemBean> mBannerList;
    private NewsDetailAdapter detailAdapter;
    private int upPullNum = 1;
    private int downPullNum = 1;
    private boolean isRemoveHeaderView = false;


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
        DaggerHttpComponent.builder()
                .applicationComponent(appComponent)
                .build()
                .inject(this);
    }

    @Override
    public void bindView(View view, Bundle savedInstanceState) {
        mPtrFrameLayout.disableWhenHorizontalMove(true);
        mPtrFrameLayout.setPtrHandler(new PtrHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return PtrDefaultHandler.checkContentCanBePulledDown(frame, mRecyclerView, header);
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                Log.i(TAG, "onRefreshBegin: " + downPullNum);
                isRemoveHeaderView = true;
                mPresenter.getData(newsid, NewsApi.ACTION_DOWN, downPullNum);
            }
        });
        beanList = new ArrayList<>();
        mBannerList = new ArrayList<>();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(detailAdapter = new NewsDetailAdapter(beanList, getActivity()));
        detailAdapter.setEnableLoadMore(true);
        detailAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        detailAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                Log.i(TAG, "onLoadMoreRequested: " + upPullNum);
                mPresenter.getData(newsid, NewsApi.ACTION_UP, upPullNum);

            }
        }, mRecyclerView);

    }

    @Override
    public void initData() {
        if (getArguments() == null) return;
        newsid = getArguments().getString("newsid");
        position = getArguments().getInt("position");
        mPresenter.getData(newsid, NewsApi.ACTION_DEFAULT, 1);
    }

    @Override
    public void loadBannerData(NewsDetail newsDetail) {

    }

    @Override
    public void loadTopNewsData(NewsDetail newsDetail) {

    }

    @Override
    public void loadData(List<NewsDetail.ItemBean> itemBeanList) {
        if (itemBeanList == null || itemBeanList.size() == 0) {
            showFaild();
            mPtrFrameLayout.refreshComplete();
        } else {
            downPullNum++;
            if (isRemoveHeaderView) {
                detailAdapter.removeAllHeaderView();
            }
            detailAdapter.setNewData(itemBeanList);
            showToast(itemBeanList.size(), true);
            mPtrFrameLayout.refreshComplete();
            showSuccess();
            Log.i(TAG, "loadData: " + itemBeanList.toString());
        }
    }

    @Override
    public void loadMoreData(List<NewsDetail.ItemBean> itemBeanList) {

    }


    private void showToast(int num, boolean isRefresh) {
        if (isRefresh) {
            mTvToast.setText(String.format(getResources().getString(R.string.news_toast), num + ""));
        } else {
            mTvToast.setText("将为你减少此类内容");
        }
        mRlTopToast.setVisibility(View.VISIBLE);
        ViewAnimator.animate(mRlTopToast)
                .newsPaper()
                .duration(1000)
                .start()
                .onStop(new AnimationListener.Stop() {
                    @Override
                    public void onStop() {
                        ViewAnimator.animate(mRlTopToast)
                                .bounceOut()
                                .duration(1000)
                                .start();
                    }
                });
    }
}
