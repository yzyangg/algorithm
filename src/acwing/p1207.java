package acwing;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: yzy
 **/
public class p1207 {
    static int N = 100012;
    static int M = 200012;
    static int w[] = new int[N];
    static int h[] = new int[N];
    static int e[] = new int[M];
    static int[] ne = new int[M];
    static int[] dis = new int[M];
    static int idx = 0;

    static public void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx;
        idx++;
    }

    static public void dfs(int u, int father, int distance) {
        dis[u] = distance;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (j != father) {
                dfs(j, u, distance + w[i]);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Arrays.fill(h, -1);
        int a, b, c;
        for (int i = 0; i < n - 1; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            add(a, b, c);
            add(b, a, c);
        }
        dfs(1, -1, 0);
        int u = 1;
        for (int i = 2; i <= n; i++) {
            if (dis[i] > dis[u]) {
                u = i;
            }
        }
        dfs(u, -1, 0);
        int maxV = dis[1];
        for (int i = 2; i <= n; i++) {
            if (dis[i] > maxV) {
                maxV = dis[i];
            }
        }
        System.out.println(maxV * 10 + ((long) (maxV + 1) * maxV) / 2);
    }
}
