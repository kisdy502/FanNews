package news.fan.weibo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnForward;
    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnClick(View view) {
        int id = view.getId();
        if (id == R.id.forward) {
            LoginContext.getLoginContext().forward(MainActivity.this);
        } else if (id == R.id.logout) {
            LoginContext.getLoginContext().setState(new LogoutState());
        }
    }
}
