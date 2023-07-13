package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: yzy
 **/
public class p3490 {
    public static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
    static int n;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(BUFFERED_READER.readLine());
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            if (check(i)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static boolean check(int i) {
        int a = ((i * i)) % n;
        double b = (double) n / 2;
        if (a < b) {
            return true;
        }
        return false;
    }
}
