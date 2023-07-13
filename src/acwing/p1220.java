package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author: yzy
 **/
public class p1220 {
    static int N = 10012;
    static int M = 2 * N;
    static int h[] = new int[N];
    static int e[] = new int[M];
    static int ne[] = new int[M];
    static int w[] = new int[N];
    static long f[] = new long[N];
    static int idx = 0;

    public static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx;
        idx++;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            w[i] = Integer.parseInt(s[n - 1]);
        }
        Arrays.fill(h, -1);
        for (int i = 0; i < n - 1; i++) {
            String[] s1 = br.readLine().split(" ");
            int a = Integer.parseInt(s1[0]);
            int b = Integer.parseInt(s1[1]);
            add(a, b);
            add(b, a);
        }
        dfs(1, -1);
        long res = f[1];
        for (int i = 2; i <= n; i++) {
            res = Math.max(res, f[i]);
        }
        System.out.println(res);
    }

    private static void dfs(int u, int father) {
        f[u] = w[u];
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            //防止往回走
            if (j != father) {
                //自底向上
                dfs(u, j);
                f[u] += Math.max(f[j], 0);
            }
        }
    }
}
