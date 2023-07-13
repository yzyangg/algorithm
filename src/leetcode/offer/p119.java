package leetcode.offer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class p119 {
}

class Solution9000 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 1) return 1;
        if (nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        UnionFind union = new UnionFind(nums);
        for (int num : nums) {
            set.add(num);
            if (set.contains(num + 1)) {
                union.union(num, num + 1);
            }
            if (set.contains(num - 1)) {
                union.union(num - 1, num);
            }
        }
        int ans = 0;
        for (int num : nums) {
            ans = Math.max(ans, union.find(num) - num + 1);
        }
        return ans;
    }
}

class UnionFind {
    Map<Integer, Integer> parents;

    public UnionFind(int[] nums) {
        this.parents = new HashMap<>();
        for (int num : nums) this.parents.put(num, num); // 初始单元素集合，parent指向自己
    }

    // 带路径压缩的查找
    public int find(int x) {
        if (parents.get(x) == x) return x;
        parents.put(x, find(parents.get(x)));
        return parents.get(x);
    }

    // 直接求并
    public void union(int x, int y) {
        if (parents.containsKey(y)) parents.put(x, y); // 以y为x的parent
    }
}