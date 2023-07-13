package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author: yzy
 **/
public class testCalender {
    public static void main(String[] args) throws IOException {

        System.out.println(toP(29, 16));
    }

    public static String f(int c) {
        return c >= 0 && c <= 9 ? String.valueOf(c) : String.valueOf((char) 'A' + c - 10);
    }

    public static String toP(int x, int p) {
        String res = "";
        while (x > 0) {
            res = f(x % p) + res;
            x /= p;

        }
        return res;

    }

}
