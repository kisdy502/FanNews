package news.fan.rsademo;

import android.util.Log;

/**
 * Created by Administrator on 2018/3/17.
 */

public class MathTool {
    private final static String TAG = "MathTool";

    /**
     * 求最大公约数 穷举法
     */
    public static int getGreatestCommonDivisor1(int m, int n) {
        int min, max;
        max = m > n ? m : n;
        min = m > n ? n : m;

        for (int end = min; end > 0; end--) {
            if (min % end == 0 && max % end == 0) {
                return end;
            }
        }
        return 1;
    }

    /**
     * 求最大公约数 辗转相除
     */
    public static int getGreatestCommonDivisor2(int m, int n) {
        int min, max;
        max = m > n ? m : n;
        min = m > n ? n : m;
        int result = 0;

        while (min != 0) {
            result = max % min;
            max = min;
            min = result;
        }
        return max;
    }

    /**
     * 求最大公约数 辗转相减法
     */
    public static int getGreatestCommonDivisor3(int m, int n) {
        return 0;
    }

    /**
     * 最小公倍数，实现方式应该也有多种
     *
     * @param m
     * @param n
     * @return
     */
    public static int getMinmumCommonMultiple(int m, int n) {
        long mult = m * n;
        int maxMult = (int) (mult / getGreatestCommonDivisor2(m, n));
        return maxMult;
    }

}
