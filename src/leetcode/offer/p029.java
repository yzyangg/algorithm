package leetcode.offer;

public class p029 {
}

class Solution23457345345 {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }
        //尾部
        Node node = head;
        while (node.val <= node.next.val && node.next != head) {
            node = node.next;
        }
        //找得到
        if (insertVal >= node.val || insertVal <= node.next.val) {
            Node newNode = new Node(insertVal);
            newNode.next = node.next;
            node.next = newNode;
            return head;
        }
        //找不到
        //上一种情况不满足 那就继续循环节点 直到找到当node.val <= insertVal并且node.next.val>=insertVal
        //反向判断
        while (node.val > insertVal || node.next.val < insertVal) {
            node = node.next;
        }
        Node node1 = new Node(insertVal);
        node1.next = node.next;
        node.next = node1;
        return head;
    }
}

class Node {
    public int val;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
