package news.fan;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import butterknife.BindView;
import news.fan.component.ApplicationComponent;
import news.fan.ui.BaseActivity;
import news.fan.ui.JanDanFragment;
import news.fan.ui.PersonalFragment;
import news.fan.ui.news.NewsFragment;
import news.fan.ui.SupportFragment;
import news.fan.ui.video.VideoFragment;
import news.fan.util.StatusBarUtil;
import news.fan.widget.BottomBar;
import news.fan.widget.BottomBarTab;

public class MainActivity extends BaseActivity {
    final static String TAG = "MainActivity";

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @BindView(R.id.contentContainer)
    FrameLayout mContentContainer;
    @BindView(R.id.bottomBar)
    BottomBar mBottomBar;

    private SupportFragment[] mFragments = new SupportFragment[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String jniStr = stringFromJNI();
        Log.d(TAG, "jniStr::" + jniStr);
    }

    @Override
    public boolean isSupportSwipeBack() {
        return false;
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    @Override
    public int getContentLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initInjector(ApplicationComponent appComponent) {

    }

    @Override
    public void bindView(View view, Bundle savedInstanceState) {
        StatusBarUtil.setTranslucentForImageViewInFragment(MainActivity.this, 0, null);
        if (savedInstanceState == null) {
            mFragments[0] = NewsFragment.newInstance();
            mFragments[1] = VideoFragment.newInstance();
            mFragments[2] = JanDanFragment.newInstance();
            mFragments[3] = PersonalFragment.newInstance();

            getSupportDelegate().loadMultipleRootFragment(R.id.contentContainer, 0,
                    mFragments[0]);
        } else {
            mFragments[0] = findFragment(NewsFragment.class);
            mFragments[1] = findFragment(VideoFragment.class);
            mFragments[2] = findFragment(JanDanFragment.class);
            mFragments[3] = findFragment(PersonalFragment.class);
        }

        mBottomBar.addItem(new BottomBarTab(this, R.drawable.ic_news, "新闻"))
                .addItem(new BottomBarTab(this, R.drawable.ic_video, "视频"))
                .addItem(new BottomBarTab(this, R.drawable.ic_jiandan, "煎蛋"))
                .addItem(new BottomBarTab(this, R.drawable.ic_my, "我的"));
        mBottomBar.setOnTabSelectedListener(new BottomBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position, int prePosition) {
//                getSupportDelegate().showHideFragment(mFragments[position], mFragments[prePosition]);
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    public void onRetry() {

    }
}
