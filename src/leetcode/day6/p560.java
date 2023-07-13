package leetcode.day6;

public class p560 {
}

class Solution123124 {
    int k;
    int nums[];
    int num;

    public int subarraySum(int[] nums, int k) {
        this.nums = nums;
        this.k = k;
        dfs(0, 0);
        return num;
    }

    public void dfs(int curSum, int idx) {
        if (idx > nums.length) return;
        if (curSum > k) return;
        if (curSum == k) num++;
        for (int i = 0; i < curSum; i++) {
            dfs(curSum + nums[i], i);
        }
    }

    public int subarraySum2(int[] nums, int k) {
        int count = 0;
        int length = nums.length;
        for (int left = 0; left < length; left++) {
            int sum = 0;
            for (int right = left; right < length; right++) {
                sum += nums[right];
                if (sum == k) count++;
            }
        }
        return count;
    }

    public int subarraySum3(int[] nums, int k) {
        int length = nums.length;
        int[] preSum = new int[length + 1];
        preSum[0] = 0;
        for (int i = 0; i < length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        int count = 0;
        //固定左边界
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (preSum[j + 1] - preSum[i] == k) count++;
            }
        }
        return count;
    }
}
