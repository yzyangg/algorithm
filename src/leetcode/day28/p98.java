package leetcode.day28;


import com.sun.org.apache.bcel.internal.generic.FADD;

import java.beans.PropertyEditor;
import java.io.StringReader;

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

public class p98 {
    class Solution {
        long pre = Integer.MAX_VALUE;

        public boolean isValidBST(TreeNode root) {
            if (root == null) return true;
            if (!isValidBST(root.left)) return false;
            if (pre > root.val) return false;
            pre = root.val;
            if (!isValidBST(root.right)) return false;
            return true;
        }
    }
}
