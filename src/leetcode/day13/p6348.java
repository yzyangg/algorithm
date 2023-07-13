package leetcode.day13;

import java.util.Comparator;
import java.util.PriorityQueue;

public class p6348 {
}

class Solution12556 {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int gift : gifts) {
            queue.offer(gift);
        }
        while (k-- > 0) {
            double poll = queue.poll();
            queue.offer((int) Math.sqrt(poll));
        }
        long ans = 0;
        while (!queue.isEmpty()) {
            ans += queue.poll();
        }
        return ans;
    }
}