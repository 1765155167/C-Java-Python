package JavaBase.编码算法.对称加密;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;

public class AES_CBC {
    public static void main(String[] args) throws Exception {
        String message = "Hello World";
        //256位密匙
        byte[] key = "0123456789abcdef0123456789abcdef".getBytes("UTF-8");
        byte[] encrypted = encrypt(key, message.getBytes());
        System.out.println(Base64.getEncoder().encodeToString(encrypted));
        byte[] decrypted = decrypt(key, encrypted);
        System.out.println(new String(decrypted, "UTF-8"));
    }

    private static byte[] decrypt(byte[] key, byte[] encrypted) throws Exception {
        byte[] iv = new byte[16];
        byte[] data = new byte[encrypted.length - 16];
        System.arraycopy(encrypted, 0, iv, 0 , 16);
        System.arraycopy(encrypted, 16, data, 0, data.length);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKey keySec = new SecretKeySpec(key, "AES");
        IvParameterSpec ivp = new IvParameterSpec(iv);
        cipher.init(Cipher.DECRYPT_MODE, keySec, ivp);
        return cipher.doFinal(data);
    }

    private static byte[] encrypt(byte[] key, byte[] bytes) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKey keySec = new SecretKeySpec(key, "AES");
        SecureRandom random = SecureRandom.getInstanceStrong();
        byte[] iv = random.generateSeed(16);//获取16字节随机数
        IvParameterSpec ivp = new IvParameterSpec(iv);
        cipher.init(Cipher.ENCRYPT_MODE, keySec, ivp);
        byte[] data = cipher.doFinal(bytes);
        return join(iv, data);
    }

    //合并两个byte[]
    private static byte[] join(byte[] bs1, byte[] bs2) {
        byte[] r = new byte[bs1.length + bs2.length];
        System.arraycopy(bs1, 0, r, 0, bs1.length);
        System.arraycopy(bs2, 0, r, bs1.length, bs2.length);
        return r;
    }
}
