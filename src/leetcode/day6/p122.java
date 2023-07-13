package leetcode.day6;

public class p122 {
    public static void main(String[] args) {

    }
}

class Solution123234 {
    public int maxProfit(int[] prices) {
        int dp[] = new int[prices.length];
        int pre = prices[0];
        dp[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            int val = prices[i] - pre > 0 ? prices[i] - pre : 0;
            dp[i] = dp[i - 1] + val;
            pre = prices[i];
        }
        return dp[prices.length - 1];
    }

    public int maxPro(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) ans += prices[i] - prices[i - 1];
        }
        return ans;
    }

    public int max(int[] prices) {
        int len = prices.length;
        int dp[][] = new int[len][2];
        dp[0][0] = 0;//0天不持有
        dp[0][1] = -prices[0];//0天买入
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }

    public int proMax(int[] prices) {
        int len = prices.length;
        int sell = 0;
        int buy = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            sell = Math.max(sell, buy + prices[i]);
            buy = Math.max(buy, sell - prices[i]);
        }
        return sell;
    }
}