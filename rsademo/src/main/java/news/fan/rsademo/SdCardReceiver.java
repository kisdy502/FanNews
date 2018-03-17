package news.fan.rsademo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Administrator on 2018/3/16.
 */

public class SdCardReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();
        if (Intent.ACTION_MEDIA_EJECT.equals(action)) {
            // 本人感觉 ACTION_MEDIA_EJECT 比
            //  ACTION_MEDIA_UNMOUNTED 好
            // sd 卡不可用
        } else if (Intent.ACTION_MEDIA_REMOVED.equals(action)) {
            // sd 卡已经被移除卡槽
        } else if (Intent.ACTION_MEDIA_SHARED.equals(action)) {
            // 选择通过 usb 共享
        } else if (Intent.ACTION_MEDIA_MOUNTED.equals(action)) {
            // sd 卡可用
        }
    }
}
