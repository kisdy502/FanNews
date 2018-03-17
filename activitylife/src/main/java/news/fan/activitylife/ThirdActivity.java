package news.fan.activitylife;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

public class ThirdActivity extends AppCompatActivity {
    Button button;
    private final static String TAG = "Main";
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {

        }
    };

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        button = findViewById(R.id.go_button);
        //时间插值器
        TimeInterpolator interpolator;
        TypeEvaluator<Integer> typeEvaluator;


        @SuppressLint("ObjectAnimatorBinding")
        ValueAnimator valueAnimator = ObjectAnimator.ofInt(button, "backgroundColor", 0xFFFF8080, 0xFF8080FF);
        valueAnimator.setDuration(3000);
        valueAnimator.setEvaluator(new ArgbEvaluator());
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.start();


        try {
            Bitmap bmp1 = BitmapFactory.decodeResource(getResources(), R.drawable.d1);
            Log.d(TAG, "size:" + bmp1.getAllocationByteCount());
            Bitmap bmp2 = BitmapFactory.decodeResource(getResources(), R.drawable.d2);
            Log.d(TAG, "size:" + bmp2.getAllocationByteCount());
            Bitmap bmp3 = BitmapFactory.decodeResource(getResources(), R.drawable.d3);
            Log.d(TAG, "size:" + bmp3.getAllocationByteCount());
            Bitmap bmp4 = BitmapFactory.decodeResource(getResources(), R.drawable.d4);
            Log.d(TAG, "size:" + bmp4.getAllocationByteCount());
            Bitmap bmp5 = BitmapFactory.decodeResource(getResources(), R.drawable.d5);
            Log.d(TAG, "size:" + bmp5.getAllocationByteCount());
            Bitmap bmp6 = BitmapFactory.decodeResource(getResources(), R.drawable.d6);
            Log.d(TAG, "size:" + bmp6.getAllocationByteCount());
            Bitmap bmp7 = BitmapFactory.decodeResource(getResources(), R.drawable.d7);
            Log.d(TAG, "size:" + bmp7.getAllocationByteCount());
//                findViewById(R.id.btn).setBackground(bmp);
        } catch (OutOfMemoryError ex) {
            ex.printStackTrace();
        }
    }
}
