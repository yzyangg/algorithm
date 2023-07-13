package leetcode.day13;

public class p6291 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.countSum(100));
    }
}

class Solution {
    public int differenceOfSum(int[] nums) {
        int sum = 0, countSum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            countSum += countSum(nums[i]);
        }
        return Math.abs(sum - countSum);
    }

    public int countSum(int num) {
        int ans = 0;
        while (num > 0) {
            ans += num % 10;
            num /= 10;
        }
        return ans;
    }
}