package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1219 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int w, m, n;
        w = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]) - 1;
        n = Integer.parseInt(s[2]) - 1;
        int rowSub, colSub;
        rowSub = Math.abs(n / w - m / w);
//        System.out.println(rowSub);
        int col1 = 0, col2 = 0;
        if ((n / w) % 2 == 1) {
            col2 = w - n % w - 1;
        } else {
            col2 = n % w;
        }
        if ((m / w) % 2 == 1) {
            col1 = w - m % w - 1;
        } else {
            col1 = m % w;
        }
        colSub = Math.abs(col1 - col2);
//        System.out.println(colSub);
        System.out.println(rowSub + colSub);
    }
}
