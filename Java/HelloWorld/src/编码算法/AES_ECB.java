package 编码算法;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class AES_ECB {
    public static void main(String[] args) throws Exception {
        String message = "Hello World";
        byte[] key = "0123456789abcdef".getBytes("UTF-8");//128bit/16Byte密匙
        //加密
        byte[] encrypted = encrypt(key, message.getBytes("UTF-8"));
        //编码输出
        System.out.println(Base64.getEncoder().encodeToString(encrypted));
        //解密
        byte[] decrypted = decrypt(key, encrypted);
        System.out.println(new String(decrypted,"UTF-8"));
    }
    //解密
    private static byte[] decrypt(byte[] key, byte[] encrypted) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        SecretKey keySpec = new SecretKeySpec(key, "AES");
        cipher.init(Cipher.DECRYPT_MODE, keySpec);//
        return cipher.doFinal(encrypted);
    }
    //加密
    private static byte[] encrypt(byte[] key, byte[] bytes) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        SecretKey keySpec = new SecretKeySpec(key, "AES");
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);//
        return cipher.doFinal(bytes);
    }
}
