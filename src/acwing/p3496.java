package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: yzy
 **/
public class p3496 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0;
        int n = 5;
        while (n-- > 0) {
            int a = Integer.parseInt(br.readLine());
            if (check(a)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static boolean check(int a) {
        return a / 10 % 10 == a / 1000 && a % 10 == (a / 100 % 10) + 1;
    }
}
