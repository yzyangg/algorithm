package leetcode.Interview_Classic_150_Questions;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author: yzy
 **/
public class l169 {
    class Solution {
        public int majorityElement(int[] nums) {
            int a;
            int b;
            a = 10;
            b = 10;
            int cur = nums[0];
            int cnt = 0;
            for (int i = 1; i < nums.length; i++) {
                if (cur == nums[i]) {
                    cnt--;
                    if (cnt == 0) cur = nums[i];
                }
            }
            return cur;
        }
    }

    class Person {

    }

    class Student extends Person {
    }
}
