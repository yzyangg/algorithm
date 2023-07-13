package leetcode.offer;

import java.util.Stack;

public class p036 {
}

class Solution1231234 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("-") || tokens[i].equals("+") || tokens[i].equals("*") || tokens[i].equals("/")) {
                Integer num1 = stack.pop();
                Integer num2 = stack.pop();
                int now = cacual(num2, num1, tokens[i]);
                stack.push(now);
            } else stack.push(Integer.valueOf(tokens[i]));
        }
        return stack.pop();
    }

    public int cacual(int a, int b, String s) {
        if (s.equals("-")) {
            return a - b;
        } else if (s.equals("+")) {
            return a + b;
        } else if (s.equals("*")) {
            return a * b;
        } else return a / b;
    }
}