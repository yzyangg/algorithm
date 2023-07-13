package leetcode.day8;

import java.util.HashMap;
import java.util.Map;

public class p6284 {
}

/**
 * class Solution {
 * public boolean isItPossible(String word1, String word2) {
 * Map<Character, Integer> map1 = new HashMap<>();
 * Map<Character, Integer> map2 = new HashMap<>();
 * for (char c : word1.toCharArray()) {
 * map1.put(c, map1.getOrDefault(c, 0) + 1);
 * }
 * for (char c : word2.toCharArray()) {
 * map2.put(c, map2.getOrDefault(c, 0) + 1);
 * }
 * if (map2.size() == map1.size()) return false;
 * //swap
 * for (char c : word1.toCharArray()) {
 * map1.put(c, map1.getOrDefault(c, 0) - 1);
 * if (map1.get(c) == 0) {
 * map1.remove(c);
 * }
 * map2.put(c, map2.getOrDefault(c, 0) + 1);
 * if (map2.get(c) == 0) {
 * map2.remove(c);
 * }
 * if (map2.size() == map1.size()) return true;
 * }
 * return false;
 * }
 * }
 */
class Solution2 {
    public boolean isItPossible(String word1, String word2) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        Map<Character, Integer> map3 = new HashMap<>();
        Map<Character, Integer> map4 = new HashMap<>();
        for (char c : word1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        for (char c : word2.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
        for (char c : word1.toCharArray()) {
            map3.put(c, map3.getOrDefault(c, 0) + 1);
        }
        for (char c : word2.toCharArray()) {
            map4.put(c, map4.getOrDefault(c, 0) + 1);
        }
        if (map2.size() == map1.size()) return true;
        //swap 1=>2
        for (char c : word1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) - 1);
            if (map1.get(c) == 0) {
                map1.remove(c);
            }
            map2.put(c, map2.getOrDefault(c, 0) + 1);
            if (map2.get(c) == 0) {
                map2.remove(c);
            }
            if (map2.size() == map1.size()) return true;
        }
        //swap 2==>1
        for (char c : word2.toCharArray()) {
            map4.put(c, map4.getOrDefault(c, 0) - 1);
            if (map4.get(c) == 0) map4.remove(c);
            map3.put(c, map3.getOrDefault(c, 0) + 1);
            if (map3.get(c) == 0) map3.remove(c);
            if (map3.size() == map4.size()) return true;
        }

        return false;
    }
}

class Solution435345 {

    public boolean isItPossible(String word1, String word2) {
        HashMap<Character, Integer> map1 = new HashMap<>(), map2 = new HashMap<>();
        for (char c : word1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        for (char c : word2.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
        for (char c1 : map1.keySet()) {
            for (char c2 : map2.keySet()) {
                Map<Character, Integer> newMap1 = new HashMap<>(map1);
                Map<Character, Integer> newMap2 = new HashMap<>(map2);
                //从word1中拿走一个字符准备放入word2
                newMap1.put(c1, newMap1.getOrDefault(c1, 0) - 1);
                //从word2中拿到一个字符
                newMap1.put(c2, newMap1.getOrDefault(c2, 0) + 1);
                if (newMap1.get(c1) == 0) newMap1.remove(c1);
                //刚刚拿走的放入word2
                newMap2.put(c1, newMap2.getOrDefault(c1, 0) + 1);
                newMap2.put(c2, newMap2.getOrDefault(c2, 0) - 1);
                if (newMap2.get(c2) == 0) newMap2.remove(c2);
                if (newMap1.size() == newMap2.size()) return true;
            }
        }
        return false;
    }
}

