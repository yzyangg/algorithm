package leetcode.day11;

import java.util.HashMap;
import java.util.Map;

public class p2283 {
}

class Solution {
    public boolean digitCount(String num) {
        Map<Integer, Integer> map = new HashMap<>();
        for (char c : num.toCharArray()) {
            int cur = c - '0';
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) - '0' != map.getOrDefault(i, 0)) return false;
        }
        return true;
    }
}
