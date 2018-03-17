package news.fan.weibo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {
    private Button btnForward;
    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void btnClick(View view) {
        int id = view.getId();
        if (id == R.id.login) {
            LoginContext.getLoginContext().setState(new LoginState());
            finish();
        }
    }
}
