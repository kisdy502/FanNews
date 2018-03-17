package news.fan.rsademo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.widget.TextView;

import java.io.File;
import java.security.Key;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

import news.fan.rsademo.rsa.FileUtil;
import news.fan.rsademo.rsa.RSACreator;
import news.fan.rsademo.rsa.RSASignature;
import news.fan.rsademo.rsa.RSAUtils;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextView tvPrivateKey;
    private TextView tvPublicKey;
    private String privateKey;
    private String publicKey;

//    final String plainText = "我是客户端发送的明文";
//    final String response = "我是服务器返回的消息";
//    String cipherText;  //密文


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvPublicKey = findViewById(R.id.public_key);
        tvPrivateKey = findViewById(R.id.private_key);
        if (!isKeyPrepared()) {
            createKey();
        } else {
            long start = System.currentTimeMillis();
            Log.d(TAG, "密钥存在，直接使用");
            String keyDir = FileUtil.getKeyPath();
            String publicKeyFile = keyDir + File.separator + "publicKey";
            String privateKeyFile = keyDir + File.separator + "privateKey";
            privateKey = FileUtil.readFile(privateKeyFile);
            publicKey = FileUtil.readFile(publicKeyFile);
            Log.i(TAG, "publicKey\n" + publicKey);
            Log.i(TAG, "privateKey\n" + privateKey);
            long end = System.currentTimeMillis();
            Log.e(TAG, "coust:" + (end - start) + "ms");
        }

        long start1 = System.currentTimeMillis();
        test1();
        long end1 = System.currentTimeMillis();
        Log.e(TAG, "test1 coust:" + (end1 - start1) + "ms");

        long start2 = System.currentTimeMillis();
        test2();
        long end2 = System.currentTimeMillis();
        Log.e(TAG, "test2 coust:" + (end2 - start2) + "ms");


        long start3 = System.currentTimeMillis();
        test3();
        long end3 = System.currentTimeMillis();
        Log.e(TAG, "test3 coust:" + (end3 - start3) + "ms");
    }


    private void createKey() {
        Map<String, Object> keyMap = null;
        try {
            keyMap = RSAUtils.initKey();
            byte[] publicKeyBytes = RSAUtils.getPublicKey(keyMap);
            byte[] privateKeyBytes = RSAUtils.getPrivateKey(keyMap);
            publicKey = RSAUtils.encryptBASE64(publicKeyBytes);
            privateKey = RSAUtils.encryptBASE64(privateKeyBytes);
            Log.i(TAG, "publicKey\n" + publicKey);
            Log.i(TAG, "privateKey\n" + privateKey);
            String keyDir = FileUtil.getKeyPath();
            if (!TextUtils.isEmpty(keyDir)) {
                Log.i(TAG, "keyDir:" + keyDir);
                String publicKeyFile = keyDir + File.separator + "publicKey";
                String privateKeyFile = keyDir + File.separator + "privateKey";
                FileUtil.wirteFile(publicKey, publicKeyFile);
                FileUtil.wirteFile(privateKey, privateKeyFile);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private boolean isKeyPrepared() {
        String keyDir = FileUtil.getKeyPath();
        if (!TextUtils.isEmpty(keyDir)) {
            String publicKeyFile = keyDir + File.separator + "publicKey";
            String privateKeyFile = keyDir + File.separator + "privateKey";
            return new File(publicKeyFile).exists() && new File(privateKeyFile).exists();
        }
        return false;
    }

    //数字签名/验证签名
    private void test1() {
        byte[] publicKeyBytes = Base64.decode(publicKey, Base64.DEFAULT);
        byte[] privateKeyBytes = Base64.decode(privateKey, Base64.DEFAULT);

        final String response = "我是服务器准备返回的消息";
        byte[] sign = RSASignature.sign(response, privateKeyBytes);                    //生成了签名
        try {
            boolean isRight = RSASignature.doCheck(response, sign, publicKeyBytes);     //验证签名
            Log.i(TAG, "验证签名结果:" + isRight);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //公钥加密/私钥解密
    private void test2() {
        final String plainText = "我是客户端发送的明文";
        try {
            byte[] publicKeyBytes = RSAUtils.decryptBASE64(publicKey);
            byte[] privateKeyBytes = RSAUtils.decryptBASE64(privateKey);
            byte[] cipherBytes = RSAUtils.encryptByPublicKey(plainText.getBytes(), publicKeyBytes);
            byte[] plainBytes = RSAUtils.decryptByPrivateKey(cipherBytes, privateKeyBytes);
            String result = new String(plainBytes);
            Log.d(TAG, "result:" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //私钥加密/公钥解密
    private void test3() {
        final String plainText = "我是服务器要发送的明文";
        try {
            byte[] publicKeyBytes = RSAUtils.decryptBASE64(publicKey);
            byte[] privateKeyBytes = RSAUtils.decryptBASE64(privateKey);
            byte[] cipherBytes = RSAUtils.encryptByPrivateKey(plainText.getBytes(), privateKeyBytes);
            byte[] plainBytes = RSAUtils.decryptByPublicKey(cipherBytes, publicKeyBytes);
            String result = new String(plainBytes);
            Log.d(TAG, "result:" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
