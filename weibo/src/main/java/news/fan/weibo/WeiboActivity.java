package news.fan.weibo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class WeiboActivity extends AppCompatActivity {
    private Button btnForward;
    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weibo);
    }

    public void btnClick(View view) {
        int id = view.getId();
        if (id == R.id.comment_weibo) {
            LoginContext.getLoginContext().comment(WeiboActivity.this);
        }
    }
}
