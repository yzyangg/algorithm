package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1264 {
    static int N = 1000001;
    static int nums[] = new int[N];
    static int tree[] = new int[N];
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        String[] s1 = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            add(i, Integer.parseInt(s1[i - 1]));
        }
        for (int i = 0; i < m; i++) {
            String[] s2 = br.readLine().split(" ");
            int t, a, b;
            t = Integer.parseInt(s2[0]);
            a = Integer.parseInt(s2[1]);
            b = Integer.parseInt(s2[2]);
            if (t == 0) {
                System.out.println(query(b) - query(a - 1));
            } else {
                add(a, b);
            }
        }
    }

    private static void add(int i, int val) {
        while (i <= n) {
            tree[i] += val;
            i += lowbit(i);
        }
    }

    public static int lowbit(int x) {
        return x & -x;
    }

    public static long query(int i) {
        long res = 0;
        while (i > 0) {
            res += tree[i];
            i -= lowbit(i);
        }
        return res;
    }
}
