package leetcode.offer;

import java.util.*;

public class p056 {
}

class Solution654 {
    Set<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        if (set.contains(k - root.val)) ;
        set.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
    }

}