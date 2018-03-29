package news.fan.fordagger.mvp;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import news.fan.fordagger.R;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View {


    private String userName, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userName = "admin";
        password = "admin";

        presenter.login(userName, password);
    }

    @Override
    public void showLoading() {
        super.showLoading();
    }

    @Override
    public void showSuccess() {
        super.showSuccess();
    }

    @Override
    public void showFaild() {
        super.showFaild();
    }
}
