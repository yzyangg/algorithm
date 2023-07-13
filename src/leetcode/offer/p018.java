package leetcode.offer;

public class p018 {
}

class Solution9876543 {
    public boolean isPalindrome(String s) {
        if (s.equals(" ") || s.length() == 1) return true;
        int length = s.length();
        int left = 0, right = length - 1;
        while (left <= right) {
            while (left <= right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (right >= left && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (left <= right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isPalindrome2(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isLetterOrDigit(s.charAt(i))) continue;
            else sb.append(Character.toLowerCase(s.charAt(i)));
        }
        String str = sb.toString();
        return sb.reverse().toString().equals(str);
    }
}
