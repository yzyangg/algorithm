package acwing.p200;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: yzy
 **/
public class p173 {
    static int n, m, N = 1012;
    static int[][] map = new int[N][N];
    static int[][] ans = new int[N][N];
    static boolean[][] vis = new boolean[N][N];
    static Deque<Node> queue = new LinkedList<>();
    static int dirs[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void bfs() {
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int x = now.x;
            int y = now.y;
            int dis = now.dis;

            for (int[] dir : dirs) {
                int a = x + dir[0];
                int b = y + dir[1];
                if (a < 1 || b < 1 || a > n || b > m || vis[a][b]) {
                    continue;
                }
                vis[a][b] = true;
                queue.offer(new Node(a, b, dis + 1));
                ans[a][b] = dis + 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        for (int i = 1; i <= n; i++) {
            String s1 = br.readLine();
            for (int j = 1; j <= m; j++) {
                map[i][j] = s1.charAt(j - 1) - '0';
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] == 1) {
                    queue.offer(new Node(i, j, 0));
                    vis[i][j] = true;
                }
            }
        }
        bfs();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                wr.print(ans[i][j] + " ");
            }
            wr.println();
        }
        wr.flush();

    }
}

class Node {
    int x, y, dis;

    public Node(int x, int y, int dis) {
        this.x = x;
        this.y = y;
        this.dis = dis;
    }
}