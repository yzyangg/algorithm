package leetcode.offer;

import java.util.Comparator;
import java.util.PriorityQueue;

public class p077 {
}

class Solution2334 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        while (head != null) {
            queue.add(head);
            head = head.next;
        }
        ListNode dummyHead = new ListNode();
        ListNode helper = dummyHead;
        while (!queue.isEmpty()) {
            helper.next = new ListNode(queue.poll().val);
            helper = helper.next;
        }
        return dummyHead.next;
    }

    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode mid = findMid(head);
        return merge(sortList2(head), sortList2(mid));
    }

    public ListNode findMid(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        return mid;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        ListNode newHead = new ListNode();
        ListNode cur = newHead;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        cur.next = head1 == null ? head2 : head1;
        return newHead.next;
    }
}