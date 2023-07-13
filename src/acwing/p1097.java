package acwing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class p1097 {
    static int N = 1012, n, m;
    static char[][] map = new char[N][N];
    static int dirs[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(new OutputStreamWriter(System.out));
        String s[] = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        for (int i = 1; i <= n; i++) {
            char chars[] = br.readLine().toCharArray();
            for (int j = 1; j <= m; j++) {
                map[i][j] = chars[j - 1];
            }
        }
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] == 'W') {
                    dfs(i, j);
                    cnt++;
                }
            }
        }
        wr.println(cnt);
        wr.flush();
    }

    public static void dfs(int i, int j) {
        if (i < 1 || i > n || j < 1 || j > m || map[i][j] == '.') {
            return;
        }
        map[i][j] = '.';
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            dfs(x, y);
        }
    }
}
