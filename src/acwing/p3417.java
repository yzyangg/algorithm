package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.channels.SelectionKey;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: yzy
 **/
public class p3417 {
    static int N = 110;
    static int M = 200010;
    static int[] nums = new int[N];
    static boolean[][] dp = new boolean[N][M];
    static int n;
    static int B = M / 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(s[i - 1]);
            sum += nums[i];
        }
        dp[0][B] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = -sum; j <= sum; j++) {
                dp[i][j + B] = dp[i - 1][j + B];
                if (j + nums[i] <= sum) {
                    dp[i][j + B] |= dp[i - 1][j + nums[i] + B];
                }
                if (j - nums[i] >= -sum) {
                    dp[i][j + B] |= dp[i - 1][j - nums[i] + B];
                }
            }
        }
        int cnt = 0;
        for (int i = 1; i <= sum; i++) {
            if (dp[n][i + B]) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
