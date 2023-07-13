package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class p3956 {
    static int N = 12;
    static int preSum[] = new int[N];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n <= 2) System.out.println(0);
        int num = 0;
        String[] line = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            num = Integer.parseInt(line[i]);
            preSum[i] = num + preSum[i - 1];
        }

        if (preSum[n] % 3 != 0) {
            System.out.println(0);
        }
        long ave = preSum[n] / 3;
        long ans = 0;
        long temp = 0;
        for (int i = 1; i < n; i++) {
            if (preSum[i] == ave * 2) ans += temp;
            if (preSum[i] == ave) temp++;
        }
        System.out.println(ans);
    }
}
