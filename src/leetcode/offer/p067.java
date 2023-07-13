package leetcode.offer;

public class p067 {
}

class Solution9900 {
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        Trie trie = new Trie();
        for (int num : nums) {
            trie.insert(num);
            max = Math.max(max, num ^ trie.search(num));
        }
        return max;
    }

    class Trie {
        Trie next[];

        public Trie() {
            next = new Trie[2];

        }

        public void insert(int num) {
            Trie root = this;
            for (int i = 30; i >= 0; i--) {
                int nowBit = (num >> i) & 1;
                if (root.next[nowBit] == null) {
                    root.next[nowBit] = new Trie();
                }
                root = root.next[nowBit];
            }
        }

        //找当前数的二进制位相反的最多的
        public int search(int num) {
            Trie root = this;
            int ans = 0;
            for (int i = 30; i >= 0; i--) {
                int nowBit = (num >> i) & 1;
                //找相反的
                nowBit = root.next[nowBit ^ 1] == null ? nowBit : nowBit ^ 1;
                //加上十进制对应的数
                ans += nowBit << i;
                root = root.next[nowBit];
            }
            return ans;
        }
    }
}