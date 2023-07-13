package leetcode.offer;

public class p002 {
    public static void main(String[] args) {
        String a = "11";
        String b = "10";
        Solution345345 solution345345 = new Solution345345();
        solution345345.addBinary(a, b);
    }
}

class Solution345345 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        int lastLeftSum = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = lastLeftSum;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            sb.insert(0, sum % 2);
            lastLeftSum = sum / 2;//够2下回就进位
        }
        sb.insert(0, lastLeftSum == 1 ? lastLeftSum : "");
        return sb.toString();
    }
}
