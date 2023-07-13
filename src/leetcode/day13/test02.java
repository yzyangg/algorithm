package leetcode.day13;

import com.sun.jmx.snmp.SnmpOid;

import java.time.temporal.Temporal;

public class test02 {
    public void swap(TreeNode node) {
        if (node.left == null && node.right == null) return;
        swap(node.left);
        swap(node.right);
        TreeNode temp = null;
        node.left = node.right;
        node.right = temp;
    }
}

class TreeNode {
    TreeNode left;
    TreeNode right;

}

