package leetcode.day13;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class p2545 {
}

class Solution112345 {
    public int[][] sortTheStudents(int[][] score, int k) {
        List<int[]> collect = Arrays.stream(score).sorted(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[k] - o1[k];
            }
        }).collect(Collectors.toList());
        int ans[][] = new int[score.length][score[0].length];
        int idx = 0;
        for (int[] ints : collect) {
            ans[idx++] = ints;
        }
        return ans;
    }
}