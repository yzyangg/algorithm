package poj;

import java.util.Scanner;

public class p1703 {
    private static final int MAXN = 100005;
    static int parent[] = new int[MAXN];
    static int rank[] = new int[MAXN];

    public static int find(int x) {
        if (x != parent[x]) return find(parent[x]);
        return x;
    }

    public static void Union(int x, int y) {
        int a = find(x);
        int b = find(y);
        if (a != b) {
            if (rank[a] >= rank[b]) parent[b] = a;
            else parent[a] = b;
            if (rank[a] == rank[b]) rank[a]++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            for (int i = 0; i < 2 * N; i++) {
                parent[i] = i;
            }
            for (int i = 0; i < M; i++) {
                char c = sc.next().charAt(0);
                int a = sc.nextInt();
                int b = sc.nextInt();
                if (c == 'A') {
                    if (find(a) == find(b)) {
                        System.out.printf("In the same gang.");
                    } else if (find(a) == find(a + N) || find(b) == find(a + N))
                        System.out.println("In different gangs.");
                    else System.out.println("Not sure yet.");
                } else if (c == 'D') {
                    Union(a, b + N);
                    Union(b, a + N);
                }
            }
        }
    }
}
