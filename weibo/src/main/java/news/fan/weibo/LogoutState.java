package news.fan.weibo;

import android.content.Context;
import android.content.Intent;

/**
 * Created by Administrator on 2018/3/17.
 */

public class LogoutState implements IUserState {
    @Override
    public void forward(Context context) {
        goToLoginActivity(context);
    }


    @Override
    public void comment(Context context) {
        goToLoginActivity(context);
    }

    private void goToLoginActivity(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

}
