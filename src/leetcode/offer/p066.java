package leetcode.offer;

public class p066 {
}

class Solution45645699 {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) return mid;
            if (nums[mid] > target) right = mid - 1;
            else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return left;
    }
}