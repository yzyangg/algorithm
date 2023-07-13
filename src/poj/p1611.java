package poj;

import java.util.Scanner;

public class p1611 {
    static int n, m, k, fa, son;
    static int MAXN = 50000;
    static int father[] = new int[MAXN];
    static int size[] = new int[MAXN];

    public static int find(int x) {
        if (x == father[x]) return x;
        return find(father[x]);
    }

    public static void Union(int x, int y) {
        int a = find(x);
        int b = find(y);
        if (a != b) {
            if (size[a] >= size[b]) {
                father[b] = a;
                size[a] += size[b];
            } else {
                father[a] = b;
                size[b] += size[a];
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            n = sc.nextInt();
            m = sc.nextInt();
            if (n == 0 && m == 0) return;
            for (int i = 0; i < n; i++) {
                father[i] = i;
                size[i] = 1;
            }
            for (int i = 0; i < m; i++) {
                k = sc.nextInt();
                fa = sc.nextInt();
                for (int j = 1; j < k; j++) {
                    son = sc.nextInt();
                    Union(fa, son);
                }
            }
            System.out.printf("%d\n", size[find(0)]);
        }
    }
}
