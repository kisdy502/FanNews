package news.fan.fordagger.mvp;

import android.text.TextUtils;
import android.util.Log;

import javax.inject.Inject;

/**
 * Created by Administrator on 2018/3/28.
 */

public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {

    @Override
    public void login(String userName, String password) {
        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(password)) {
            Log.w("login", "input not full");
        } else {
            if ("admin".equals(userName) && "test".equals(password)) {
                Log.d("login", "login successd");
            } else {
                Log.e("login", "error userName or password");
            }
        }
    }
}
