package leetcode.offer;

import java.util.List;

public class p063 {
}

class Solution33343 {
    class Node {
        Node next[];
        String word;

        public Node() {
            this.next = new Node[26];
            this.word = null;
        }
    }

    Node root = new Node();

    public void insert(String word) {
        Node node = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.next[idx] == null) {
                node.next[idx] = new Node();
            }
            node = node.next[idx];
        }
        node.word = word;
    }

    public String getPrefix(String s) {
        Node node = root;
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            if (node.next[idx] == null) return null;
            node = node.next[idx];
            if (node.word != null) return node.word;
        }
        return null;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        for (String s : dictionary) {
            insert(s);
        }
        String[] strs = sentence.split(" ");
        for (int i = 0; i < strs.length; i++) {
            strs[i] = getPrefix(strs[i]) == null ? strs[i] : getPrefix(strs[i]);
        }
        return String.join(" ", strs);
    }
}
