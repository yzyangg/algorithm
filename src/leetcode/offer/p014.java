package leetcode.offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class p014 {
}

class Solution21314 {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0, valid = 0;
        int length = s2.length();
        while (right < length) {
            char c = s2.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);
            if (window.get(c).equals(need.get(c))) valid++;
            while (left < right && (!need.containsKey(s2.charAt(left)) || right - left + 1 == s1.length())) {
                if (valid == need.size()) return true;
                char leave = s2.charAt(left);
                left++;
                if (window.get(leave).equals(need.get(leave))) valid--;
                window.put(leave, window.get(leave) - 1);
            }
            right++;
        }
        return false;
    }

    public boolean checkInclusion2(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int a[] = new int[26];
        int b[] = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            a[s1.charAt(i) - 'a']++;
            b[s2.charAt(i) - 'a']++;
        }
        if (Arrays.equals(a, b)) return true;
        //窗口大小已经固定
        int left = 0, right = s1.length();
        while (right < s2.length()) {
            b[s2.charAt(right) - 'a']++;
            b[s2.charAt(left) - 'a']--;
            if (Arrays.equals(a, b)) return true;
            right++;
            left++;
        }
        return false;
    }
}