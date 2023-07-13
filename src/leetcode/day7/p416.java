package leetcode.day7;

import com.sun.org.apache.xerces.internal.dom.AbortException;

public class p416 {
}

class Solution5435 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) return false;
        int target = sum / 2;
        int dp[] = new int[target + 1];
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                //滚动数组只有一层，外循环不断更新该层
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[target] == target;
    }

    public boolean cnaPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) return false;
        int target = sum / 2;
        int length = nums.length;
        boolean dp[][] = new boolean[length][target + 1];
        //dp[i][j]代表0~i能刚好凑齐j
        //第一行只有下面那种情况能满足
        if (nums[0] <= target) dp[0][nums[0]] = true;
        //第一列代表容量为0时 所以全都为false
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }
                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[length - 1][target];
    }
}