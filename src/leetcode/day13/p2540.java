package leetcode.day13;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class p2540 {

}

class Solution665 {
    public int getCommon(int[] nums1, int[] nums2) {
        int idx1 = 0, idx2 = 0;
        while (idx1 < nums1.length && idx2 < nums2.length) {
            if (nums1[idx1] == nums2[idx2]) return nums1[idx1];
            else if (nums1[idx1] < nums2[idx2]) idx1++;
            else idx2++;
        }
        return -1;
    }

    public int getCommon2(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums2) {
            set.add(i);
        }

        for (int i = 0; i < nums1.length; i++) {
            if (set.contains(nums1[i])) return nums1[i];
        }
        return -1;
    }
}