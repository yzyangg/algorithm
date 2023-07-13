package leetcode.day6;

public class p309 {
    public static void main(String[] args) {

    }
}

class Solution335465 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int len = prices.length;
        //dp[i][0] 我不持有股票，而且我啥都没干的钱
        //dp[i][1] 我持有股票，我今天买入
        //dp[i][2] 我不持有股票，我今天卖出去
        int dp[][] = new int[len][3];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        for (int i = 0; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = dp[i - 1][1] + prices[i];
        }
        return Math.max(dp[len - 1][0], dp[len - 1][2]);
    }
}
