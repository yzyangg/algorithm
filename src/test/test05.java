package test;

import javax.swing.*;
import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;

public class test05 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {

            new Thread(new Station()).start();
        }
//        Station station = new Station();
//        Thread t1 = new Thread(station);
//        Thread t2 = new Thread(station);
//        Thread t3 = new Thread(station);
//        t1.setName("窗口1");
//        t2.setName("窗口2");
//        t3.setName("窗口3");
//        t1.start();
//        t2.start();
//        t3.start();
    }
}

class Station implements Runnable {
    static int account = 100;

    @Override
    public void run() {
        synchronized (Station.class) {
            while (true) {
                if (account > 0) {
                    System.out.println(Thread.currentThread().getName() + "售出，票号为" + account);
                    account--;
                    System.out.println("当前票数剩余" + account);
                } else break;
            }
        }
    }
}