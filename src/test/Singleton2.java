package test;

import java.util.Stack;

public class Singleton2 {
    private Singleton2() {
        System.out.println("单例已被创建");
    }

    private static volatile Singleton2 INSTANCE = null;

    /**
     * 会有多线程并发问题，所以加锁，但存在一个效率问题，即使单例被创建后，再去获取单例仍然需要排队
     *
     * @return
     */
    public static synchronized Singleton2 getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton2.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton2();
                }
            }
        }
        return INSTANCE;
    }
}
