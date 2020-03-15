package JavaBase.编码算法.密匙交换;

import javax.crypto.KeyAgreement;
import java.math.BigInteger;
import java.security.*;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;

public class DH {
    public static void main(String[] args) {
        Person bob = new Person("Bob");
        Person alice = new Person("Alice");
        //各自生成自己的公匙和私匙
        bob.generateKeyPair();
        alice.generateKeyPair();
        //根据对方的公匙生成自己的密匙
        bob.generateSecretKey(alice.publicKey.getEncoded());
        alice.generateSecretKey(bob.publicKey.getEncoded());
        //打印双方密匙，看看是否相同
        System.out.println(bob.toString());
        System.out.println(alice.toString());
    }
}
class Person {
    public final String name;

    public PublicKey publicKey;//公匙
    private PrivateKey privateKey;//私匙
    private byte[] secretKey;//密匙

    public Person(String name) {
        this.name = name;
    }

    //生成Key Pair
    public void generateKeyPair() {
        try {
            KeyPairGenerator kpGen = KeyPairGenerator.getInstance("DH");
            kpGen.initialize(512);
            KeyPair keyPair = kpGen.generateKeyPair();
            this.privateKey = keyPair.getPrivate();
            this.publicKey = keyPair.getPublic();
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
    }
    //生成密匙
    public void generateSecretKey(byte[] receivedPubKeyBytes) {
        try {
            //从byte[]恢复PublicKey
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(receivedPubKeyBytes);
            KeyFactory factory = KeyFactory.getInstance("DH");
            PublicKey receivedPublicKey = factory.generatePublic(keySpec);
            //生成本地密匙
            KeyAgreement keyAgreement = KeyAgreement.getInstance("DH");
            keyAgreement.init(this.privateKey);
            keyAgreement.doPhase(receivedPublicKey, true);
            //生成SecretKey
            this.secretKey = keyAgreement.generateSecret();
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", publicKey=" + new BigInteger(1, this.publicKey.getEncoded()) +
                ", privateKey=" + new BigInteger(1, this.privateKey.getEncoded()) +
                ", secretKey=" + Arrays.toString(secretKey) +
                '}';
    }
}
