package leetcode.offer;

import java.util.ArrayList;
import java.util.List;

public class p079 {
}

class Solution344 {
    int[] nums;

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(ans, path, 0);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, List<Integer> path, int idx) {

        if (idx == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        path.add(nums[idx]);

        dfs(ans, path, idx + 1);
        path.remove(path.size() - 1);
        dfs(ans, path, idx + 1);
    }
}