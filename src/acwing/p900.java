package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: yzy
 **/
public class p900 {
    static int N = (int) (1e3 + 7);
    static int mod = (int) (1e9 + 7);

    static int dp[][] = new int[N][N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - i >= 0) {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - i]) % mod;
                }
            }
        }
        System.out.println(dp[n][n]);
    }
}
