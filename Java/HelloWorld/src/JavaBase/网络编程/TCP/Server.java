package JavaBase.网络编程.TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(666);
        System.out.println("service is running");
        ExecutorService service = Executors.newFixedThreadPool(10);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("connect from " + socket.getRemoteSocketAddress());
            service.submit(new Handler(socket));
        }
    }
}

class Handler extends Thread {
    Socket socket;

    public Handler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (InputStream input = this.socket.getInputStream()) {
            try (OutputStream output = this.socket.getOutputStream()) {
                handle(input, output);
            }
        } catch (Exception e) {
            try {
                this.socket.close();
            } catch (IOException ioe) {
            }
            System.out.println("client disconnected.");
        }
    }

    private void handle(InputStream inputStream, OutputStream outputStream) throws IOException {
        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(outputStream,
                        StandardCharsets.UTF_8)
        );
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(inputStream,
                        StandardCharsets.UTF_8)
        );

        writer.write("Hello\n");
        writer.flush();
        while(true) {
            String s = reader.readLine();
            if (Objects.equals(s, "bye")) {
                writer.write("bye\n");
                writer.flush();
                System.out.println(socket.getRemoteSocketAddress()+"正常退出");
                break;
            }
            writer.write("ok" + s.toUpperCase() + "\n");
            writer.flush();
        }
    }
}
