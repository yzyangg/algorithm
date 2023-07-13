package leetcode.day13;

public class p307 {
}

class NumArray {
    private final int length;
    int segmentTree[];
    int nums[];

    public NumArray(int[] nums) {
        this.nums = nums;
        this.length = nums.length;
        segmentTree = new int[length * 4];
        build(0, 0, length - 1);
    }

    public void build(int i, int start, int end) {
        if (start == end) {
            segmentTree[i] = nums[end];
            return;
        }
        int leftNode = i * 2 + 1;
        int rightNode = i * 2 + 2;
        int mid = (start + end) >> 1;
        build(leftNode, start, mid);
        build(rightNode, mid + 1, end);
        up(i);
    }

    public void update(int idx, int i, int value, int start, int end) {
        if (start == end) {
            nums[idx] = value;
            segmentTree[i] = value;
            return;
        }
        int mid = (start + end) >> 1;
        //确定修改左右分支
        //改左
        int leftNode = i * 2 + 1;
        int rightNode = i * 2 + 2;
        if (idx <= mid) {
            update(idx, leftNode, value, start, mid);
        }
        //改右
        else if (idx > mid) {
            update(idx, rightNode, value, mid + 1, end);
        }
        up(i);
    }

    public void update(int index, int val) {
        update(index, 0, val, 0, length - 1);
    }

    public int sumRange(int left, int right) {
        return query(left, right, 0, length - 1, 0);
    }

    public int query(int left, int right, int start, int end, int i) {
        if (right < start || left > end) return 0;
        if (start >= left && end <= right) return segmentTree[i];
        if (start == end) return segmentTree[i];
        int mid = (start + end) >> 1;
        int leftNode = i * 2 + 1;
        int rightNode = i * 2 + 2;
        int sumLeft = query(left, right, start, mid, leftNode);
        int sumRight = query(left, right, mid + 1, end, rightNode);
        return sumLeft + sumRight;
    }

    public void up(int i) {
        int leftNode = i * 2 + 1;
        int rightNode = i * 2 + 2;
        segmentTree[i] = segmentTree[leftNode] + segmentTree[rightNode];
    }
}