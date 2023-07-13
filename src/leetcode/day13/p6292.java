package leetcode.day13;

public class p6292 {
}

class Solution456456 {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int mat[][] = new int[n][n];
        int row1 = 0, col1 = 0, row2 = 0, col2 = 0;
        for (int i = 0; i < queries.length; i++) {
            row1 = queries[i][0];
            col1 = queries[i][1];
            row2 = queries[i][2];
            col2 = queries[i][3];
            calcu(mat, row1, col1, row2, col2);
        }
        return mat;
    }

    public void calcu(int mat[][], int r1, int c1, int r2, int c2) {
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                mat[i][j]++;
            }
        }
    }
}