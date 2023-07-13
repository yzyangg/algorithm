package leetcode.day28;


import java.util.*;

public class p1376 {
    class Solution {
        public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
            List<Integer>[] relations = new List[n];
            for (int i = 0; i < n; i++) {
                relations[i] = new ArrayList<>();
            }
            for (int i = 0; i < n; i++) {
                if (i != headID) {
                    relations[manager[i]].add(i);
                }
            }
            int maxTime = 0;
            Deque<int[]> queue = new ArrayDeque<>();
            queue.offer(new int[]{headID, 0});
            while (!queue.isEmpty()) {
                //同一层具有相同的被通知时间
                int[] peek = queue.peek();
                int first = peek[0];
                maxTime += informTime[first];
                for (int i = 0; i < queue.size(); i++) {
                    int[] poll = queue.poll();
                    int emp = poll[0];

                    for (Integer integer : relations[emp]) {
                        queue.offer(new int[]{integer, maxTime});
                    }
                }
            }
            return maxTime;
        }
    }

}
