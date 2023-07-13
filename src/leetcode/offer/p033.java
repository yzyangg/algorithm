package leetcode.offer;

import java.util.*;

public class p033 {
    public static void main(String[] args) {
        PriorityQueue<Integer> objects = new PriorityQueue<>();
        int nums[] = new int[]{1, 4, 56, 67, 3, 45, 345, 78, 89, 9, 5, 345345};
        for (int num : nums) {
            objects.offer(num);
        }
        System.out.println(objects);
        for (int i = 0; i < 10; i++) {
            System.out.println(objects.peek());
            objects.poll();
        }
    }
}

class Solution787878 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }
}