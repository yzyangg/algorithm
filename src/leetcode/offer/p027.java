package leetcode.offer;

public class p027 {
}

class Solution4365567 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode mid = findMid(head);
        ListNode head2 = mid;
        ListNode rHead = reverse(head2);
        mid.next = null;
        while (head != null) {
            if (rHead.val != head.val) return false;
            rHead = rHead.next;
            head = head.next;
        }
        return true;
    }

    public ListNode reverse(ListNode node) {
        if (node == null || node.next == null) return node;
        ListNode newHead = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return newHead;
    }

    public ListNode findMid(ListNode node) {

        ListNode fast = node;
        ListNode slow = node;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }


}