package news.fan.rsademo.rsa;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by Administrator on 2018/3/16.
 */

public class IoUtil {
    public static void close(Closeable io){
        if(io!=null){
            try {
                io.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
