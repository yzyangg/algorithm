package leetcode.offer;

import java.util.*;

public class p094 {

}

class Solution11223 {
    int ans = 0;

    public int minCut(String s) {
        int length = s.length();
        char[] charArray = s.toCharArray();
        boolean dp[][] = new boolean[length][length];
        //先填列后填行
        for (int right = 0; right < length; right++) {
            for (int left = 0; left <= right; left++) {
                if (charArray[left] == charArray[right] && (right - left <= 2 || dp[left + 1][right - 1]))
                    dp[left][right] = true;
            }
        }
        int numDp[] = new int[length];
        Arrays.fill(numDp, Integer.MAX_VALUE);
        for (int i = 0; i < length; i++) {
            if (dp[0][i]) numDp[i] = 0;
            else {
                for (int j = 0; j < i; j++) {
                    if (dp[j + 1][i]) {
                        numDp[i] = Math.min(numDp[i], numDp[j] + 1);
                    }
                }
            }
        }
        return numDp[length - 1];
    }
}