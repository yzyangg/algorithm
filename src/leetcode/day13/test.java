package leetcode.day13;

class NumArray2 {

    int[] nums, tree, lazy;
    boolean[] updated;
    int n;

    public NumArray2(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        this.tree = new int[4 * n];
        this.lazy = new int[4 * n];
        this.updated = new boolean[4 * n];
        build(0, n - 1, 0);
    }

    public void build(int start, int end, int i) {
        if (start == end) tree[i] = nums[i];
        int mid = (start + end) >> 1;
        int leftNode = i * 2 + 1;
        int rightNode = i * 2 + 2;
        build(start, mid, leftNode);
        build(mid + 1, end, rightNode);
        pushUp(i);
    }

    public int sum(int left, int right, int start, int end, int i) {
        if (left > start || end > right) return 0;//不是查询区间，减枝
        if (left <= start && end <= right) return tree[i];//处于查询区间以内
        int mid = (start + end) >> 1;
        int lSum = sum(left, right, start, mid, i * 2 + 1);
        int rSum = sum(left, right, mid + 1, end, i * 2 + 2);
        return lSum + rSum;
    }

    public void update(int index, int val) {
        updateOne(index, val, 0, n - 1, 0);
    }

    public void updateOne(int idx, int val, int start, int end, int i) {
        if (start == end) {
            tree[i] = val;
            nums[idx] = val;
            return;
        }
        int mid = (start + end) >> 1;
        if (lazy[i] != 0) pushDown(start, mid, end, i);//是否推送标记
        if (idx <= mid) updateOne(idx, val, start, mid, i * 2 + 1);
        else updateOne(idx, val, mid + 1, end, i * 2 + 2);
        pushUp(i);//后序操作，自底向上更新节点区间和tree[i]
    }

    public int sumRange(int left, int right) {
        return sum(left, right, 0, n - 1, 0);
    }

    public void pushDown(int start, int mid, int end, int i) {
        tree[i * 2 + 1] += (mid - start + 1) * lazy[i];//更新左节点的区间和
        lazy[i * 2 + 1] += lazy[i];//传递懒标记
        tree[i * 2 + 2] += (end - mid) * lazy[i];//更新右边
        lazy[i * 2 + 2] += lazy[i];//传递懒标记
        lazy[i] = 0;//更新完了，重置
    }

    public void pushUp(int i) {
        tree[i] = tree[i * 2 + 1] + tree[i * 2 + 2];
    }

    public static void main(String[] args) {
        int n = 10;
        n = +9;
        System.out.println(n);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */