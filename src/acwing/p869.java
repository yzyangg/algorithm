package acwing;

import java.io.*;
import java.util.TreeSet;

/**
 * @author: yzy
 **/
public class p869 {
    static TreeSet set = new TreeSet();
    static int n, a;

    public static void getDivisors(int a) {
        for (int i = 1; i <= a / i; i++) {
            if (a % i == 0) {
                set.add(i);
                set.add(a / i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            set.clear();
            a = Integer.parseInt(br.readLine());
            getDivisors(a);
            for (Object o : set) {
                out.print((int) o + " ");
            }
            out.println();
            out.flush();
        }

    }
}
