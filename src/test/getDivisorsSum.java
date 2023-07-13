package test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: yzy
 **/
public class getDivisorsSum {
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {

        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                int s = 0;
                while (n % i == 0) {
                    s++;
                    n /= i;
                }
                map.put(i, s);
            }
        }
        if (n > 1) {
            map.put(n, 1);
        }
        int res = 1;
        for (Integer a : map.keySet()) {
            Integer b = map.get(a);
            int c = 1;
            while (b-- > 0) {
                c = (c * a + 1);
            }
            res *= c;
        }
        out.println(res);
        out.flush();

    }
}
