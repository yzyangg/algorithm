package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;

/**
 * @author: yzy
 **/
public class p901 {
    static int N = 310, n, m;
    static int map[][] = new int[N][N];
    static int dp[][] = new int[N][N];

    static {
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        for (int i = 1; i <= n; i++) {
            String[] s1 = br.readLine().split(" ");
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(s1[j - 1]);
            }
        }
        int res = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                res = Math.max(res, dfs(i, j));
            }
        }
        System.out.println(res);
    }

    static int dirs[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private static int dfs(int i, int j) {
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int max = 1;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 1 && x <= n && y >= 1 && y <= m && map[i][j] > map[x][y]) {
                dp[i][j] = Math.max(dp[i][j], dfs(x, y) + 1);
                max = dp[i][j];
            }
        }
        return max;
    }
}
