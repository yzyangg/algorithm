package leetcode.day6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class p438 {
    public static void main(String[] args) {
        Solution32545 solution = new Solution32545();
        String a = "abc";
        String b = "abe";
        System.out.println(solution.isAna(a, b));
    }
}

class Solution32545 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (i + p.length() <= s.length()) {
                String str = s.substring(i, i + p.length());
                if (isAna(str, p)) list.add(i);
            }
        }
        return list;
    }

    public boolean isAna(String str, String p) {
        int letter1[] = new int[26];
        for (char c : str.toCharArray()) {
            letter1[c - 'a']++;
        }
        int letter2[] = new int[26];
        for (char c : p.toCharArray()) {
            letter2[c - 'a']++;
        }
        int sum = 0;
        for (int i = 0; i < letter1.length; i++) {
            if (letter1[i] != letter2[i]) return false;
        }
        return true;
    }

    public List<Integer> findAnagrams2(String s, String p) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0, valid = 0;
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))) valid++;
            }
            System.out.println(left + "===and===" + right);
            while (right - left == p.length()) {
                if (valid == need.size()) {
                    list.add(left);
                }
                char leave = s.charAt(left);
                left++;
                if (need.containsKey(leave)) {
                    if (need.get(leave).equals(window.get(leave))) valid--;
                    window.put(leave, window.get(leave) - 1);
                }
            }
        }
        return list;
    }
}
