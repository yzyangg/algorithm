package leetcode.offer;

public class p023 {
}

class Solution321233556 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode A = headA;
        ListNode B = headB;
        while (A != B) {
            A = A.next == null ? headB : A.next;
            B = B.next == null ? headA : B.next;
        }
        return A;
    }
}