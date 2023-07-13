package acwing;

import java.io.*;

/**
 * @author yzy
 * @version 1.0
 * @description TODO
 * @date 2023/5/23 17:40
 */
public class p1273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int nums[] = new int[n];
        String s[] = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        SegmentTreeAdd segmentTreeAdd = new SegmentTreeAdd(nums);
        int m = Integer.parseInt(br.readLine());
        while (m > 0) {
            m--;
            String s1[] = br.readLine().split(" ");
            int l = Integer.parseInt(s1[0]);
            int r = Integer.parseInt(s1[1]);
            out.println(segmentTreeAdd.max(l - 1, r - 1));

        }
        out.flush();

    }

    /**
     * 静态线段树 (带懒标记，增量式区间修改)
     * 支持：单点修改 / 单点查询 / 区间求和 / 增量式区间修改
     */
    static class SegmentTreeAdd {
        int[] nums, tree, lazy;
        int n;

        public SegmentTreeAdd(int[] nums) {
            this.nums = nums;
            this.n = nums.length;
            this.tree = new int[4 * n];
            this.lazy = new int[4 * n];
            build(0, n - 1, 1);
        }

        public void add(int i, int x) { // 单点修改(驱动): 增量式 nums[i] += x
            add(i, x, 0, n - 1, 1);
        }

        public void update(int i, int x) { // 单点修改(驱动): 覆盖式 nums[i] = x
            update(i, x, 0, n - 1, 1);
        }

        public int query(int i) { // 单点查询 (驱动): 查询 nums[i]
            return query(i, 0, n - 1, 1);
        }

        public void add(int l, int r, int x) { // 区间修改(驱动): 增量式 [l,r] 区间所有元素加上x
            add(l, r, x, 0, n - 1, 1);
        }

        public int sum(int l, int r) { // 区间查询(驱动): nums[l]~nums[r]之和
            return sum(l, r, 0, n - 1, 1);
        }

        public int min(int l, int r) { // 区间查询 (驱动): 查询[l,r]中的最小值
            return min(l, r, 0, n - 1, 1);
        }

        public int max(int l, int r) { // 区间查询 (驱动): 查询[l,r]中的最大值
            return max(l, r, 0, n - 1, 1);
        }

        // 单点修改: 增量式 令nums[idx] += x。修改叶子结点，无关标记。
        private void add(int idx, int x, int s, int t, int i) {
            if (s == t) {
                tree[i] += x; // 增量更新
                return;
            }
            int c = s + (t - s) / 2;
            if (lazy[i] != 0) pushDown(s, c, t, i); // 是否推送标记
            if (idx <= c) add(idx, x, s, c, i * 2);
            else add(idx, x, c + 1, t, i * 2 + 1);
            pushUp(i); // 后序动作，自底向上更新结点区间和 tree[i]
        }

        // 单点修改: 覆盖式 令nums[idx] = x。修改叶子结点，无关标记。
        private void update(int idx, int x, int s, int t, int i) {
            if (s == t) {
                tree[i] = x; // 覆盖更新
                return;
            }
            int c = s + (t - s) / 2;
            if (lazy[i] != 0) pushDown(s, c, t, i); // 是否推送标记
            if (idx <= c) update(idx, x, s, c, i * 2);
            else update(idx, x, c + 1, t, i * 2 + 1);
            pushUp(i);  // 后序动作，自底向上更新结点区间和 tree[i]
        }

        // 单点查询 (具体): 查询 nums[i]，尾递归
        private int query(int idx, int s, int t, int i) {
            if (s == t) return tree[i];
            int c = s + (t - s) / 2;
            if (lazy[i] != 0) pushDown(s, c, t, i); // 是否推送标记
            if (idx <= c) return query(idx, s, c, i * 2);
            else return query(idx, c + 1, t, i * 2 + 1);
        }

        // 区间修改: 增量式 [l,r] 区间所有元素加上x
        private void add(int l, int r, int x, int s, int t, int i) {
            if (l <= s && t <= r) { // 当前结点代表的区间在所求区间之内
                tree[i] += (t - s + 1) * x; // 结点i的区间和加上t-s+1个x
                if (s != t) lazy[i] += x; // 结点i不是叶子结点，懒标记值加上x
                return;
            }
            int c = s + (t - s) / 2;
            if (lazy[i] != 0) pushDown(s, c, t, i); // 是否推送标记
            if (l <= c) add(l, r, x, s, c, i * 2);
            if (r > c) add(l, r, x, c + 1, t, i * 2 + 1);
            pushUp(i); // 后序动作，自底向上更新结点区间和 tree[i]
        }

        // 区间查询: 求 nums[l]~nums[r]之和
        private int sum(int l, int r, int s, int t, int i) {
            if (l <= s && t <= r) return tree[i]; // 当前结点代表的区间在所求区间之内
            int c = s + (t - s) / 2, sum = 0;
            if (lazy[i] != 0) pushDown(s, c, t, i); // 是否推送标记
            if (l <= c) sum += sum(l, r, s, c, i * 2);
            if (r > c) sum += sum(l, r, c + 1, t, i * 2 + 1);
            return sum;
        }

        // 区间查询: 查询[l,r]中的最小值
        private int min(int l, int r, int s, int t, int i) {
            if (s == t) return tree[i]; // 叶子结点
            int c = s + (t - s) / 2, lmin = Integer.MAX_VALUE, rmin = Integer.MAX_VALUE;
            if (lazy[i] != 0) pushDown(s, c, t, i); // 是否推送标记
            if (l <= c) lmin = min(l, r, s, c, i * 2);
            if (r > c) rmin = min(l, r, c + 1, t, i * 2 + 1);
            return Math.min(lmin, rmin);
        }

        // 区间查询: 查询[l,r]中的最大值
        private int max(int l, int r, int s, int t, int i) {
            if (s == t) return tree[i];
            int c = s + (t - s) / 2, lmax = Integer.MIN_VALUE, rmax = Integer.MIN_VALUE;
            if (lazy[i] != 0) pushDown(s, c, t, i);
            if (l <= c) lmax = max(l, r, s, c, i * 2);
            if (r > c) rmax = max(l, r, c + 1, t, i * 2 + 1);
            return Math.max(lmax, rmax);
        }

        // 构建线段树(tree数组)
        private void build(int s, int t, int i) {
            if (s == t) { // s: start,nums当前结点区间起点下标，t: terminal,nums当前结点区间末尾下标
                tree[i] = nums[s];
                return;
            }
            int c = s + (t - s) / 2;
            build(s, c, i * 2);
            build(c + 1, t, i * 2 + 1);
            pushUp(i);  // 后序动作，自底向上更新结点区间和 tree[i]
        }

        // pushup: 更新 tree[i]
        private void pushUp(int i) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }

        // pushdown: 更新当前结点及其左右子结点的懒标记
        private void pushDown(int s, int c, int t, int i) {
            tree[i * 2] += (c - s + 1) * lazy[i]; // 更新其左子结点的区间和
            lazy[i * 2] += lazy[i]; // 传递懒标记(增量标记)
            tree[i * 2 + 1] += (t - c) * lazy[i];
            lazy[i * 2 + 1] += lazy[i];
            lazy[i] = 0; // 重置当前结点懒惰标记值（增量标记置0）
        }
    }
}
