package JavaBase.编码算法.编码;

import org.bouncycastle.jcajce.provider.symmetric.ARC4;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Base64;

public class Base64Demo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        byte[] data = new byte[]{(byte) 0xe4, (byte) 0xb8, (byte) 0xad, (byte)0x01, (byte)0x02, (byte)0x7f, (byte)0x00};
        //编码
        String base64Coding = Base64.getEncoder().encodeToString(data);
        //withoutPadding()去除末尾的=
        String base64Coding2 = Base64.getEncoder().withoutPadding().encodeToString(data);
        //针对URl的Base64编码 只是将编码后的+变成-，/变成_
        String base64Url = Base64.getUrlEncoder().encodeToString(data);
        System.out.println(base64Coding);//5LitAQJ/AA==
        System.out.println(base64Coding2);//5LitAQJ/AA
        System.out.println(base64Url);//5LitAQJ_AA==
        //解码，末尾无=也能解码出来
        byte[] decode = Base64.getDecoder().decode(base64Coding2);
        System.out.println(Arrays.toString(decode));//[-28, -72, -83, 1, 2, 127, 0]
        //解URL格式的Base64码
        byte[] urlDecode = Base64.getUrlDecoder().decode(base64Url);
        System.out.println(Arrays.toString(urlDecode));//[-28, -72, -83, 1, 2, 127, 0]

        String encode = Base64.getEncoder().encodeToString("HelloWorld".getBytes("UTF-8"));
        System.out.println(encode);
        byte[] decoder = Base64.getDecoder().decode(encode);
        System.out.println(new String(decoder,"UTF-8"));
    }
}
