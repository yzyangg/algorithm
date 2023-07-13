package leetcode.offer;

public class p012 {
}

class Solution87654 {
    public int pivotIndex(int[] nums) {
        int sum = 0, curSum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];
            if (sum == curSum) return i;
            curSum += nums[i];
        }
        return -1;
    }

    public int pivotIndex2(int[] nums) {
        int[] preSum = new int[nums.length + 2];
        preSum[0] = 0;
        int sum = 0;
        for (int i = 1; i <= nums.length; i++) {
            sum += nums[i - 1];
            preSum[i] += preSum[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            if (preSum[i] * 2 + nums[i] == sum) return i;
        }
        return -1;
    }

    public int pivotIndex3(int[] nums) {
        int[] preSum = new int[nums.length + 2];
        preSum[0] = 0;
        int sum = 0;
        for (int i = 1; i <= nums.length; i++) {
            sum += nums[i - 1];
            preSum[i] += preSum[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            if (preSum[i] + preSum[i + 1] == sum) return i;
        }
        return -1;
    }
}
