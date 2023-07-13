package leetcode.day6;

import java.util.HashMap;
import java.util.Map;

public class p567 {
}

class Solution235235 {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0, valid = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                //窗口中有一个字符瓷瓶合法了
                if (window.get(c).equals(need.get(c))) valid++;
            }
            while (right - left == s1.length()) {
                if (valid == need.size()) return true;
                char leave = s2.charAt(left);
                left++;
                if (need.containsKey(leave)) {
                    //删除左端点导致合法的失效了一个
                    if (window.get(leave).equals(need.get(leave))) valid--;
                    window.put(leave, window.get(leave) - 1);
                }
            }
        }
        return false;
    }
}
