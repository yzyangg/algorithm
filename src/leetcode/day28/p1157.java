package leetcode.day28;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class p1157 {
    class MajorityChecker {
        //出现次数作为索引
        public MajorityChecker(int[] arr) {

        }
        //离散化

        public int query(int left, int right, int threshold) {
            return 0;
        }
    }

    class BIT {
        int tree[];
        int n;

        public BIT(int n) {
            tree = new int[n + 1];
        }

        public int lowbit(int x) {
            return -x & x;
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
                i += lowbit(i);
            }
            return ans;
        }

        public int sum(int i, int j) {
            return query(j + 1) - query(i);
        }
    }

/**
 * Your MajorityChecker object will be instantiated and called as such:
 * MajorityChecker obj = new MajorityChecker(arr);
 * int param_1 = obj.query(left,right,threshold);
 */
}
