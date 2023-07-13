package test;

public class test04 {
    public static void main(String[] args) {
        //匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("meao!");
            }
        }).start();
        //基于接口的内部类
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };
    }
}

class Car implements Runnable {

    @Override
    public void run() {
        System.out.println("Running!");
    }
}

class Dog extends Thread {
    @Override
    public void run() {
        System.out.println("wolf!");
    }
}
