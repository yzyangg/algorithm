package leetcode.day28;

import java.util.*;

public class p493 {
    class Solution {
        public int reversePairs(int[] nums) {
            int n = nums.length;
            long[] newNums = new long[2 * n];
            int idx = 0;
            for (int i = 0; i < n; i++) {
                newNums[idx++] = nums[i];
                newNums[idx++] = 2 * (long) nums[i];
            }
            //离散化
            Map<Long, Integer> map = discrete(newNums);
            BIT bit = new BIT(2 * n);
            int ans = 0;
            for (int i = 0; i < n; i++) {
                //离散后的索引
                int pos = map.get(2 * nums[i]);
                ans += i - bit.query(pos);
                bit.add(pos, 1);
            }
            return ans;
        }

        public Map<Long, Integer> discrete(long[] nums) {
            Map<Long, Integer> map = new HashMap<>();
            Set<Long> set = new HashSet<>();
            for (long num : nums) set.add(num);
            List<Long> list = new ArrayList<>(set);
            Collections.sort(list);
            int idx = 0;
            for (Long aLong : list) {
                map.put(aLong, ++idx);
            }
            return map;
        }
    }

    class BIT {
        int n;
        int[] tree;

        public BIT(int n) {
            this.n = n;
            tree = new int[n + 1];
        }

        public int lowbit(int i) {
            return -i & i;
        }

        public void add(int i, int val) {
            while (i <= n) {
                tree[i] += val;
                i += lowbit(i);
            }
        }

        public int query(int i) {
            int ans = 0;
            while (i > 0) {
                ans += tree[i];
                i -= lowbit(i);
            }
            return ans;
        }
    }
}
