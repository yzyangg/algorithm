package acwing;

import java.io.*;

/**
 * @author: yzy
 **/
public class p1112 {
    static int N = 112;
    static int n, x1, y1, x2, y2;
    static char[][] map = new char[N][N];
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            flag = false;
            n = Integer.parseInt(br.readLine());
            for (int i = 1; i <= n; i++) {
                char[] chars = br.readLine().toCharArray();
                for (int j = 1; j <= n; j++) {
                    map[i][j] = chars[j - 1];
                }
            }
            String[] s = br.readLine().split(" ");
            x1 = Integer.parseInt(s[0]) + 1;
            y1 = Integer.parseInt(s[1]) + 1;
            x2 = Integer.parseInt(s[2]) + 1;
            y2 = Integer.parseInt(s[3]) + 1;
            dfs(x1, y1);
            if (flag) {
                out.println("YES");
            } else {
                out.println("NO");
            }
            out.flush();

        }
    }

    private static void dfs(int i, int j) {
        if (i < 1 || j < 1 || i > n || j > n || map[i][j] == '#') {
            return;
        }
        if (i == x2 && j == y2) {
            flag = true;
        }
        map[i][j] = '#';
        dfs(i + 1, j);
        dfs(i - 1, j);
        dfs(i, j + 1);
        dfs(i, j - 1);
    }
}
