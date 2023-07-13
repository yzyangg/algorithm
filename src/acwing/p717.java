package acwing;

import java.io.*;

public class p717 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        fib(n);

    }

    public static void fib(int n) {
        int a = 0;
        int b = 1;
        int c = 1;
        while (n-- > 0) {
            System.out.print(a + " ");
            a = b;
            b = c;
            c = a + b;
        }
    }
}
