package news.fan.dynmictype;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    static HashMap<String, Class> map = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String channelId1 = "yingfeike";
        String channelId2 = "fangzheng";
        String channelId3 = "chuangwei";
        create(channelId1);
    }

    static {
        map.put("chuangwei", ConfigChuangwei.class);
        map.put("yingfeike", ConfigInfeike.class);
        map.put("fangzheng", ConfigFangzheng.class);
    }

    private void create(String channelId) {
        Class clz = map.get(channelId);
        if (clz != null) {
            try {
                Config config = (Config) clz.newInstance();
                Log.d("MainActivity", config.getProp_BootVideo());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    static class Config {
        protected String prop_BootVideo;

        public String getProp_BootVideo() {
            return prop_BootVideo;
        }

        public void setProp_BootVideo(String prop_BootVideo) {
            prop_BootVideo = prop_BootVideo;
        }
    }

    static class ConfigChuangwei extends Config {

        public ConfigChuangwei() {
            prop_BootVideo = "sys.bootvideo.skyworth";
        }

    }

    static class ConfigInfeike extends Config {
        public ConfigInfeike() {
            prop_BootVideo = "sys.bootvideo.ifeike";
        }
    }

    static class ConfigFangzheng extends Config {
        public ConfigFangzheng() {
            prop_BootVideo = "sys.bootvideo.fangzheng";
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface ChannelType {
        String value();
    }

}
