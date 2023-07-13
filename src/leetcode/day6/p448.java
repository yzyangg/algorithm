package leetcode.day6;

import java.util.*;

public class p448 {

}

class Solution31234 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int length = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= length; i++) {
            if (!set.contains(i)) {
                ans.add(i);
            }
        }

        return ans;
    }

    public List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int length = nums.length;
        for (int num : nums) {
            int idx = (num - 1) % length;
            nums[idx] += length;
        }
        for (int i = 0; i < length; i++) {
            if (nums[i] < length) list.add(i + 1);
        }
        return list;
    }

    public List<Integer> findDisappearedNumbers3(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i]) - 1]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) list.add(i + 1);
        }
        return list;
    }
}