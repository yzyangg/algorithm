package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: yzy
 **/
public class p798 {
    static int N = 1012;
    static int nums[][] = new int[N][N];
    static int sub[][] = new int[N][N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m, q;
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        q = Integer.parseInt(s[2]);
        for (int i = 1; i <= n; i++) {
            String[] s1 = br.readLine().split(" ");
            for (int j = 1; j <= m; j++) {
                nums[i][j] = Integer.parseInt(s1[j - 1]);
            }
        }
        while (q-- > 0) {
            String[] s2 = br.readLine().split(" ");
            int x1 = Integer.parseInt(s2[0]);
            int y1 = Integer.parseInt(s2[1]);
            int x2 = Integer.parseInt(s2[2]);
            int y2 = Integer.parseInt(s2[3]);
            int v = Integer.parseInt(s2[4]);
            add(x1, y1, x2, y2, v);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sub[i][j] += sub[i - 1][j] + sub[i][j - 1] - sub[i - 1][j - 1];
                System.out.print((sub[i][j] + nums[i][j] + " "));
            }
            System.out.println();
        }


    }

    private static void add(int x1, int y1, int x2, int y2, int v) {
        sub[x1][y1] += v;
        sub[x1][y2 + 1] -= v;
        sub[x2 + 1][y1] -= v;
        sub[x2 + 1][y2 + 1] += v;
    }


}
