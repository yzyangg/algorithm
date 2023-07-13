package test;

import java.lang.annotation.Target;
import java.util.*;

public class test03 {
    public static void main(String[] args) {
        Mother mother = () -> System.out.println("son");
        mother.show();
    }
}


interface Mother {
    void show();
}
class Father {
    public void show() {
        System.out.println("father");
    }
}
