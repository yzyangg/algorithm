package leetcode.offer;

import java.util.ArrayDeque;
import java.util.Deque;

public class p038 {
}

class Solution09090 {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int ans[] = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int now = temperatures[i];
            if (stack.isEmpty() || now > stack.peek()) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }
}