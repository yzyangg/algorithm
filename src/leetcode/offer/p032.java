package leetcode.offer;

public class p032 {
}

class Solution54q342531 {
    public boolean isAnagram(String s, String t) {
        if (s.equals(t)) return false;
        int arr1[] = new int[26];
        int arr2[] = new int[26];
        for (char c : t.toCharArray()) {
            arr1[c - 'a']++;
        }
        for (char c : s.toCharArray()) {
            arr2[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (arr2[i] != arr1[1]) return false;
        }
        return true;
    }

    public boolean isAnagram2(String s, String t) {
        if (s.equals(t) || s.length() != t.length()) return false;
        int count[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }
}