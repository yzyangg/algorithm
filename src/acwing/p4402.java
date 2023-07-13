package acwing;

import java.io.*;
import java.util.Scanner;

/**
 * @author: yzy
 **/
public class p4402 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        long a, b, n;
        a = Long.parseLong(s[0]);
        b = Long.parseLong(s[1]);
        n = Long.parseLong(s[2]);
        long aweek = 5 * a + 2 * b;
        long weeks = n / aweek;
        long left = n - (aweek * weeks);
        int idx = 1;
        while (left > 0) {
            if (idx <= 5) {
                left -= a;
            } else {
                left -= b;
            }
            idx++;
        }
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        out.println(weeks * 7 + idx - 1);
        out.flush();

    }
}
