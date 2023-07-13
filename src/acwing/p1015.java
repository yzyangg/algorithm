package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: yzy
 **/
public class p1015 {
    static int N = 1012;
    static int[][] nums = new int[N][N];
    static int[][] dp = new int[N][N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int n, m;
        while (T-- > 0) {
            String[] s = br.readLine().split(" ");
            n = Integer.parseInt(s[0]);
            m = Integer.parseInt(s[1]);
            for (int i = 1; i <= n; i++) {
                String[] s1 = br.readLine().split(" ");
                for (int j = 1; j <= m; j++) {
                    nums[i][j] = Integer.parseInt(s1[j - 1]);
                }
            }
            dp[1][1] = nums[1][1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (i == 1 && j == 1) {
                        continue;
                    }
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + nums[i][j];
                }
            }
            System.out.println(dp[n][m]);
        }
    }
}
