package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: yzy
 **/
public class p4941 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int res = 0;

        while (n > 1) {
            if (n % 2 != 0) {
                res += (n % 2);
            }
            n /= 2;
        }
        if (n != 0) {
            res += n;
        }
        System.out.println(res);

    }
}
