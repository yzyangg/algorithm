package leetcode.offer;

import java.util.ArrayList;
import java.util.List;

public class p052 {
}

class Solution233311 {
    public TreeNode increasingBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        dfs(list, root);
        TreeNode newHead = new TreeNode();
        TreeNode cur = newHead;
        for (int i = 0; i < list.size(); i++) {
            TreeNode node = list.get(i);
            node.right = null;
            cur.right = node;
            cur = cur.right;
        }
        return newHead.right;
    }

    public void dfs(List<TreeNode> list, TreeNode node) {
        if (node == null) return;
        dfs(list, node.left);
        list.add(node);
        dfs(list, node.right);

    }

    public TreeNode increasingBST2(TreeNode root) {
        if (root == null) return null;
        root.left.left = root.right;
        root.right = root.left;
        root.left = null;
        return root;
    }

    TreeNode pre = new TreeNode(0);
    TreeNode head = null;

    public void dfs2(TreeNode node) {
        if (node == null) return;
        dfs2(node.left);
        if (head == null) head = node;
        pre.right = node;
        node.left = null;
        pre = node;
        dfs2(node.right);
    }

}