package leetcode.day6;

public class p121 {
    public static void main(String[] args) {

    }
}

class Solution3123123 {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int dp[] = new int[prices.length];
        dp[0] = 0;
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            int val = prices[i] - min;
            val = val > 0 ? val : 0;
            dp[i] = Math.max(dp[i - 1], val);
            min = Math.min(min, prices[i]);
        }
        return dp[prices.length - 1];
    }

    public int max(int[] prices) {
        int sell = 0;
        int buy = prices[0];
        for (int i = 0; i < prices.length; i++) {
            sell = Math.max(sell, buy + prices[i]);
            buy = Math.max(buy, -prices[i]);
        }
        return sell;
    }
}
