package leetcode.offer;

import java.util.*;

public class p015 {
}

class Solution765432 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s.length() < p.length()) return list;
        int a[] = new int[26];
        int b[] = new int[26];
        //a是target！！
        for (int i = 0; i < p.length(); i++) {
            a[p.charAt(i) - 'a']++;
            b[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(a, b)) list.add(0);
        int left = 0, right = p.length();
        while (right < s.length()) {
            b[s.charAt(right) - 'a']++;
            b[s.charAt(left) - 'a']--;
            right++;
            left++;
            if (Arrays.equals(a, b)) list.add(left);
        }
        return list;
    }

    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s.length() < p.length()) return list;
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0, valid = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);
            if (window.get(c).equals(need.get(c))) valid++;
            //始终位置同一长度的window
            while (left <= right &&  right - left + 1 == p.length()) {
                if (valid == need.size()) list.add(left);
                char leave = s.charAt(left);
                if (need.containsKey(leave)) {
                    if (need.get(leave).equals(window.get(leave))) valid--;
                }
                window.put(leave, window.get(leave) - 1);
                left++;
            }
            right++;
        }
        return list;
    }
}
