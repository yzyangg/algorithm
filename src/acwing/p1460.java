package acwing;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: yzy
 **/
public class p1460 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        String s = br.readLine();

        for (int i = 1; i <= n; i++) {
            Set<String> set = new HashSet<>();
            boolean flag = true;
            for (int j = 0; j + i <= n; j++) {
                String tmp = s.substring(j, j + i);
                if (set.contains(tmp)) {
                    flag = false;
                    break;
                }
                set.add(tmp);
            }
            if (flag) {
                out.println(i);
                out.flush();
                out.close();
                break;
            }
        }
    }
}
