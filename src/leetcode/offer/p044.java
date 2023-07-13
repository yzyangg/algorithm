package leetcode.offer;

import java.util.*;

public class p044 {
}

class Solution111 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        dfs(list, root, 0);
        return list;
    }

    public void dfs(List<Integer> list, TreeNode node, int curH) {
        if (curH == list.size()) list.add(node.val);
        else list.set(curH, Math.max(list.get(curH), node.val));
        if (node.left != null) dfs(list, node.left, curH + 1);
        if (node.right != null) dfs(list, node.right, curH + 1);
    }

    public List<Integer> largestValues2(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            ans.add(getMax(list));
        }
        return ans;
    }

    public int getMax(List<Integer> list) {
        Collections.sort(list);
        return list.get(list.size() - 1);
    }


}