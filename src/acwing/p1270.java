package acwing;

import java.io.*;

public class p1270 {
    static int n, m, N = 100005, nums[] = new int[N];

    static class node {
        int l, r, maxV;

        public node(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }

    static node nodes[] = new node[4 * N];

    static void push_up(int u) {
        nodes[u].maxV = Math.max(nodes[u << 1].maxV, nodes[u << 1 | 1].maxV);
    }

    static void build(int u, int l, int r) {
        nodes[u] = new node(l, r);
        if (l == r) nodes[u].maxV = nums[r];
        else {
            int mid = (l + r) >> 1;
            build(u << 1, l, mid);
            build(u << 1 | 1, mid + 1, r);
            push_up(u);
        }
    }


    static int query(int u, int l, int r) {
        if (nodes[u].l >= l && nodes[u].r <= r) return nodes[u].maxV;
        int mid = (nodes[u].l + nodes[u].r) >> 1;
        int res = Integer.MIN_VALUE;
        if (l <= mid) res = Math.max(query(u << 1, l, r), res);
        if (r > mid) res = Math.max(res, query(u << 1 | 1, l, r));
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        String ss[];
        ss = in.readLine().trim().split(" ");
        n = Integer.parseInt(ss[0]);
        m = Integer.parseInt(ss[1]);
        ss = in.readLine().trim().split(" ");
        for (int i = 1; i <= n; ++i) nums[i] = Integer.parseInt(ss[i - 1]);
        build(1, 1, n);
        while ((m--) > 0) {
            int l, r;
            ss = in.readLine().trim().split(" ");
            l = Integer.parseInt(ss[0]);
            r = Integer.parseInt(ss[1]);
            out.println(query(1, l, r));
        }
        out.flush();
    }
}
