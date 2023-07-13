package leetcode.offer;

import java.util.HashMap;
import java.util.Map;

public class p005 {
}

class Solution123434 {
    public int maxProduct(String[] words) {
        int maxDif = Integer.MIN_VALUE;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (difCount(words[i], words[j])) {
                    maxDif = Math.max(maxDif, words[i].length() * words[j].length());
                }
            }
        }
        return maxDif;
    }

    public boolean difCount(String a, String b) {
        Map<Character, Integer> mapA = new HashMap<>();
        Map<Character, Integer> mapB = new HashMap<>();
        for (char c : a.toCharArray()) {
            mapA.put(c, mapA.getOrDefault(c, 0) + 1);
        }
        for (char c : b.toCharArray()) {
            mapB.put(c, mapB.getOrDefault(c, 0) + 1);
        }
        for (Character character : mapA.keySet()) {
            if (mapB.containsKey(character)) return false;
        }
        return true;
    }

    public int maxProduct2(String[] words) {
        int length = words.length, idx = 0;
        int mask[] = new int[length];
        Map<Integer, Integer> map = new HashMap<>();
        for (String word : words) {
            int t = 0, len = word.length();
            for (int i = 0; i < word.length(); i++) {
                int u = word.charAt(i) - 'a';
                t |= 1 << u;
            }
            if (!map.containsKey(t) || map.get(t) < len) {
                map.put(t, len);
            }
        }
        int ans = 0;
        for (Integer i : map.keySet()) {
            for (Integer j : map.keySet()) {
                if ((i & j) == 0) ans = Math.max(map.get(i) * map.get(j), ans);
            }
        }
        return ans;
    }
}