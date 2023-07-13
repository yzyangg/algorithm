package leetcode.day13;

import java.util.Arrays;

public class p2541 {
}

class Solution80999 {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        if (getSum(nums1) != getSum(nums2)) return -1;
        if (Arrays.equals(nums1, nums2)) return 0;
        if (k == 0) return -1;
        long subSum = 0L;
        for (int i = 0; i < nums1.length; i++) {
            int curSub = Math.abs(nums1[i] - nums2[i]);
            if (curSub % k != 0) return -1;
            subSum += curSub;

        }
        if (subSum == 0) return 0;
        if (subSum % (2 * k) != 0) return -1;
        return subSum / (2 * k);
    }

    public int getSum(int nums[]) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

}