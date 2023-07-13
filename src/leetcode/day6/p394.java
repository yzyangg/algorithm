package leetcode.day6;

import java.util.Stack;

public class p394 {

}

class Solution456456 {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c != ']') {
                stack.push(c);
            } else {
                //取出str
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && Character.isLetter(stack.peek())) {
                    sb.insert(0, stack.pop());
                }
                String str = sb.toString();
                //弹出'['
                stack.pop();
                //取出数字
                StringBuilder number = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    number.insert(0, stack.pop());
                }
                //转化
                int count = Integer.valueOf(number.toString());
                while (count > 0) {
                    for (char ch : str.toCharArray()) {
                        stack.push(ch);
                    }
                    count--;
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.insert(0, stack.pop());
        }
        return ans.toString();

    }
}