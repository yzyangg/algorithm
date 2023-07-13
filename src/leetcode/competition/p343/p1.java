package leetcode.competition.p343;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: yzy
 **/
public class p1 {
    public static void main(String[] args) {
        Solution solution = new Solution();

    }

    static class Solution {
        public int isWinner(int[] player1, int[] player2) {
            int sum1 = 0;
            int sum2 = 0;

            Deque<Integer> list1 = new LinkedList<>();
            for (int i = 0; i < player1.length; i++) {
                if (i < 2) {
                    if (list1.contains(10)) {
                        sum1 += player1[i] * 2;
                    } else sum1 += player1[i];
                    list1.addLast(player1[i]);
                } else {
                    if (list1.contains(10)) {
                        sum1 += player1[i] * 2;
                        list1.addLast(player1[i]);
                    } else {
                        sum1 += player1[i];
                        list1.addLast(player1[i]);
                    }
                    if (list1.size() > 0) {
                        list1.removeFirst();
                    }
                }
            }
            System.out.println(sum1);
            Deque<Integer> list2 = new LinkedList<>();
            for (int i = 0; i < player2.length; i++) {
                if (i < 2) {
                    if (list2.contains(10)) {
                        sum2 += player2[i] * 2;
                    } else sum2 += player2[i];
                    list2.addLast(player2[i]);
                } else {
                    if (list2.contains(10)) {
                        sum2 += player2[i] * 2;
                        list2.addLast(player2[i]);
                    } else {
                        sum2 += player2[i];
                        list2.addLast(player2[i]);
                    }
                    if (list2.size() > 0) {
                        list2.removeFirst();
                    }
                }
            }
            System.out.println(sum2);
            if (sum1 > sum2) {
                return 1;
            } else if (sum1 < sum2) {
                return 2;
            } else {
                return 0;
            }

        }
    }
}
