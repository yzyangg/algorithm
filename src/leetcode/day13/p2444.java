package leetcode.day13;

import com.sun.org.apache.xerces.internal.impl.dv.xs.AnyURIDV;

import java.util.HashMap;
import java.util.Map;

public class p2444 {
}

class Solution113 {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        Map<Integer, Integer> need = new HashMap<>();
        need.put(minK, 1);
        need.put(maxK, 1);
        Map<Integer, Integer> window = new HashMap<>();
        int left = 0, right = 0, valid = 0;
        while (right < nums.length) {
            int rNum = nums[right];
            right++;
            window.put(rNum, window.getOrDefault(rNum, 0));
            while (left < right && window.containsKey(maxK) && window.containsKey(minK)) {
                valid++;
                int leave = nums[left];
                window.put(leave, window.get(leave) - 1);
                if (window.get(leave) == 0) window.remove(leave);
                left++;
            }
        }
        return valid;
    }

    public long countSubarrays2(int[] nums, int minK, int maxK) {
        long ans = 0L;
        int minI = -1, maxI = -1, wall = -1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == minK) minI = i;
            if (num == maxK) maxI = i;
            if (num < minK || num > maxK) wall = i;
            ans += Math.max(Math.min(minI, maxI) - wall, 0);
        }
        return ans;
    }
}