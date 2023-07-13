package leetcode.offer;

import java.util.HashMap;
import java.util.Map;

public class p017 {
}

class Solution456456 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0, valid = 0, minlen = Integer.MAX_VALUE;
        int start = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);
            if (window.get(c).equals(need.get(c))) valid++;
            //更新窗口
            while (left <= right && valid == need.size()) {
                if (right - left + 1 < minlen) {
                    minlen = right - left + 1;
                    start = left;
                }
                char leave = s.charAt(left);
                left++;
                if (window.get(leave).equals(need.get(leave))) valid--;
                window.put(leave, window.get(leave) - 1);
            }
            right++;
        }
        return minlen == Integer.MAX_VALUE ? "" : s.substring(start, start + minlen);
    }

}