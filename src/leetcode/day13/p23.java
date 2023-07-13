package leetcode.day13;


import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class p23 {

}

class Solution234 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode newHead = new ListNode();
        for (int i = 0; i < lists.length; i++) {
            newHead = merge(newHead, lists[i]);
        }
        return newHead;
    }

    public ListNode merge(ListNode nodeA, ListNode nodeB) {
        if (nodeB == null || nodeA == null) {
            return nodeA == null ? nodeB : nodeA;
        }

        ListNode A = nodeA;
        ListNode B = nodeB;
        ListNode newHead = new ListNode();
        ListNode helper = newHead;
        while (A != null && B != null) {
            if (A.val <= B.val) {
                helper.next = A;
                A = A.next;
            } else {
                helper.next = B;
                B = B.next;
            }
            helper = helper.next;
        }
        helper.next = A == null ? B : A;
        return newHead.next;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists.length == 0) return null;
        PriorityQueue<ListNode> listNodes = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode list : lists) {
            if (list == null) continue;
            listNodes.add(list);
        }
        ListNode head = new ListNode();
        ListNode dummyHead = head;
        while (!listNodes.isEmpty()) {
            ListNode newNode = listNodes.poll();
            dummyHead.next = newNode;
            dummyHead = dummyHead.next;
            if (newNode.next != null) {
                listNodes.add(newNode.next);
            }
        }
        return head.next;
    }

    public ListNode mergeKLists3(ListNode[] lists) {

        return null;
    }

    public ListNode mergeTwo(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        int mid = left + (right - left) / 2;
        ListNode l = mergeTwo(lists, left, mid);
        System.out.println(left + "  and  " + mid);
        ListNode r = mergeTwo(lists, mid + 1, right);
        System.out.println(left + "  and  " + mid);
        return merge(l, r);
    }


}