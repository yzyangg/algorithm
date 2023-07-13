package acwing;

import netscape.security.UserTarget;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.*;

/**
 * @author: yzy
 **/
public class p1050 {
    static int n, m;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

//        while (T-- > 0) {
//            String[] s = br.readLine().split(" ");
//            m = Integer.parseInt(s[0]);
//            n = Integer.parseInt(s[1]);
//            dfs(m, n);
//        }
//        System.out.println(set.size());

        while (T-- > 0) {
            res = 0;
            String[] s = br.readLine().split(" ");
            m = Integer.parseInt(s[0]);
            n = Integer.parseInt(s[1]);
            dfs(m, 0, 0);
            System.out.println(res);
        }

    }

    static long res = 0;

    private static void dfs(int t, int idx, int state) {
        if (state == n && t == 0) {
            res++;
        }
        if (state > n) {
            return;
        }
        for (int i = idx; i <= m; i++) {
            dfs(t - i, i, state + 1);
        }
    }

    static Set<List<Integer>> set = new HashSet<>();
    static List<Integer> path = new ArrayList<>();

//    private static void dfs(int m, int n) {
//        if (n == 0) {
//
//            if (m == 0) {
//
//                System.out.println();
//                Collections.sort(path);
//                if (set.contains(path)) {
//                    return;
//                }
//                System.out.println(path);
//                set.add(new ArrayList<>(path));
//            }
//            return;
//        }
//        for (int i = 0; i <= m; i++) {
//            path.add(i);
//            m -= i;
//            n -= 1;
//            dfs(m, n);
//            m += i;
//            n += 1;
//            path.remove(path.size() - 1);
//        }
//    }


}
