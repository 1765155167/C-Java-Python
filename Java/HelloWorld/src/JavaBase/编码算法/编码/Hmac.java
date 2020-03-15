package JavaBase.编码算法.编码;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.Scanner;

public class Hmac {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        File file = new File("./res/password");
        if (!file.isFile()) {//文件不存在
            System.out.println("请输入注册的密码");
            String message = scanner.nextLine();
            file.createNewFile();
            HmacMessage hmacMessage = calculator(message);
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(buffer);
            out.writeObject(hmacMessage);
            FileOutputStream fOut = new FileOutputStream(file);
            fOut.write(buffer.toByteArray());
        } else {
            System.out.println("请输入密码");
            String message = scanner.nextLine();
            FileInputStream fIn = new FileInputStream(file);
            byte[] data = fIn.readAllBytes();
            ByteArrayInputStream buffer = new ByteArrayInputStream(data);
            ObjectInputStream in = new ObjectInputStream(buffer);
            HmacMessage hmacMessage = (HmacMessage) in.readObject();
            if (isOK(message, hmacMessage)) {
                System.out.println("密码正确!!");
            } else {
                System.out.println("密码错误!!");
            }
        }
    }

    static HmacMessage calculator(String message) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");
        SecretKey key = keyGenerator.generateKey();
        byte[] sKey = key.getEncoded();
        Mac mac = Mac.getInstance("HmacMD5");
        mac.init(key);
        mac.update(message.getBytes());
        return new HmacMessage(sKey, mac.doFinal());
    }

    static boolean isOK(String message, HmacMessage hmacMessage) throws Exception {
        SecretKey key = new SecretKeySpec(hmacMessage.getsKey(), "HmacMD5");
        Mac mac = Mac.getInstance("HmacMd5");
        mac.init(key);
        mac.update(message.getBytes());
        byte[] result = mac.doFinal();
        return hmacMessage.isOK(result);
    }
}

class HmacMessage implements Serializable {
    private byte[] sKey;//key值
    private byte[] result;//哈希值

    public HmacMessage(byte[] sKey, byte[] result) {
        this.sKey = sKey;
        this.result = result;
    }

    public boolean isOK(byte[] result) {
        if (result.length != this.result.length) {
            return false;
        }
        for (int i = 0; i < result.length; i++) {
            if (result[i] != this.result[i]) {
                return false;
            }
        }
        return true;
    }

    public byte[] getsKey() {
        return sKey;
    }

    public byte[] getResult() {
        return result;
    }
}