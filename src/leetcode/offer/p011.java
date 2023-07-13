package leetcode.offer;

import java.util.HashMap;
import java.util.Map;

public class p011 {
}

class Solution98765 {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map0 = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                map0.put(i, map0.getOrDefault(i, 0) + 1);
                map1.put(i, map1.getOrDefault(i, 0));
            } else {
                map1.put(i, map1.getOrDefault(i, 0) + 1);
                map0.put(i, map0.getOrDefault(i, 0));
            }
        }
        return 0;
    }

    public int findMaxLength2(int[] nums) {
        int length = nums.length, ans = 0;
        int preSum[] = new int[length + 1];
        for (int i = 1; i <= length; i++) preSum[i] = preSum[i - 1] + (nums[i - 1] == 0 ? -1 : 1);
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for (int i = 1; i <= length; i++) {
            int curPreSum = preSum[i];
            if (map.containsKey(curPreSum)) {
                ans = Math.max(ans, i - map.get(curPreSum));
            }
            if (!map.containsKey(curPreSum)) {
                map.put(curPreSum, i);
            }
        }
        return ans;
    }
}