package leetcode.day13;

import com.sun.org.apache.xml.internal.dtm.ref.sax2dtm.SAX2DTM2;

public class p2356 {
}

class Solution1 {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int diff[][] = new int[n + 1][n + 1];
        for (int[] q : queries) {
            int r1 = q[0], c1 = q[1], r2 = q[2], c2 = q[3];
            ++diff[r1][c1];
            --diff[r1 + 1][c2];
            --diff[r2][c1 + 1];
            ++diff[r2 + 1][c2 + 1];
        }
        int ans[][] = new int[n][n];
        int[][] ints = PreSum(diff);
        for (int i = 1; i < ans.length; i++) {
            for (int j = 1; j < ans[0].length; j++) {
                ans[i][j] += ints[i][j];
            }
        }
        return ans;
    }

    public int[][] PreSum(int[][] arrs) {
        int preSum[][] = new int[arrs.length][arrs[0].length];
        preSum[0][0] = arrs[0][0];
        for (int i = 1; i < arrs.length; i++) preSum[i][0] += preSum[i - 1][0] + arrs[i][0];
        for (int j = 1; j < arrs[0].length; j++) preSum[0][j] += preSum[0][j - 1] + arrs[0][j];
        for (int i = 1; i < arrs.length; i++) {
            for (int j = 1; j < arrs[0].length; j++) {
                preSum[i][j] = arrs[i][j] + preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1];
            }
        }
        return preSum;
    }

}
