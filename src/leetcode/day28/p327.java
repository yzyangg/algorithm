package leetcode.day28;

import javax.print.DocFlavor;
import java.io.FilterOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class p327 {
    class Solution {
        public int countRangeSum(int[] nums, int lower, int upper) {
            int n = nums.length;
            long sum = 0;
            long preSum[] = new long[n + 1];
            for (int i = 0; i < n; i++) {
                sum += nums[i];
                preSum[i + 1] = sum;
            }
            //离散化
            Set<Long> allNumbers = new TreeSet<Long>();
            for (long x : preSum) {
                allNumbers.add(x);
                allNumbers.add(x - lower);
                allNumbers.add(x - upper);
            }

            Map<Long, Integer> map = new HashMap<>();
            int idx = 0;
            for (Long allNumber : allNumbers) {
                map.put(allNumber, idx++);
            }
            int ans = 0;
            BIT bit = new BIT(map.size());
            for (int i = 0; i < preSum.length; i++) {
                int left = map.get(preSum[i] - upper), right = map.get(preSum[i] - lower);
                System.out.println("left:" + left + "and" + "right:" + right);
                ans += bit.sum(left, right);
                bit.add(map.get(preSum[i]) + 1, 1);
                for (int a : bit.tree) {
                    System.out.print(a + " ");
                }
                System.out.println();
            }

            return ans;
        }

        class BIT {
            private int tree[];
            private int n;

            public BIT(int n) {
                this.n = n;
                tree = new int[n + 1];
            }

            public int lowbit(int i) {
                return -i & i;
            }

            public int query(int i) {
                int ans = 0;
                while (i > 0) {
                    ans += tree[i];
                    i -= lowbit(i);
                }
                return ans;
            }

            public int sum(int i, int j) {
                return query(j + 1) - query(i);
            }


            public void add(int i, int val) {
                while (i <= n) {
                    tree[i] += val;
                    i += lowbit(i);
                }
            }
        }
    }
}
