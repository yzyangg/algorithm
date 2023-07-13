package leetcode;

import java.util.*;

/**
 * @author yzy
 * @version 1.0
 * @description TODO
 * @date 2023/5/14 10:46
 */
public class p347 {
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int n : nums) {
                map.put(n, map.getOrDefault(n, 0) + 1);
            }
            PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    return o2.getValue() - o1.getValue();
                }
            });

            queue.addAll(map.entrySet());
            int res[] = new int[k];
            int idx = 0;

            while (k-- > 0) {
                Integer poll = queue.poll().getKey();
                res[idx++] = poll;
            }

            return res;
        }
    }
}



