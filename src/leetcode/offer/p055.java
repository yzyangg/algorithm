package leetcode.offer;

import java.util.ArrayList;
import java.util.List;

public class p055 {
}

class BSTIterator {
    List<Integer> list;
    int idx = 0;

    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        inorder(root);

    }

    public void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        list.add(node.val);
        inorder(node.right);
    }

    public int next() {
        return list.get(idx++);
    }

    public boolean hasNext() {
        return idx < list.size();
    }
}