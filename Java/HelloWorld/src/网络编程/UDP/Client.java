package 网络编程.UDP;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Client {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        socket.setSoTimeout(1000);//设定超时1秒，意思是后续接收UDP包时，等待时间最多不会超过1秒
        //连接服务器
        socket.connect(InetAddress.getByName("localhost"), 6666);
        byte[] data = "Hello".getBytes(StandardCharsets.UTF_8);
        DatagramPacket packet = new DatagramPacket(data, data.length);
        socket.send(packet);
        byte[] buffer = new byte[1024];
        packet = new DatagramPacket(buffer, buffer.length);
        socket.receive(packet);
        String res = new String(packet.getData(), packet.getOffset(), packet.getLength());
        System.out.println("receive" + res);
        socket.disconnect();
    }
}
