package leetcode.day13;

import javax.swing.plaf.IconUIResource;
import java.util.*;

public class p1466 {

    class Solution {
        public int minReorder(int n, int[][] connections) {
            List<Integer> in[] = new ArrayList[n];
            List<Integer> out[] = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                in[i] = new ArrayList<>();
                out[i] = new ArrayList<>();
            }
            //正反向邻接表
            for (int[] connection : connections) {
                in[connection[1]].add(connection[0]);
                out[connection[0]].add(connection[1]);
            }
            boolean visited[] = new boolean[n];
            int needToChange = 0;
            Deque<Integer> queue = new ArrayDeque<>();
            queue.offer(0);
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size-- > 0) {
                    Integer node = queue.poll();
                    visited[node] = true;
                    for (Integer inNode : in[node]) {
                        if (!visited[inNode]) {
                            queue.offer(inNode);
                        }
                    }
                    for (Integer outNode : out[node]) {
                        if (!visited[outNode]) {
                            needToChange++;
                            queue.offer(outNode);
                        }
                    }
                }
            }
            return needToChange;
        }
    }
}
