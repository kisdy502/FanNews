package news.fan.fordagger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    @Inject
    public MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerMainComponent.builder()
                .mainModule(new MainModule(this))
                .build()
                .inject(this);
        loadData();

        Log.d("main", "inject result:" + (presenter != null));
    }

    @Override
    public void loadData() {
        Log.d("main", "load data");
        Toast.makeText(this, "load", Toast.LENGTH_SHORT).show();
    }
}
