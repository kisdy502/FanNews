package news.fan.weibo;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2018/3/17.
 */

public class LoginState implements IUserState {

    @Override
    public void forward(Context context) {
        Toast.makeText(context, "forward", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void comment(Context context) {
        Toast.makeText(context, "comment", Toast.LENGTH_SHORT).show();
    }
}
