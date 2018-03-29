package news.fan.dagger2mvp.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import news.fan.dagger2mvp.MyApplicaiton;


/**
 * desc:
 * author: Will .
 * date: 2017/9/2 .
 */
public abstract class BaseActivity<T1 extends IBaseContract.IBasePresenter> extends AppCompatActivity implements IBase, IBaseContract.IBaseView {


    @Nullable
    @Inject
    protected T1 mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initInjector(MyApplicaiton.getInstance().getmApplicationComponent());
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }

    }


}
