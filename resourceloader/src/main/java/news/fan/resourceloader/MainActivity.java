package news.fan.resourceloader;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import dalvik.system.DexClassLoader;

public class MainActivity extends BaseActivity {
    /**
     * 需要替换主题的控件
     * 这里就列举三个：TextView,ImageView,LinearLayout
     */
    private TextView textV;
    private ImageView imgV;
    private LinearLayout layout;

    /**
     * 类加载器
     */
    protected DexClassLoader classLoader = null;

    protected File fileRelease = null; //释放目录


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textV = (TextView) findViewById(R.id.text);
        imgV = (ImageView) findViewById(R.id.imageview);
        layout = (LinearLayout) findViewById(R.id.layout);

        fileRelease = getDir("dex", 0);


        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View arg0) {
                String filesDir = getCacheDir().getAbsolutePath();
                String filePath = filesDir + File.separator + "resourcethemeclassic.apk";
                classLoader = new DexClassLoader(filePath, fileRelease.getAbsolutePath(), null, getClassLoader());
                loadResources(filePath);
                setContent();
            }
        });

        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                String filesDir = getCacheDir().getAbsolutePath();
                String filePath = filesDir + File.separator + "resourcethemesky.apk";
                classLoader = new DexClassLoader(filePath, fileRelease.getAbsolutePath(), null, getClassLoader());
                loadResources(filePath);
                setContent1();
            }
        });

    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void setContent() {
        try {
            Class clazz = classLoader.loadClass("news.res.classic.UiUtils");
            Method method = clazz.getMethod("getTextString", Context.class);
            String str = (String) method.invoke(null, this);
            textV.setText(str);
            method = clazz.getMethod("getImageDrawable", Context.class);
            Drawable drawable = (Drawable) method.invoke(null, this);
            imgV.setBackground(drawable);
            method = clazz.getMethod("getLayout", Context.class);
            View view = (View) method.invoke(null, this.getApplicationContext());
            layout.addView(view);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void setContent1() {
        int stringId = getTextStringId();
        int drawableId = getImgDrawableId();
        int layoutId = getLayoutId();

        try {
            String str = mResources.getString(stringId);
            textV.setText(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Drawable drawable = mResources.getDrawable(drawableId);
            imgV.setBackground(drawable);
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            XmlResourceParser parser = mResources.getLayout(layoutId);
            View view=LayoutInflater.from(this).inflate(parser, null);
            layout.addView(view);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Log.i("Loader", "stringId:" + stringId + ",drawableId:" + drawableId + ",layoutId:" + layoutId);
    }

    @SuppressLint("NewApi")
    private int getTextStringId() {
        try {
            Class clazz = classLoader.loadClass("news.res.sky.R$string");
            Field field = clazz.getField("app_name");
            int resId = (int) field.get(null);
            return resId;
        } catch (Exception e) {
            Log.i("Loader", "error:" + Log.getStackTraceString(e));
        }
        return 0;
    }

    @SuppressLint("NewApi")
    private int getImgDrawableId() {
        try {
            Class clazz = classLoader.loadClass("news.res.sky.R$drawable");
            Field field = clazz.getField("yangmi");
            int resId = (int) field.get(null);
            return resId;
        } catch (Exception e) {
            Log.i("Loader", "error:" + Log.getStackTraceString(e));
        }
        return 0;
    }

    @SuppressLint("NewApi")
    private int getLayoutId() {
        try {
            Class clazz = classLoader.loadClass("news.res.sky.R$layout");
            Field field = clazz.getField("activity_main_sky");
            int resId = (int) field.get(null);
            return resId;
        } catch (Exception e) {
            Log.i("Loader", "error:" + Log.getStackTraceString(e));
        }
        return 0;
    }

//    @SuppressLint("NewApi")
//    private void printResourceId() {
//        try {
//            Class clazz = classLoader.loadClass("news.res.sky.UiUtils");
//            Method method = clazz.getMethod("getTextStringId", null);
//            Object obj = method.invoke(null, null);
//            Log.i("Loader", "stringId:" + obj);
//            Log.i("Loader", "newId:" + R.string.app_name);
//            method = clazz.getMethod("getImageDrawableId", null);
//            obj = method.invoke(null, null);
//            Log.i("Loader", "drawableId:" + obj);
//            Log.i("Loader", "newId:" + R.mipmap.ic_launcher);
//            method = clazz.getMethod("getLayoutId", null);
//            obj = method.invoke(null, null);
//            Log.i("Loader", "layoutId:" + obj);
//            Log.i("Loader", "newId:" + R.layout.activity_main);
//        } catch (Exception e) {
//            Log.i("Loader", "error:" + Log.getStackTraceString(e));
//        }
//    }

    private void printRField() {
        Class clazz = R.id.class;
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            Log.i("Loader", "fields:" + field);
        }
        Class clazzs = R.layout.class;
        Field[] fieldss = clazzs.getFields();
        for (Field field : fieldss) {
            Log.i("Loader", "fieldss:" + field);
        }
    }
}
