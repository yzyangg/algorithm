package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: yzy
 **/
public class p1303 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int a = 1 % m;
        int b = 1 % m;
        int c = (a + b) % m;
        long sum = (a + b + c) % m;
        for (int i = 4; i <= n; i++) {
            a = b;
            b = c;
            c = (a + b) % m;
            sum += c % m;
        }
        System.out.println(sum);
    }
}
