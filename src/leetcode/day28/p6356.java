package leetcode.day28;

import com.sun.xml.internal.org.jvnet.mimepull.CleanUpExecutorFactory;

import java.util.ArrayList;
import java.util.List;

public class p6356 {
    public static void main(String[] args) {
        String s = "101101";
        System.out.println(s.substring(5, 6));
    }

    class Solution {
        String s;

        public int[][] substringXorQueries(String s, int[][] queries) {
            this.s = s;
            List<int[]> list = new ArrayList<>();
            for (int[] query : queries) {
                int first = query[0];
                int second = query[1];
                int[] LeftAndRight = check(first, second);
                list.add(LeftAndRight);
            }
            int ans[][] = new int[list.size()][2];
            int idx = 0;
            for (int[] ints : list) {
                ans[idx++] = ints;
            }
            return ans;
        }

        public int[] check(int first, int second) {
            for (int i = 0; i < s.length() - 1; i++) {
                for (int j = i + 1; j <= s.length(); j++) {
                    int bi = Integer.parseInt(s.substring(i, j), 2);
                    System.out.println(bi);
                    if ((bi ^ first) == second) {
                        System.out.println("now" + bi + "^" + first + "==" + second);
                        while (s.charAt(i) == '0') i++;
                        return new int[]{i, j};
                    }
                }
            }
            return new int[]{-1, -1};
        }
    }
}
