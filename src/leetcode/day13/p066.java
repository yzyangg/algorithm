package leetcode.day13;

import java.util.TreeMap;

public class p066 {
}

class MapSum {
    Trie trie;

    /**
     * Initialize your data structure here.
     */
    public MapSum() {
        trie = new Trie();
    }

    public void insert(String key, int val) {
        trie.insert(key, val);
    }

    public int sum(String prefix) {
        return trie.search(prefix);
    }
}

class Trie {
    Trie[] next;
    int val;

    public Trie() {
        next = new Trie[26];
    }

    public void insert(String key, int val) {
        Trie root = this;
        for (char c : key.toCharArray()) {
            int idx = c - 'a';
            if (root.next[idx] == null) {
                root.next[idx] = new Trie();
            }
            root = root.next[idx];
        }
        root.val = val;
    }

    public int search(String key) {
        Trie root = this;
        for (char c : key.toCharArray()) {
            int idx = c - 'a';
            if (root.next[idx] == null) {
                return 0;
            }
            root = root.next[idx];
        }
        return calculate(root, 0);
    }

    public int calculate(Trie node, int sum) {
        if (node.val != 0) sum += node.val;
        for (Trie child : node.next) {
            sum += child == null ? 0 : calculate(child, 0);
        }
        return sum;
    }
}
