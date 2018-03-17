package news.fan.rsademo.rsa;

/**
 * 质数计算工具
 * Created by Administrator on 2018/3/17.
 */

//质数又称素数。一个大于1的自然数，除了1和它自身外，不能被其他自然数整除的数叫做质数；否则称为合数。
public class PrimeUtil {
    /**
     * 判断一个数字是否为质数(素数)
     */
    public static boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2) return true;
        //从2到数字num的开平方指范围内进行循环计算
        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    /**
     * 判断两个数字互质(互为素数)
     */
    public static boolean checkPrime(int n1, int n2) {
        System.out.printf("n1:%d,n2:%d\n", n1, n2);
        int min, max, result;
        max = n1 > n2 ? n1 : n2;
        min = n1 > n2 ? n2 : n1;
        result = max % min;
        if (result == 0) {
            return false;
        } else if (result == 1) {
            return true;
        } else {
            return checkPrime(result, min);
        }

    }


    public static void main(String[] args) {
        int index;
        for (index = 0; index < 10000; index++) {
            if (PrimeUtil.isPrime(index)) {
                System.out.println(index + ":是素数");
            }
        }
    }

}