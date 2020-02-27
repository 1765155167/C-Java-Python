package 编码算法.签名算法;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.*;

public class SHA1withRSA {
    public static void main(String[] args) throws GeneralSecurityException {
        //生成RSA公有密匙和私有密匙
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(1024);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        //待签名消息
        byte[] message = "Hello, I am Bob!".getBytes(StandardCharsets.UTF_8);
        //用私有密匙签名
        Signature s = Signature.getInstance("SHA1withRSA");
        s.initSign(privateKey);
        s.update(message);
        byte[] signed = s.sign();
        System.out.println("sign:" + new BigInteger(1, signed).toString(16));

        //用公钥验证
        Signature v = Signature.getInstance("SHA1withRSA");
        v.initVerify(publicKey);
        v.update(message);
        boolean valid = v.verify(signed);
        System.out.println("Valid?" + valid);

    }
}
