package poj;

import java.util.Arrays;
import java.util.Scanner;

public class p2236 {
    static int[][] map = new int[1010][1010];
    static int[] set = new int[1010];

    static class node {
        int x;
        int y;

        public node() {
            this.x = 0;
            this.y = 0;
        }
    }

    static node nodes[] = new node[1010];

    public static int find(int x) {
        if (x == set[x]) return x;
        return find(set[x]);
    }

    public static void union(int x, int y) {
        //直接合并
        int a = find(x);
        set[a] = y;
    }

    static int N = 0, distance = 0;
    static int x = 0, y = 0;
    static char dir = ' ';
    static int tx = 0, ty = 0;
    static int healthyOne = 0;

    public static void main(String[] args) {
//        System.out.println("???");
        Arrays.fill(set, -1);
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        distance = sc.nextInt();
//        System.out.println("distance: " + distance);
        //申明初始坐标
        for (int i = 1; i <= N; i++) {
            //坏的计算机的坐标
            nodes[i] = new node();
            nodes[i].x = sc.nextInt();
            nodes[i].y = sc.nextInt();
        }
        //遍历，开始链接
        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (Math.sqrt((nodes[i].x - nodes[j].x) * (nodes[i].x - nodes[j].x) + (nodes[i].y - nodes[j].y) * (nodes[i].y - nodes[j].y)) <= distance) {
                    //合法距离内的坏电脑互相连接
                    map[i][j] = 1;
                    map[j][i] = 1;
                }
            }
        }
        while (sc.hasNext()) {
            dir = sc.next().charAt(0);
//            System.out.println("dir: " + dir);
            if (dir == 'O') {
                int healthyOne = sc.nextInt();
                set[healthyOne] = healthyOne;
                for (int i = 1; i <= N; i++) {
                    if (map[healthyOne][i] == 1 && set[i] != -1) {
                        //开机了链接
                        union(healthyOne, i);
                    }
                }
            } else {
                int tx = sc.nextInt();
                int ty = sc.nextInt();
                System.out.println(find(tx) == find(ty) ? "SUCCESS" : "FAIL");
            }
        }

    }

}
