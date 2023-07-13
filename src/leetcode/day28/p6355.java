package leetcode.day28;

import java.util.*;

public class p6355 {
    class Solution {
        public long countFairPairs(int[] nums, int lower, int upper) {
            //离散化
            Set<Integer> set = new TreeSet<>();
            for (int num : nums) {
                set.add(num);
                set.add(upper - num);
                set.add(lower - num);
            }
            //固定j找i
            Map<Integer, Integer> map = new HashMap<>();
            int idx = 1;
            for (Integer integer : set) {
                map.put(integer, idx++);
            }
            BIT bit = new BIT(map.size());
            long ans = 0;
            for (int i = 0; i < nums.length; i++) {
                int left = map.get(lower - nums[i]), right = map.get(upper - nums[i]);
                ans += bit.query(right) - bit.query(left);
                bit.add(map.get(nums[i]), 1);
            }
            return ans;
        }
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

    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long count = 0;
        for (int i = 0, j = nums.length - 1, k = nums.length - 1; i < nums.length; i++) {
            for (; j >= 0 && nums[i] + nums[j] >= lower; j--) {
            }
            for (; k >= 0 && nums[i] + nums[k] > upper; k--) {
            }
            count += k - j - (i > j && i <= k ? 1 : 0);
        }
        return count / 2;
    }
}
