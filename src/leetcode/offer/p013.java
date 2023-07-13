package leetcode.offer;

public class p013 {
}

class NumMatrix {
    int cowPreSum[][];

    public NumMatrix(int[][] matrix) {
        int length = matrix.length;
        if (length > 0) {
            int cowlen = matrix[0].length;
            cowPreSum = new int[length][cowlen + 1];
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < cowlen; j++) {
                    cowPreSum[i][j + 1] = cowPreSum[i][j] + matrix[i][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = 0;
        for (int i = row1; i <= row2; i++) {
            ans += cowPreSum[i][col2 + 1] - cowPreSum[i][col1];
        }
        return ans;
    }
}