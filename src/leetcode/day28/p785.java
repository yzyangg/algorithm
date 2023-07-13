package leetcode.day28;

import javax.swing.plaf.IconUIResource;
import java.util.LinkedList;
import java.util.Queue;

public class p785 {
    class Solution {
        public boolean isBipartite(int[][] graph) {
            //多源BFS
            int len = graph.length;
            int visited[] = new int[len];
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < len; i++) {
                if (visited[i] != 0) continue;
                queue.offer(i);
                while (!queue.isEmpty()) {
                    Integer w = queue.poll();
                    for (int v : graph[w]) {
                        if (visited[w] == visited[v]) {
                            //邻接点和顶点处于了同一集合
                            return false;
                        }
                        //临界点没被访问时
                        if (visited[v] == 0) {
                            visited[v] = -visited[w];
                            queue.offer(v);
                        }
                    }
                }
            }
            return true;
        }
    }

    class Solution2 {
        public boolean isBipartite(int[][] graph) {
            //定义两种颜色1和-1
            int length = graph.length;
            int color[] = new int[length];
            for (int i = 0; i < length; i++) {
                if (!dfs(graph, color, i, 0)) return false;
            }
            return true;
        }

        public boolean dfs(int[][] graph, int color[], int idx, int lastColor) {
            //顶点和邻接点颜色相同了
            //如果已经被染色了并且颜色和上次相同说明有问题
            if (color[idx] != 0) return color[idx] != lastColor;
            int nowColor = -lastColor;
            color[idx] = nowColor;
            for (int i : graph[idx]) {
                if (!dfs(graph, color, i, nowColor)) return false;
            }
            return true;
        }
    }
}
