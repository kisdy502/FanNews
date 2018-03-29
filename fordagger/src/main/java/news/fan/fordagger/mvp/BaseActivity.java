package news.fan.fordagger.mvp;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements IBaseContract.IBaseView {

    @Nullable
    @Inject
    protected T presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showSuccess() {

    }

    @Override
    public void showFaild() {

    }

}
