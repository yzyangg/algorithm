package poj;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class p2524 {

    static int MAXN = 50000;
    static int parent[] = new int[MAXN];
    static int rank[] = new int[MAXN];
    static int caseNumber = 0;
    static int dif;

    public static void Union(int x, int y) {
        int a = find(x);
        int b = find(y);
        if (a != b) {
            if (rank[a] >= rank[b]) parent[b] = a;
            else parent[a] = b;
            if (rank[a] == rank[b]) rank[a]++;
            dif--;
        }
    }

    public static int find(int x) {
        if (x != parent[x]) return find(parent[x]);
        return x;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            if (n == 0 && m == 0) break;
            dif = 0;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
                dif++;
            }
            for (int i = 0; i < m; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                Union(a, b);
            }

            System.out.printf("Case %d: %d\n", ++caseNumber, dif);
        }
    }
}
