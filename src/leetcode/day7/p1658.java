package leetcode.day7;

public class p1658 {
    public static void main(String[] args) {
        Solution234234 solution234234 = new Solution234234();
        int arr[] = {1, 1, 4, 2, 3};
        solution234234.minOperations3(arr, 5);
    }
}

class Solution234234 {
    int[] nums;
    int mincount = Integer.MAX_VALUE;

    public int minOperations(int[] nums, int x) {
        this.nums = nums;
        if (nums[0] > x && nums[nums.length - 1] > x) return -1;
        int left = 0, right = nums.length - 1;
        dfs(0, nums.length - 1, x, 0);
        return mincount;
    }

    public void dfs(int left, int right, int target, int count) {
        if (left > right) return;
        if (target < 0) return;
        if (target == 0) {
            mincount = Math.min(count, mincount);
        }
        dfs(left + 1, right, target - nums[left], count++);
        dfs(left, right - 1, target - nums[right], count++);
    }

    public int minOperations2(int[] nums, int x) {
        int target = -x;
        for (int num : nums) {
            target += num;
        }
        int length = nums.length;
        int left = 0, right = 0, maxLen = -1, sum = 0;
        while (right < length) {
            sum += nums[right++];
            while (left < right && sum > target) {
                sum -= nums[left++];
            }
            if (sum == target) {
                maxLen = Math.max(maxLen, right - left);
            }
        }
        return maxLen < 0 ? -1 : nums.length - maxLen;
    }

    public int minOperations3(int[] nums, int x) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int[] preSumArr = preSumArr(nums);
        int maxLen = -1;
        int length = nums.length;
        for (int left = 0; left < nums.length; left++) {
            for (int right = left; right <= nums.length; right++) {
                int curSum = preSumArr[right] - preSumArr[left];
                if (sum - curSum == x) {
                    maxLen = Math.max(maxLen, right - left);
                }
            }
        }
        return maxLen < 0 ? -1 : length - maxLen;
    }

    public int[] preSumArr(int[] arr) {
        int preSum[] = new int[arr.length];
        preSum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            preSum[i] += preSum[i - 1] + arr[i];
        }
        int trueArr[] = new int[arr.length + 1];
        System.arraycopy(preSum, 0, trueArr, 1, preSum.length);
        return trueArr;
    }

    public int minOperations4(int[] nums, int x) {
        int target = -x;
        for (int num : nums) {
            target += num;
        }
        int left = 0, sum = 0, maxLen = -1;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (right > left && sum > target) {
                sum -= nums[left++];
            }
            if (sum == target) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
        return maxLen < 0 ? -1 : nums.length - maxLen;
    }
}