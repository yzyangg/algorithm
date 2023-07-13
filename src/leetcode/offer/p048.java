package leetcode.offer;

import java.util.*;

public class p048 {
}

class Codec2222 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) sb.append("X,");
            else {
                sb.append(node.val + ",");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "")
            return null;
        String strs[] = data.split(",");
        Deque<String> nodes = new LinkedList<>(Arrays.asList(strs));
        Deque<TreeNode> queue = new ArrayDeque<>();
        TreeNode node = new TreeNode(Integer.parseInt(nodes.poll()));
        queue.offer(node);
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            String leftChild = nodes.poll();
            String rightChild = nodes.poll();
            if (!leftChild.equals("X")) {
                curNode.left = new TreeNode(Integer.parseInt(leftChild));
                queue.offer(curNode.left);
            }
            if (!rightChild.equals("X")) {
                curNode.right = new TreeNode(Integer.parseInt(rightChild));
                queue.offer(curNode.right);
            }
        }
        return node;
    }
}