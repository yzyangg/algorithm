package leetcode.day6;

import java.util.*;

public class p301 {
    public static void main(String[] args) {
        String s = "yzyayzy";
        StringBuilder sb = new StringBuilder(s);
        StringBuilder delete = sb.delete(3, 4);
        System.out.println(delete.toString());
    }
}

class Solution98 {
    Set<String> set = new HashSet<>();
    int len, maxCount, maxLen;
    String s;

    public List<String> removeInvalidParentheses(String _s) {
        s = _s;
        len = s.length();
        int left = 0, right = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') left++;
            else if (c == ')') right++;
        }
        maxCount = Math.min(left, right);
        dfs(0, "", 0);
        return new ArrayList<>(set);
    }

    public void dfs(int idx, String path, int score) {
        if (score < 0 || score > maxCount) return;
        if (idx == len) {
            if (score == 0 && path.length() >= maxLen) {
                if (path.length() > maxLen) set.clear();
                maxLen = path.length();
                set.add(path);
            }
            return;
        }
        char c = s.charAt(idx);
        if (c == '(') {
            //choose (
            dfs(idx + 1, path + c, score + 1);
            //not choose )
            dfs(idx + 1, path, score);
        } else if (c == ')') {
            dfs(idx + 1, path + c, score - 1);
            dfs(idx + 1, path, score);
        } else {
            dfs(idx + 1, path + c, score);
        }
    }


}
