package acwing;

import com.sun.java.swing.plaf.windows.WindowsInternalFrameTitlePane;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author: yzy
 **/
public class p4405 {
    static int N = 520;
    static long[][] preSum = new long[N][N];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int n, m, k;
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        k = Integer.parseInt(s[2]);
        long cnt = 0;
        long now = 0;
        for (int i = 1; i <= n; i++) {
            String[] s1 = br.readLine().split(" ");
            for (int j = 1; j <= m; j++) {
                now = Integer.parseInt(s1[j - 1]);
                preSum[i][j] = preSum[i - 1][j] + now;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int l = 1, r = 1, sum = 0; r <= m; r++) {
                    sum += preSum[j][r] - preSum[i - 1][r];
                    while (sum > k) {
                        sum -= preSum[j][l] - preSum[i - 1][l];
                        l++;
                    }
                    cnt += r - l + 1;
                }
            }
        }

        out.println(cnt);
        out.flush();
    }
}
