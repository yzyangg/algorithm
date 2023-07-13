package leetcode.day6;

import java.util.Arrays;

public class p416 {

}

class Solution0988 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) return false;
        sum /= 2;
        int sum2 = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            sum2 += nums[i];
            if (sum2 == sum) return true;
        }
        return false;
    }

    public int sum(int[] nums, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += nums[i];
        }
        return sum;
    }

    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if ((sum & 1) == 1) return false;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) max = nums[i];
        }
        int target = sum /= 2;
        if (max > target) return false;
        boolean dp[][] = new boolean[nums.length][target + 1];//加1是为了让下标和值对应
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];//不选当前数 前面的数中已经可以挑选出构成j
                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }
                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - nums[i]];
                }
            }
        }
        return dp[nums.length - 1][target];
    }

    public boolean canPartition3(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if ((sum & 1) == 1) return false;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) max = nums[i];
        }
        int target = sum /= 2;
        if (max > target) return false;
        boolean dp[][] = new boolean[nums.length][target + 1];//加1是为了让下标和值对应
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int curNum = 0; curNum <= target; curNum++) {
                if (nums[i] <= curNum) {
                    dp[i][curNum] = dp[i - 1][curNum] || dp[i - 1][curNum - nums[i]];
                } else
                    dp[i][curNum] = dp[i - 1][curNum];
            }
        }
        return dp[nums.length - 1][target];
    }
}