package test;

public class Singleton3 {
    public Singleton3() {
        System.out.println("单例被构造了");
    }

    /**
     * 内部类没有被调用时不会初始化的
     */
    private static class Holder {
        static Singleton3 INSTANCE = new Singleton3();
    }

    public static Singleton3 getInstance() {
        return Holder.INSTANCE;
    }

    public static void otherMethod() {
        System.out.println("otherMethod");
    }
}
