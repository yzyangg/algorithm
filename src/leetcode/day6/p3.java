package leetcode.day6;

import java.util.HashMap;
import java.util.Map;

public class p3 {
    public static void main(String[] args) {
        Solution3453 solution3453 = new Solution3453();
        solution3453.lengthOfLongestSubstring("pwwkew");
    }

}

class Solution3453 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int maxLen = Integer.MIN_VALUE;
        int left = 0, right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            //重复
            while (window.get(c) > 1) {
                char leave = s.charAt(left);
                left++;
                window.put(c, window.get(leave) - 1);
            }
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }
}