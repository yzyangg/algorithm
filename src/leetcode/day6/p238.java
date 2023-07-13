package leetcode.day6;

public class p238 {
    public static void main(String[] args) {
        int nums[] = new int[]{1, 2, 3, 4};
        Solution3123 solution3123 = new Solution3123();
        solution3123.productExceptSelf(nums);
    }
}

class Solution3123 {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int first = 1;
        int second = 1;
        for (int i = 0; i < nums.length; i++) {
            res[i] *= first;
            first *= nums[i];
        }
        for (int i = nums.length - 1; i > 0; i--) {
            second *= nums[i];
            res[i - 1] *= second;
        }
        return res;
    }

}