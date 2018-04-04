package news.fan.resourceloader;

import android.app.Application;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2018/4/3.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        String dir = getCacheDir().getAbsolutePath();
        Log.d("ee", "dir:"+dir);
        init();
    }


    private void init() {
        copyFile("resourcethemeclassic.apk");
        copyFile("resourcethemesky.apk");
    }

    private void copyFile(String fName) {
        InputStream is = null;
        FileOutputStream fs = null;
        try {
            is = getAssets().open(fName);
            fs = new FileOutputStream(new File(getCacheDir(),fName));
            byte[] buffer = new byte[2048];
            int len = 0;
            while ((len = is.read(buffer)) > 0) {
                fs.write(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {



            IoUtils.close(is);
            IoUtils.close(fs);
        }
    }
}
