package leetcode.offer;

public class p051 {
}
class Solution45654 {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return maxSum;
    }

    public int dfs(TreeNode node) {
        if (node == null) return 0;
        int leftGain = Math.max(dfs(node.left), 0);
        int rightGain = Math.max(dfs(node.right), 0);
        int nowGain = node.val + leftGain + rightGain;
        maxSum = Math.max(nowGain, maxSum);
        return node.val + Math.max(leftGain, rightGain);
    }

}