package leetcode.day6;

import java.util.HashMap;
import java.util.Map;

public class p494 {

}

class Solution3245234 {
    int nums[];
    int target;
    int count;
    Map<Integer, Integer> cache;

    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        count = 0;
        cache = new HashMap<>();
        dfs(0, 0);
        return count;
    }

    public void dfs(int curSum, int idx) {
        if (idx == nums.length) {
            count += curSum == target ? 1 : 0;
            return;
        }
        dfs(curSum - nums[idx], idx + 1);
        dfs(curSum + nums[idx], idx + 1);
        cache.put(idx, curSum);
    }
}
