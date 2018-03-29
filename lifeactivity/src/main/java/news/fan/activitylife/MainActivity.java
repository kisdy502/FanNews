package news.fan.activitylife;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = "Main";
    List<Object> list = new ArrayList<>();

    HashMap<Integer, Bitmap> bmpList = new HashMap<>();

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate");

        try {
//            for (int i = 0; i < 50; i++) {
//                byte[] b = new byte[1024 * 1204 * 10];
//                list.add(b);
//            }

            while (true) {
                list.add(new Object());
            }
        } catch (OutOfMemoryError ex) {
            ex.printStackTrace();
//            list.add(new Object());  //OutOfMemoryError被捕获到后，如果在catch块中尝试分配内存，就会知道崩溃
//            for (int i = 0; i < 50; i++) {
//                byte[] b = new byte[1024 * 1204 * 10];
//                list.add(b);
//            }

        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putLong("id", 1234567890);
        Log.d(TAG, "onSaveInstanceState");

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        long id = savedInstanceState.getLong("id");
        Log.d(TAG, "onRestoreInstanceState:" + id);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    public void btnClick(View view) {
//        PopupWindow popupWindow = new TestPopupWindow(this);
//        popupWindow.showAsDropDown(view);
//        createDialog();
        startActivity(new Intent(this, SecondActivity.class));
    }


    public class TestPopupWindow extends PopupWindow {
        public TestPopupWindow(Context context) {
            super(context);
            setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
            setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
            setOutsideTouchable(true);
            setFocusable(true);
            setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            TextView contentView = new TextView(context);
            contentView.setTextColor(getResources().getColor(R.color.colorPrimary));
            contentView.setText("PopWindow");
            setContentView(contentView);
        }
    }


    private void createDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
// 设置参数
        builder.setTitle("请做出选择").setIcon(R.mipmap.ic_launcher)
                .setMessage("凤姐美不美")
                .setPositiveButton("美", new DialogInterface.OnClickListener() {// 积极
                    @Override
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        Toast.makeText(MainActivity.this, "恭喜你打错了", 0)
                                .show();
                    }
                }).setNegativeButton("不美", new DialogInterface.OnClickListener() {// 消极
            @Override
            public void onClick(DialogInterface dialog,
                                int which) {
                Toast.makeText(MainActivity.this, "恭喜你答对了", 0)
                        .show();
            }
        }).setNeutralButton("不知道", new DialogInterface.OnClickListener() {// 中间级
            @Override
            public void onClick(DialogInterface dialog,
                                int which) {
                Toast.makeText(MainActivity.this, "你瞎啊", 0)
                        .show();
            }
        });
        builder.create().show();
    }

}
