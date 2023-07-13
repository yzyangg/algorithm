package leetcode.day13;

import java.util.ArrayList;
import java.util.List;

public class p6346 {

    class Solution {

        public int minCapability(int[] nums, int k) {
            int max = nums[0], min = nums[0];
            for (int i = 0; i < nums.length; i++) {
                max = Math.max(nums[i], max);
                min = Math.min(nums[i], min);
            }
            while (max > min) {
                int mid = (max + min) >> 1;
                if (check(nums, mid, k)) max = mid;
                else min = mid + 1;
            }
            return min;
        }

        public boolean check(int nums[], int x, int k) {
            int count = 0;
            for (int i = 0, j = -2; i < nums.length; i++) {
                //越来越小，并且可以抢夺
                if (nums[i] <= x && i - j > 1) {
                    count++;
                    j = i;
                }

            }
            return count >= k;
        }
    }
}

