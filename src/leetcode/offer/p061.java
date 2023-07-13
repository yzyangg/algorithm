package leetcode.offer;

import java.util.*;

public class p061 {
}

class Solution33334555 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>((o1, o2) -> o1.get(0) + o1.get(1) - o2.get(0) - o2.get(1));
        for (int x : nums1) {
            for (int y : nums2) {
                queue.offer(Arrays.asList(x, y));
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        while (k > 0 && !queue.isEmpty()) {
            ans.add(queue.poll());
        }
        return ans;
    }
}