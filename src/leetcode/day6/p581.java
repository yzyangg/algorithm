package leetcode.day6;

import java.util.Arrays;

public class p581 {
    public static void main(String[] args) {

    }
}

class Solution345346 {
    public int findUnsortedSubarray(int[] nums) {
        int maxlen = Integer.MIN_VALUE;
        int left = -1;
        int right = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                if (left == -1) {
                    left = i - 1;
                } else {
                    right = i;
                }
            }
        }
        System.out.println(left);
        System.out.println(right);
        return (right - left + 1) == -1 ? 0 : right - left + 1;
    }

    public int find(int[] nums) {
        int len = nums.length;
        int min = nums[len - 1];
        int max = nums[0];
        int begin = -1;
        int end = -1;
        for (int i = 0; i < len; i++) {
            //最大不升序
            if (max > nums[i]) {
                end = i;
            } else max = nums[i];
            //最小不降序
            if (min < nums[len - i - 1]) {
                begin = len - i - 1;
            } else {
                min = nums[len - i - 1];
            }
        }
        System.out.println(begin);
        System.out.println(end);
        return begin == -1 ? 0 : end - begin + 1;
    }

    public int find2(int[] nums) {
        int len = nums.length;
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int begin = 0, end = len - 1;
        while (begin < end && nums[begin] == arr[begin]) begin++;
        while (begin < end && nums[end] == arr[end]) end--;
        return end - begin + 1;
    }
}