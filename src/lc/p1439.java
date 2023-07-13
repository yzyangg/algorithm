package lc;

public class p1439 {
    class Solution {
        public String smallestString(String s) {
            int idx = -1;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'a') {
                    idx = i;
                }
            }
            String ans = s;
            char[] chars = s.toCharArray();
            if (idx > 0 && idx < s.length()) {
                for (int i = 0; i < idx; i++) {
                    //将当前字符替换为单词表中上一个字符
                    chars[i] = (char) (chars[i] - 'a' + 'a' - 1);
                }
            } else if (idx == 0) {
                for (int i = 1; i < s.length(); i++) {
                    chars[i] = (char) (chars[i] - 'a' + 'a' - 1);
                }
            } else if (idx == -1) {
                for (int i = 0; i < s.length(); i++) {
                    chars[i] = (char) (chars[i] - 'a' + 'a' - 1);

                }
            }
            return new String(chars);
        }
    }

}
