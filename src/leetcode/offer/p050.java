package leetcode.offer;

public class p050 {
}

class Solution111112312 {
    int ans;
    int target;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        target = targetSum;
        dfs(root, 0);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return ans;
    }

    public void dfs(TreeNode node, long curSum) {
        if (node == null) return;
        curSum += node.val;
        if (curSum == target) ans++;
        dfs(node.left, curSum);
        dfs(node.right, curSum);
    }
}