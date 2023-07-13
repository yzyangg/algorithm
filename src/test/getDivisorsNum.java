package test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: yzy
 **/
public class getDivisorsNum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int nums[] = new int[1000];
        int cnt = 1;
        for (int i = 2; i <= n / i; i++) {

            if (n % i == 0) {
                int s = 0;
                while (n % i == 0) {
                    s++;
                    n /= i;
                }
                nums[cnt++] = s;
            }
        }
        if (n > 1) {
            nums[cnt++] = 1;
        }
        long res = 1;
        for (int i = 1; i <= cnt; i++) {
            System.out.print(nums[i] + " ");
            res *= (nums[i]+1);
        }
        out.println(res);
        out.flush();

    }
}
