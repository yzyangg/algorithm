package leetcode.offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class p046 {

}

class Solution2222 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            list.add(temp.get(temp.size() - 1));
        }
        return list;
    }

    private List<Integer> list;

    public List<Integer> rightSideView2(TreeNode root) {
        list = new ArrayList<>();
        if (root == null) return list;
        dfs(root, 0);
        return list;
    }

    public void dfs(TreeNode node, int dep) {
        if (node == null) return;
        if (dep == list.size()) {
            list.add(node.val);
        }
        dep++;
        dfs(node.right, dep);
        dfs(node.left, dep);
    }
}