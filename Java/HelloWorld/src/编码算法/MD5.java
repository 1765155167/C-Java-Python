package 编码算法;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class MD5 {
    public static void main(String[] args) throws Exception {
        MessageDigest md5Digest = MessageDigest.getInstance("MD5");
        md5Digest.update("Hello".getBytes("UTF-8"));
        md5Digest.update("World".getBytes("UTF-8"));

        MessageDigest shaDigest = MessageDigest.getInstance("SHA-1");
        shaDigest.update("Hello".getBytes("UTF-8"));
        shaDigest.update("World".getBytes("UTF-8"));

        byte[] md5Result = md5Digest.digest();//68e109f0f40ca72a15e05cc22786f8e6
        byte[] shaResult = shaDigest.digest();
//        System.out.println(Arrays.toString(md5Result));
        System.out.println(new BigInteger(1, md5Result).toString(16));
        System.out.println(new BigInteger(1, shaResult).toString(16));
    }
}
