package leetcode.offer;

import java.util.ArrayDeque;
import java.util.Deque;

public class p040 {
}

class Solution334343434c {
    public int maximalRectangle(String[] matrix) {
        if (matrix.length == 0) return 0;
        int height[] = new int[matrix[0].length()];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length(); j++) {
                if (matrix[i].charAt(j) == '1') height[j]++;
                else height[j] = 0;
            }
            int ans = largestRectangleArea(height);
            max = Math.max(ans, max);
        }
        return max;
    }

    public int largestRectangleArea(int[] heights) {
        int max = 0;
        //遇到小的时候就开始计算
        int temp[] = new int[heights.length + 2];
        System.arraycopy(heights, 0, temp, 1, heights.length);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < temp.length; i++) {
            int now = temp[i];
            while (!stack.isEmpty() && now < temp[stack.peek()]) {
                int height = temp[stack.pop()];
                int width = i - stack.peek() - 1;
                max = Integer.max(max, width * height);
            }
            stack.push(i);
        }
        return max;
    }
}
