package leetcode.offer;

import java.util.*;

public class p037 {
}

class Solution0987u65 {
    public int[] asteroidCollision(int[] asteroids) {

        Deque<Integer> stack = new ArrayDeque<>();
        int idx = 0;
        while (idx < asteroids.length) {
            int now = asteroids[idx];
            //栈为空
            //栈顶元素为负数(下一个为负数则一起向左，下一个为正数则分向两边)
            //当前元素为正数（栈顶为正一起向右，栈顶为负分向两边）
            if (stack.isEmpty() || stack.peek() < 0 || now > 0) {
                stack.push(now);
            } else if (stack.peek() <= -now) {
                if (stack.pop() < now) continue;
            }
            idx++;
        }
        int ans[] = new int[stack.size()];
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }
}