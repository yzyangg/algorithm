package leetcode.day6;

public class p4 {
    public static void main(String[] args) {

    }
}

class Solution {
    public static void main(String[] args) {
        int[] ints1 = {1, 2};
        int[] ints2 = {3, 4};
        System.out.println(findMedianSortedArrays(ints1, ints2));

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        int left = 0, right = 0;
        int aS = 0, bS = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (aS < m && (nums1[aS] <= nums2[bS] || bS >= m)) right = nums1[aS++];
            else right = nums2[bS++];
        }
        if ((len & 1) == 0) {
            return (left + right) / 2.0;
        }

        return right;
    }
}
