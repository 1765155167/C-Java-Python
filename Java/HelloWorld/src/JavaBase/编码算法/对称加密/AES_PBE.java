package JavaBase.编码算法.对称加密;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Base64;

public class AES_PBE {
    public static void main(String[] args) throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        String message = "HelloWorld";//原文
        String password = "hqf666123";//密文
        //16bit Salt 获取16bit盐值
        byte[] salt = SecureRandom.getInstanceStrong().generateSeed(16);
        System.out.printf("salt:%032x\n",new BigInteger(1, salt));
        //加密
        byte[] encrypted = encrypt(password, salt, message.getBytes("UTF-8"));
        System.out.println(Base64.getEncoder().encodeToString(encrypted));
        //解密
        byte[] decrypted = decrypt(password, salt, encrypted);
        System.out.println("decrypted="+new String(decrypted,"UTF-8"));
    }

    private static byte[] decrypt(String password, byte[] salt, byte[] encrypted) throws Exception {
        PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBEwithSHA1and128bitAES-CBC-BC");
        SecretKey sKey = factory.generateSecret(keySpec);
        PBEParameterSpec pSpec = new PBEParameterSpec(salt, 1000);//循环1000次
        Cipher cipher = Cipher.getInstance("PBEwithSHA1and128bitAES-CBC-BC");
        cipher.init(Cipher.DECRYPT_MODE, sKey, pSpec);
        return cipher.doFinal(encrypted);
    }

    private static byte[] encrypt(String password, byte[] salt, byte[] bytes) throws Exception {
        PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBEwithSHA1and128bitAES-CBC-BC");
        SecretKey key = factory.generateSecret(keySpec);
        PBEParameterSpec pSpec = new PBEParameterSpec(salt, 1000);
        Cipher cipher = Cipher.getInstance("PBEwithSHA1and128bitAES-CBC-BC");
        cipher.init(Cipher.ENCRYPT_MODE, key, pSpec);
        return cipher.doFinal(bytes);
    }
}
