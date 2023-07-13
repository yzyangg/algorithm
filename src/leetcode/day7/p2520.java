package leetcode.day7;

public class p2520 {

}

class Solution34546745 {
    public int countDigits(int num) {
        int count = 0;
        String number = String.valueOf(num);
        for (int i = 0; i < number.length(); i++) {
            if ((num % Integer.parseInt(String.valueOf(number.charAt(i))) == 0)) {
                count++;
            }
        }
        return count;
    }

    public int countDigits2(int num) {
        int count = 0;
        for (int i = num; i > 0; i /= 10) {
            if (num % (i % 10) == 0) count++;
        }
        return count;
    }
}
