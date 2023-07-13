package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class p2067 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int dp[][] = new int[n][m];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if ((i + 1) % 2 == 0 && (j + 1) % 2 == 0) dp[i][j] = 0;
                else dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        System.out.println(dp[n-1][m-1]);
    }
}
