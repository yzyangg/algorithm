package acwing;

import netscape.security.UserTarget;

import java.io.*;

public class p1265 {
    static int N = 15012;
    static int tree[] = new int[N];
    static int level[] = new int[N];

    static int lowbit(int x) {
        return x & -x;
    }

    static int query(int x) {
        int res = 0;
        for (int i = x; i > 0; i -= lowbit(i)) {
            res += tree[i];
        }
        return res;
    }

    static int n;

    static void add(int i) {
        while (i <= N) {
            tree[i]++;
            i += lowbit(i);
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            int x;
            x = Integer.parseInt(input[0]);
            x++;
            level[query(x)]++;
            add(x);
        }
        for (int i = 0; i < n; i++) {
            out.write(level[i] + "\n");
        }
        out.flush();
    }
}

