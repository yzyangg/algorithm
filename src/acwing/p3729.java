package acwing;

import java.io.*;
import java.util.Arrays;

/**
 * @author: yzy
 **/
public class p3729 {
    static int N = 200012;
    static int[] nums = new int[N];
    static int[] dif = new int[N];

    public static void add(int l, int r) {
        dif[l] += 1;
        dif[r + 1] -= 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            Arrays.fill(dif, 0);
            int n = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            for (int i = 1; i <= n; i++) {
                int j = Integer.parseInt(s[i - 1]);
                if (j == 0) {
                    continue;
                }
                if (j >= i) {
                    add(1, i);
                } else {
                    add(i - j + 1, i);
                }
            }
            for (int i = 1; i <= n; i++) {
                dif[i] += dif[i - 1];
            }
            for (int i = 1; i <= n; i++) {
                out.println((dif[i] > 0 ? 1 : 0) + " ");
            }
            out.println();
            out.flush();
            out.close();
        }

    }
}
