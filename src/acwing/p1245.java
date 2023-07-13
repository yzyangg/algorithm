package acwing;

import com.sun.deploy.net.offline.WIExplorerOfflineHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class p1245 {
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        set.add(2);
        set.add(0);
        set.add(1);
        set.add(9);
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            if (isOK(i)) ans += i;
        }
        System.out.println(ans);
    }

    public static boolean isOK(int num) {
        while (num > 0) {
            int cur = num % 10;
            if (set.contains(cur)) return true;
            num /= 10;
        }
        return false;
    }

}
