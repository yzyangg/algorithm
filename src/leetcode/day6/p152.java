package leetcode.day6;

public class p152 {
    public static void main(String[] args) {

    }
}

class Solution3213 {
    public int maxProduct(int[] nums) {
        int dp[] = new int[nums.length];
        int max = Integer.MIN_VALUE;
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                dp[i] = 0;
            }
            dp[i] = dp[i - 1] * nums[i];
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public int maxProduct2(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);
            max = Math.max(max, imax);
        }
        return max;
    }
}
