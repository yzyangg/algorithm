package acwing;

import java.io.*;

public class p1249 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    static int N = 20010;
    static int[] parent = new int[N];


    public static void main(String[] args) throws IOException {
        int n, m;
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        while (m-- > 0) {
            String[] s1 = br.readLine().split(" ");
            int a = Integer.parseInt(s1[0]);
            int b = Integer.parseInt(s1[1]);
            merge(a, b);
        }
        int q = Integer.parseInt(br.readLine());
        while (q-- > 0) {
            String[] s2 = br.readLine().split(" ");
            int a = Integer.parseInt(s2[0]);
            int b = Integer.parseInt(s2[1]);
            if (find(a) == find(b)) {
                out.println("Yes");
            } else {
                out.println("No");
            }
        }
        out.flush();
    }

    private static void merge(int a, int b) {
        if (find(a) != find(b)) {
            parent[find(a)] = find(b);
        }
    }

    public static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

}
