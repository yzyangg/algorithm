package leetcode.offer;

import java.util.HashMap;
import java.util.Map;

public class p034 {
    public static void main(String[] args) {
        String words[] = {"hello", "leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        Solution2w3e4234t solution2w3e4234t = new Solution2w3e4234t();
        solution2w3e4234t.isAlienSorted(words, order);
    }
}

class Solution2w3e4234t {
    public boolean isAlienSorted(String[] words, String order) {
        if (words.length == 1) return true;
        Map<Character, Integer> compare = new HashMap<>();
        int idx = 0;
        for (char c : order.toCharArray()) {
            compare.put(c, idx++);
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (!isTrue(compare, words[i], words[i + 1])) return false;
        }
        return true;
    }

    public boolean isTrue(Map<Character, Integer> compare, String str1, String str2) {
        int idx1 = 0, idx2 = 0;
        while (idx1 < str1.length() && idx2 < str2.length()) {
            char c1 = str1.charAt(idx1);
            char c2 = str2.charAt(idx2);
            idx1++;
            idx2++;
            if (compare.get(c1) < compare.get(c2)) return true;
            else if (compare.get(c1) == compare.get(c2)) continue;
            else if (compare.get(c1) > compare.get(c2)) return false;
        }
        if (str1.length() > str2.length()) return false;
        return true;
    }
}