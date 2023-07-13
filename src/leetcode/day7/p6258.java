package leetcode.day7;

import java.util.*;

public class p6258 {
}

class Solution5675677 {
    public long maxKelements(int[] nums, int k) {
        //选k个当前最大数
        int score = 0;
        Arrays.sort(nums);
        List<Long> list = new ArrayList<>();
        for (long num : nums) {
            list.add(num);
        }
        while (k > 0) {
            Long max = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            score += max;
            long newNum = (long) Math.ceil(max / 3.0);
            maintain(list, newNum);
            k--;
        }
        return score;
    }

    public void maintain(List<Long> list, long num) {
        list.add(num);
        Collections.sort(list);

    }

    public long maxKelements2(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.offer(-num);
        }
        long sum = 0;
        while (k > 0) {
            sum -= queue.peek();
            queue.offer((queue.poll() - 2) / 3);
        }
        return sum;
    }

}