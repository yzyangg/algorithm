package leetcode.offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class p053 {

}

class Solution22222323 {
    Map<TreeNode, Integer> map;
    List<TreeNode> list;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        map = new HashMap<>();
        list = new ArrayList<>();
        dfs(root);
        return map.get(p) + 1 >= list.size() ? null : list.get(map.get(p) + 1);
    }

    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        TreeNode ans = null;
        int val = p.val;
        while (root != null) {
            if (root.val > val) {
                ans = root;
                ans = ans.left;
            } else {
                root = root.right;
            }
        }
        return ans;
    }

    public void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        map.put(node, list.size());
        list.add(node);
        dfs(node.right);
    }


}