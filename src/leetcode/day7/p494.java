package leetcode.day7;

import java.util.Map;

public class p494 {
}

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, target, 0, 0);
    }

    public int dfs(int[] nums, int target, int idx, int curSum) {
        if (idx == nums.length) {
            return curSum == target ? 1 : 0;
        }
        int left = dfs(nums, target, idx + 1, curSum - nums[idx]);
        int right = dfs(nums, target, idx + 1, curSum + nums[idx]);
        return left + right;
    }

    public int findTargetSumWays2(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < Math.abs(target)) return 0;
        if ((target + sum) % 2 == 1) return 0;
        int bagSize = (target + sum) / 2;
        if (bagSize < 0) bagSize = -bagSize;
        int[] dp = new int[bagSize + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = bagSize; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[bagSize];
    }
}