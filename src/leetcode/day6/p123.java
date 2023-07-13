package leetcode.day6;

public class p123 {
    public static void main(String[] args) {

    }
}

class Solution231234 {
    public int maxProfit(int[] prices) {
        int dp[][] = new int[2][2];
        dp[2][0] = 0;
        dp[2][1] = -prices[0];
        dp[1][0] = 0;
        dp[1][1] = -prices[0];
        for (int i = 0; i < prices.length; i++) {
            dp[2][0] = Math.max(dp[2][0], dp[2][1] + prices[i]);
            dp[2][1] = Math.max(dp[2][1], dp[1][0] - prices[i]);
            dp[1][0] = Math.max(dp[1][0], dp[1][1] + prices[i]);
            dp[1][1] = Math.max(dp[1][1], -prices[i]);
        }
        return Math.max(dp[2][0], dp[1][0]);
    }
}
