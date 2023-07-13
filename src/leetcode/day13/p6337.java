package leetcode.day13;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class p6337 {
}

class Solutio123123n {
    public int distinctIntegers(int n) {
        Set<Integer> set = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.add(n);
        set.add(n);
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            for (int i = 1; i <= n; i++) {
                if (pop % i == 1) {
                    stack.add(i);
                    set.add(i);
                }
            }
        }
        return set.size();
    }

}