package 多线程.守护线程;

import javax.sound.midi.Soundbank;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        //建立一个守护线程定时打印当前时间
        Thread t = new Thread(()->{
            while (true) {
                System.out.println(LocalDateTime.now());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        //不标记成守护线程的话，此线程不结束，程序会一直执行
        t.setDaemon(true);//将线程标记成守护线程
        t.start();

        int n = 10;
        while (n-- > 0) {
            System.out.println("main running..");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("程序结束运行");
    }
}
