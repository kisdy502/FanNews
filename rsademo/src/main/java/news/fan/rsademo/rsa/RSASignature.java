package news.fan.rsademo.rsa;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * 私钥持有方通过私钥对发送内容数字签名
 * 公钥方通过公钥校验签名是否正确
 * Created by Administrator on 2018/3/16.
 */

public class RSASignature {

    /**
     * 签名算法  md5
     */
    public static final String SIGNATURE_ALGORITHM = "MD5withRSA";

    /**
     * 签名算法  sha1
     */
    public static final String SIGN_ALGORITHMS = "SHA1WithRSA";

    /**
     * RSA签名
     *
     * @param content    待签名数据
     * @param privateKey 商户私钥
     * @param encode     字符集编码
     * @return 签名值, 未加密的签名
     */
    public static byte[] sign(String content, byte[] privateKey, String encode) {
        try {
            PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(privateKey);

            KeyFactory keyf = KeyFactory.getInstance("RSA");
            PrivateKey priKey = keyf.generatePrivate(priPKCS8);

            java.security.Signature signature = java.security.Signature.getInstance(SIGNATURE_ALGORITHM);

            signature.initSign(priKey);
            signature.update(content.getBytes(encode));
            byte[] signed = signature.sign();   //得到了数字签名(原始未加密的签名)
            return signed;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static byte[] sign(String content, byte[] privateKey) {
        return sign(content, privateKey, "UTF-8");
    }


    /**
     * RSA验签名检查
     *
     * @param content   待签名数据
     * @param sign      签名值
     * @param publicKey 分配给开发商公钥
     * @param encode    字符集编码
     * @return 布尔值
     */
    public static boolean doCheck(String content, byte[] sign, byte[] publicKey, String encode) {
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(publicKey));
            java.security.Signature signature = java.security.Signature
                    .getInstance(SIGNATURE_ALGORITHM);
            signature.initVerify(pubKey);
            signature.update(content.getBytes(encode));
            boolean bverify = signature.verify(sign);
            return bverify;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public static boolean doCheck(String content, byte[] sign, byte[] publicKey) {
        return doCheck(content, sign, publicKey, "UTF-8");
    }
}
