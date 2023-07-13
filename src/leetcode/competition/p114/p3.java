package leetcode.competition.p114;

import java.util.Arrays;

/**
 * @author yzy
 * @version 1.0
 * @description TODO
 * @date 2023/5/14 9:48
 */
public class p3 {
    class Solution {
        public long maximumOr(int[] nums, int k) {
            int n = nums.length;
            int suf[] = new int[n + 1];
            for (int i = n - 1; i > 0; i--) {
                suf[i] = suf[i + 1] | nums[i];
            }
            long ans = 0;
            int pre = 0;
            for (int i = 0; i < n; i++) {
                ans = Math.max(ans, pre | (long) nums[i] << k | suf[i + 1]);
                pre |= nums[i];
            }
            return ans;
        }
    }
}

