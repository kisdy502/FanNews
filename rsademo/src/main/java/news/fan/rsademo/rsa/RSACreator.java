package news.fan.rsademo.rsa;

import java.math.BigDecimal;
import java.math.BigInteger;

import news.fan.rsademo.MathTool;

/**
 * 简单的RSA加密原理模拟
 * Created by Administrator on 2018/3/16.
 */

public class RSACreator {

    public static void main(String[] args) {
        //pq 互质的两个数字 79,73
        //N= p*q=79*73
        //L= lcm ((p-1),(q-1))   //p-1和q-1的最小公倍数
        //E  1<E<L ,E,L互质 gcd(E,L)=1;    //E,L的最大公约数为1
        //D  1<D<L ,E*D mod L=1;
        int p = 17, q = 19;
        int N = p * q;
        System.out.printf("N=%d\n", N);
        int L = MathTool.getMinmumCommonMultiple(p - 1, q - 1);
        System.out.printf("L=%d\n", L);
        int E = 0;
        for (int i = 2; i < L; i++) {
            if (MathTool.getGreatestCommonDivisor1(i, L) == 1) {
                System.out.printf("E=%d\n", i);
                E = i;
                break;
            }
        }

        int D = 0;
        for (int i = 2; i < L; i++) {
            if (i * E % L == 1) {
                System.out.printf("D=%d\n", i);
                D = i;
                break;
            }
        }

        //公钥 EN  5,323
        //私钥 DN  29,323

        ;

        //加密  密文＝明文^E mod N
        double cipher = Math.pow(123, 5) % 323;
        System.out.printf("cipher=%f\n", cipher);

        //解密
        //明文＝密文^D mod N＝225^29mod323=123

        System.out.printf("descrypt=%f\n", Math.pow(225, 29) % 323);

        //解密答案不正确，225的29次方太大了，无法计算出正确答案


    }


}
