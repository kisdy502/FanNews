package news.fan.hookactivity;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import dalvik.system.DexClassLoader;

public class LoadModuleActivity extends AppCompatActivity {
    private final static String TAG = "LoadModule";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_module);

        loadDex();
    }

    private void loadDex() {
        //dex解压释放后的目录
        final File dexOutPutDir = getDir("dex", 0);
        Log.d(TAG, "dexOutPutDir:" + dexOutPutDir);
        //dex所在目录
        final String dexPath = Environment.getExternalStorageDirectory().toString() + File.separator + "new_log.jar";
        Log.d(TAG, "dexPath:" + dexPath);
        //第一个参数：是dex压缩文件的路径
        //第二个参数：是dex解压缩后存放的目录
        //第三个参数：是C/C++依赖的本地库文件目录,可以为null
        //第四个参数：是上一级的类加载器
        DexClassLoader classLoader = new DexClassLoader(dexPath, dexOutPutDir.getAbsolutePath(),
                null, getClassLoader());

        try {
            final Class<?> loadClazz = classLoader.loadClass("news.fan.testlib.SuperLog");
            final Object o = loadClazz.newInstance();
            final Method printLogMethod = loadClazz.getDeclaredMethod("logDebug");
            printLogMethod.setAccessible(true);
            printLogMethod.invoke(o);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


    }
}
