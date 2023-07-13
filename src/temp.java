import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/**
 * The type Temp.
 *
 * @author yzy
 * @version 1.0
 * @description TODO
 * @date 2023 /5/16 0:27
 */
public class temp {
    class Solution {
        public boolean isPalindrome(String s) {
            List<Character> list = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (Character.isLetterOrDigit(c)) {
                    list.add(Character.toLowerCase(c));
                }
            }

            List<Character> list1 = new ArrayList<>(list);
            Collections.reverse(list1);
            return list.equals(list1);

        }
    }
}
