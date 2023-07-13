package leetcode.day28;

import java.util.*;

public class p315 {
    class Solution {
        public List<Integer> countSmaller(int[] nums) {
            int length = nums.length;
            List<Integer> ans = new ArrayList<>();
            if (length == 1) {
                ans.add(0);
                return ans;
            }
            int temp[] = new int[length];
            //离散化
            System.arraycopy(nums, 0, temp, 0, length);
            Arrays.sort(temp);
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Arrays.binarySearch(temp, nums[i]) + 1;
            }
            BIT bit = new BIT(length);
            for (int i = nums.length - 1; i >= 0; i--) {
                int lessThan = bit.sum(nums[i] - 1);
                ans.add(lessThan);
                bit.add(nums[i], 1);
            }
            Collections.reverse(ans);
            return ans;
        }
    }

    class BIT {
        int tree[];
        int n;

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

        public int sum(int i) {
            int ans = 0;
            while (i > 0) {
                ans += tree[i];
                i -= lowbit(i);
            }
            return ans;
        }
    }

}
