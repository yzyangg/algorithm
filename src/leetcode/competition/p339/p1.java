package leetcode.competition.p339;

/**
 * @author: yzy
 **/
class p1 {
    public static void main(String[] args) {
        String s = "01";
        System.out.println(findTheLongestBalancedSubstring(s));

    }

    public static int findTheLongestBalancedSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < s.toCharArray().length; i++) {
            for (int j = i + 1; j < s.toCharArray().length; j++) {

            }
        }
        return max;
    }


}