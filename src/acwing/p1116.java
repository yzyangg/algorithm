package acwing;

import java.io.*;
import java.net.InetAddress;

/**
 * @author: yzy
 **/
public class p1116 {
    static int N = 12;
    static boolean vis[][] = new boolean[
            N][N];
    static int n, m, x, y;
    static int res = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            res = 0;
            String[] s = br.readLine().split(" ");
            n = Integer.parseInt(s[0]);
            m = Integer.parseInt(s[1]);
            x = Integer.parseInt(s[2]) + 1;
            y = Integer.parseInt(s[3]) + 1;

            dfs(x, y, 0);
            out.println(res);
            out.flush();
        }


    }


    static int dirs[][] = {{2, 1}, {1, 2}, {-1, 2}, {2, -1}, {-2, 1}, {1, -2}, {-1, -2}, {-2, -1}};

    private static void dfs(int x, int y, int step) {
        if (step == n * m) {
            res++;
        }
        if (x < 1 || y < 1 || x > n || y > m || vis[x][y]) {
            return;
        }
        for (int[] dir : dirs) {
            int a = x + dir[0];
            int b = y + dir[1];
            if (a < 1 || b < 1 || a > n || b > m || vis[a][b]) {
                continue;
            }
            vis[a][b] = true;
            dfs(a, b, step + 1);
            vis[a][b] = false;

        }

    }
}
