package leetcode.day6;

import java.util.Arrays;

public class p1803 {
    public static void main(String[] args) {

    }
}

class Solution43534 {
    public int countPairs(int[] nums, int low, int high) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] ^ nums[j]) <= high && (nums[i] ^ nums[j]) >= low) count++;
            }
        }
        return count;
    }
}
