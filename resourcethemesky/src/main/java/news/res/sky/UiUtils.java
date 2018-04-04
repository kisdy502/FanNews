package news.res.sky;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by Administrator on 2018/4/3.
 */

public class UiUtils {

    public static String getTextString(Context ctx){
        return ctx.getResources().getString(R.string.app_name);
    }

    public static Drawable getImageDrawable(Context ctx){
        return ctx.getResources().getDrawable(R.drawable.yangmi);
    }

    public static View getLayout(Context ctx){
        return LayoutInflater.from(ctx).inflate(R.layout.activity_main_sky, null);
    }

    public static int getTextStringId(){
        return R.string.app_name;
    }

    public static int getImageDrawableId(){
        return R.drawable.yangmi;
    }

    public static int getLayoutId(){
        return R.layout.activity_main_sky;
    }
}
