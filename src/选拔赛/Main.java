package 选拔赛;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (scanner.hasNextInt()) {
            int t = scanner.nextInt();
            int mod = scanner.nextInt();
            for (int i = 0; i < t; i++) {
                int sx = scanner.nextInt();
                int sy = scanner.nextInt();
                int x = sx;
                int y = sy;
                Map<String, Integer> mp = new HashMap<>();
                int cnt = 0;
                while (true) {
                    cnt++;
                    x = (x + y) % mod;
                    y = (x + y) % mod;

                    if (x == 0) {
                        out.println(1);
                        break;
                    }
                    if (y == 0) {
                        out.println(2);
                        break;
                    }
                    String s = x + "  " + y;
//                    out.println("S === >" + s);

                    mp.put(s, mp.getOrDefault(s, 0) + 1);
                    if ((x == sx && y == sy) || mp.get(s) > 1) {
//                        out.println("error" + x + " " + y);
                        out.println("error");
                        break;
                    }

                }
                out.flush();
            }
        }
    }
}
