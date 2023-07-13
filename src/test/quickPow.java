package test;

import java.io.*;

/**
 * @author: yzy
 **/
public class quickPow {
    public static void main(String[] args) throws IOException {
        while (true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] s = br.readLine().split(" ");
            int a, b;
            a = Integer.parseInt(s[0]);
            b = Integer.parseInt(s[1]);
            PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
            int res = 1;
            while (b > 0) {
                if ((b & 1) == 1) {
                    res *= a;
                }
                a *= a;
                b >>= 1;
            }

            out.println(res);
            out.flush();

        }
    }
}
