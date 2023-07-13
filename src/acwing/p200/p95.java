package acwing.p200;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class p95 {
    static int dirs[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {0, 0}};
    static int N = 6;
    static char[][] graph = new char[N][N];
    static char[][] backup = new char[N][N];

    public static void turn(int x, int y) {
        for (int i = 0; i < 5; i++) {
            int a = x + dirs[i][0];
            int b = y + dirs[i][1];
            //如果在边界外边，直接忽略即可
            if (a < 0 || a >= 5 || b < 0 || b >= 5) continue;
            //等价于 g[a][b] = '0' + ('1'  - g[a][b])
            graph[a][b] ^= 1;   //异或，不同的时候就变成相反的数
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while (n-- > 0) {
            int res = 7;
            //初始化
            for (int i = 0; i < 5; i++) graph[i] = sc.next().toCharArray();


            for (int op = 0; op < 1 << 5; op++) {
                //拷贝
                for (int i = 0; i < 5; i++) {
                    backup[i] = Arrays.copyOf(graph[i], 5);
                }
                int step = 0;
//                System.out.println("1========");
                //操作第一行a
                for (int j = 0; j < 5; j++) {
                    if (((op >> j) & 1) == 1) {
                        turn(0, j);
                        step++;
                    }
                }
//                System.out.println("2========");
                //操作后续行
                for (int i = 0; i < 4; ++i)
                    for (int j = 0; j < 5; ++j) {
                        if (graph[i][j] == '0') {
                            step++;
                            // 如果这个位置是灭的，就按下一行对应的位置
                            turn(i + 1, j);
                        }
                    }

//                System.out.println("3========");
                //操作完了检验
                boolean isAllLight = true;
                for (int j = 0; j < 5; j++)
                    if (graph[4][j] == '0') {
                        isAllLight = false;
                        break;
                    }
//                System.out.println("4========");
                //检验完了判断
                if (isAllLight) {
                    res = Math.min(res, step);
                }
//                System.out.println("5========");
                //还原
                for (int i = 0; i < 5; i++) {
                    graph[i] = Arrays.copyOf(backup[i], 5);
                }
            }
            System.out.println(res > 6 ? -1 : res);
        }
    }
}
