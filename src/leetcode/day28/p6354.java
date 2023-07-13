package leetcode.day28;
import com.sun.xml.internal.ws.server.ServerRtException;

import java.util.ArrayDeque;
import java.util.Deque;

public class p6354 {
    class Solution {
        public long findTheArrayConcVal(int[] nums) {
            String arrs[] = new String[nums.length];
            for (int i = 0; i < nums.length; i++) {
                arrs[i] = String.valueOf(nums[i]);
            }
            Deque<String> queue = new ArrayDeque<>();
            for (String arr : arrs) {
                queue.offer(arr);
            }
            long ans = 0;
            while (queue.size() > 1) {
                String first = (queue.pollFirst());
                String last = (queue.pollLast());
                String value = first + last;
                System.out.println(value);
                if (value != " " && value != null) {
                    ans += Integer.parseInt(value);
                }
            }
            String end = queue.poll();
            if (end != " ") {
                int endValue = Integer.parseInt(end);
                ans += endValue;
            }
            return ans;
        }
    }
}
