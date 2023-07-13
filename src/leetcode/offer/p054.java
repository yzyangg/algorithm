package leetcode.offer;

public class p054 {
}

class Solution009 {
    int preSum = 0;

    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    public void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.right);
        node.val = node.val + preSum;
        preSum = node.val;
        dfs(node.left);
    }
}