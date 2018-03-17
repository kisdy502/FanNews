package news.fan.testlib;

/**
 * 利用原型模式实现防止其它开发人员修改User
 * 任然可以通过反射修改
 * Created by Administrator on 2018/3/15.
 */


//避免DCL的耗性能写法，确保线程安全同时，延迟单例对象实例化
public class LoginSession {
    private static class SessionHolder {
        private final static LoginSession instance = new LoginSession();
    }

    private LoginSession() {
    }

    public static LoginSession getInstance() {
        return SessionHolder.instance;
    }

    User loginUser;

    public User getLoginUser() {
        return loginUser.clone();
    }

    void setLoginUser(User user) {
        loginUser = user;
    }
}
