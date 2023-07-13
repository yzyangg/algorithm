package leetcode.offer;

public class p028 {
}

class Solution7654354 {
    public node flatten(node head) {
        node cur = head;
        while (cur != null) {
            if (cur.child != null) {
                node tmp = cur.next;//遍历
                node childHead = flatten(cur.child);
                node childEnd = getEnd(childHead);
                //插入
                childEnd.next = cur.next;
                childHead.prev = cur;
                if (cur.next != null) {
                    cur.next.prev = childEnd;
                }
                cur.next = childHead;
                cur.child = null;
                cur = tmp;
            } else cur = cur.next;
        }
        return head;
    }

    public node getEnd(node node) {
        while (node.next != null) {
            node = node.next;
        }
        return node;
    }
}

// Definition for a Node.
class node {
    public int val;
    public node prev;
    public node next;
    public node child;
};
