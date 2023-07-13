package leetcode.day28;

import java.util.LinkedList;
import java.util.Queue;

public class p847 {
    class Solution {
        public int shortestPathLength(int[][] graph) {
            int length = graph.length;
            //三元数组表示 当前位置：每个节点访问状态（状态压缩）：距离
            Queue<int[]> queue = new LinkedList<int[]>();
            //以某种状态走到当前节点的是否被访问
            boolean visited[][] = new boolean[length][1 << length];
            for (int i = 0; i < length; i++) {
                queue.offer(new int[]{i, 1 << i, 0});
            }
            //开始搜索
            while (!queue.isEmpty()) {
                int[] tuple = queue.poll();
                int idx = tuple[0];
                int mask = tuple[1];
                int dist = tuple[2];
                //找到答案 每个节点已经被访问过
                if (mask == ((1 << length)) - 1) return dist;
                for (int i : graph[idx]) {
                    //更改访问状态
                    int nextMask = mask | (1 << i);
                    if (!visited[i][nextMask]) {
                        queue.offer(new int[]{i, nextMask, dist + 1});
                        visited[i][nextMask] = true;
                    }
                }
            }
            return 0;
        }

    }
}
