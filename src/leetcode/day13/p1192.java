package leetcode.day13;

import java.util.*;

public class p1192 {
    class Solution {
        public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
            List<Integer>[][] g = new List[2][n];
            //全部初始化
            for (List<Integer>[] lists : g) {
                Arrays.setAll(lists, value -> new ArrayList<>());
            }
            //邻接表
            //eg:0=>{1,2,3,4}
            for (int[] redEdge : redEdges) {
                g[0][redEdge[0]].add(redEdge[1]);
            }
            for (int[] blueEdge : blueEdges) {
                g[1][blueEdge[0]].add(blueEdge[1]);
            }
            Deque<int[]> queue = new ArrayDeque<>();
            queue.offer(new int[]{0, 0});//从红色开始走
            queue.offer(new int[]{0, 1});//从蓝色开始走
            int ans[] = new int[n];
            boolean visited[][] = new boolean[n][2];
            Arrays.fill(ans, -1);
            int distance = 0;
            //同时开启了两个源头的bfs
            //首层红【0，0】和蓝【0，1】 两条路同时bfs
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size-- > 0) {
                    int[] poll = queue.poll();
                    int locate = poll[0];
                    int color = poll[1];
                    if (ans[locate] == -1) {
                        //当前位置没走过
                        ans[locate] = distance;
                    }
                    //当前颜色的道路走过
                    visited[locate][color] = true;
                    //变色
                    color ^= 1;
                    //接轨[0,1]==>[1,0]
                    for (Integer cur : g[color][locate]) {
                        if (!visited[cur][color]) {
                            queue.offer(new int[]{cur, color});
                        }
                    }
                }

                distance++;
            }
            return ans;
        }

    }
}
