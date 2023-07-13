package leetcode.day13;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class p2542 {
}

class Solution8656456 {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int len = nums1.length;
        int[][] multi = new int[len][2];
        for (int i = 0; i < len; i++) {
            multi[i][0] = nums1[i];
            multi[i][1] = nums2[i];
        }
        Arrays.sort(multi, (o1, o2) -> o2[1] - o1[1]);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sum = 0;
        long maxScore = 0;
        for (int i = 0; i < len; i++) {
            //最大的k个数字
            int x = multi[i][0];
            int y = multi[i][1];
            if (minHeap.size() >= k) {
                //去除最小的
                sum -= minHeap.poll();
            }
            minHeap.add(x);
            sum += x;
            if (minHeap.size() == k) {
                long cur = sum * y;
                maxScore = Math.max(cur, maxScore);
            }
        }
        return maxScore;
    }
}