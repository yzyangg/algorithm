package leetcode.day13;

import org.omg.CORBA.OMGVMCID;

import java.util.HashMap;
import java.util.Map;

public class p6293 {
}


class Solution89898 {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> window = new HashMap<>();
        //合法数对
        int valid = 0;
        int ans = 0;
        int left = 0, right = 0;
        int len = 0;
        while (right < nums.length) {
            int rNum = nums[right];
            window.put(rNum, window.getOrDefault(rNum, 0) + 1);
            len++;
            if (window.get(rNum) >= 2) valid++;
            if (valid >= k) ans++;

            right++;
        }
        return ans;
    }
}