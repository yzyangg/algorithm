package leetcode.day6;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class p84 {
    public static void main(String[] args) {
        Solution322 solution32 = new Solution322();
        System.out.println(solution32.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }
}

class Solution32 {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < heights.length; i++) {
            if (stack.isEmpty()) stack.push(i);
            if (heights[i] < heights[stack.peek()]) {
                int width = i - stack.peek() + 1;
                int height = heights[stack.peek()];
                ans = width * height;
                while (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            stack.push(i);
        }
        return ans;
    }
}

class Solution322 {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int temp[] = new int[heights.length + 2];

        System.arraycopy(heights, 0, temp, 1, heights.length);
        int ans = 0;
        for (int i = 0; i < temp.length; i++) {
            while (!stack.isEmpty() && temp[i] < temp[stack.peek()]) {
                int h = heights[stack.pop()];
                int w = i - stack.peek() - 1;
                ans = Math.max(ans, h * w);
            }
            stack.push(i);
        }
        return ans;
    }

}
