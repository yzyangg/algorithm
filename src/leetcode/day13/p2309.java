package leetcode.day13;

import java.awt.image.ImagingOpException;
import java.util.HashSet;
import java.util.Set;

public class p2309 {
}

class Solution09 {
    public String greatestLetter(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        for (int i = 25; i >= 0; i--) {
            if (set.contains((char) ('a' + i)) && set.contains((char) ('A' + i)))
                return String.valueOf((char) (i + 'A'));
        }
        return "";
    }
}