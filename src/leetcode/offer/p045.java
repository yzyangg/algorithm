package leetcode.offer;

import java.util.ArrayDeque;
import java.util.Deque;

public class p045 {
}

class Solution32323 {
    public int findBottomLeftValue(TreeNode root) {
        int nodes[] = new int[10000];
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                nodes[i] = node.val;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return nodes[0];
    }
}