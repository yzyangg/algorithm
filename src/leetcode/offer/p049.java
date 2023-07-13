package leetcode.offer;

public class p049 {
}

class Solution9999999 {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode node, int preSum) {
        if (node == null) return 0;
        int curSum = preSum * 10 + node.val;
        if (node.left == null && node.right == null) return curSum;
        else return dfs(node.left, curSum) + dfs(node.right, curSum);
    }
}