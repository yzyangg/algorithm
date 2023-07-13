package acwing;

import java.io.*;

/**
 * @author: yzy
 **/
public class p3491 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        long n = Long.parseLong(br.readLine());
        long ans = 1;
        for (int i = 2; i <= n / i; i++) {
            if (n % i == 0) {
                int s = 0;
                while (n % i == 0) {
                    s++;
                    n /= i;
                }
                if (s % 2 != 0) {
                    ans *= i;
                }
            }
        }
        if (n > 1) {
            ans *= n;
        }
        out.println(ans);
        out.flush();
    }
}
