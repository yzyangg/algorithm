package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * @author: yzy
 **/
public class p4943 {
    static int n, m, k;
    static int N = 1012;
    static char[][] map = new char[N][N];
    static boolean[][] st = new boolean[N][N];
    static int x1, x2, y1, y2;
    static int dirs[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        k = Integer.parseInt(s[2]);
        for (int i = 1; i <= n; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 1; j <= m; j++) {
                map[i][j] = chars[j - 1];
            }
        }
        String[] s1 = br.readLine().split(" ");
        x1 = Integer.parseInt(s1[0]);
        y1 = Integer.parseInt(s1[1]);
        x2 = Integer.parseInt(s1[2]);
        y2 = Integer.parseInt(s1[3]);

        if (x1 == x2 && y1 == y2) {
            System.out.println(0);
            return;
        }
        PriorityQueue<node> queue = new PriorityQueue<>((o1, o2) -> o2.times - o1.times);
        queue.offer(new node(x1, y1, 0));
        st[x1][y1] = true;
        while (!queue.isEmpty()) {
            node now = queue.poll();
            int i = now.x;
            int j = now.y;
            int times = now.times;
            if (i == x2 && j == y2) {
                System.out.println(now.times);
                flag = true;
                break;
            }
            for (int[] dir : dirs) {
                for (int d = 1; d <= k; d--) {
                    int x = i + dir[0] * d;
                    int y = j + dir[1] * d;
                    if (x < 1 || y < 1 || x > n || y > m || st[x][y] || map[x][y] == '#') {
                        continue;
                    }
                    st[x][y] = true;
                    queue.offer(new node(x, y, times + 1));
                }
            }

        }

        if (!flag) {
            System.out.println(-1);
        }


    }

    static class node {
        int x, y, times;

        public node(int x, int y, int times) {
            this.x = x;
            this.y = y;
            this.times = times;
        }
    }
}
