package leetcode.day6;

import java.util.HashMap;
import java.util.Map;

public class p2351 {
    public static void main(String[] args) {

    }
}

class Solution3232 {
    public char repeatedCharacter(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            if (map.get(s.charAt(i)) > 1) return s.charAt(i);
        }
        return 's';
    }

    public char repeatedCharacter2(String s) {
        int mask = 0;
        for (char c : s.toCharArray()) {
            int t = 1 << (c - 'a');
            if ((mask & t) != 0) return c;
            mask |= t;
        }
        return 0;
    }
}