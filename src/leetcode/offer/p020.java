package leetcode.offer;

public class p020 {
}

class Solution765437 {
    public int countSubstrings(String s) {
        int length = s.length();
        boolean dp[][] = new boolean[length][length];
        int ans = 0;
        for (int j = 0; j < length; j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    ans++;
                }
            }
        }
        return ans;
    }

    public int countSubstrings3(String s) {
        int ans = 0;
        for (int i = 0; i < 2 * s.length() - 1; i++) {
            int left = i / 2;
            int right = left + i % 2;
            while (left >= 0 && right < s.length() && s.charAt(right) == s.charAt(left)) {
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }
}
