package leetcode.day6;

import java.util.Arrays;

public class p312 {
    public static void main(String[] args) {

    }
}

class Solution12344 {
    int cache[][];

    public int maxCoins(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        int arr[] = new int[len + 2];
        arr[0] = 1;
        arr[len + 1] = 1;
        System.arraycopy(nums, 0, arr, 1, len);
        cache = new int[len + 2][len + 2];
        for (int i = 0; i < len + 2; i++) {
            Arrays.fill(cache[i], -1);
        }
        return recursion(arr, 0, len + 1);
    }

    private int recursion(int[] arr, int left, int right) {
        if (left + 2 > right) return 0;
        else if (left + 2 == right) return arr[left] * arr[left + 1] * arr[left + 2];
        if (cache[left][right] != -1) {
            return cache[left][right];
        }
        int res = 0;
        int start = left + 1;
        while (start < right - 1) {
            int lValue = recursion(arr, left, start);
            int rValue = recursion(arr, start, right);
            res = Math.max(res, lValue + rValue + arr[start] * arr[left] * arr[right]);
        }
        cache[left][right] = res;
        return res;
    }

    public int maxCoinsS(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        int arr[] = new int[len + 2];
        arr[0] = 1;
        arr[len + 1] = 1;
        System.arraycopy(nums, 0, arr, 1, len);
        int dp[][] = new int[len + 2][len + 2];
        //从下到上
        for (int i = len; i >= 0; i--) {
            for (int j = i + 1; j < len + 2; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + arr[k] * arr[i] * arr[j]);
                }
            }
        }
        return dp[0][len + 1];
    }

}

