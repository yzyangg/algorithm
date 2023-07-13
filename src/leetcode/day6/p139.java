package leetcode.day6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class p139 {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        Solution87 solution4343 = new Solution87();
        solution4343.wordBreak(s, list);
    }
}

class Solution4343 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int used[] = new int[s.length()];
        for (int i = 0; i < wordDict.size(); i++) {
            String str = wordDict.get(i);
            if (s.contains(str)) {
                //去找索引
                int firstIndex = s.indexOf(str);
                for (int j = firstIndex; j < firstIndex + str.length(); j++) {
                    used[j] = 1;
                }
            }
        }

        for (int i = 0; i < used.length; i++) {
            if (used[i] == 0) return false;
        }
        return true;
    }


}

class Solution87 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String substring = s.substring(j, i);
                if (dp[j] && wordDictSet.contains(substring)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
