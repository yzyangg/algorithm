package test;

import java.io.Serializable;

public class Singleton implements Serializable {
    private Singleton() {
        if (INSTANCE != null) {
            throw new RuntimeException("单例已被创建");
        }
        System.out.println("饿汉被构造");
    }

    private static final Singleton INSTANCE = new Singleton();

    public static Singleton getInstance() {
        return INSTANCE;
    }

    public static void otherMethod() {
        System.out.println("others");
    }

    public Object readResolve() {
        return INSTANCE;
    }
}
