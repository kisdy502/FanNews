package news.fan.dagger2mvp;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


/**
 * desc:
 * author: Will .
 * date: 2017/9/2 .
 */
public class NewsApi {


    public static NewsApi sInstance;


    public NewsApi() {

    }

    public static NewsApi getInstance() {
        if (sInstance == null)
            sInstance = new NewsApi();
        return sInstance;
    }

}
