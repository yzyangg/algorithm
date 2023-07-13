package leetcode.day13;

import javax.swing.plaf.IconUIResource;
import java.util.*;

public class p6347 {
    class Solution {
        public int[] vowelStrings(String[] words, int[][] queries) {
            Set<Character> set = new HashSet<>();
            set.add('a');
            set.add('e');
            set.add('i');
            set.add('o');
            set.add('u');
            int[] isValid = new int[words.length];
            for (int i = 0; i < words.length; i++) {
                char c = words[i].charAt(0);
                char c1 = words[i].charAt(words[i].length() - 1);
                if (set.contains(c) && set.contains(c1))
                    isValid[i] = 1;
            }
            int preSum[] = new int[words.length];
            preSum[0] = 0;
            preSum[1] = isValid[0];
            for (int i = 1; i < isValid.length; i++) {
                preSum[i + 1] = preSum[i] + isValid[i];
            }
            List<Integer> list = new ArrayList<>();
            for (int[] query : queries) {
                int l = query[0];
                int r = query[1];
                int count = 0;
                count += preSum[r + 1] - preSum[l];
                list.add(count);
            }
            int ans[] = new int[list.size()];
            int idx = 0;
            for (Integer integer : list) {
                ans[idx++] = integer;
            }
            return ans;
        }
    }
}
