package leetcode.day28;

import javax.swing.text.StyledEditorKit;
import java.util.*;

public class p1654 {
    class Solution {
        int target = 0;
        int a;
        int b;
        boolean[] visited = new boolean[8000];
        int ans = -1;

        public int minimumJumps(int[] forbidden, int a, int b, int x) {
            this.a = a;
            this.b = b;
            target = x;
            for (int i : forbidden) {
                visited[i] = true;//标记禁区
            }
            dfs(0, 0, false);
            return ans;
        }

        //每个分支分向前和向后
        public void dfs(int nowIndex, int takes, boolean backward) {
            if (nowIndex >= 0 && nowIndex < 8000) {
                if (nowIndex != target) {
                    if (nowIndex + a < 8000 && !visited[nowIndex + a]) {
                        visited[nowIndex + a] = true;
                        dfs(nowIndex + a, takes + 1, false);
                    }
                    if (!backward && nowIndex > 0 && !visited[nowIndex - b]) {
                        visited[nowIndex - b] = true;
                        dfs(nowIndex - b, takes + 1, true);
                    }
                } else {
                    ans = takes;
                    return;
                }
            }
        }
    }

    class Solution2 {
        boolean visited[];


        public int minimumJumps(int[] forbidden, int a, int b, int x) {

            visited = new boolean[6000];
            for (int i : forbidden) {
                visited[i] = true;
            }
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{0, 1, 0});
            while (!queue.isEmpty()) {
                int[] poll = queue.poll();
                int nowIndex = poll[0];
                int direct = poll[1];
                int step = poll[2];
                if (nowIndex == x) return step;
                if (visited[nowIndex]) continue;
                visited[nowIndex] = true;
                if (direct == 1 && nowIndex - b >= 0 && !visited[nowIndex - b]) {
                    queue.offer(new int[]{nowIndex - b, -1, step + 1});
                }
                if (nowIndex + a < 6000 && !visited[nowIndex + a]) {
                    queue.offer(new int[]{nowIndex + a, 1, step + 1});
                }
            }
            return -1;
        }

    }
}
