package leetcode.day6;

public class p208 {
    public static void main(String[] args) {

    }
}

class Trie {
    Trie[] next;
    boolean isEnd;

    public Trie() {
        this.next = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie root = this;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (root.next[idx] == null) {
                root.next[idx] = new Trie();
            }
            root = root.next[idx];
        }
        root.isEnd = true;
    }

    public boolean search(String word) {
        Trie end = searchPrefix(word);
        return end != null && end.isEnd;
    }

    public Trie searchPrefix(String prefix) {
        Trie root = this;
        for (char c : prefix.toCharArray()) {
            int idx = c - 'a';
            if (root.next[idx] == null) {
                return null;
            }
            root = root.next[idx];
        }
        return root;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }
}
/**
 * Map<Character, Trie> next;
 * boolean isEnd;
 * <p>
 * public Trie() {
 * this.next = new HashMap<>();
 * isEnd = false;
 * }
 * <p>
 * public void insert(String word) {
 * Trie root = this;
 * for (char c : word.toCharArray()) {
 * if (root.next.get(c) == null) {
 * root.next.put(c, new Trie());
 * }
 * root = root.next.get(c);
 * }
 * root.isEnd = true;
 * }
 * <p>
 * public boolean search(String word) {
 * Trie end = searchPrefix(word);
 * return end != null && end.isEnd;
 * }
 * <p>
 * public Trie searchPrefix(String prefix) {
 * Trie root = this;
 * for (char c : prefix.toCharArray()) {
 * if (root.next.get(c) == null) {
 * return null;
 * }
 * root = root.next.get(c);
 * }
 * return root;
 * }
 * <p>
 * public boolean startsWith(String prefix) {
 * return searchPrefix(prefix) != null;
 * }
 * <p>
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 * <p>
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 * <p>
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 * <p>
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 * <p>
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 * <p>
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */