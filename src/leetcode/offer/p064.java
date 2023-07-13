package leetcode.offer;

public class p064 {
}

class MagicDictionary {
    String words[];

    /**
     * Initialize your data structure here.
     */
    public MagicDictionary() {

    }

    public void buildDict(String[] dictionary) {
        words = dictionary;
    }

    public boolean search(String searchWord) {
        int length = searchWord.length();
        for (String word : words) {
            if (word.length() != length) continue;
            int difCount = 0;
            for (int i = 0; i < length; i++) {
                if (word.charAt(i) != searchWord.charAt(i)) {
                    difCount++;
                    if (difCount > 1) break;
                }
            }
            if (difCount == 1) return true;
        }
        return false;
    }
}