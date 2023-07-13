package leetcode.day6;

public class p279 {
    public static void main(String[] args) {

    }
}

class Solution3212 {
    public int numSquares(int n) {
        int dp[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            int div = (int) Math.sqrt(i);
            for (int j = 1; j <= div; j++) {
                if (i - j * j == 0) dp[i] = 1;
                else dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
