package news.fan.testlib;

/**
 * Created by Administrator on 2018/3/15.
 */

public class User implements Cloneable {

    @Override
    protected User clone() {
        User user = null;
        try {
            user = (User) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return user;
    }
}
