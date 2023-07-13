package acwing;

import java.util.Scanner;

public class p795 {
    static int N = 100002;
    static int preSum[] = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int num = 0;
        for (int i = 1; i <= n; i++) {
            num = sc.nextInt();
            preSum[i] = num + preSum[i - 1];
        }
        int l, r;
        while (q-- > 0) {
            l = sc.nextInt();
            r = sc.nextInt();
            System.out.println(preSum[r] - preSum[l - 1]);
        }
    }
}
