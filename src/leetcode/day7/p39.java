package leetcode.day7;

import java.util.ArrayList;
import java.util.List;

public class p39 {
}

class Solution5464567 {
    List<List<Integer>> ans;
    int target;
    int[] candidates;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.ans = new ArrayList<>();
        this.target = target;
        this.candidates = candidates;
        List<Integer> list = new ArrayList<>();
        dfs(list, 0, 0);
        return ans;
    }

    public void dfs(List<Integer> path, int idx, int curSum) {
        if (curSum > target || idx >= candidates.length) return;
        if (curSum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            if ((curSum + candidates[i]) > target) continue;
            path.add(candidates[i]);
            dfs(path, i, curSum + candidates[i]);
            path.remove(path.size() - 1);
        }
    }
}