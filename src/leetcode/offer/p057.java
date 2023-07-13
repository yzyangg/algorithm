package leetcode.offer;

import java.util.TreeSet;

public class p057 {
}

class Solution1234 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length == 0) return false;
        //滑窗窗口最大为k
        int left = 0, right = 0;
        int sub = 0;
        for (int i = 0; i < nums.length; i++) {
            sub = Math.abs(nums[right] - nums[left]);
            if (sub <= t) return true;
            while (right - left >= k) {
                left++;
                sub = Math.abs(nums[right] - nums[left]);
                if ((right - left) <= k && sub <= t) return true;
            }
            right++;
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        int length = nums.length;
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < length; i++) {
            int cur = nums[i];
            Long curNum = cur * 1L;
            /**
             * -ceil
             * -cur
             * -floor
             */
            Long ceiling = set.ceiling((long) cur);
            Long floor = set.floor((long) cur);
            if (ceiling != null && ceiling - curNum <= t) return true;
            if (floor != null && curNum - floor <= t) return true;
            set.add(curNum);
            if (i >= k) {
                set.remove(nums[i - k] * 1L);
            }
        }
        return false;
    }

}