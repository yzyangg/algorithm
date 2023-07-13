package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: yzy
 **/
public class p1212 {
    static int N = 1012;
    static int dp[][] = new int[N][N];
    static int nums[][] = new int[N][N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n, m, k;
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        k = Integer.parseInt(s[2]);

        for (int i = 0; i < n; i++) {
            String[] s1 = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                nums[i][j] = Integer.parseInt(s1[j]);
            }
        }
        //初始化行
        dp[0][0] = 1;
        for (int i = 1; i < m; i++) {
            if (nums[0][i] > nums[0][i - 1]) {
                dp[0][i] = dp[0][i - 1] + 1;
            } else {
                dp[0][i] = 0;
            }
        }
        //初始化列
        for (int i = 1; i < m; i++) {
            if (nums[i][0] > nums[i - 1][0]) {
                dp[i][0] = dp[i - 1][0] + 1;
            } else {
                dp[i][0] = 0;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (nums[i][j] > nums[i - 1][j] && nums[i][j] > nums[i][j - 1]) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }
        int res = 0;
        for (int[] ints : dp) {
            for (int i = 0; i < m; i++) {
                if (ints[i] == k) {
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}