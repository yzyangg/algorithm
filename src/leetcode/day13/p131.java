package leetcode.day13;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Stream;

public class p131 {
}

class Solution222122 {
    public List<List<String>> partition(String s) {
        int length = s.length();
        List<List<String>> res = new ArrayList<>();
        if (length == 0) return res;
        char[] charArray = s.toCharArray();
        boolean dp[][] = new boolean[length][length];
        //先填列后填行
        for (int right = 0; right < length; right++) {
            for (int left = 0; left <= right; left++) {
                if (charArray[left] == charArray[right] && (right - left <= 2 || dp[left + 1][right - 1]))
                    dp[left][right] = true;
            }
        }
        Deque<String> stack = new ArrayDeque<>();
        dfs(s, 0, length, dp, stack, res);
        return res;
    }

    public void dfs(String s, int idx, int len, boolean dp[][], Deque<String> path, List<List<String>> res) {
        if (idx == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx; i < len; i++) {
            if (dp[idx][i]) {
                path.addLast(s.substring(idx, i + 1));
                dfs(s, idx + 1, len, dp, path, res);
                path.removeLast();
            }
        }

    }
}