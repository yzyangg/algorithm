package leetcode.offer;

import java.util.ArrayDeque;
import java.util.Deque;

public class p039 {
}

class Solution32323232 {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        //遇到小的时候就开始计算
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < heights.length; i++) {
            int now = heights[i];
            while (!stack.isEmpty() && now < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = i - stack.peek();
                max = Integer.max(max, width * height);
            }
            stack.push(i);
        }
        return max;
    }

    public int largestRectangleArea2(int[] heights) {
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
