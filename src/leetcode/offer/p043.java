package leetcode.offer;

import java.util.ArrayDeque;
import java.util.Deque;

public class p043 {
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class CBTInserter {
    Deque<TreeNode> queue;
    TreeNode root;

    public CBTInserter(TreeNode root) {
        this.root = root;
        queue = new ArrayDeque<>();
        Deque<TreeNode> nodeQueue = new ArrayDeque<>();
        nodeQueue.addLast(root);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.pop();
            if (node.left != null) nodeQueue.offer(node.left);
            if (node.right != null) nodeQueue.offer(node.right);
            if (!(node.left != null && node.right != null)) {
                queue.offer(node);
            }
        }
    }

    public int insert(int v) {
        TreeNode child = new TreeNode(v);
        TreeNode node = queue.peek();
        if (node.left == null) node.left = child;
        else {
            node.right = child;
            queue.poll();
        }
        queue.offer(child);
        return node.val;
    }

    public TreeNode get_root() {
        return root;
    }
}
