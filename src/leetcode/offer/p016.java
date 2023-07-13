package leetcode.offer;

import java.util.HashMap;
import java.util.Map;

public class p016 {
}

class Solution76543 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int window[] = new int[26];
        int right = 0, left = 0, maxLen = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            window[c - 'a']++;
            while (left < right && window[c - 'a'] > 1) {
                window[s.charAt(left) - 'a']--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s.length() == 0) return 0;
        Map<Character, Integer> window = new HashMap<>();
        int right = 0, left = 0, maxLen = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);
            while (left < right && window.get(c) > 1) {
                char leave = s.charAt(left);
                window.put(leave, window.get(leave) - 1);
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }

    public int lengthOfLongestSubstring3(String s) {
        if (s.length() == 0) return 0;
        int right, left = 0, maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}