package leetcode.day13;

import java.util.*;

public class p841 {
    class Solution {
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            int n = rooms.size(), count = 0;
            boolean visited[] = new boolean[n];
            Queue<Integer> deque = new LinkedList<>();
            visited[0] = true;
            deque.offer(0);
            while (!deque.isEmpty()) {
                int size = deque.size();
                while (size-- > 0) {
                    count++;
                    Integer poll = deque.poll();
                    for (Integer integer : rooms.get(poll)) {
                        if (!visited[integer]) {
                            deque.offer(integer);
                            visited[integer] = true;
                        }
                    }
                }

            }
            return count == n;
        }
    }
}
