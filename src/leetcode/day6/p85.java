package leetcode.day6;

import java.util.ArrayDeque;
import java.util.Deque;

public class p85 {
    public static void main(String[] args) {

    }
}

class Solution3 {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = Integer.MIN_VALUE;
        //层
        int heights[] = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') heights[j] += 1;
                else {
                    heights[j] = 0;
                }
            }
            int cur = largestRectangleArea(heights);
            max = Math.max(cur, max);
        }
        return max;

    }

    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int temp[] = new int[heights.length + 2];

        System.arraycopy(heights, 0, temp, 1, heights.length);
        int ans = 0;
        for (int i = 0; i < temp.length; i++) {
            while (!stack.isEmpty() && temp[i] < temp[stack.peek()]) {
                int h = temp[stack.pop()];
                int w = i - stack.peek() - 1;
                ans = Math.max(ans, h * w);
            }
            stack.push(i);
        }
        return ans;
    }

    public int localOne(char[][] matrix, int i, int j) {
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = 0;
        //列扩张
        int column = 0;
        while (j < n) {
            if (matrix[i][j] == '1') column++;
            else break;
            j++;
        }
        //行扩张
        int line = 0;
        int count = 0;
        boolean flag = false;
        while (i < m) {
            for (int k = 0; k < column; k++) {
                if (matrix[i][k] == '1') {
                    count++;
                } else {
                    flag = true;
                    break;
                }
            }
            if (count == column) {
                line++;
            }
            if (flag) break;
            count = 0;
            i++;
        }
        return line * column;
    }
}