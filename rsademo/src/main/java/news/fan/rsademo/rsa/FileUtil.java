package news.fan.rsademo.rsa;

import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

/**
 * Created by Administrator on 2018/3/16.
 */

public class FileUtil {

    public static String getKeyPath() {
        boolean exist = Environment.getExternalStorageState()
                .equals(android.os.Environment.MEDIA_MOUNTED);
        if (exist) {
            String dir = Environment.getExternalStorageDirectory().getPath() + File.separator + "keypairs";
            File keyDir = new File(dir);
            if (!keyDir.exists()) {
                keyDir.mkdirs();
            }
            return dir;
        } else {
            return null;
        }
    }

    private static String getSdCard() {
        boolean exist = Environment.getExternalStorageState()
                .equals(android.os.Environment.MEDIA_MOUNTED);
        if (exist) {
            return Environment.getExternalStorageDirectory().getPath();
        } else {
            return null;
        }
    }

    /**
     * 往文件中写输入数据
     */
    public static void wirteFile(String key, String keyFile) {
        File f = new File(keyFile);
        if (f.exists()) {
            f.delete();
        }
        boolean created = false;
        try {
            created = f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (created) {
            FileWriter writer = null;
            try {
                writer = new FileWriter(f);
                writer.write(key);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                IoUtil.close(writer);
            }
        }
    }


    public static String readFile(String keyFile) {
        File f = new File(keyFile);
        if (f.exists()) {
            Reader read = null;
            BufferedReader bReader = null;
            StringBuilder sb = new StringBuilder();//定义一个字符串缓存，将字符串存放缓存中
            String s = "";
            try {
                read = new FileReader(f);
                bReader = new BufferedReader(read);//new一个BufferedReader对象，将文件内容读取到缓存
                int len;
                while ((s = bReader.readLine()) != null) {//逐行读取文件内容，不读取换行符和末尾的空格
                    sb.append(s);//将读取的字符串添加换行符后累加存放在缓存中
                }
                return sb.toString();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                IoUtil.close(bReader);
                IoUtil.close(read);
            }

        }
        return null;
    }


}
