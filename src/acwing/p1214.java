package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: yzy
 **/
public class p1214 {
    static int n, s, a, b, res;
    static int MOD = 100000007;
    static int N = 1012;
    static int[][] dp = new int[N][N];

    static int getMod(int a, int b) {
        return (a % b + b) % b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        n = Integer.parseInt(str[0]);
        s = Integer.parseInt(str[1]);
        a = Integer.parseInt(str[2]);
        b = Integer.parseInt(str[3]);

        dp[0][0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = (dp[i - 1][getMod(j - a * (n - i), n)] + dp[i - 1][getMod(j + b * (n - i), n)]) % MOD;
            }
        }
        //同余
        System.out.println(dp[n - 1][getMod(s, n)]);
    }

}
