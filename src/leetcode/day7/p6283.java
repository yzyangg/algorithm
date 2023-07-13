package leetcode.day7;

public class p6283 {
}

class Solution324234 {
    public int maximumCount(int[] nums) {
        int num1 = 0, num2 = 0;
        for (int num : nums) {
            if (num < 0) num1++;
            else if (num > 0) num2++;
        }
        return Math.max(num2, num1);
    }
}
