package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: yzy
 **/
public class p4942 {
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        if (check(n, m)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static boolean check(int n, int m) {
        while (m > 0) {
            //最后那个数的
            int r = m % n;
            if (r != 0 || r != 1 || r != n - 1) {
                return false;
            }
            if (r > 1) {
                r = -1;
            }
            m -= r;
            m = m / n;
        }
        return true;
    }

}
