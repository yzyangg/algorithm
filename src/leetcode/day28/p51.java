package leetcode.day28;

import jdk.nashorn.internal.ir.SplitReturn;

import java.util.Arrays;

public class p51 {
    class Solution {
        public int reversePairs(int[] nums) {
            //离散化
            int length = nums.length;
            int temp[] = new int[length];
            System.arraycopy(nums, 0, temp, 0, length);
            Arrays.sort(temp);
            //78，90，7000，800000
            //映射后
            //1，2，3，4
            for (int i = 0; i < length; i++) {
                nums[i] = Arrays.binarySearch(temp, nums[i]) + 1;
            }
            BIT bit = new BIT(length);
            int ans = 0;
            for (int i = nums.length - 1; i >= 0; i--) {
                int nowLessThan = bit.query(nums[i] - 1);
                ans += nowLessThan;
                bit.add(nums[i]);

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


        public void add(int i) {
            while (i <= n) {
                tree[i] += 1;
                i += lowbit(i);
            }
        }
    }

}
