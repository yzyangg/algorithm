package leetcode.day6;

import java.util.Arrays;

public class p287 {
    public static void main(String[] args) {

    }
}

class Solution2222 {
    public int findDuplicate(int[] nums) {
        int fast = 0, slow = 0;
        while (true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if (fast == slow) break;
        }
        int finder = 0;
        while (true) {
            finder = nums[finder];
            slow = nums[slow];
            if (slow == finder) break;
        }
        return slow;
    }

    public int find(int[] nums) {
        Arrays.sort(nums);
        int pre = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (pre == nums[i]) return nums[i];
        }
        return 0;
    }

    public int findByB(int[] nums) {
        int len = nums.length;
        int left = 1, right = len - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }
            if (count > mid) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}
