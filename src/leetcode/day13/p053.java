package leetcode.day13;

public class p053 {

}

class Solution2134 {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        int preSum[] = new int[len];
        int minSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            if (i == 0) preSum[i] = nums[i];
            else preSum[i] = preSum[i - 1] + nums[i];
            if (preSum[i] - minSum > maxSum) {
                maxSum = preSum[i] - minSum;
            }
            if (preSum[i] < minSum) minSum = preSum[i];
        }
        return maxSum;
    }

    public int maxSubArray2(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        int preSum[] = new int[len];
        preSum[0] = nums[0];
        for (int i = 1; i < len; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
        int minPresum = 0;
        int maxSum = Integer.MIN_VALUE;
        int nowSum = 0;
        for (int i = 0; i < len; i++) {
            nowSum = preSum[i] - minPresum;
            maxSum = Math.max(nowSum, maxSum);
            minPresum = Math.min(minPresum, preSum[i]);
        }
        return maxSum;
    }
}