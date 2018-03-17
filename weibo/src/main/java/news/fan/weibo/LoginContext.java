package news.fan.weibo;

import android.content.Context;

/**
 * Created by Administrator on 2018/3/17.
 */

public class LoginContext implements IUserState {
    private final static LoginContext instance = new LoginContext();

    IUserState state = new LogoutState();

    public final static LoginContext getLoginContext() {
        return instance;
    }

    public void setState(IUserState state) {
        this.state = state;
    }


    @Override
    public void forward(Context context) {
        state.forward(context);
    }

    @Override
    public void comment(Context context) {
        state.comment(context);
    }
}
