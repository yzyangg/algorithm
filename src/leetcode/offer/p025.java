package leetcode.offer;

import java.util.ArrayDeque;
import java.util.Deque;

public class p025 {
}

class Solution765433 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode r1 = reverse(l1);
        ListNode r2 = reverse(l2);
        ListNode ans = new ListNode();
        int lastSumleft = 0;
        while (r1 != null || r2 != null) {
            int curSum = (r1 == null ? 0 : r1.val) + (r2 == null ? 0 : r2.val) + lastSumleft;
            int curSumleft = curSum % 10;
            ans.next = new ListNode(curSumleft);
            ans = ans.next;
            lastSumleft = (curSum - curSumleft) / 10;
            if (r1 != null && r1.next != null)
                r1 = r1.next;
            if (r1 != null && r2.next != null)
                r2 = r2.next;
        }
        if (lastSumleft != 0) ans.next = new ListNode(lastSumleft);
        ans = ans.next;
        return reverse(ans.next);
    }

    public ListNode reverse(ListNode root) {
        if (root == null || root.next == null) return null;
        ListNode newHead = reverse(root.next);
        root.next.next = root;
        root.next = null;
        return newHead;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack1.push(l2.val);
            l2 = l2.next;
        }
        int lastSumLeft = 0;
        ListNode ans = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || lastSumLeft != 0) {
            int a = stack1.isEmpty() ? 0 : stack1.pop();
            int b = stack2.isEmpty() ? 0 : stack2.pop();
            int curSum = a + b + lastSumLeft;
            lastSumLeft = curSum / 10;
            curSum %= 10;
            ListNode node = new ListNode(curSum);
            //头插法
            node.next = ans;
            ans = node;
        }
        return ans;

    }
}