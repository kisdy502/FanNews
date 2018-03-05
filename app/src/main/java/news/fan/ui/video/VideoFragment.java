package news.fan.ui.video;

import android.os.Bundle;
import android.view.View;

import java.util.List;

import javax.inject.Inject;

import news.fan.R;
import news.fan.bean.VideoChannelBean;
import news.fan.bean.VideoDetailBean;
import news.fan.component.ApplicationComponent;
import news.fan.component.DaggerHttpComponent;
import news.fan.ui.BaseFragment;
import news.fan.ui.JanDanFragment;
import news.fan.ui.video.VideoContract;

/**
 * Created by Administrator on 2018/3/5.
 */

public class VideoFragment extends BaseFragment<VideoPresenter> implements VideoContract.View {

    public static VideoFragment newInstance() {
        Bundle args = new Bundle();
        VideoFragment fragment = new VideoFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void loadVideoChannel(List<VideoChannelBean> channelBean) {

    }

    @Override
    public void loadVideoDetails(List<VideoDetailBean> detailBean) {

    }

    @Override
    public void loadMoreVideoDetails(List<VideoDetailBean> detailBean) {

    }

    @Override
    public int getContentLayout() {
        return  R.layout.fragment_video;
    }

    @Override
    @Inject
    public void initInjector(ApplicationComponent appComponent) {
        DaggerHttpComponent.builder()
                .applicationComponent(appComponent)
                .build()
                .inject(this);
    }

    @Override
    public void bindView(View view, Bundle savedInstanceState) {

    }

    @Override
    public void initData() {

    }
}
