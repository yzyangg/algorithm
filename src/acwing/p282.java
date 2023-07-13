package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: yzy
 **/
public class p282 {
    static int N = 310;
    static int preSum[] = new int[N];
    static int dp[][] = new int[N][N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");

        for (int i = 1; i <= n; i++) {
            int now = Integer.parseInt(s[i - 1]);
            preSum[i] = preSum[i - 1] + now;
        }
        for (int len = 1; len <= n; len++) {
            for (int l = 1; l + len - 1 <= n; l++) {
                int r = len + l - 1;
                dp[l][r] = Integer.MAX_VALUE;
                if (len == 1) {
                    dp[l][r] = 0;
                }
                for (int k = l; k + 1 <= r; k++) {
                    dp[l][r] = Math.min(dp[l][r], dp[l][k] + dp[k + 1][r] + preSum[r] - preSum[l - 1]);
                }
            }
        }
        System.out.println(dp[1][n]);
    }
}
