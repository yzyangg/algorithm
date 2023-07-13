package leetcode.offer;

public class p019 {
}

class Solution987654 {
    public boolean validPalindrome(String s) {
        int length = s.length();
        int left = 0, right = length - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isValid(s, left + 1, right) || isValid(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isValid(String s, int left, int right) {
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}