package leetcode.offer;

public class p008 {
    public static void main(String[] args) {
        Solution123124 solution123124 = new Solution123124();
        solution123124.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
    }
}

class Solution123124 {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 1 && (nums[0] != target)) return 0;
        int minLen = Integer.MAX_VALUE, left = 0, right = 0, curSum = 0;
        while (right < nums.length) {
            System.out.println(curSum);
            curSum += nums[right];
            while (left < right && curSum > target) {
                curSum -= nums[left];
                left++;
            }
            if (target == curSum) {
                minLen = Math.min(minLen, right - left);
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
