package leetcode.offer;

import java.util.*;
import java.util.stream.Collectors;

public class p074 {
}

class Solution879789 {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = Arrays.stream(intervals).sorted(Comparator.comparingInt(o -> {
            return o[0];
        })).collect(Collectors.toList());
        Stack<int[]> stack = new Stack<>();
        for (int[] ints : list) {
            if (stack.isEmpty()) stack.add(ints);
            else {
                //需要合并
                if (stack.peek()[1] >= ints[0]) {
                    int now[] = stack.pop();
                    stack.add(new int[]{now[0], Math.max(ints[1], now[1])});
                    System.out.println("合并了一次");
                } else {
                    stack.add(ints);
                }
            }
        }
        int ans[][] = new int[stack.size()][2];
        int idx = stack.size() - 1;
        while (!stack.isEmpty()) {
            ans[idx--] = stack.pop();
        }
        return ans;
    }

    public int[][] merge2(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int ans[][] = new int[intervals.length][2];
        int pre = -1;
        for (int[] interval : intervals) {
            if (pre == -1 || interval[0] > ans[pre][1]) {
                ans[++pre] = interval;
            } else {
                ans[pre][1] = Math.max(ans[pre][1], interval[1]);
            }
        }

        return Arrays.copyOf(ans, pre + 1);
    }
}