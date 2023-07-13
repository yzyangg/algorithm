package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: yzy
 **/
public class p1205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n, m;
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        System.out.println((n - 1) * (m - 1) - 1);
    }
}
