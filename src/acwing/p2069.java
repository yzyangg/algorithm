package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class p2069 {
    static int N = 100001;
    static int parent[] = new int[N];
    static int d[] = new int[N];

    public static int find(int x) {
        if (parent[x] == x || parent[parent[x]] == parent[x]) {
            return parent[x];
        }
        int root = find(parent[x]);
        d[x] += d[parent[x]];
        parent[x] = root;
        return root;
    }

    public static void union(int x, int y) {
        int a = find(x);
        int b = find(y);
        if (a != b) {
            d[a] -= d[b];
            parent[a] = b;
        }
    }

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        while (m-- > 0) {
            int a, b, c;
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            if (a == 1) {
                union(b, c);
            } else if (a == 2) {
                b = find(b);
                d[b] += c;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (i == find(i)) System.out.print(d[i] + " ");
            else System.out.println(d[i] + d[parent[i]] + " ");
            System.out.println();
        }
    }
}
