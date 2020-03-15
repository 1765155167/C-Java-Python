package JavaBase.编码算法.非对称加密;

import javax.crypto.Cipher;
import java.math.BigInteger;
import java.security.*;

public class RSA {
    public static void main(String[] args) throws Exception {
        String message = "Hello World";
        Person alice = new Person("Alice");
        byte[] publicKey = alice.getPublicKey();
        System.out.println("公匙" + new BigInteger(1, publicKey).toString(16));
        byte[] encrypted = alice.encrypt(message.getBytes());
        System.out.println("密文" + new BigInteger(1, encrypted).toString(16));
        byte[] privateKey = alice.getPrivateKey();
        System.out.println("私匙" + new BigInteger(1, privateKey).toString(16));
        byte[] decrypted = alice.decrypt(encrypted);
        System.out.println("明文" + new String(decrypted, "UTF-8"));
    }
}

class Person {
    private String name;
    private PrivateKey privateKey;
    private PublicKey publicKey;

    public Person(String name) throws GeneralSecurityException {
        this.name = name;
        KeyPairGenerator kpGenerator = KeyPairGenerator.getInstance("RSA");
        kpGenerator.initialize(1024);
        KeyPair keyPair = kpGenerator.generateKeyPair();
        this.publicKey = keyPair.getPublic();
        this.privateKey = keyPair.getPrivate();
    }

    public byte[] getPrivateKey() {
        return privateKey.getEncoded();
    }

    public byte[] getPublicKey() {
        return publicKey.getEncoded();
    }

    //通过公匙进行加密
    public byte[] encrypt(byte[] message) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, this.publicKey);
        return cipher.doFinal(message);
    }

    //通过私匙进行解密
    public byte[] decrypt(byte[] input) throws GeneralSecurityException {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, this.privateKey);
        return cipher.doFinal(input);
    }
}