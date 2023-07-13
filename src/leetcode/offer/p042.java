package leetcode.offer;

import java.util.ArrayDeque;
import java.util.Deque;

public class p042 {
}


class RecentCounter {
    Deque<Integer> queue;

    public RecentCounter() {
        queue = new ArrayDeque<>();
    }

    public int ping(int t) {
        queue.addLast(t);
        while (queue.peek() < t - 3000) {
            queue.poll();

        }
        return queue.size();
    }
}
