package news.fan.rsademo;

import org.junit.Test;

import news.fan.rsademo.rsa.PrimeUtil;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testPrime() throws Exception {
        int index;
        for (index = 0; index < 10000; index++) {
            if (PrimeUtil.isPrime(index)) {
                System.out.println(index + ":是素数");
            }
        }
    }


    @Test
    public void testcheckPrime() throws Exception {
        int min = 5, max = 6;
        if (PrimeUtil.checkPrime(min, max)) {
            System.out.println(min + "与" + max + "互质");
        } else {
            System.out.println(min + "与" + max + "不是互质");
        }

        min = 3;
        max = 7;
        if (PrimeUtil.checkPrime(min, max)) {
            System.out.println(min + "与" + max + "互质");
        } else {
            System.out.println(min + "与" + max + "不是互质");
        }

        min = 63;
        max = 189;
        if (PrimeUtil.checkPrime(min, max)) {
            System.out.println(min + "与" + max + "互质");
        } else {
            System.out.println(min + "与" + max + "不是互质");
        }

        min = 43424321;
        max = 458545445;
        if (PrimeUtil.checkPrime(min, max)) {
            System.out.println(min + "与" + max + "互质");
        } else {
            System.out.println(min + "与" + max + "不是互质");
        }
    }


    @Test
    public void testCommonDivder() throws Exception {
        int m, n;
        int diver;

        m = 18;
        n = 24;
        diver = MathTool.getGreatestCommonDivisor2(m, n);
        System.out.println(m + "与" + n + "最大公约数是:" + diver);

        m = 29;
        n = 21;
        diver = MathTool.getGreatestCommonDivisor2(m, n);
        System.out.println(m + "与" + n + "最大公约数是:" + diver);
    }

    @Test
    public void testMaxMultiple() throws Exception {
        int m, n;
        int diver;

        m = 12;
        n = 11;
        diver = MathTool.getMinmumCommonMultiple(m, n);
        System.out.println(m + "与" + n + "最大公倍数是:" + diver);

    }
}