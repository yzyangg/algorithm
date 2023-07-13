package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: yzy
 **/
public class p3717 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set = new HashSet<>();
        int n = Integer.parseInt(br.readLine());
        int fama[] = new int[n];
        String s[] = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            fama[i] = Integer.parseInt(s[i]);

        }
        set.add(0);
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>(set);
            for (int k : list) {
                set.add(k + fama[i]);
                set.add(Math.abs(k - fama[i]));
            }
        }
        set.remove(0);
        System.out.println(set.size());
    }
}
