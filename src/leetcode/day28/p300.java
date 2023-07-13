package leetcode.day28;

public class p300 {
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            int dp[] = new int[n];
            dp[0] = 1;
            int ans = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[j] + 1, dp[i]);
                    }
                }
                ans = Math.max(dp[i], ans);
            }
            return ans;
        }
    }
}
