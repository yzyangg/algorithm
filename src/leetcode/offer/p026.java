package leetcode.offer;

public class p026 {
}

class Solution995432 {
    public void reorderList(ListNode head) {
        if (head == null) return;
        ListNode mid = findMid(head);
        ListNode head2 = mid.next;
        mid.next = null;
        head2 = reverse(head2);

        ListNode head1 = head;
        merge(head1, head2);
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
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void merge(ListNode head1, ListNode head2) {
        ListNode next1 = null, next2 = null;
        while (head1 != null && head2 != null) {
            next1 = head1.next;
            next2 = head2.next;

            head1.next = head2;
            head1 = next1;

            head2.next = head1;
            head2 = next2;
        }
    }
}