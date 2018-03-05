package news.fan.ui.news;

import org.litepal.crud.DataSupport;
import org.litepal.crud.callback.SaveCallback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import news.fan.MyApplication;
import news.fan.R;
import news.fan.bean.Channel;
import news.fan.ui.BasePresenter;
import news.fan.ui.news.NewsContract;

/**
 * Created by Administrator on 2018/3/5.
 */

public class NewsPresenter extends BasePresenter<NewsContract.View> implements NewsContract.Presenter {
    @Inject
    public NewsPresenter() {
    }


    @Override
    public void getChannel() {
        List<Channel> channelList;
        List<Channel> myChannels = new ArrayList<>();
        List<Channel> otherChannels = new ArrayList<>();


        List<String> channelName = Arrays.asList(MyApplication.getInstance().getResources()
                .getStringArray(R.array.news_channel));
        List<String> channelId = Arrays.asList(MyApplication.getInstance().getResources()
                .getStringArray(R.array.news_channel_id));
        List<Channel> channels = new ArrayList<>();

        for (int i = 0; i < channelName.size(); i++) {
            Channel channel = new Channel();
            channel.setChannelId(channelId.get(i));
            channel.setChannelName(channelName.get(i));
            channel.setChannelType(i < 1 ? 1 : 0);
            channel.setChannelSelect(i < channelId.size() - 3);
            if (i < channelId.size() - 3) {
                myChannels.add(channel);
            } else {
                otherChannels.add(channel);
            }
            channels.add(channel);
        }

        DataSupport.saveAllAsync(channels).listen(new SaveCallback() {
            @Override
            public void onFinish(boolean success) {
            }
        });

        channelList = new ArrayList<>();
        channelList.addAll(channels);

        mView.loadData(myChannels, otherChannels);
    }
}
