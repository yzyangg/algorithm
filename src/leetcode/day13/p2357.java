package leetcode.day13;

import javax.print.DocFlavor;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class p2357 {
}

class Solution111222333 {
    public long countGood(int[] nums, int k) {
        Long ans = 0L;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            int curNum = nums[right];
            map.put(curNum, map.getOrDefault(curNum, 0) + 1);
            //更新数对
            if (map.get(curNum) > 1) sum += map.get(curNum) - 1;
            while (sum >= k) {
                int leave = nums[left];
                ans += nums.length - right;//左边已找到满足好子数组的最小条件,身下的i~j+1,i~j+2都是好子数组
                if (map.get(leave) > 1) {
                    sum -= map.get(leave) - 1;
                }
                map.put(leave, map.get(leave) - 1);
                left++;
            }
        }
        return ans;
    }
}