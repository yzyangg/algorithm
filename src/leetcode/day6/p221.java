package leetcode.day6;

import java.util.ArrayDeque;
import java.util.Deque;

public class p221 {
    public static void main(String[] args) {

    }
}

class Solution32122 {
    public int maximalSquare(char[][] matrix) {
        int intMatrix[][] = new int[matrix.length][matrix[0].length];
        //copy
        int ans = 0;
        int heights[] = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') heights[j]++;
                else heights[j] = 0;
            }
            ans = Math.max(ans, LargestArea(heights));
        }
//        int heights[] = new int[matrix[0].length];
//        for (int i = 0; i < intMatrix.length; i++) {
//            for (int j = 0; j < intMatrix[0].length; j++) {
//                if (intMatrix[i][j] == 1) heights[j]++;
//                else heights[j] = 0;
//            }
//            ans = Math.max(ans, LargestArea(heights));
//        }
        return ans;
    }

    public int LargestArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int temp[] = new int[heights.length + 2];
        int ans = 0;
        System.arraycopy(heights, 0, temp, 1, heights.length);
        for (int i = 0; i < temp.length; i++) {
            while (!stack.isEmpty() && temp[i] < temp[stack.peek()]) {
                int height = temp[stack.pop()];
                int weight = i - stack.peek() - 1;
                if (height == weight) {
                    ans = Math.max(ans, height * weight);
                }
            }
        }
        return ans;
    }

    public int max(char[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return 0;
        int height = matrix.length;
        int weight = matrix[0].length;
        int maxSide = 0;
        int dp[][] = new int[height + 1][weight + 1];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < weight; j++) {
                if (matrix[i][j] == '1') {
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i + 1][j], dp[i][j + 1]), dp[i][j]) + 1;
                    maxSide = Math.max(maxSide, dp[i + 1][j + 1]);
                }
            }
        }
        return maxSide * maxSide;
    }
}
