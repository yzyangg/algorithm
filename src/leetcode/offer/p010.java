package leetcode.offer;

import java.util.HashMap;
import java.util.Map;

public class p010 {
}

class Solution123566 {


    public int subarraySum(int[] nums, int k) {
        int preSum[] = new int[nums.length + 1];
        preSum[0] = 0;
        int count = 0;
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < preSum.length; i++) {
            for (int j = 0; j < preSum.length; j++) {
                if (preSum[j] - preSum[i] == k) count++;
            }
        }
        return count;
    }

    public int subarraySum2(int[] nums, int k) {
        int preSum = 0, ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            preSum += num;
            if (map.containsKey(preSum - k)) {
                ans += map.getOrDefault(preSum, 0);
            }
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return ans;
    }
}