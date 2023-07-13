package test;

public class testVolatile {
    static Integer a;
    static Boolean flag;

    public static void writer() {
        a = 1;
        flag = true;
    }

    public static void reader() {
        if (flag != null && flag) {
            System.out.println(a);
            a = 0;
            flag = null;
        }
    }

    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                writer();
            }
        }).start();
        new Thread(() -> {
            while (true) {
                reader();
            }
        }).start();
    }
}
