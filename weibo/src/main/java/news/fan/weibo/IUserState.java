package news.fan.weibo;

import android.content.Context;

/**
 * Created by Administrator on 2018/3/17.
 */

public interface IUserState {

    //转发
    public void forward(Context context);

    //评论
    public void comment(Context context);
}
