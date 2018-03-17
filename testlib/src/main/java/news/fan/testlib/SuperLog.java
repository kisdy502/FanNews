package news.fan.testlib;

import android.util.Log;

/**
 * Created by Administrator on 2018/3/12.
 */

public class SuperLog {

    private static void logDebug() {
        Log.d("sLog", "log message from outer module");
    }

}
